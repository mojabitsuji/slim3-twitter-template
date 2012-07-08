package jp.coxs.twitter.favrt.model.json;

import java.util.Arrays;

/**
 * Twitter����̉�����Json�Ŏ󂯎�鎞�Ɏg�p����G���e�B�e�B�N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
public class BoundingBox {
    private double[][][] coordinates;
    private String type;

    public double[][][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[][][] coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BoundingBox [coordinates=" + Arrays.toString(coordinates) + ", type=" + type + "]";
    }
}
