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

        String editURI = req.getContextPath() + "/edit";
        boolean isEditRequest = req.getRequestURI().equals(editURI);
        boolean isEditPage = req.getRequestURI().endsWith("edit");

        String addURI = req.getContextPath() + "/add";
        boolean isAddRequest = req.getRequestURI().equals(addURI);
        boolean isAddPage = req.getRequestURI().endsWith("add");

        boolean isAdmin = session.getAttribute("role").equals("admin");

        if (!isAdmin && (isEditRequest || isEditPage || isAddRequest || isAddPage)) {
            req.setAttribute("error", "ACCESS RESTRICTED");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        } else {
            filterChain.doFilter(req, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
