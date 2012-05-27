package jp.coxs.twitter.favrt.util;

import java.io.IOException;

import com.google.appengine.api.mail.MailService;
import com.google.appengine.api.mail.MailServiceFactory;

/**
 * Gae�p���[�e�B���e�B�N���X�B
 * 
 * @author Shunichi Todoroki
 */
public class GaeUtil {
    /*
     * �R���X�g���N�^�B<br />
     * ��Q��
     */
    private GaeUtil() {
    }

    /**
     * �Ǘ��҂ւ̃��[�����M�B<br />
     * ���M����A���M���Gae�Ȃ̂ŕύX����Ƃ��̓R���p�C�����Ȃ����đS�W�J����̂ŌŒ�
     * 
     * @param subject ����
     * @param message ���b�Z�[�W
     * @throws IOException IO��O
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
