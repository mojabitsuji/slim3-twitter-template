package jp.coxs.twitter.favrt.controller;

import org.slim3.controller.Navigation;

/**
 * ‚È‚É‚à‚µ‚È‚¢‚Ø[‚¶B<br />
 * Ä¯ÌßÍß°¼Ş‚Ö‚ÌˆÄ“à‚ğ•\¦‚µ‚Ü‚·
 * 
 * @author Shunichi Todoroki
 */
public class IndexController extends AbstractFrontController {

    @Override
    public Navigation doRun() throws Exception {
        return forward("index.jsp");
    }
}
