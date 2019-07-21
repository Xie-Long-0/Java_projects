package myservlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ParamTestServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        PrintWriter pw = response.getWriter();
        pw.println("<html lang=\"zh_CN\">");
        pw.println("<head>");
        pw.println("<title>结果页</title>");
        pw.println("<body>");
        pw.println("<h3>姓名：" + name + "</h3>");
        pw.println("<h3>年龄：" + age + "</h3>");
        pw.println("<a href = \"input.html\">return Home</a>");
        pw.println("</body></html>");
        pw.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        doGet(request, response);
    }
}
