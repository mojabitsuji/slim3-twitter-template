package jp.coxs.twitter.favrt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

/**
 * ユーザ情報を保持するエンティティクラスです。<br />
 * Twitterが返してくる情報で必要なものはここに定義しておく
 * 
 * @author Shunichi Todoroki
 */
@Model(schemaVersion = 1)
public class TwitterUser extends BaseUser implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
     * 以下、画面表示用項目
     * TODO:正直この項目に何が入っているか知らない
     */
    @Attribute(persistent = false)
    private String screenName;
    @Attribute(persistent = false)
    private boolean defaultProfile;
    @Attribute(persistent = false)
    private String profileImageUrl;
    private String followsNextCursor;
    private Set<String> followIds;
    private Date lastFollowSearchDate;
    private boolean apiLimit;

    /**
     * スクリーン表示名称を返します。
     * 
     * @return スクリーン表示名称
     */
    public String getScreenName() {
        return screenName;
    }

    /**
     * スクリーン表示名称を設定します。
     * 
     * @param screenName スクリーン表示名称
     */
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    /**
     * デフォルトのプロフィールを返します。
     * 
     * @return デフォルトのプロフィール
     */
    public boolean getDefaultProfile() {
        return defaultProfile;
    }

    /**
     * デフォルトのプロフィールを設定します。
     * 
     * @param defaultProfile デフォルトのプロフィール
     */
    public void setDefaultProfile(boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    /**
     * プロフィール画像のURLを返します。
     * 
     * @return プロフィール画像のURL
     */
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    /**
     * プロフィール画像のURLを設定します。
     * 
     * @param profileImageUrl プロフィール画像のURL
     */
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    /**
     * 処理途中の次回フォロー取得開始のTwitterIDを返します。
     * 
     * @return 次回フォロー取得開始のTwitterID
     */
    public String getFollowsNextCursor() {
        return followsNextCursor;
    }

    /**
     * 処理途中の次回フォロー取得開始のTwitterIDを設定します。
     * 
     * @param followsNextCursor
     *            次回フォロー取得開始のTwitterID
     */
    public void setFollowsNextCursor(String followsNextCursor) {
        this.followsNextCursor = followsNextCursor;
    }

    /**
     * 自分がフォローしている人のIDのセットを返します。
     * 
     * @return 自分がフォローしている人のIDのセット
     */
    public Set<String> getFollowIds() {
        return followIds;
    }

    /**
     * 自分がフォローしている人のIDのセットを設定します。
     * 
     * @param followIds 自分がフォローしている人のIDのセット
     */
    public void setFollowIds(Set<String> followIds) {
        this.followIds = followIds;
    }

    /**
     * 最後にフォローを検索した日付を返します。
     * 
     * @return 最後にフォローを検索した日付
     */
    public Date getLastFollowSearchDate() {
        return lastFollowSearchDate;
    }

    /**
     * 最後にフォローを検索した日付を設定します。
     * 
     * @param lastFollowSearchDate 最後にフォローを検索した日付
     */
    public void setLastFollowSearchDate(Date lastFollowSearchDate) {
        this.lastFollowSearchDate = lastFollowSearchDate;
    }

    /**
     * API制限中かどうかを返します。
     * 
     * @return API制限中ならtrue
     */
    public boolean isApiLimit() {
        return apiLimit;
    }

    /**
     * API制限中か同化のフラグを設定します。
     * 
     * @param apiLimit API制限中フラグ
     */
    public void setApiLimit(boolean apiLimit) {
        this.apiLimit = apiLimit;
    }

    public String toString() {
        return (new StringBuilder()).append("screenName [").append(screenName).append(
            "], defaultProfile [").append(defaultProfile).append("], profileImageUrl [").append(
            profileImageUrl).append("], followsNextCursor [").append(followsNextCursor).append(
            "], followIds [abbreviation...], lastFollowSearchDate [").append(lastFollowSearchDate).append(
            "], apiLimit [").append(apiLimit).append("]").toString();
    }
}
