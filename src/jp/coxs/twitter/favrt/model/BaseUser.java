package jp.coxs.twitter.favrt.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * ユーザの基本的な情報を保持するエンティティクラスです。
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
     * ユーザIDを返します。
     * 
     * @return ユーザID
     */
    public String getId() {
        return id;
    }

    /**
     * ユーザIDを設定します。
     * 
     * @param id ユーザID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * OAuthで取得したRequestTokenを返します。
     * 
     * @return RequestToken
     */
    public String getRequestToken() {
        return requestToken;
    }

    /**
     * OAuthで取得したRequestTokenを設定します。
     * 
     * @param requestToken RequestToken
     */
    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    /**
     * OAuthで取得したAccessTokenを返します。
     * 
     * @return AccessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * OAuthで取得したAccessTokenを設定します。
     * 
     * @param accessToken AccessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * OAuthで取得したTokenSecretを返します。
     * 
     * @return TokenSecret
     */
    public String getTokenSecret() {
        return tokenSecret;
    }

    /**
     * OAuthで取得したTokenSecretを設定します。
     * 
     * @param tokenSecret TokenSecret
     */
    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    /**
     * 更新日時を返します。
     * 
     * @return 更新日時
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新日時を設定します。
     * 
     * @param updateDate 更新日時
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
