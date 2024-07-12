package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import auth.User;

@WebFilter("/*")
public class LoginFilter extends HttpFilter implements Filter {
    public LoginFilter() {
        super();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getRequestURI();
        path = path.substring(path.lastIndexOf("/") + 1);

        if (path.equals("login.jsp") || path.equals("loginUser") || path.equals("registerUser")
                || path.equals("registrazione.jsp") || path.equals("dimenticaPassword")
                || path.equals("update-password.jsp") ||path.equals("modificaPassword")
        || path.equals("Modifica.jsp")){
            chain.doFilter(request, response);
            return;
        }

        if (!User.isLogged(req.getSession())) {
            res.sendRedirect(req.getContextPath() + "/login.jsp?e=1");
            return;
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}