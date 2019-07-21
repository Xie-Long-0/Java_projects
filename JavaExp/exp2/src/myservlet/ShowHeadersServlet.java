package myservlet;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ShowHeadersServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("<html lang=\"zh_CN\">");
        pw.println("<head>\n<title>All Headers</title>\n</head>");
        pw.println("<body style=\"background-color: #fdf5e6 \">");
        pw.println("<div style=\"display: flex; align-items: center; flex-direction: column \">");
        pw.println("<h1>All Request Headers</h1>");
        pw.println("<table border=1>\n<tr style=\"background-color: #ffad00 \">");
        pw.println("<th>Header Name</th><th>Value</th></tr>");

        Enumeration headerNames = request.getHeaderNames();
        String headerName;
        while (headerNames.hasMoreElements()) {
            headerName = (String)headerNames.nextElement();
            pw.println("<tr><td>" + headerName + "</td>");
            pw.println("<td>" + request.getHeader(headerName) + "</td></tr>");
        }
        pw.println("</table>\n</div>");
        pw.println("</body>\n</html>");
        pw.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        doGet(request, response);
    }
}
