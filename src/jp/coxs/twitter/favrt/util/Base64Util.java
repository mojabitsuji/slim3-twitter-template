package jp.coxs.twitter.favrt.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64�Í���/�������̃��[�e�B���e�B�N���X�ł��B
 * 
 * @author TCI
 */
public class Base64Util {
    /**
     * �������BASE�U�S�ɂĈÍ������܂��B
     * 
     * @param str
     * @return Base64������������
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
     * �������BASE64�ɂĕ��������܂��B
     * 
     * @param str
     * @return Base64������������
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
