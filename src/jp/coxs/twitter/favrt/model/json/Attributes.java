package jp.coxs.twitter.favrt.model.json;

/**
 * Twitter����̉�����Json�Ŏ󂯎�鎞�Ɏg�p����G���e�B�e�B�N���X�ł��B *
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
