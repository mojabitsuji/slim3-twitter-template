package jp.coxs.twitter.favrt.model.json;

/**
 * Twitter����̉�����Json�Ŏ󂯎�鎞�Ɏg�p����G���e�B�e�B�N���X�ł��B<br />
 * {@link jp.coxs.twitter.favrt.model.json.User}
 * �N���X�Ɋ܂܂�܂��B
 * 
 * @author Shunichi Todoroki
 */
public class Status extends BaseStatus {
    private BaseStatus retweetedStatus;

    public BaseStatus getRetweetedStatus() {
        return retweetedStatus;
    }

    public void setRetweetedStatus(BaseStatus retweetedStatus) {
        this.retweetedStatus = retweetedStatus;
    }
}
