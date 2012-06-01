package jp.coxs.twitter.favrt.model.json;

import com.google.gson.annotations.SerializedName;

/**
 * Twitterからの応答をJsonで受け取る時に使用する エンティティクラスです。
 * 
 * @author Shunichi Todoroki
 */
public class User {
    private boolean contributorsEnabled;
    private String createdAt;
    private boolean defaultProfile;
    private String defaultProfileImage;
    private String description;
    private int favouritesCount;
    private boolean followRequestSent;
    private int followersCount;
    private boolean following;
    private int friendsCount;
    private boolean geoEnabled;
    private String id;
    private String idStr;
    private boolean isTranslator;
    private String lang;
    private int listedCount;
    private String location;
    private String name;
    private boolean notifications;
    private String profileBackgroundColor;
    private String profileBackgroundImageUrl;
    private String profileBackgroundImageUrlHttps;
    private String profileBackgroundTile;
    private String profileImageUrl;
    private String profileImageUrlHttps;
    private String profileLinkColor;
    private String profileSidebarBorderColor;
    private String profileSidebarFillColor;
    private String profileTextColor;
    private String profileUseBackgroundImage;
    @SerializedName("protected")
    private boolean escapedProtected;
    private String screenName;
    private boolean showAllInlineMedia;
    private Status status;
    private int statusesCount;
    private String timeZone;
    private String url;
    private int utcOffset;
    private boolean verified;

    public boolean isContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public String getDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(String defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(int favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public boolean isFollowRequestSent() {
        return followRequestSent;
    }

    public void setFollowRequestSent(boolean followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public boolean isGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public boolean isTranslator() {
        return isTranslator;
    }

    public void setTranslator(boolean isTranslator) {
        this.isTranslator = isTranslator;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getListedCount() {
        return listedCount;
    }

    public void setListedCount(int listedCount) {
        this.listedCount = listedCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNotifications() {
        return notifications;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    public String getProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    public void setProfileBackgroundTile(String profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    public String getProfileTextColor() {
        return profileTextColor;
    }

    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    public String getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(String profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public boolean isProtected() {
        return escapedProtected;
    }

    public void setProtected(boolean escapedProtected) {
        this.escapedProtected = escapedProtected;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public boolean isShowAllInlineMedia() {
        return showAllInlineMedia;
    }

    public void setShowAllInlineMedia(boolean showAllInlineMedia) {
        this.showAllInlineMedia = showAllInlineMedia;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(int statusesCount) {
        this.statusesCount = statusesCount;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("User [contributorsEnabled=").append(contributorsEnabled).append(
            ", createdAt=").append(createdAt).append(", defaultProfile=").append(defaultProfile).append(
            ", defaultProfileImage=").append(defaultProfileImage).append(", description=").append(
            description).append(", escapedProtected=").append(escapedProtected).append(
            ", favouritesCount=").append(favouritesCount).append(", followRequestSent=").append(
            followRequestSent).append(", followersCount=").append(followersCount).append(
            ", following=").append(following).append(", friendsCount=").append(friendsCount).append(
            ", geoEnabled=").append(geoEnabled).append(", id=").append(id).append(", idStr=").append(
            idStr).append(", isTranslator=").append(isTranslator).append(", lang=").append(lang).append(
            ", listedCount=").append(listedCount).append(", location=").append(location).append(
            ", name=").append(name).append(", notifications=").append(notifications).append(
            ", profileBackgroundColor=").append(profileBackgroundColor).append(
            ", profileBackgroundImageUrl=").append(profileBackgroundImageUrl).append(
            ", profileBackgroundTile=").append(profileBackgroundTile).append(", profileImageUrl=").append(
            profileImageUrl).append(", profileLinkColor=").append(profileLinkColor).append(
            ", profileSidebarBorderColor=").append(profileSidebarBorderColor).append(
            ", profileSidebarFillColor=").append(profileSidebarFillColor).append(
            ", profileTextColor=").append(profileTextColor).append(", profileUseBackgroundImage=").append(
            profileUseBackgroundImage).append(", screenName=").append(screenName).append(
            ", showAllInlineMedia=").append(showAllInlineMedia).append(", status=").append(status).append(
            ", statusesCount=").append(statusesCount).append(", timeZone=").append(timeZone).append(
            ", url=").append(url).append(", utcOffset=").append(utcOffset).append(", verified=").append(
            verified).append("]").toString();
    }
}
