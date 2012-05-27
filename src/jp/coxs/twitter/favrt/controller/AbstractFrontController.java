package jp.coxs.twitter.favrt.controller;

import jp.coxs.twitter.favrt.model.BaseUser;
import jp.coxs.twitter.favrt.util.ServiceProviderConnector.KujiraException;
import jp.coxs.twitter.favrt.util.ServiceProviderConnector.TwitterApiException;

import org.slim3.controller.Navigation;

/**
 * ���̃A�v���̃t�����g�R���g���[�����ʂ̑����񋟂��钊�ۃR���g���[���N���X�ł��B
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
     * �R���g���[���Ƃ��ĕK�v�ȏ������s���A�K�؂ȑJ�ڐ��Ԃ��܂��B<br />
     * Controller�N���X�̃e���v���[�g���\�b�h�Ƃ��āA�O�����ƌ㏈�����O��ɓ���܂�
     * �B
     * 
     * @return �]����������̓��_�C���N�g��
     * @throws ��O
     */
    protected abstract Navigation doRun() throws Exception;

    /**
     * �Ȃɂ���邱�Ƃ����������X�L�q����
     * 
     * @param navigation �ύX�O��navigation
     * @return �ύX���navigation
     * @throws ��O
     */
    protected Navigation postRun(Navigation navigation) throws Exception {
        //TODO
        //User user = (User)request.getAttribute("user");
        //Decoration d = Decoration.valueOf(user.getDecoration());
        //requestScope("decorate", d);
        return navigation;
    }

    /**
     * �R���g���[���ŗ�O��������ꂽ���ɁA���ʃG���[��ʂ�\�������܂��B
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
     * ��{���[�U�����Z�b�V�����ɕۑ����܂��B
     * 
     * @param baseUser ��{���[�U���
     */
    protected void updateSessionUser(BaseUser baseUser) {
        sessionScope(SESSION_USER_KEY, baseUser);
    }

    /**
     * ��{���[�U�����Z�b�V��������擾���܂��B
     * 
     * @return ��{���[�U���
     */
    protected BaseUser getSessionUser() {
        return sessionScope(SESSION_USER_KEY);
    }

    /**
     * �y�[�W�����v�Z���ĉ�ʂɕ`��̂��߂̏����쐬���܂��B
     * 
     * @param linkSize �\��������y�[�W�������N�̐�
     * @param listSize �P�y�[�W�ɕ\�����錏��
     * @param totalSize ������
     * @param currentOffset ���݈ʒu�������I�t�Z�b�g
     * @param linkUrl �y�[�W�������N��URL
     */
    protected void createPager(int linkSize, int listSize, int totalSize, Integer currentOffset,
            String linkUrl) {
        //�y�[�W��
        int totalPageCount = ((totalSize - 1) / listSize) + 1;
        requestScope("_totalSize_", totalSize);
        requestScope("_pagerCount_", totalPageCount);
        //���݂�offset�����y�[�W�ڂ����v�Z
        int currentPage = (currentOffset / listSize) + 1;
        //�ǂ̃y�[�W����ǂ̃y�[�W�܂Ń����N��\�����邩���v�Z
        int linkStart = 1;
        if (totalPageCount >= linkSize) {
            if (currentPage > (linkSize / 2)) {
                //�����N�\��������̏ꍇ�A�^�񒆂ɕ\�������̂����݂̃y�[�W
                //�����N�\�����������̏ꍇ�A�^�񒆂̉E�i6�Ȃ�4�Ԗځj�ɕ\�������̂����݂̃y�[�W
                if (currentPage + (linkSize / 2) > totalPageCount) {
                    linkStart = totalPageCount - linkSize + 1;
                } else {
                    linkStart = currentPage - (linkSize / 2);
                }
            }
        }
        //�����N
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
        //�O�y�[�W
        requestScope("_prev_", currentPage > 1);
        if (currentPage > 1) {
            requestScope("_prevUrl_", linkUrl + ((currentPage - 2) * listSize));
        }
        //��y�[�W
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
