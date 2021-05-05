package ua.aleksandr.hotelproject.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        HttpSession session = req.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("role") != null);
        String orderURI  = req.getContextPath() + "/orders";
        boolean isOrderRequest = req.getRequestURI().equals(orderURI);

        if(isLoggedIn) {
            boolean isAdmin = session.getAttribute("role").equals("admin");
            if(!isAdmin && isOrderRequest) {
                req.setAttribute("error", "ACCESS RESTRICTED");
                req.getRequestDispatcher("error.jsp").forward(req,resp);
            }else {
                filterChain.doFilter(req, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
