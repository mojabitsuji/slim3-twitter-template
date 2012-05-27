package jp.coxs.twitter.favrt.model.json;

/**
 * TwitterAPI呼び出しの応答ヘッダーで返却される、
 * API実行回数制限を保持するエンティティです。
 * 
 * @author Shunichi Todoroki
 */
public abstract class ApiLimitHeader {
    private Integer rateLimitLimit;
    private Integer rateLimitRemaining;

    /**
     * 60分間に実行可能な回数を返します。
     * 
     * @return 60分間に実行可能な回数
     */
    public Integer getRateLimitLimit() {
        return rateLimitLimit;
    }

    /**
     * 60分間に実行可能な回数を設定します。
     * 
     * @param xRateLimitLimit 60分間に実行可能な回数
     */
    public void setRateLimitLimit(Integer rateLimitLimit) {
        this.rateLimitLimit = rateLimitLimit;
    }

    /**
     * 60分間に残り何回実行可能なのかを返します。
     * 
     * @return 60分間に残り何回実行可能なのか
     */
    public Integer getRateLimitRemaining() {
        return rateLimitRemaining;
    }

    /**
     * 60分間に残り何回実行可能なのかを設定します。
     * 
     * @param xRateLimitRemaining 60分間に残り何回実行可能なのか
     */
    public void setRateLimitRemaining(Integer rateLimitRemaining) {
        this.rateLimitRemaining = rateLimitRemaining;
    }
}
