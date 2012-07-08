package jp.coxs.twitter.favrt.model.json;

/**
 * Twitterからの応答をJsonで受け取る時に使用するエンティティクラスです。<br />
 * status系エンティティのベースになるクラスです。
 * 
 * @author Shunichi Todoroki
 */
public class BaseStatus {
    private Coordinates coordinates;
    private boolean favorited;
    private boolean truncated;
    private String createdAt;
    private String idStr;
    private String inReplyToUserIdStr;
    private String text;
    private String contributors;
    private int id;
    private int retweetCount;
    private String inReplyToStatusIdStr;
    private Geo geo;
    private boolean retweeted;
    private String inReplyToUserId;
    private String source;
    private Place place;
    private String inReplyToScreenName;
    private String inReplyToStatusId;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    public void setInReplyToUserIdStr(String inReplyToUserIdStr) {
        this.inReplyToUserIdStr = inReplyToUserIdStr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContributors() {
        return contributors;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public String getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    public void setInReplyToStatusIdStr(String inReplyToStatusIdStr) {
        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    public String getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(String inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public String getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(String inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    @Override
    public String toString() {
        return "BaseStatus [coordinates="
            + coordinates
            + ", favorited="
            + favorited
            + ", truncated="
            + truncated
            + ", createdAt="
            + createdAt
            + ", idStr="
            + idStr
            + ", inReplyToUserIdStr="
            + inReplyToUserIdStr
            + ", text="
            + text
            + ", contributors="
            + contributors
            + ", id="
            + id
            + ", retweetCount="
            + retweetCount
            + ", inReplyToStatusIdStr="
            + inReplyToStatusIdStr
            + ", geo="
            + geo
            + ", retweeted="
            + retweeted
            + ", inReplyToUserId="
            + inReplyToUserId
            + ", source="
            + source
            + ", place="
            + place
            + ", inReplyToScreenName="
            + inReplyToScreenName
            + ", inReplyToStatusId="
            + inReplyToStatusId
            + "]";
    }
}
