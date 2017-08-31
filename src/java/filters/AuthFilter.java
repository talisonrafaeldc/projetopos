package filters;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthFilter implements Filter {
     
    public AuthFilter() {
    }
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
        ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = ((HttpServletRequest) request).getSession (true);
            HttpSession ses = req.getSession(false);

            //System.out.println (session.getAttribute ("acesso"));
            if (session.getAttribute ("acesso") != null && !session.isNew ()) {
                chain.doFilter (request, response);
            } else {

                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect (req.getContextPath () + "/login.jsf");
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
        finally {

        }

    }
    @Override
    public void destroy() {
         
    }
}