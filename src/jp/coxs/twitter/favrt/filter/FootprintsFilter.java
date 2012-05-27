package jp.coxs.twitter.favrt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import jp.coxs.twitter.favrt.service.UserService;

/**
 * ユーザのログイン状況などを記録するフィルターです。
 * 
 * @author Shunichi Todoroki
 */
public class FootprintsFilter implements Filter {
    /**
     * ユーザ情報に関する操作を提供するサービスです。
     */
    protected UserService userService = new UserService();

    /**
     * 初期化処理。
     * 
     * @param config フィルターコンフィグ
     */
    public void init(FilterConfig config) throws ServletException {
    }

    /**
     * ユーザのアクセスを記録します。<br />
     * 初めてアクセスしてきたユーザのレコードを作成し記録します<br />
     * 最後のアクセスから一定時間過ぎた後のアクセスは、最終ログイン時間として記録します<br />
     * 
     * @param req リクエスト
     * @param res レスポンス
     * @param chain フィルターチェーン
     */
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        //TODO
        //User user = userService.printoutUserAccess(ownerId, new Date());
        chain.doFilter(req, res);
    }

    /**
     * 終了処理。
     */
    public void destroy() {
    }
}
