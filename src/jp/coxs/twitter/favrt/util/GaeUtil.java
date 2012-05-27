package jp.coxs.twitter.favrt.util;

import java.io.IOException;

import com.google.appengine.api.mail.MailService;
import com.google.appengine.api.mail.MailServiceFactory;

/**
 * Gae用ユーティリティクラス。
 * 
 * @author Shunichi Todoroki
 */
public class GaeUtil {
    /*
     * コンストラクタ。<br />
     * 非参照
     */
    private GaeUtil() {
    }

    /**
     * 管理者へのメール送信。<br />
     * 送信元や、送信先はGaeなので変更するときはコンパイルしなおして全展開するので固定
     * 
     * @param subject 件名
     * @param message メッセージ
     * @throws IOException IO例外
     */
    public static void sendAdminMail(String subject, String message)
            throws IOException {
        MailService.Message msg = new MailService.Message();
        msg.setSender("todoroki3401@gmail.com");
        msg.setTo("todoroki@coxs.jp");
        msg.setSubject(subject);
        msg.setTextBody(message);
        MailService mailservice = MailServiceFactory.getMailService();
        mailservice.send(msg);
    }
}
