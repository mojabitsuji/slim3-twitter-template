package jp.coxs.twitter.favrt.model.json;

import java.util.Arrays;

/**
 * Twitter����̉�����Json�Ŏ󂯎�鎞�Ɏg�p����G���e�B�e�B�N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
public class Geo {
    private String type;
    private double[] coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Geo [coordinates=" + Arrays.toString(coordinates) + ", type=" + type + "]";
    }
}
