package jp.coxs.twitter.favrt.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import jp.coxs.twitter.favrt.model.BaseUser;
import jp.coxs.twitter.favrt.model.json.ApiLimitHeader;
import jp.coxs.twitter.favrt.util.TwitterServiceProvider.DebugProcessor;

/**
 * 各サービスプロバイダーが固有の処理やプロパティをを持つ抽象クラスです。
 * 
 * @author Shunichi Todoroki
 */
public abstract class ServiceProvider {
    private String oauthToken;
    private String oauthTokenSecret;
    private String oauthCallbackConfirmed;

    /*
     * ConsumerKeyを返します。
     */
    abstract String getConsumerKey();

    /*
     * CosumerSecretを返します。
     */
    abstract String getConsumerSecret();

    /*
     * RequestTokenUrlを返します。
     */
    abstract String getRequestTokenUrl();

    /*
     * AccessTokenUrlを返します。
     */
    abstract String getAccessTokenUrl();

    /*
     * AuthorizeUrlを返します。
     */
    abstract String getAuthorizeUrl();

    /*
     * VerfyCredentialsUrlを返します。
     */
    abstract String getVerfyCredentialsUrl();

    /*
     * CallBackUrlを返します。
     */
    abstract String getCallBackUrl();

    /**
     * OauthTokenを返します。
     * 
     * @return OauthToken
     */
    public String getOauthToken() {
        return oauthToken;
    }

    /**
     * OauthTokenを設定します。
     * 
     * @param oauthToken OauthToken
     */
    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

    /**
     * OauthTokenSecretを返します。
     * 
     * @return OauthTokenSecret
     */
    public String getOauthTokenSecret() {
        return oauthTokenSecret;
    }

    /**
     * OauthTokenSecretを設定します。
     * 
     * @param oauthTokenSecret OauthTokenSecret
     */
    public void setOauthTokenSecret(String oauthTokenSecret) {
        this.oauthTokenSecret = oauthTokenSecret;
    }

    /**
     * OauthCallbackConfirmedを返します。
     * 
     * @return OauthCallbackConfirmed
     */
    public String getOauthCallbackConfirmed() {
        return oauthCallbackConfirmed;
    }

    /**
     * OauthCallbackConfirmedを設定します。
     * 
     * @param oauthCallbackConfirmed
     *            OauthCallbackConfirmed
     */
    public void setOauthCallbackConfirmed(String oauthCallbackConfirmed) {
        this.oauthCallbackConfirmed = oauthCallbackConfirmed;
    }

    /**
     * ユーザ情報のインスタンスを返します。
     * 
     * @return BaseUser
     */
    abstract BaseUser createNewUserInstance();

    /**
     * 認証確認で戻ってきたJson文字列から、ユーザ基本情報に値を設定して返します。
     * 
     * @param <T extends BaseUser>
     * @param user ユーザオブジェクト
     * @param jsonString 応答Json文字列
     */
    abstract <T extends BaseUser> void parseVerifyCredentialsResponse(T user,
            String jsonString);

    /**
     * 各リクエストに固有の処理を行うプロセッサインターフェースです。
     * ※だめだなこりゃ、Twitterに依存しちゃってる
     * 。ApiLimitHeaderも。とりあえず面倒くさいので必要ないし直さない。
     * 
     * @author Shunichi Todoroki
     * @param <T> 応答オブジェクト
     */
    public static abstract class Processor<T extends ApiLimitHeader> {
        private Map<String, String> params = new HashMap<String, String>();

        public abstract String getRequestName();

        public abstract String getMethod();

        public abstract String getRequestUrl();

        public abstract T parseResponse(String jsonString);

        public abstract DebugProcessor<T> toDebugProcessor();

        Processor() {
        }

        public void addUserId(String userId) {
            String id = params.get("user_id");
            if(id == null) {
                params.put("user_id", userId);
            } else {
                params.put("user_id", id + "," + userId);
            }
        }

        public void setUserId(String userId) {
            params.put("user_id", userId);
        }

        public void setScreenName(String screenName) {
            params.put("screen_name", screenName);
        }

        public void setPage(String page) {
            params.put("page", page);
        }

        public void setCount(int count) {
            params.put("count", String.valueOf(count));
        }

        public void setCursor(String cursor) {
            params.put("cursor", cursor);
        }

        public void setLite(boolean lite) {
            params.put("lite", Boolean.toString(lite));
        }

        public Set<Entry<String, String>> getParams() {
            return params.entrySet();
        }
    }
}
