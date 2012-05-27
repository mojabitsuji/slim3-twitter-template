package jp.coxs.twitter.favrt.controller;

import java.io.IOException;

import jp.coxs.twitter.favrt.service.UserService;
import jp.coxs.twitter.favrt.util.GaeUtil;

import org.mobylet.core.Carrier;
import org.mobylet.core.Mobylet;
import org.mobylet.core.device.Device;
import org.slim3.controller.Controller;

/**
 * このアプリのコントローラ共通の操作を提供する抽象コントローラクラスです。
 * 
 * @author Shunichi Todoroki
 */
public abstract class AbstractController extends Controller {
    /**
     * モバイルに関する操作を提供するオブジェクト
     */
    protected Mobylet mobylet;
    /**
     * アクセス端末の端末情報です
     */
    protected Device device;
    /**
     * アクセス端末のキャリア種別です
     */
    protected Carrier carrier;
    /**
     * アクセス元のサービス種別
     */
    protected UserService userService = new UserService();
    protected static final String cr = System.getProperty("line.separator");
    /**
     * 定数
     */
    protected static final Integer ZERO = Integer.valueOf(0);
    protected static final Integer ONE = Integer.valueOf(1);
    protected static final Integer TWO = Integer.valueOf(2);
    protected static final Integer NINE = Integer.valueOf(9);

    /**
     * 処理状況状態
     */
    public enum Status {
        COMPLETION(0), PROCESSWAIT(1), PROCESSING(2);
        private Integer status;

        private Status(Integer status) {
            this.status = status;
        }

        public Integer getStatus() {
            return status;
        }
    }

    /**
     * 指定されたキーでリクエストからパラメーターを取り出し、配列として返します。<br />
     * request.getParameterValuesから取得してなければ、
     * request.getParameterから取得した値を配列として返します
     * 
     * @param key パラメーターキー
     * @return パラメーターバリューの配列
     */
    protected String[] asArray(String key) {
        String[] params = request.getParameterValues(key);
        if (params == null) {
            String param = request.getParameter(key);
            if (param != null) {
                return new String[] { param };
            }
        }
        return params;
    }

    /**
     * タスク名を返します。
     * 
     * @return タスク名
     */
    protected String getTaskName() {
        return request.getHeader("X-AppEngine-TaskName");
    }

    /**
     * タスクキューのリトライを制御します。<br />
     * タスクキューの実行回数が最大回数を超えたら、管理者にメールを送信してタスクの実行を
     * 終わらせます
     * 
     * @param maxRetry 最大リトライ回数
     * @param subject 最大回数を超えた場合のメール件名
     * @param message最大回数を超えた場合のメールメッセージ
     * @throws TaskRetryOverException タスクリトライ例外
     */
    protected void taskRetryHandler(int maxRetry, String subject, String message)
            throws TaskRetryOverException {
        int currentRetry = Integer.valueOf(request.getHeader("X-AppEngine-TaskRetryCount"));
        if (currentRetry >= maxRetry) {
            try {
                GaeUtil.sendAdminMail(subject, message);
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
            throw new TaskRetryOverException();
        }
        return;
    }

    protected class TaskRetryOverException extends Exception {
        private static final long serialVersionUID = 7411536657011819015L;

        public TaskRetryOverException() {
            super();
        }

        public TaskRetryOverException(String message) {
            super(message);
        }

        public TaskRetryOverException(String message, Throwable cause) {
            super(message, cause);
        }

        public TaskRetryOverException(Throwable cause) {
            super(cause);
        }
    }
}
