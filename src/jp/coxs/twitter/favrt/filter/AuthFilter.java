package jp.coxs.twitter.favrt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.mobylet.core.Carrier;
import org.mobylet.core.MobyletFactory;

/**
 * �T�C�g�S�̂ɑ΂��ĕK�v�ȋ��ʂ̏���
 * ���N�G�X�g�X�R�[�v�ɐݒ肷��Filter�N���X�ł��B
 * 
 * @author Shunichi Todoroki
 */
public class AuthFilter implements Filter {
    
    /**
     * ���N�G�X�g�̃L�����A�����N�G�X�g�X�R�[�v�Ɋi�[����L�[������ł�
     */
    public static final String CARRIER_KEY = 
        AuthFilter.class.getCanonicalName() + ".CarrierKey";
    
    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, 
     *          javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        Carrier carrier = MobyletFactory.getInstance().getCarrier();
        if (carrier == null) {
            carrier = Carrier.OTHER;
        }
        request.setAttribute(CARRIER_KEY, carrier);
        chain.doFilter(request, response);
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
    }
}
