package myservlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EventTestServlet extends HttpServlet
{
    ServletContext context = null;

    public void init(ServletConfig config)
    {
        context = config.getServletContext();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("<html>\n<head>");
        pw.println("<title>Event Test</title>");
        pw.println("</head>\n<body>");
        context.setAttribute("login", "xielong");
        context.setAttribute("login", "master");
        context.removeAttribute("login");
        pw.println("<h3>已在ServletContext上添加、修改、删除了属性</h3>");
        pw.println("<a href=\"index.jsp\">Home</a>");
        pw.println("</body>\n</html>");
        pw.close();
    }
}
