package jp.coxs.twitter.favrt.controller;

import org.slim3.controller.Navigation;

/**
 * なにもしないぺーじ。<br />
 * ﾄｯﾌﾟﾍﾟｰｼﾞへの案内を表示します
 * 
 * @author Shunichi Todoroki
 */
public class IndexController extends AbstractFrontController {

    @Override
    public Navigation doRun() throws Exception {
        return forward("index.jsp");
    }
}
