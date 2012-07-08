package jp.coxs.twitter.favrt.model.json;

import java.util.Arrays;

/**
 * Twitter����̉�����Json�Ŏ󂯎�鎞�Ɏg�p����G���e�B�e�B�N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
@Done
public class UserMention {
    private String name;
    private int id;
    private String idStr;
    private int[] indices;
    private String screenName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @Override
    public String toString() {
        return "UserMention [name="
            + name
            + ", id="
            + id
            + ", idStr="
            + idStr
            + ", indices="
            + Arrays.toString(indices)
            + ", screenName="
            + screenName
            + "]";
    }
}
