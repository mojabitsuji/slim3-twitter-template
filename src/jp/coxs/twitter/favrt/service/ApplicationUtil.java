package jp.coxs.twitter.favrt.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import jp.coxs.twitter.favrt.model.TwitterUser;
import jp.coxs.twitter.favrt.model.json.User;

/**
 * ���̃A�v���P�[�V�����̂��߂̋��ʃ��[�e�B���e�B�ł��B
 * 
 * @author Shunichi Todoroki
 */
public class ApplicationUtil {
    protected static final Integer ZERO = Integer.valueOf(0);
    protected static final Integer ONE = Integer.valueOf(1);
    static {
        loadProperties();
    }
    /**
     * ���̃A�v�������삵�Ă���T�[�o�[�̃h���C���B
     */
    public static String thisServerDomain;

    /*
     * �R���X�g���N�^�B
     */
    private ApplicationUtil() {
    }

    /**
     * null�ł���΋��ArrayList��Ԃ��A
     * null�łȂ�����������̃��X�g�����̂܂ܕԂ����\�b�h�ł��B
     * 
     * @param <T>
     * @param list null���肵�������X�g
     * @return null�Ȃ�΋��ArrayList�A����ȊO�͈����̃��X�g���̂���
     */
    public static <T> List<T> nullToEmptyList(List<T> list) {
        return list == null ? new ArrayList<T>() : list;
    }

    /**
     * null�ł���΋��HashSet��Ԃ��A
     * null�łȂ�����������̃Z�b�g�����̂܂ܕԂ����\�b�h�ł��B
     * 
     * @param <T>
     * @param set null���肵�����Z�b�g
     * @return null�Ȃ�΋��HashSet�A����ȊO�͈����̃Z�b�g���̂���
     */
    public static <T> Set<T> nullToEmptySet(Set<T> set) {
        return set == null ? new HashSet<T>() : set;
    }

    public static List<TwitterUser> convertFromJsonModelList(List<User> fromUserList) {
        List<TwitterUser> toTwihoUserList = new ArrayList<TwitterUser>();
        for (User user : fromUserList) {
            toTwihoUserList.add(convertFromJsonModel(user));
        }
        return toTwihoUserList;
    }

    public static TwitterUser convertFromJsonModel(User fromUser) {
        TwitterUser toTwihoUser = new TwitterUser();
        toTwihoUser.setId(fromUser.getIdStr());
        toTwihoUser.setScreenName(fromUser.getScreenName());
        toTwihoUser.setDefaultProfile(fromUser.getDefaultProfile());
        toTwihoUser.setProfileImageUrl(fromUser.getProfileImageUrl());
        return toTwihoUser;
    }

    private static void loadProperties() {
        Properties authProps = new Properties();
        Properties serverProps = new Properties();
        InputStream in = null;
        try {
            in =
                new BufferedInputStream(ApplicationUtil.class.getClassLoader().getResourceAsStream(
                    "authprivatekeys.properties"));
            authProps.load(in);
            in.close();
            in =
                new BufferedInputStream(ApplicationUtil.class.getClassLoader().getResourceAsStream(
                    makePropertieName("serverspecific.properties")));
            serverProps.load(in);
        } catch (IOException e) {
            System.err.println(e.toString());
            e.printStackTrace(System.err);
            System.exit(1);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ignore) {
                    ignore.printStackTrace(System.err);
                }
            }
        }
        thisServerDomain = serverProps.getProperty("this.server.domain");
    }

    private static String makePropertieName(String propertieName) {
        String suffix = System.getProperty("server.specific.propertie.suffix");
        if (suffix != null && suffix.length() > 0) {
            propertieName +=
                "_for" + suffix.substring(0, 1).toUpperCase() + suffix.substring(1).toLowerCase();
        }
        return propertieName;
    }

    /**
     * �f�o�b�O�o�͂��܂��B<br />
     * �o�͑Ώۂ̃I�u�W�F�N�g�́AtoString()���\�b�h���I�[�o�[���C�h����<br />
     * �o�͂��������e��Ԃ��悤�ɂ��Ă��������B
     * 
     * @param <E> �f�o�b�O�o�͑ΏۂƂȂ�v�f
     * @param preMsg �f�o�b�O�o�͂ɕt�������v���t�B�b�N�X������
     * @param elem �f�o�b�O�Ώۂ̗v�f
     */
    public static <E> void debugLogout(String preMsg, E elem) {
        if (elem != null) {
            String prefix = preMsg + "=";
            System.out.println(prefix + elem.toString());
        }
    }

    /**
     * �f�o�b�O�o�͂��܂��B<br />
     * �o�͑Ώۂ̃I�u�W�F�N�g�́AtoString()���\�b�h���I�[�o�[���C�h����<br />
     * �o�͂��������e��Ԃ��悤�ɂ��Ă��������B
     * 
     * @param <E> �f�o�b�O�o�͑ΏۂƂȂ�v�f
     * @param preMsg �f�o�b�O�o�͂ɕt�������v���t�B�b�N�X������
     * @param collection �f�o�b�O�Ώۂ̗v�f�R���N�V����
     */
    public static <E> void debugLogout(String preMsg, Collection<E> collection) {
        if (collection != null) {
            String prefix = preMsg + "=";
            for (E elem : collection) {
                System.out.println(prefix + elem.toString());
            }
        }
    }
}
