package jp.coxs.twitter.favrt.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64暗号化/複合化のユーティリティクラスです。
 * 
 * @author TCI
 */
public class Base64Util {
    /**
     * 文字列をBASE６４にて暗号化します。
     * 
     * @param str
     * @return Base64複合化文字列
     */
    public static String getEncodedStr(String str) {
        try {
            byte[] bytes = Base64.encodeBase64(str.getBytes());
            return new String(bytes, "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 文字列をBASE64にて複合化します。
     * 
     * @param str
     * @return Base64複合化文字列
     */
    public static String getDecodedStr(String str) {
        try {
            byte[] bytes = Base64.decodeBase64(str.getBytes("iso-8859-1"));
            return new String(bytes);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
