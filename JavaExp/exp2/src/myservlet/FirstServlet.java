package myservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        Student student = new Student();
        student.setSno(request.getParameter("sno"));
        student.setName(request.getParameter("name"));
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("student", student);
        request.getRequestDispatcher("/second").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doGet(request, response);
    }
}
