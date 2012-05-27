package jp.coxs.twitter.favrt.model.json;

/**
 * Twitterからの応答をJsonで受け取る時に使用するエンティティクラスです。<br />
 * {@link jp.coxs.twitter.favrt.model.json.User}
 * クラスに含まれます。
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
