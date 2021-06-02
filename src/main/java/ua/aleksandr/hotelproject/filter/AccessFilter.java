package ua.aleksandr.hotelproject.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        if(req.getSession().getAttribute("dao") != null) {

            boolean isEditPage = req.getRequestURI().endsWith("edit");

            boolean isAddPage = req.getRequestURI().endsWith("add");

            boolean isUpdatePage = req.getRequestURI().endsWith("update");

            boolean isAdmin = session.getAttribute("role").equals("admin");

            if (!isAdmin && (isEditPage || isAddPage || isUpdatePage)) {
                req.setAttribute("error", "ACCESS RESTRICTED");
                req.getRequestDispatcher("/error.jsp").forward(req, resp);
            } else {
                filterChain.doFilter(req, servletResponse);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }

    @Override
    public void destroy() {

    }
}
