package jp.coxs.twitter.favrt.controller;

import java.io.IOException;

import jp.coxs.twitter.favrt.service.UserService;
import jp.coxs.twitter.favrt.util.GaeUtil;

import org.mobylet.core.Carrier;
import org.mobylet.core.Mobylet;
import org.mobylet.core.device.Device;
import org.slim3.controller.Controller;

/**
 * ���̃A�v���̃R���g���[�����ʂ̑����񋟂��钊�ۃR���g���[���N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
public abstract class AbstractController extends Controller {
    /**
     * ���o�C���Ɋւ��鑀���񋟂���I�u�W�F�N�g
     */
    protected Mobylet mobylet;
    /**
     * �A�N�Z�X�[���̒[�����ł�
     */
    protected Device device;
    /**
     * �A�N�Z�X�[���̃L�����A��ʂł�
     */
    protected Carrier carrier;
    /**
     * �A�N�Z�X���̃T�[�r�X���
     */
    protected UserService userService = new UserService();
    protected static final String cr = System.getProperty("line.separator");
    /**
     * �萔
     */
    protected static final Integer ZERO = Integer.valueOf(0);
    protected static final Integer ONE = Integer.valueOf(1);
    protected static final Integer TWO = Integer.valueOf(2);
    protected static final Integer NINE = Integer.valueOf(9);

    /**
     * �����󋵏��
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
     * �w�肳�ꂽ�L�[�Ń��N�G�X�g����p�����[�^�[�����o���A�z��Ƃ��ĕԂ��܂��B<br />
     * request.getParameterValues����擾���ĂȂ���΁A
     * request.getParameter����擾�����l��z��Ƃ��ĕԂ��܂�
     * 
     * @param key �p�����[�^�[�L�[
     * @return �p�����[�^�[�o�����[�̔z��
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
     * �^�X�N����Ԃ��܂��B
     * 
     * @return �^�X�N��
     */
    protected String getTaskName() {
        return request.getHeader("X-AppEngine-TaskName");
    }

    /**
     * �^�X�N�L���[�̃��g���C�𐧌䂵�܂��B<br />
     * �^�X�N�L���[�̎��s�񐔂��ő�񐔂𒴂�����A�Ǘ��҂Ƀ��[���𑗐M���ă^�X�N�̎��s��
     * �I��点�܂�
     * 
     * @param maxRetry �ő僊�g���C��
     * @param subject �ő�񐔂𒴂����ꍇ�̃��[������
     * @param message�ő�񐔂𒴂����ꍇ�̃��[�����b�Z�[�W
     * @throws TaskRetryOverException �^�X�N���g���C��O
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
