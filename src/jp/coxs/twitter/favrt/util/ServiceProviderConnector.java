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
 * �T�[�r�X�v���o�C�_�ւ̐ڑ�����������N���X�ł��B<br />
 * �}���`�X���b�h�ɑΉ����Ă��Ȃ��̂Ŗ���C���X�^���X�����Ă��������B
 * 
 * @author Shunichi Todoroki
 */
public class ServiceProviderConnector {
    private ServiceProvider sp;

    /**
     * �R���X�g���N�^�B
     * 
     * @param sp �T�[�r�X�v���o�C�_�Ɉˑ��������ێ�����N���X
     */
    public ServiceProviderConnector(ServiceProvider sp) {
        if (sp == null) {
            throw new NullPointerException(
                    "this connector class instance initialize is needed service provider.");
        }
        this.sp = sp;
    }

    /**
     * �T�[�r�X�v���o�C�_�ɑ΂����N�G�X�g�𔭍s���A�F�؂��邽�߂ɕK�v�ȃ��_�C���N�g��
     * URL���擾���܂��B<br />
     * ���_�C���N�g��URL�ɂ̓A�N�Z�X�ɕK�v��OAuth�g�[�N�����t������܂�
     * 
     * @throws TwitterApiException
     *             TwitterAPI�Ăяo�����A�v����O
     */
    public String prepareRedirectUrl() throws TwitterApiException {
        return prepareRedirectUrl(null);
    }

    /**
     * �T�[�r�X�v���o�C�_�ɑ΂����N�G�X�g�𔭍s���A�F�؂��邽�߂ɕK�v�ȃ��_�C���N�g��
     * URL���擾���܂��B<br />
     * ���_�C���N�g��URL�ɂ̓A�N�Z�X�ɕK�v��OAuth�g�[�N�����t������܂�
     * 
     * @param params callbackUrl�ɕt���������p�����[�^
     * @throws TwitterApiException
     *             TwitterAPI�Ăяo�����A�v����O
     */
    public String prepareRedirectUrl(Parameters params) throws TwitterApiException {
        //Gae��ł�URLConnectionClient�����g�p�ł��Ȃ����߂��̎������g��
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
            //���O�ɏo�͂��Ă��Ƃ͖���
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
     * �R�[���o�b�N�ɂČĂяo���ꂽ�A�N�Z�X����A�ēx�F�؂������Ȃ��̂��ǂ�����
     * ������s���A�������烊�N�G�X�g�ɕK�v�ȏ������[�U���ɐݒ肵�ĕԂ��܂��B
     * 
     * @param request Http�T�[�u���b�g���N�G�X�g
     * @return �F�؍ςݏ��
     * @throws TwitterApiException
     *             TwitterAPI�Ăяo�����A�v����O
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
            //���O�ɏo�͂��Ă��Ƃ͖���
        }
        return user;
    }

    /**
     * ���N�G�X�g���������܂��B<br />
     * �e���N�G�X�g�ɕK�v�ȌŗL�ȏ���A���X�|���X����͂��ăI�u�W�F�N�g��
     * �ݒ肷�鏈���͑S�Ĉ����œn�����v���Z�b�T�ɂ���čs���܂��B
     * 
     * @param <T> ���X�|���X�I�u�W�F�N�g
     * @param baseUser ��{���[�U���
     * @param processor �e���N�G�X�g���ʂɏ�������v���Z�b�T
     * @return ���X�|���X�I�u�W�F�N�g
     * @throws TwitterApiException
     *             TwitterAPI�Ăяo�����A�v����O
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
                //TODO:304 Not Modified:�V�������͂Ȃ�
                //���Ăǂ�����Ⴂ���́H
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
            //����
        }
        return response;
    }

    /**
     * Twitter����̉����Ń��[�U��������Ȃ��ꍇ�ɓ��������O�ł��B
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
     * Twitter��API�񐔐����Ɉ��������������ɓ��������O�ł��B
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
     * Twitter�ŔF�؂Ɏ��s�����ꍇ�ɓ��������O�ł��B
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
     * Twitter�����A�T�[�o���~�܂��Ă����胁���e���̏ꍇ�A���邢��
     * �T�[�o�̕��ׂ��������ă��N�G�X�g���ق��؂�Ȃ����ɓ��������O�ł��B
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
