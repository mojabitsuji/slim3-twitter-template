package jp.coxs.twitter.favrt.controller;

import jp.coxs.twitter.favrt.util.ServiceProvider;
import jp.coxs.twitter.favrt.util.ServiceProviderConnector;
import jp.coxs.twitter.favrt.util.TwitterServiceProvider;

import org.slim3.controller.Navigation;

/**
 * ���[�U����̃��O�C���̗v�����󂯕t���ATwitter�ɑ΂���OAuth�F�؂�
 * �v������R���g���[���[�N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
public class LoginController extends AbstractFrontController {

    @Override
    public Navigation doRun() throws Exception {
        ServiceProvider sp = new TwitterServiceProvider();
        ServiceProviderConnector connector = new ServiceProviderConnector(sp);
        String redirectUrl = connector.prepareRedirectUrl();
        return redirect(redirectUrl);
    }
}
