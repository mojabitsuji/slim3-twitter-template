package jp.coxs.twitter.favrt.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * ���[�U�̊�{�I�ȏ���ێ�����G���e�B�e�B�N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
@Model(schemaVersion = 1)
public class BaseUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Attribute(primaryKey = true)
    private Key key;
    @Attribute(version = true)
    private Long version;
    private String id;
    private String requestToken;
    private String accessToken;
    private String tokenSecret;
    private Date updateDate;

    /**
     * ���[�UID��Ԃ��܂��B
     * 
     * @return ���[�UID
     */
    public String getId() {
        return id;
    }

    /**
     * ���[�UID��ݒ肵�܂��B
     * 
     * @param id ���[�UID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * OAuth�Ŏ擾����RequestToken��Ԃ��܂��B
     * 
     * @return RequestToken
     */
    public String getRequestToken() {
        return requestToken;
    }

    /**
     * OAuth�Ŏ擾����RequestToken��ݒ肵�܂��B
     * 
     * @param requestToken RequestToken
     */
    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    /**
     * OAuth�Ŏ擾����AccessToken��Ԃ��܂��B
     * 
     * @return AccessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * OAuth�Ŏ擾����AccessToken��ݒ肵�܂��B
     * 
     * @param accessToken AccessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * OAuth�Ŏ擾����TokenSecret��Ԃ��܂��B
     * 
     * @return TokenSecret
     */
    public String getTokenSecret() {
        return tokenSecret;
    }

    /**
     * OAuth�Ŏ擾����TokenSecret��ݒ肵�܂��B
     * 
     * @param tokenSecret TokenSecret
     */
    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    /**
     * �X�V������Ԃ��܂��B
     * 
     * @return �X�V����
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * �X�V������ݒ肵�܂��B
     * 
     * @param updateDate �X�V����
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Returns the key.
     * 
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     * 
     * @param key the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     * 
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     * 
     * @param version the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        BaseUser other = (BaseUser) obj;
        if(key == null) {
            if(other.key != null) {
                return false;
            }
        } else if(!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (new StringBuilder()).append("id [").append(id).append(
            "], requestToken [***], accessToken [***], tokenSecret [***], updateDate [").append(
            updateDate).append("]").toString();
    }
}
