package jp.coxs.twitter.favrt.util;

import jp.coxs.twitter.favrt.model.TwitterUser;

import org.slim3.datastore.Datastore;

/**
 * Modelクラスのキーを生成し、設定するクラスです。
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
     * インスタンスを生成させない。
     */
    private ModelKeyGenerator() {
    }

    /**
     * ユーザ情報のキーを生成し、モデルに設定します。
     * 
     * @param user ユーザ情報
     */
    public static void generateKey(TwitterUser user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("キー作成に必要なidが設定されていません。");
        }
        user.setKey(Datastore.createKey(TwitterUser.class, format(TWITTER_ID_LENGTH, user.getId())));
    }

    /*
     * フォーマットメソッド。<br />
     * フォーマットする長さに達するまで、前方にフォーマット文字を付加して返します。
     * 
     * @param formatLength フォーマットする長さ
     * @param target フォーマットするターゲット文字列
     */
    private static String format(int formatLength, String target) {
        if (formatLength > MAX_FORMAT_LENGTH || target.length() > MAX_FORMAT_LENGTH) {
            throw new IllegalArgumentException("このジェネレータでキー作成可能な文字列長を超えています。フォーマット可能な文字列長 ["
                + MAX_FORMAT_LENGTH
                + "]。");
        }
        if (target.length() > formatLength) {
            throw new IllegalArgumentException("フォーマット指定を間違っています。 format length ["
                + formatLength
                + "], target ["
                + target
                + "]。");
        }
        return FORMATTER[formatLength - target.length()] + target;
    }

    private static String format(int formatLength, Integer target) {
        return format(formatLength, String.valueOf(target));
    }
}
