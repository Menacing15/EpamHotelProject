package ua.aleksandr.hotelproject.controller;

import org.junit.Test;
import ua.aleksandr.hotelproject.dao.DataBaseDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TableServletTest {

    @Test
    public void testDoGet() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        DataBaseDao dao = mock(DataBaseDao.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("dao")).thenReturn(dao);
        //when(dao.getColumnNames("rooms")).thenReturn()
    }
}
