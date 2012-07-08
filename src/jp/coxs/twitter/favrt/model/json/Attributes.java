package jp.coxs.twitter.favrt.model.json;

/**
 * Twitterからの応答をJsonで受け取る時に使用するエンティティクラスです。 *
 * 
 * @author Shunichi Todoroki
 */
public class Attributes {
    private String streetAddress;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Override
    public String toString() {
        return "Attributes [streetAddress=" + streetAddress + "]";
    }
}
