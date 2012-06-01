package jp.coxs.twitter.favrt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

/**
 * ���[�U����ێ�����G���e�B�e�B�N���X�ł��B<br />
 * Twitter���Ԃ��Ă�����ŕK�v�Ȃ��̂͂����ɒ�`���Ă���
 * 
 * @author Shunichi Todoroki
 */
@Model(schemaVersion = 1)
public class TwitterUser extends BaseUser implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
     * �ȉ��A��ʕ\���p����
     * TODO:�������̍��ڂɉ��������Ă��邩�m��Ȃ�
     */
    @Attribute(persistent = false)
    private String screenName;
    @Attribute(persistent = false)
    private boolean defaultProfile;
    @Attribute(persistent = false)
    private String profileImageUrl;
    private String followsNextCursor;
    private Set<String> followIds;
    private Date lastFollowSearchDate;
    private boolean apiLimit;

    /**
     * �X�N���[���\�����̂�Ԃ��܂��B
     * 
     * @return �X�N���[���\������
     */
    public String getScreenName() {
        return screenName;
    }

    /**
     * �X�N���[���\�����̂�ݒ肵�܂��B
     * 
     * @param screenName �X�N���[���\������
     */
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    /**
     * �f�t�H���g�̃v���t�B�[����Ԃ��܂��B
     * 
     * @return �f�t�H���g�̃v���t�B�[��
     */
    public boolean getDefaultProfile() {
        return defaultProfile;
    }

    /**
     * �f�t�H���g�̃v���t�B�[����ݒ肵�܂��B
     * 
     * @param defaultProfile �f�t�H���g�̃v���t�B�[��
     */
    public void setDefaultProfile(boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    /**
     * �v���t�B�[���摜��URL��Ԃ��܂��B
     * 
     * @return �v���t�B�[���摜��URL
     */
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    /**
     * �v���t�B�[���摜��URL��ݒ肵�܂��B
     * 
     * @param profileImageUrl �v���t�B�[���摜��URL
     */
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    /**
     * �����r���̎���t�H���[�擾�J�n��TwitterID��Ԃ��܂��B
     * 
     * @return ����t�H���[�擾�J�n��TwitterID
     */
    public String getFollowsNextCursor() {
        return followsNextCursor;
    }

    /**
     * �����r���̎���t�H���[�擾�J�n��TwitterID��ݒ肵�܂��B
     * 
     * @param followsNextCursor
     *            ����t�H���[�擾�J�n��TwitterID
     */
    public void setFollowsNextCursor(String followsNextCursor) {
        this.followsNextCursor = followsNextCursor;
    }

    /**
     * �������t�H���[���Ă���l��ID�̃Z�b�g��Ԃ��܂��B
     * 
     * @return �������t�H���[���Ă���l��ID�̃Z�b�g
     */
    public Set<String> getFollowIds() {
        return followIds;
    }

    /**
     * �������t�H���[���Ă���l��ID�̃Z�b�g��ݒ肵�܂��B
     * 
     * @param followIds �������t�H���[���Ă���l��ID�̃Z�b�g
     */
    public void setFollowIds(Set<String> followIds) {
        this.followIds = followIds;
    }

    /**
     * �Ō�Ƀt�H���[�������������t��Ԃ��܂��B
     * 
     * @return �Ō�Ƀt�H���[�������������t
     */
    public Date getLastFollowSearchDate() {
        return lastFollowSearchDate;
    }

    /**
     * �Ō�Ƀt�H���[�������������t��ݒ肵�܂��B
     * 
     * @param lastFollowSearchDate �Ō�Ƀt�H���[�������������t
     */
    public void setLastFollowSearchDate(Date lastFollowSearchDate) {
        this.lastFollowSearchDate = lastFollowSearchDate;
    }

    /**
     * API���������ǂ�����Ԃ��܂��B
     * 
     * @return API�������Ȃ�true
     */
    public boolean isApiLimit() {
        return apiLimit;
    }

    /**
     * API�������������̃t���O��ݒ肵�܂��B
     * 
     * @param apiLimit API�������t���O
     */
    public void setApiLimit(boolean apiLimit) {
        this.apiLimit = apiLimit;
    }

    public String toString() {
        return (new StringBuilder()).append("screenName [").append(screenName).append(
            "], defaultProfile [").append(defaultProfile).append("], profileImageUrl [").append(
            profileImageUrl).append("], followsNextCursor [").append(followsNextCursor).append(
            "], followIds [abbreviation...], lastFollowSearchDate [").append(lastFollowSearchDate).append(
            "], apiLimit [").append(apiLimit).append("]").toString();
    }
}
