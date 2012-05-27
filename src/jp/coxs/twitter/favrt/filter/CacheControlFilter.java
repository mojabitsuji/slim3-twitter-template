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
import javax.servlet.http.HttpServletResponse;

import org.mobylet.core.Carrier;
import org.mobylet.core.Mobylet;
import org.mobylet.core.MobyletFactory;

/**
 * 特定�?キャリアに対してキャ�?��ュを抑制させるフィルターです�? 
 * 
 * @author Shinobu.Aoki
 */
public class CacheControlFilter implements Filter {

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // do nothing.
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, 
     *          javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        Mobylet mobylet = MobyletFactory.getInstance();
        Carrier carrier = mobylet.getCarrier();
        if (Carrier.AU == carrier) {
            HttpServletResponse res = HttpServletResponse.class.cast(response);
            res.setDateHeader("Expires", 0);
            res.setHeader("Pragma", "no-cache");
            res.setHeader("Cache-Control", "no-cache");
        }
        chain.doFilter(request, response);
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
        // do nothing.
    }

}
