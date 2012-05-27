package jp.coxs.twitter.favrt.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import jp.coxs.twitter.favrt.model.BaseUser;
import jp.coxs.twitter.favrt.model.json.ApiLimitHeader;
import jp.coxs.twitter.favrt.util.ServiceProviderConnector.CallBackParameter.Parameters;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.OAuthServiceProvider;
import net.oauth.ParameterStyle;
import net.oauth.client.OAuthClient;
import net.oauth.client.OAuthResponseMessage;
import net.oauth.client.URLConnectionClient;
import net.oauth.http.HttpResponseMessage;

/**
 * サービスプロバイダへの接続を処理するクラスです。<br />
 * マルチスレッドに対応していないので毎回インスタンス化してください。
 * 
 * @author Shunichi Todoroki
 */
public class ServiceProviderConnector {
    private ServiceProvider sp;

    /**
     * コンストラクタ。
     * 
     * @param sp サービスプロバイダに依存する情報を保持するクラス
     */
    public ServiceProviderConnector(ServiceProvider sp) {
        if (sp == null) {
            throw new NullPointerException(
                    "this connector class instance initialize is needed service provider.");
        }
        this.sp = sp;
    }

    /**
     * サービスプロバイダに対しリクエストを発行し、認証するために必要なリダイレクトの
     * URLを取得します。<br />
     * リダイレクトのURLにはアクセスに必要なOAuthトークンが付加されます
     * 
     * @throws TwitterApiException
     *             TwitterAPI呼び出し時アプリ例外
     */
    public String prepareRedirectUrl() throws TwitterApiException {
        return prepareRedirectUrl(null);
    }

    /**
     * サービスプロバイダに対しリクエストを発行し、認証するために必要なリダイレクトの
     * URLを取得します。<br />
     * リダイレクトのURLにはアクセスに必要なOAuthトークンが付加されます
     * 
     * @param params callbackUrlに付加したいパラメータ
     * @throws TwitterApiException
     *             TwitterAPI呼び出し時アプリ例外
     */
    public String prepareRedirectUrl(Parameters params) throws TwitterApiException {
        //Gae上ではURLConnectionClientしか使用できないためこの実装を使う
        OAuthClient client = new OAuthClient(new URLConnectionClient());
        OAuthServiceProvider provider =
            new OAuthServiceProvider(sp.getRequestTokenUrl(), sp.getAuthorizeUrl(),
                    sp.getAccessTokenUrl());
        OAuthConsumer consumer =
            new OAuthConsumer(sp.getCallBackUrl(), sp.getConsumerKey(), sp.getConsumerSecret(),
                    provider);
        OAuthAccessor accessor = new OAuthAccessor(consumer);
        try {
            if (params != null && params.getParams().size() > 0) {
                Map<String, String> requestMap = new HashMap<String, String>();
                requestMap.put("oauth_callback", OAuth.addParameters(accessor.consumer.callbackURL,
                    params.getParams().entrySet()));
            }
            client.getRequestToken(accessor, null, null);
        } catch (IOException e) {
            throw new TwitterApiException(
                    "An exception has occurred while getting the request to issue a RequestToken",
                    e);
        } catch (OAuthException e) {
            throw new TwitterApiException(
                    "An authentication exception has occurred while receive requests to issue a RequestToken",
                    e);
        } catch (URISyntaxException e) {
            e.printStackTrace(System.err);
            //ログに出力してあとは無視
        }
        String redirectTo;
        try {
            redirectTo =
                OAuth.addParameters(accessor.consumer.serviceProvider.userAuthorizationURL,
                    "oauth_token", accessor.requestToken//
                );
            System.err.println("redirectTo=" + redirectTo);
        } catch (IOException e) {
            throw new TwitterApiException("An exception occurred while getting the redirect url", e);
        }
        return redirectTo;
    }

    public static class CallBackParameter {
        private CallBackParameter() {
        }

        public static Parameters add(String key, String value) {
            return new Parameters(key, value);
        }

        public static class Parameters {
            private Map<String, String> params;

            private Parameters(String key, String value) {
                params = new HashMap<String, String>();
                params.put(key, value);
            }

            public Parameters add(String key, String value) {
                params.put(key, value);
                return this;
            }

            private Map<String, String> getParams() {
                return params;
            }
        }
    }

    /**
     * コールバックにて呼び出されたアクセスから、再度認証が正式なものかどうかの
     * 判定を行い、応答からリクエストに必要な情報をユーザ情報に設定して返します。
     * 
     * @param request Httpサーブレットリクエスト
     * @return 認証済み情報
     * @throws TwitterApiException
     *             TwitterAPI呼び出し時アプリ例外
     */
    public BaseUser verifyUserCredentials(HttpServletRequest request) throws TwitterApiException {
        String requestToken = request.getParameter(OAuth.OAUTH_TOKEN);
        if (requestToken == null) {
            throw new TwitterApiException("twitter authenticate is failed. requestToken ["
                + requestToken
                + "]");
        }
        String verifier = request.getParameter(OAuth.OAUTH_VERIFIER);
        if (verifier == null) {
            throw new TwitterApiException("twitter authenticate is failed. verifier ["
                + verifier
                + "]");
        }
        OAuthClient client = new OAuthClient(new URLConnectionClient());
        OAuthServiceProvider provider =
            new OAuthServiceProvider(sp.getRequestTokenUrl(), sp.getAuthorizeUrl(),
                    sp.getAccessTokenUrl());
        OAuthConsumer consumer =
            new OAuthConsumer(sp.getCallBackUrl(), sp.getConsumerKey(), sp.getConsumerSecret(),
                    provider);
        OAuthAccessor accessor = new OAuthAccessor(consumer);
        accessor.requestToken = requestToken;
        OAuthMessage oMessage = null;
        BaseUser user = sp.createNewUserInstance();
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put(OAuth.OAUTH_VERIFIER, verifier);
            client.getAccessToken(accessor, null, params.entrySet());
            oMessage = accessor.newRequestMessage("GET", sp.getVerfyCredentialsUrl(), null);
            OAuthResponseMessage responseMessage =
                client.access(oMessage, ParameterStyle.AUTHORIZATION_HEADER);
            int status = responseMessage.getHttpResponse().getStatusCode();
            if (status == HttpResponseMessage.STATUS_OK) {
                String jsonString = responseMessage.readBodyAsString();
                sp.parseVerifyCredentialsResponse(user, jsonString);
                user.setRequestToken(accessor.requestToken);
                user.setAccessToken(accessor.accessToken);
                user.setTokenSecret(accessor.tokenSecret);
                accessor.setProperty("id", user.getId());
            } else {
                throw new NotAuthorizedException("verify credentials failed.", status,
                        user.getId(), params.entrySet());
            }
        } catch (IOException e) {
            throw new TwitterApiException(
                    "An exception has occurred while getting the request to issue a AccessToken", e);
        } catch (OAuthException e) {
            throw new TwitterApiException(
                    "An authentication exception has occurred while receive requests to issue a AccessToken",
                    e);
        } catch (URISyntaxException e) {
            e.printStackTrace(System.err);
            //ログに出力してあとは無視
        }
        return user;
    }

    /**
     * リクエストを処理します。<br />
     * 各リクエストに必要な固有な情報や、レスポンスを解析してオブジェクトに
     * 設定する処理は全て引数で渡されるプロセッサによって行われます。
     * 
     * @param <T> レスポンスオブジェクト
     * @param baseUser 基本ユーザ情報
     * @param processor 各リクエストを個別に処理するプロセッサ
     * @return レスポンスオブジェクト
     * @throws TwitterApiException
     *             TwitterAPI呼び出し時アプリ例外
     */
    public <T extends ApiLimitHeader> T request(BaseUser baseUser,
            ServiceProvider.Processor<T> processor) throws TwitterApiException,
            UserNotFoundException, ApiLimitException, NotAuthorizedException, KujiraException {
        if (processor == null) {
            throw new NullPointerException("this method call is needed service provider processor.");
        }
        OAuthClient client = new OAuthClient(new URLConnectionClient());
        OAuthServiceProvider provider =
            new OAuthServiceProvider(sp.getRequestTokenUrl(), sp.getAuthorizeUrl(),
                    sp.getAccessTokenUrl());
        OAuthConsumer consumer =
            new OAuthConsumer(sp.getCallBackUrl(), sp.getConsumerKey(), sp.getConsumerSecret(),
                    provider);
        OAuthAccessor accessor = new OAuthAccessor(consumer);
        accessor.setProperty("id", baseUser.getId());
        accessor.accessToken = baseUser.getAccessToken();
        accessor.requestToken = baseUser.getRequestToken();
        accessor.tokenSecret = baseUser.getTokenSecret();
        OAuthMessage oMessage = null;
        T response = null;
        try {
            oMessage =
                accessor.newRequestMessage(processor.getMethod(), processor.getRequestUrl(),
                    processor.getParams());
            OAuthResponseMessage responseMessage =
                client.access(oMessage, ParameterStyle.AUTHORIZATION_HEADER);
            int status = responseMessage.getHttpResponse().getStatusCode();
            if (status == 200) {
                String jsonString = responseMessage.readBodyAsString();
                System.out.println(jsonString);
                response = processor.parseResponse(jsonString);
                String rateLimitLimit = responseMessage.getHeader("X-RateLimit-Limit");
                String rateLimitRemaining = responseMessage.getHeader("X-RateLimit-Remaining");
                response.setRateLimitLimit(rateLimitLimit == null ? 0
                    : Integer.valueOf(rateLimitLimit));
                response.setRateLimitRemaining(rateLimitRemaining == null ? 0
                    : Integer.valueOf(rateLimitRemaining));
            } else if (status == 400) {
                throw new ApiLimitException("user not found.", status, baseUser.getId(),
                        processor.getParams());
            } else if (status == 401 || status == 403) {
                throw new NotAuthorizedException("not authorized.", status, baseUser.getId(),
                        processor.getParams());
            } else if (status == 404) {
                throw new UserNotFoundException("user not found.", status, baseUser.getId(),
                        processor.getParams());
            } else if (status == 502 || status == 503) {
                throw new KujiraException("twitter server is full filled.", status,
                        baseUser.getId(), processor.getParams());
            } else {
                //TODO:304 Not Modified:新しい情報はない
                //ってどうすりゃいいの？
                throw new TwitterApiException("response status is suggest failed. status code ["
                    + status
                    + "]");
            }
        } catch (IOException e) {
            throw new TwitterApiException(
                    "An exception has occurred while requesting following method ["
                        + processor.getRequestName()
                        + "]", e);
        } catch (OAuthException e) {
            throw new TwitterApiException(
                    "An authentication exception has occurred while receive requests by following method ["
                        + processor.getRequestName()
                        + "]", e);
        } catch (URISyntaxException e) {
            e.printStackTrace(System.err);
            //無視
        }
        return response;
    }

    /**
     * Twitterからの応答でユーザが見つからない場合に投げられる例外です。
     * 
     * @author Shunichi Todoroki
     */
    public static class UserNotFoundException extends BaseException {
        private static final long serialVersionUID = 2453311860161070513L;

        public UserNotFoundException(String message, int statusCode, String id,
                Set<Entry<String, String>> params) {
            super(message, statusCode, id, params);
        }
    }

    /**
     * TwitterのAPI回数制限に引っかかった時に投げられる例外です。
     * 
     * @author Shunichi Todoroki
     */
    public static class ApiLimitException extends BaseException {
        private static final long serialVersionUID = -4366573481728176131L;

        public ApiLimitException(String message, int statusCode, String id,
                Set<Entry<String, String>> params) {
            super(message, statusCode, id, params);
        }
    }

    /**
     * Twitterで認証に失敗した場合に投げられる例外です。
     * 
     * @author Shunichi Todoroki
     */
    public static class NotAuthorizedException extends BaseException {
        private static final long serialVersionUID = 3885327119318565447L;

        public NotAuthorizedException(String message, int statusCode, String id,
                Set<Entry<String, String>> params) {
            super(message, statusCode, id, params);
        }
    }

    /**
     * Twitter側が、サーバが止まっていたりメンテ中の場合、あるいは
     * サーバの負荷が高すぎてリクエストを裁き切れない時に投げられる例外です。
     * 
     * @author Shunichi Todoroki
     */
    public static class KujiraException extends BaseException {
        private static final long serialVersionUID = -6561057922309454959L;

        public KujiraException(String message, int statusCode, String id,
                Set<Entry<String, String>> params) {
            super(message, statusCode, id, params);
        }
    }

    protected static class BaseException extends TwitterApiException {
        private static final long serialVersionUID = -633849508575943229L;

        public BaseException(String message, int statusCode, String id,
                Set<Entry<String, String>> params) {
            super(message
                + " status code ["
                + statusCode
                + "], id ["
                + id
                + "], params ["
                + params
                + "]");
        }
    }

    public static class TwitterApiException extends Exception {
        private static final long serialVersionUID = -3696036231214097674L;

        public TwitterApiException() {
            super();
        }

        public TwitterApiException(String message) {
            super(message);
        }

        public TwitterApiException(String message, Throwable cause) {
            super(message, cause);
        }

        public TwitterApiException(Throwable cause) {
            super(cause);
        }
    }
}
