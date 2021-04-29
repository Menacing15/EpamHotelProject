package ua.aleksandr.hotelproject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse resp = (HttpServletResponse)res;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("dao") != null);

        String loginURI = httpRequest.getContextPath() + "/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        String registerURI  = httpRequest.getContextPath() + "/register";
        boolean isRegisterRequest = httpRequest.getRequestURI().equals(registerURI);

        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");

        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            resp.sendRedirect("home");
        } else if (isLoggedIn || isLoginRequest || isRegisterRequest) {
            chain.doFilter(req, res);
        } else {
            resp.sendRedirect("login");
        }
    }

    @Override
    public void destroy() { }
}