package jp.coxs.twitter.favrt.exception;

/**
 * このアプリで共通のキャッチすべき例外です。 ※名前はアプリごとに決めてリファクタリングすること
 * 
 * @author Shunichi Todoroki
 */
public class XXXXXAppException extends Exception {
    private static final long serialVersionUID = 7795498832616866908L;

    public XXXXXAppException() {
        super();
    }

    public XXXXXAppException(String message) {
        super(message);
    }

    public XXXXXAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public XXXXXAppException(Throwable cause) {
        super(cause);
    }
}
