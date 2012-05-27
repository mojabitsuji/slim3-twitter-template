package jp.coxs.twitter.favrt.controller;

import jp.coxs.twitter.favrt.util.ServiceProvider;
import jp.coxs.twitter.favrt.util.ServiceProviderConnector;
import jp.coxs.twitter.favrt.util.TwitterServiceProvider;

import org.slim3.controller.Navigation;

/**
 * ユーザからのログインの要求を受け付け、Twitterに対してOAuth認証を
 * 要求するコントローラークラスです。
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
