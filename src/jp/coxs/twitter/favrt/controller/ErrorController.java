package jp.coxs.twitter.favrt.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * �V�X�e���G���[�Ȃǂ̎��ɉ�ʂ�\������R���g���[���[�N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
public class ErrorController extends Controller {
    @Override
    public Navigation run() throws Exception {
        return forward("error.jsp");
    }
}
