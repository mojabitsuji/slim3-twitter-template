package jp.coxs.twitter.favrt.model.json;

/**
 * Twitterからの応答をJsonで受け取る時に使用する エンティティクラスです。<br />
 * Userをリストとして受け取るときの親エンティティです。
 * 
 * @author Shunichi Todoroki
 */
public class Users<T> extends ApiLimitHeader {
    private T users;
    private long nextCursor;
    private long previousCursor;
    private String nextCursorStr;
    private String previousCursorStr;

    public T getUsers() {
        return users;
    }

    public void setUsers(T users) {
        this.users = users;
    }

    public long getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(int nextCursor) {
        this.nextCursor = nextCursor;
    }

    public long getPreviousCursor() {
        return previousCursor;
    }

    public void setPreviousCursor(int previousCursor) {
        this.previousCursor = previousCursor;
    }

    public String getNextCursorStr() {
        return nextCursorStr;
    }

    public void setNextCursorStr(String nextCursorStr) {
        this.nextCursorStr = nextCursorStr;
    }

    public String getPreviousCursorStr() {
        return previousCursorStr;
    }

    public void setPreviousCursorStr(String previousCursorStr) {
        this.previousCursorStr = previousCursorStr;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("User [nextCursor=").append(nextCursor).append(
            ", previousCursor=").append(previousCursor).append(", nextCursorStr=").append(
            nextCursorStr).append(", previousCursorStr=").append(previousCursorStr).toString();
    }
}
