/**
 * 
 */
package jp.coxs.twitter.favrt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.mobylet.core.Carrier;
import org.mobylet.core.Mobylet;
import org.mobylet.core.MobyletFactory;

/**
 * モバイルとそれ以外の端末で、リクエストの文字エンコーディングを
 * 適切に設定するFilterクラスです。
 * 
 * @author Shinobu.Aoki
 */
public class EncodingFilter implements Filter {

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // do nothing
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, 
     *         javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        Mobylet mobylet = MobyletFactory.getInstance();
        Carrier carrier = mobylet.getCarrier();
        if (carrier == Carrier.OTHER) {
            request.setCharacterEncoding("UTF-8");
        } else {
            request.setCharacterEncoding("Windows-31J");
        }
        chain.doFilter(request, response);
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig arg0) throws ServletException {
        // do nothing
    }
}
