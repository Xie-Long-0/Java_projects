package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author XieLong
 *
 */
public class HelloUserServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public void service(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String username = request.getParameter("username");
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h3>Hello, " + username + "</h3>");
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }
}
