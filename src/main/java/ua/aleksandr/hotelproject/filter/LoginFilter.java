package ua.aleksandr.hotelproject.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse resp = (HttpServletResponse) res;
        HttpSession session = httpRequest.getSession(false);

        //if (session != null) {
            String role = (String) session.getAttribute("role");
            if (role != null) {

                boolean isGuest = (role.equals("guest"));

                boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");
                boolean isRegisterPage = httpRequest.getRequestURI().endsWith("register");
                boolean isTablePage = httpRequest.getRequestURI().endsWith("table");
                boolean isHomePage = httpRequest.getRequestURI().endsWith("home");

                if (!isGuest && isLoginPage) {
                    resp.sendRedirect(((HttpServletRequest) req).getContextPath() + "/home");
                }
                if (!(isLoginPage || isRegisterPage || isTablePage || isHomePage) && isGuest) {
                    resp.sendRedirect(((HttpServletRequest) req).getContextPath() + "/login");
                } else {
                    chain.doFilter(req, res);
                }
            } else {
                chain.doFilter(req, res);
            }
       /*} else {
            chain.doFilter(req, res);
        }*/
    }

    @Override
    public void destroy() {
    }
}