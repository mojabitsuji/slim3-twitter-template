package jp.coxs.twitter.favrt.model.json;

public class BaseStatus {
    //使わないのに、parse用のクラスがめんどくさいのでコメントアウト
    //private Coordinates coordinates;
    private String text;
    private String idStr;
    private String inReplyToStatusId;
    private String favorited;
    private String retweetCount;
    //private Geo geo;
    private String inReplyToScreenName;
    private String source;
    private String inReplyToStatusIdStr;
    private String contributors;
    private String retweeted;
    private String inReplyToUserIdStr;
    private String inReplyToUserId;
    private String createdAt;
    //private Place place;
    private String truncated;
    private String id;

    //public Coordinates getCoordinates() {
    //    return coordinates;
    //}
    //
    //public void setCoordinates(Coordinates coordinates) {
    //    this.coordinates = coordinates;
    //}
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(String inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public String getFavorited() {
        return favorited;
    }

    public void setFavorited(String favorited) {
        this.favorited = favorited;
    }

    public String getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(String retweetCount) {
        this.retweetCount = retweetCount;
    }

    //public Geo getGeo() {
    //    return geo;
    //}
    //
    //public void setGeo(Geo geo) {
    //    this.geo = geo;
    //}
    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    public void setInReplyToStatusIdStr(String inReplyToStatusIdStr) {
        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
    }

    public String getContributors() {
        return contributors;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    public String getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(String retweeted) {
        this.retweeted = retweeted;
    }

    public String getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    public void setInReplyToUserIdStr(String inReplyToUserIdStr) {
        this.inReplyToUserIdStr = inReplyToUserIdStr;
    }

    public String getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(String inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    //public Place getPlace() {
    //    return place;
    //}
    //
    //public void setPlace(Place place) {
    //    this.place = place;
    //}
    public String getTruncated() {
        return truncated;
    }

    public void setTruncated(String truncated) {
        this.truncated = truncated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Status [contributors=").append(contributors).append(
            ", coordinates=").append(", createdAt=").append(", id=").append(id).append(
            ", idStr=").append(idStr).append(", inReplyToScreenName=").append(
            inReplyToScreenName).append(", inReplyToStatusId=").append(
            inReplyToStatusId).append(", inReplyToStatusIdStr=").append(
            inReplyToStatusIdStr).append(", inReplyToUserId=").append(inReplyToUserId).append(
            ", inReplyToUserIdStr=").append(inReplyToUserIdStr).append(", place=").append(
            ", retweetCount=").append(retweetCount).append(", retweeted=").append(
            retweeted).append(", source=").append(source).append(", text=").append(
            text).append(", truncated=").append(truncated).append("]").toString();
    }
}
