package jp.coxs.twitter.favrt.model.json;

/**
 * TwitterAPI�Ăяo���̉����w�b�_�[�ŕԋp�����A
 * API���s�񐔐�����ێ�����G���e�B�e�B�ł��B
 * 
 * @author Shunichi Todoroki
 */
public abstract class ApiLimitHeader {
    private Integer rateLimitLimit;
    private Integer rateLimitRemaining;

    /**
     * 60���ԂɎ��s�\�ȉ񐔂�Ԃ��܂��B
     * 
     * @return 60���ԂɎ��s�\�ȉ�
     */
    public Integer getRateLimitLimit() {
        return rateLimitLimit;
    }

    /**
     * 60���ԂɎ��s�\�ȉ񐔂�ݒ肵�܂��B
     * 
     * @param xRateLimitLimit 60���ԂɎ��s�\�ȉ�
     */
    public void setRateLimitLimit(Integer rateLimitLimit) {
        this.rateLimitLimit = rateLimitLimit;
    }

    /**
     * 60���ԂɎc�艽����s�\�Ȃ̂���Ԃ��܂��B
     * 
     * @return 60���ԂɎc�艽����s�\�Ȃ̂�
     */
    public Integer getRateLimitRemaining() {
        return rateLimitRemaining;
    }

    /**
     * 60���ԂɎc�艽����s�\�Ȃ̂���ݒ肵�܂��B
     * 
     * @param xRateLimitRemaining 60���ԂɎc�艽����s�\�Ȃ̂�
     */
    public void setRateLimitRemaining(Integer rateLimitRemaining) {
        this.rateLimitRemaining = rateLimitRemaining;
    }
}
