package jp.coxs.twitter.favrt.model.json;

/**
 * Twitterからの応答をJsonで受け取る時に使用する
 * エンティティクラスです。
 * 
 * @author Shunichi Todoroki
 */
public class User {
    private String followRequestSent;
    private String friendsCount;
    private long id;
    private String idStr;
    private String following;
    private String profileTextColor;
    private String description;
    private Status status;
    private String profileSidebarFillColor;
    private String followersCount;
    private String isTranslator;
    private String profileBackgroundTile;
    private String location;
    private String listedCount;
    private String contributorsEnabled;
    private String showAllInlineMedia;
    private String geoEnabled;
    private String timeZone;
    private String profileLinkColor;
    private String url;
    private String profileSidebarBorderColor;
    private String lang;
    private String verified;
    private String notifications;
    private String favouritesCount;
    private String createdAt;
    private String escapedProtected;
    private String profileImageUrl;
    private String defaultProfileImage;
    private String statusesCount;
    private String profileUseBackgroundImage;
    private String name;
    private String profileBackgroundColor;
    private String screenName;
    private String defaultProfile;
    private String profileBackgroundImageUrl;
    private String utcOffset;
    public String getFollowRequestSent() {
        return followRequestSent;
    }
    public void setFollowRequestSent(String followRequestSent) {
        this.followRequestSent = followRequestSent;
    }
    public String getFriendsCount() {
        return friendsCount;
    }
    public void setFriendsCount(String friendsCount) {
        this.friendsCount = friendsCount;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getIdStr() {
        return idStr;
    }
    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }
    public String getFollowing() {
        return following;
    }
    public void setFollowing(String following) {
        this.following = following;
    }
    public String getProfileTextColor() {
        return profileTextColor;
    }
    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }
    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }
    public String getFollowersCount() {
        return followersCount;
    }
    public void setFollowersCount(String followersCount) {
        this.followersCount = followersCount;
    }
    public String getIsTranslator() {
        return isTranslator;
    }
    public void setIsTranslator(String isTranslator) {
        this.isTranslator = isTranslator;
    }
    public String getProfileBackgroundTile() {
        return profileBackgroundTile;
    }
    public void setProfileBackgroundTile(String profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getListedCount() {
        return listedCount;
    }
    public void setListedCount(String listedCount) {
        this.listedCount = listedCount;
    }
    public String getContributorsEnabled() {
        return contributorsEnabled;
    }
    public void setContributorsEnabled(String contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }
    public String getShowAllInlineMedia() {
        return showAllInlineMedia;
    }
    public void setShowAllInlineMedia(String showAllInlineMedia) {
        this.showAllInlineMedia = showAllInlineMedia;
    }
    public String getGeoEnabled() {
        return geoEnabled;
    }
    public void setGeoEnabled(String geoEnabled) {
        this.geoEnabled = geoEnabled;
    }
    public String getTimeZone() {
        return timeZone;
    }
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
    public String getProfileLinkColor() {
        return profileLinkColor;
    }
    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }
    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }
    public String getLang() {
        return lang;
    }
    public void setLang(String lang) {
        this.lang = lang;
    }
    public String getVerified() {
        return verified;
    }
    public void setVerified(String verified) {
        this.verified = verified;
    }
    public String getNotifications() {
        return notifications;
    }
    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }
    public String getFavouritesCount() {
        return favouritesCount;
    }
    public void setFavouritesCount(String favouritesCount) {
        this.favouritesCount = favouritesCount;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getEscapedProtected() {
        return escapedProtected;
    }
    public void setProtected(String escapedProtected) {
        this.escapedProtected = escapedProtected;
    }
    public String getProfileImageUrl() {
        return profileImageUrl;
    }
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
    public String getDefaultProfileImage() {
        return defaultProfileImage;
    }
    public void setDefaultProfileImage(String defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }
    public String getStatusesCount() {
        return statusesCount;
    }
    public void setStatusesCount(String statusesCount) {
        this.statusesCount = statusesCount;
    }
    public String getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }
    public void setProfileUseBackgroundImage(String profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }
    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }
    public String getScreenName() {
        return screenName;
    }
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
    public String getDefaultProfile() {
        return defaultProfile;
    }
    public void setDefaultProfile(String defaultProfile) {
        this.defaultProfile = defaultProfile;
    }
    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }
    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }
    public String getUtcOffset() {
        return utcOffset;
    }
    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("User [contributorsEnabled=").append(
            contributorsEnabled).append(", createdAt=").append(createdAt).append(
            ", defaultProfile=").append(defaultProfile).append(
            ", defaultProfileImage=").append(defaultProfileImage).append(
            ", description=").append(description).append(", escapedProtected=").append(
            escapedProtected).append(", favouritesCount=").append(
            favouritesCount).append(", followRequestSent=").append(
            followRequestSent).append(", followersCount=").append(
            followersCount).append(", following=").append(following).append(
            ", friendsCount=").append(friendsCount).append(", geoEnabled=").append(
            geoEnabled).append(", id=").append(id).append(", idStr=").append(
            idStr).append(", isTranslator=").append(isTranslator).append(
            ", lang=").append(lang).append(", listedCount=").append(listedCount).append(
            ", location=").append(location).append(", name=").append(name).append(
            ", notifications=").append(notifications).append(
            ", profileBackgroundColor=").append(profileBackgroundColor).append(
            ", profileBackgroundImageUrl=").append(profileBackgroundImageUrl).append(
            ", profileBackgroundTile=").append(profileBackgroundTile).append(
            ", profileImageUrl=").append(profileImageUrl).append(
            ", profileLinkColor=").append(profileLinkColor).append(
            ", profileSidebarBorderColor=").append(profileSidebarBorderColor).append(
            ", profileSidebarFillColor=").append(profileSidebarFillColor).append(
            ", profileTextColor=").append(profileTextColor).append(
            ", profileUseBackgroundImage=").append(profileUseBackgroundImage).append(
            ", screenName=").append(screenName).append(", showAllInlineMedia=").append(
            showAllInlineMedia).append(", status=").append(status).append(
            ", statusesCount=").append(statusesCount).append(", timeZone=").append(
            timeZone).append(", url=").append(url).append(", utcOffset=").append(
            utcOffset).append(", verified=").append(verified).append("]").toString();
   }
}
