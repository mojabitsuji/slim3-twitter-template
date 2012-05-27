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
 * サイト全体に対して必要な共通の情報を
 * リクエストスコープに設定するFilterクラスです。
 * 
 * @author Shunichi Todoroki
 */
public class AuthFilter implements Filter {
    
    /**
     * リクエストのキャリアをリクエストスコープに格納するキー文字列です
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
