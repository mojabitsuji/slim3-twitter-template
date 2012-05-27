package jp.coxs.twitter.favrt.controller;

import jp.coxs.twitter.favrt.model.BaseUser;
import jp.coxs.twitter.favrt.util.ServiceProviderConnector.KujiraException;
import jp.coxs.twitter.favrt.util.ServiceProviderConnector.TwitterApiException;

import org.slim3.controller.Navigation;

/**
 * このアプリのフロントコントローラ共通の操作を提供する抽象コントローラクラスです。
 * 
 * @author Shunichi Todoroki
 */
public abstract class AbstractFrontController extends AbstractController {
    private static final String SESSION_USER_KEY = "__session_user__store_key__";

    /* (non-Javadoc)
     * @see org.slim3.controller.Controller#run()
     */
    @Override
    protected final Navigation run() throws Exception {
        return postRun(doRun());
    }

    /**
     * コントローラとして必要な処理を行い、適切な遷移先を返します。<br />
     * Controllerクラスのテンプレートメソッドとして、前処理と後処理が前後に入ります
     * 。
     * 
     * @return 転送先もしくはリダイレクト先
     * @throws 例外
     */
    protected abstract Navigation doRun() throws Exception;

    /**
     * なにかやることがあったら後々記述する
     * 
     * @param navigation 変更前のnavigation
     * @return 変更後のnavigation
     * @throws 例外
     */
    protected Navigation postRun(Navigation navigation) throws Exception {
        //TODO
        //User user = (User)request.getAttribute("user");
        //Decoration d = Decoration.valueOf(user.getDecoration());
        //requestScope("decorate", d);
        return navigation;
    }

    /**
     * コントローラで例外が投げられた時に、共通エラー画面を表示させます。
     * 
     * @param error
     */
    @Override
    protected Navigation handleError(Throwable error) throws Throwable {
        if (error instanceof TwitterApiException) {
            System.err.println("handle app exception in action controller with ["
                + error.getMessage()
                + ", "
                + error.toString()
                + "]");
        } else if (error instanceof KujiraException) {
            //TODO
        } else {
            System.err.println(error.toString());
            System.err.println("handle unexpected error with following stack trace.");
            error.printStackTrace(System.err);
        }
        return forward("/error");
    }

    /**
     * 基本ユーザ情報をセッションに保存します。
     * 
     * @param baseUser 基本ユーザ情報
     */
    protected void updateSessionUser(BaseUser baseUser) {
        sessionScope(SESSION_USER_KEY, baseUser);
    }

    /**
     * 基本ユーザ情報をセッションから取得します。
     * 
     * @return 基本ユーザ情報
     */
    protected BaseUser getSessionUser() {
        return sessionScope(SESSION_USER_KEY);
    }

    /**
     * ページャを計算して画面に描画のための情報を作成します。
     * 
     * @param linkSize 表示させるページャリンクの数
     * @param listSize １ページに表示する件数
     * @param totalSize 総件数
     * @param currentOffset 現在位置を示すオフセット
     * @param linkUrl ページャリンクのURL
     */
    protected void createPager(int linkSize, int listSize, int totalSize, Integer currentOffset,
            String linkUrl) {
        //ページ数
        int totalPageCount = ((totalSize - 1) / listSize) + 1;
        requestScope("_totalSize_", totalSize);
        requestScope("_pagerCount_", totalPageCount);
        //現在のoffsetが何ページ目かを計算
        int currentPage = (currentOffset / listSize) + 1;
        //どのページからどのページまでリンクを表示するかを計算
        int linkStart = 1;
        if (totalPageCount >= linkSize) {
            if (currentPage > (linkSize / 2)) {
                //リンク表示数が奇数の場合、真ん中に表示されるのが現在のページ
                //リンク表示数が偶数の場合、真ん中の右（6なら4番目）に表示されるのが現在のページ
                if (currentPage + (linkSize / 2) > totalPageCount) {
                    linkStart = totalPageCount - linkSize + 1;
                } else {
                    linkStart = currentPage - (linkSize / 2);
                }
            }
        }
        //リンク
        if (linkUrl.indexOf("?") >= 0) {
            linkUrl += "&offset=";
        } else {
            linkUrl += "?offset=";
        }
        int size = totalPageCount >= linkSize ? linkSize : totalPageCount;
        Link[] links = new Link[size];
        for (int i = 0; i < size; i++) {
            links[i] = new Link();
            links[i].linkNo = linkStart + i;
            links[i].linkUrl = linkUrl + ((links[i].linkNo - 1) * listSize);
            links[i].current = (linkStart + i == currentPage);
        }
        requestScope("_links_", links);
        //前ページ
        requestScope("_prev_", currentPage > 1);
        if (currentPage > 1) {
            requestScope("_prevUrl_", linkUrl + ((currentPage - 2) * listSize));
        }
        //後ページ
        requestScope("_next_", currentPage < totalPageCount);
        if (currentPage < totalPageCount) {
            requestScope("_nextUrl_", linkUrl + (currentPage * listSize));
        }
    }

    public static class Link {
        private Integer linkNo;
        private String linkUrl;
        private boolean current;

        public Integer getLinkNo() {
            return linkNo;
        }

        public String getLinkUrl() {
            return linkUrl;
        }

        public boolean isCurrent() {
            return current;
        }
    }
}
