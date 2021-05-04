package ua.aleksandr.hotelproject.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//Throws logged out user to login page, allows only /login /register pages to visit
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse resp = (HttpServletResponse)res;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("role") != null);

        String loginURI = httpRequest.getContextPath() + "/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        String registerURI  = httpRequest.getContextPath() + "/register";
        boolean isRegisterRequest = httpRequest.getRequestURI().equals(registerURI);

        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");

        boolean isResource = httpRequest.getRequestURI().endsWith(".css") ||
                httpRequest.getRequestURI().endsWith(".jpg"); //without this css doesn't work

        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            resp.sendRedirect("home");
        } else if (isLoggedIn || isLoginRequest || isRegisterRequest || isResource) {
            chain.doFilter(req, res);
        } else {
            resp.sendRedirect("login");
        }
    }

    @Override
    public void destroy() { }
}