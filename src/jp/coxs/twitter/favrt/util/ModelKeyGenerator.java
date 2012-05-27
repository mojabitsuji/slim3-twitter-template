package jp.coxs.twitter.favrt.util;

import jp.coxs.twitter.favrt.model.TwitterUser;

import org.slim3.datastore.Datastore;

/**
 * Model�N���X�̃L�[�𐶐����A�ݒ肷��N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
public class ModelKeyGenerator {
    private static final int MAX_FORMAT_LENGTH = 100;
    private static String[] FORMATTER;
    private static String FORMAT_STRING = " ";
    private static final int TWITTER_ID_LENGTH = 20;
    private static final int TWITTER_USER_NAME_LENGTH = 15;
    static {
        FORMATTER = new String[MAX_FORMAT_LENGTH];
        StringBuilder br = new StringBuilder();
        for (int i = 0; i < MAX_FORMAT_LENGTH; i++) {
            FORMATTER[i] = br.toString();
            br.append(FORMAT_STRING);
        }
    }

    /*
     * �C���X�^���X�𐶐������Ȃ��B
     */
    private ModelKeyGenerator() {
    }

    /**
     * ���[�U���̃L�[�𐶐����A���f���ɐݒ肵�܂��B
     * 
     * @param user ���[�U���
     */
    public static void generateKey(TwitterUser user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("�L�[�쐬�ɕK�v��id���ݒ肳��Ă��܂���B");
        }
        user.setKey(Datastore.createKey(TwitterUser.class, format(TWITTER_ID_LENGTH, user.getId())));
    }

    /*
     * �t�H�[�}�b�g���\�b�h�B<br />
     * �t�H�[�}�b�g���钷���ɒB����܂ŁA�O���Ƀt�H�[�}�b�g������t�����ĕԂ��܂��B
     * 
     * @param formatLength �t�H�[�}�b�g���钷��
     * @param target �t�H�[�}�b�g����^�[�Q�b�g������
     */
    private static String format(int formatLength, String target) {
        if (formatLength > MAX_FORMAT_LENGTH || target.length() > MAX_FORMAT_LENGTH) {
            throw new IllegalArgumentException("���̃W�F�l���[�^�ŃL�[�쐬�\�ȕ����񒷂𒴂��Ă��܂��B�t�H�[�}�b�g�\�ȕ����� ["
                + MAX_FORMAT_LENGTH
                + "]�B");
        }
        if (target.length() > formatLength) {
            throw new IllegalArgumentException("�t�H�[�}�b�g�w����Ԉ���Ă��܂��B format length ["
                + formatLength
                + "], target ["
                + target
                + "]�B");
        }
        return FORMATTER[formatLength - target.length()] + target;
    }

    private static String format(int formatLength, Integer target) {
        return format(formatLength, String.valueOf(target));
    }
}
