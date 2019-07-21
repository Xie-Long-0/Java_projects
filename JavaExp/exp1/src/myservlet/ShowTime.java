package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author XieLong
 */
public class ShowTime extends HttpServlet {

	private static final long serialVersionUID = 2L;

	public void service(HttpServletRequest request,	HttpServletResponse response)
		throws IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html lang=zh-CN>");
		out.println("<head>");
		out.println("\t<title>Show Time</title>");
		out.println("</head>\n<body>");
		out.println("\t<h3>Hello World</h3>");
		out.println("The time now is: " + new java.util.Date());
		out.println("<br><a href=\"index.jsp\">Home</a><br>\n</body>\n</html>");
		out.close();
	}
	
}