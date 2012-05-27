package jp.coxs.twitter.favrt.controller.top;

import jp.coxs.twitter.favrt.controller.AbstractFrontController;
import jp.coxs.twitter.favrt.model.TwitterUser;

import org.slim3.controller.Navigation;

/**
 * トップページを表示するコントローラクラスです。
 * 
 * @author Shunichi Todoroki
 */
public class IndexController extends AbstractFrontController {
    @Override
    public Navigation doRun() throws Exception {
        TwitterUser user = (TwitterUser) getSessionUser();
        if (user == null) {
            return forward("index.jsp");
        } else {
            return forward("/auth");
        }
    }
}
