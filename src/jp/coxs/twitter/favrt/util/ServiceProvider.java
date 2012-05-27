package jp.coxs.twitter.favrt.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import jp.coxs.twitter.favrt.model.BaseUser;
import jp.coxs.twitter.favrt.model.json.ApiLimitHeader;
import jp.coxs.twitter.favrt.util.TwitterServiceProvider.DebugProcessor;

/**
 * �e�T�[�r�X�v���o�C�_�[���ŗL�̏�����v���p�e�B���������ۃN���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
public abstract class ServiceProvider {
    private String oauthToken;
    private String oauthTokenSecret;
    private String oauthCallbackConfirmed;

    /*
     * ConsumerKey��Ԃ��܂��B
     */
    abstract String getConsumerKey();

    /*
     * CosumerSecret��Ԃ��܂��B
     */
    abstract String getConsumerSecret();

    /*
     * RequestTokenUrl��Ԃ��܂��B
     */
    abstract String getRequestTokenUrl();

    /*
     * AccessTokenUrl��Ԃ��܂��B
     */
    abstract String getAccessTokenUrl();

    /*
     * AuthorizeUrl��Ԃ��܂��B
     */
    abstract String getAuthorizeUrl();

    /*
     * VerfyCredentialsUrl��Ԃ��܂��B
     */
    abstract String getVerfyCredentialsUrl();

    /*
     * CallBackUrl��Ԃ��܂��B
     */
    abstract String getCallBackUrl();

    /**
     * OauthToken��Ԃ��܂��B
     * 
     * @return OauthToken
     */
    public String getOauthToken() {
        return oauthToken;
    }

    /**
     * OauthToken��ݒ肵�܂��B
     * 
     * @param oauthToken OauthToken
     */
    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

    /**
     * OauthTokenSecret��Ԃ��܂��B
     * 
     * @return OauthTokenSecret
     */
    public String getOauthTokenSecret() {
        return oauthTokenSecret;
    }

    /**
     * OauthTokenSecret��ݒ肵�܂��B
     * 
     * @param oauthTokenSecret OauthTokenSecret
     */
    public void setOauthTokenSecret(String oauthTokenSecret) {
        this.oauthTokenSecret = oauthTokenSecret;
    }

    /**
     * OauthCallbackConfirmed��Ԃ��܂��B
     * 
     * @return OauthCallbackConfirmed
     */
    public String getOauthCallbackConfirmed() {
        return oauthCallbackConfirmed;
    }

    /**
     * OauthCallbackConfirmed��ݒ肵�܂��B
     * 
     * @param oauthCallbackConfirmed
     *            OauthCallbackConfirmed
     */
    public void setOauthCallbackConfirmed(String oauthCallbackConfirmed) {
        this.oauthCallbackConfirmed = oauthCallbackConfirmed;
    }

    /**
     * ���[�U���̃C���X�^���X��Ԃ��܂��B
     * 
     * @return BaseUser
     */
    abstract BaseUser createNewUserInstance();

    /**
     * �F�؊m�F�Ŗ߂��Ă���Json�����񂩂�A���[�U��{���ɒl��ݒ肵�ĕԂ��܂��B
     * 
     * @param <T extends BaseUser>
     * @param user ���[�U�I�u�W�F�N�g
     * @param jsonString ����Json������
     */
    abstract <T extends BaseUser> void parseVerifyCredentialsResponse(T user,
            String jsonString);

    /**
     * �e���N�G�X�g�ɌŗL�̏������s���v���Z�b�T�C���^�[�t�F�[�X�ł��B
     * �����߂��Ȃ����ATwitter�Ɉˑ���������Ă�
     * �BApiLimitHeader���B�Ƃ肠�����ʓ|�������̂ŕK�v�Ȃ��������Ȃ��B
     * 
     * @author Shunichi Todoroki
     * @param <T> �����I�u�W�F�N�g
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
