package myservlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckParamServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.print("<html lang='zh'>\n<head>\n" +
                "  <title>Param Test</title>\n" +
                "</head>\n<body>\n" +
                "<h3>你的用户名为：" + name + "</h3>\n" +
                "<h3>你的口令为：" + pass + "</h3>\n" +
                "<a href='index.jsp'>Home</a>\n" +
                "<a href='login.html'>Return</a>\n" +
                "</body>\n</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        doGet(request, response);
    }
}
