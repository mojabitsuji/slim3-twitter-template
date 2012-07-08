package jp.coxs.twitter.favrt.model.json;

/**
 * Twitterからの応答をJsonで受け取る時に使用するエンティティクラスです。
 * 
 * @author Shunichi Todoroki
 */
public class Place {
    private String name;
    private String countryCode;
    private String country;
    private Attributes attributes;
    private String url;
    private String id;
    private BoundingBox boundingBox;
    private String fullName;
    private String placeType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    @Override
    public String toString() {
        return "Place [name="
            + name
            + ", countryCode="
            + countryCode
            + ", country="
            + country
            + ", attributes="
            + attributes
            + ", url="
            + url
            + ", id="
            + id
            + ", boundingBox="
            + boundingBox
            + ", fullName="
            + fullName
            + ", placeType="
            + placeType
            + "]";
    }
}
