package jp.coxs.twitter.favrt.controller;

import jp.coxs.twitter.favrt.model.TwitterUser;
import jp.coxs.twitter.favrt.util.ServiceProvider;
import jp.coxs.twitter.favrt.util.ServiceProviderConnector;
import jp.coxs.twitter.favrt.util.ServiceProviderConnector.TwitterApiException;
import jp.coxs.twitter.favrt.util.TwitterServiceProvider;

import org.slim3.controller.Navigation;

/**
 * Twitterで認証を受けてきたユーザのコールバックを受け付ける コントローラークラスです。<br />
 * アクセスが正当なものかどうかもう一度ここからTwitterへ問い合わせを行います。
 * 
 * @author Shunichi Todoroki
 */
public class AuthController extends AbstractFrontController {
    @Override
    public Navigation doRun() throws Exception {
        TwitterUser user = (TwitterUser) getSessionUser();
        if (user == null) {
            ServiceProvider sp = new TwitterServiceProvider();
            ServiceProviderConnector connector = new ServiceProviderConnector(sp);
            try {
                user = (TwitterUser) connector.verifyUserCredentials(request);
                userService.storeVerifiedCredentials(user);
                updateSessionUser(user);
            } catch (TwitterApiException e) {
                return forward("/error.jsp");
            }
        }
        return forward("/top/top.jsp");
    }
}
