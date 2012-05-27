package jp.coxs.twitter.favrt.model.json;

/**
 * Twitterからの応答をJsonで受け取る時に使用するエンティティクラスです。
 * 
 * @author Shunichi Todoroki
 */
public class Place {
    private String countryCode;
    private BoundingBox boundingBox;
    private String name;
    private String id;
    private String country;
    private String placeType;
    private String fullName;
    private String url;
    private Attributes attributes;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Place [attributes="
            + attributes
            + ", boundingBox="
            + boundingBox
            + ", country="
            + country
            + ", countryCode="
            + countryCode
            + ", fullName="
            + fullName
            + ", id="
            + id
            + ", name="
            + name
            + ", placeType="
            + placeType
            + ", url="
            + url
            + "]";
    }
}
