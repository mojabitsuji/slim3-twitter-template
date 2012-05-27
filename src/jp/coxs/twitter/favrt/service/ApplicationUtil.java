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
 * このアプリケーションのための共通ユーティリティです。
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
     * このアプリが動作しているサーバーのドメイン。
     */
    public static String thisServerDomain;

    /*
     * コンストラクタ。
     */
    private ApplicationUtil() {
    }

    /**
     * nullであれば空のArrayListを返し、
     * nullでなかったら引数のリストをそのまま返すメソッドです。
     * 
     * @param <T>
     * @param list null判定したいリスト
     * @return nullならば空のArrayList、それ以外は引数のリストそのもの
     */
    public static <T> List<T> nullToEmptyList(List<T> list) {
        return list == null ? new ArrayList<T>() : list;
    }

    /**
     * nullであれば空のHashSetを返し、
     * nullでなかったら引数のセットをそのまま返すメソッドです。
     * 
     * @param <T>
     * @param set null判定したいセット
     * @return nullならば空のHashSet、それ以外は引数のセットそのもの
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
     * デバッグ出力します。<br />
     * 出力対象のオブジェクトは、toString()メソッドをオーバーライドして<br />
     * 出力したい内容を返すようにしてください。
     * 
     * @param <E> デバッグ出力対象となる要素
     * @param preMsg デバッグ出力に付加されるプレフィックス文字列
     * @param elem デバッグ対象の要素
     */
    public static <E> void debugLogout(String preMsg, E elem) {
        if (elem != null) {
            String prefix = preMsg + "=";
            System.out.println(prefix + elem.toString());
        }
    }

    /**
     * デバッグ出力します。<br />
     * 出力対象のオブジェクトは、toString()メソッドをオーバーライドして<br />
     * 出力したい内容を返すようにしてください。
     * 
     * @param <E> デバッグ出力対象となる要素
     * @param preMsg デバッグ出力に付加されるプレフィックス文字列
     * @param collection デバッグ対象の要素コレクション
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
