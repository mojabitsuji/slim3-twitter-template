package jp.coxs.twitter.favrt.controller;

import org.slim3.controller.Navigation;

/**
 * �Ȃɂ����Ȃ��؁[���B<br />
 * į���߰�ނւ̈ē���\�����܂�
 * 
 * @author Shunichi Todoroki
 */
public class IndexController extends AbstractFrontController {

    @Override
    public Navigation doRun() throws Exception {
        return forward("index.jsp");
    }
}
