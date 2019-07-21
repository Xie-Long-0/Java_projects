package mylistener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class MyRequestListener implements ServletRequestListener
{
    private Integer count = 0;

    public void requestInitialized(ServletRequestEvent re)
    {
        HttpServletRequest request = (HttpServletRequest)re.getServletRequest();
        if (request.getRequestURI().equals("/exp6/view_count_test.jsp")) {
            count++;
            re.getServletContext().setAttribute("viewcount", count);
        }
    }

    public void requestDestroyed(ServletRequestEvent re)
    {
    }
}
