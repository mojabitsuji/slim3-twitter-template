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
 * ���[�U�̃��O�C���󋵂Ȃǂ��L�^����t�B���^�[�ł��B
 * 
 * @author Shunichi Todoroki
 */
public class FootprintsFilter implements Filter {
    /**
     * ���[�U���Ɋւ��鑀���񋟂���T�[�r�X�ł��B
     */
    protected UserService userService = new UserService();

    /**
     * �����������B
     * 
     * @param config �t�B���^�[�R���t�B�O
     */
    public void init(FilterConfig config) throws ServletException {
    }

    /**
     * ���[�U�̃A�N�Z�X���L�^���܂��B<br />
     * ���߂ăA�N�Z�X���Ă������[�U�̃��R�[�h���쐬���L�^���܂�<br />
     * �Ō�̃A�N�Z�X�����莞�ԉ߂�����̃A�N�Z�X�́A�ŏI���O�C�����ԂƂ��ċL�^���܂�<br />
     * 
     * @param req ���N�G�X�g
     * @param res ���X�|���X
     * @param chain �t�B���^�[�`�F�[��
     */
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        //TODO
        //User user = userService.printoutUserAccess(ownerId, new Date());
        chain.doFilter(req, res);
    }

    /**
     * �I�������B
     */
    public void destroy() {
    }
}
