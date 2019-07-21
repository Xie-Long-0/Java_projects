package myservlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet
{
    public void service(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        Student student = (Student) request.getAttribute("student");
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        pw.println("<html lang=\"zh_CN\">");
        pw.println("<head>");
        pw.println("<title>结果页</title>");
        pw.println("<body>");
        pw.println("<h3>学号：" + student.getSno() + "</h3>");
        pw.println("<h3>姓名：" + student.getName() + "</h3>");
        pw.println("<a href = \"input.html\">return Home</a>");
        pw.println("</body></html>");
        pw.close();
    }
}
