package myservlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OnlineCountServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        ServletContext context = getServletConfig().getServletContext();
        Integer count = (Integer) context.getAttribute("onlinecount");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html lang='zh'>\n<head>\n" +
                "<title>Session Event Test</title>\n" +
                "</head>\n<body>\n" +
                "<h3 style='color: #0000FF'>" +
                "当前在线人数：" + count + "</h3>\n" +
                "<a href='index.jsp'>Home</a>\n" +
                "</body>\n</html>");
        pw.close();
    }
}
