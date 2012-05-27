package jp.coxs.twitter.favrt.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * システムエラーなどの時に画面を表示するコントローラークラスです。
 * 
 * @author Shunichi Todoroki
 */
public class ErrorController extends Controller {
    @Override
    public Navigation run() throws Exception {
        return forward("error.jsp");
    }
}
