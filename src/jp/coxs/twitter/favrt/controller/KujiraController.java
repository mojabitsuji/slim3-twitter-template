package jp.coxs.twitter.favrt.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * Twitter���Łu�N�W���v���\�����ꂽ���ɁA��ʂ�\������R���g���[���N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
public class KujiraController extends Controller {
    @Override
    public Navigation run() throws Exception {
        return forward("kujira.jsp");
    }
}
