package jp.coxs.twitter.favrt.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * Twitter側で「クジラ」が表示された時に、画面を表示するコントローラクラスです。
 * 
 * @author Shunichi Todoroki
 */
public class KujiraController extends Controller {
    @Override
    public Navigation run() throws Exception {
        return forward("kujira.jsp");
    }
}
