package jp.coxs.twitter.favrt.model.json;

import java.util.Arrays;

/**
 * Twitter����̉�����Json�Ŏ󂯎�鎞�Ɏg�p����G���e�B�e�B�N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
@Done
public class Hashtag {
    private String text;
    private int[] indices;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }

    @Override
    public String toString() {
        return "Hashtag [text=" + text + ", indices=" + Arrays.toString(indices) + "]";
    }
}
