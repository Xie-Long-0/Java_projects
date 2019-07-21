package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author XieLong
 * @time   2019-4
 */
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html lang=zh-CN>");
		out.println("<head>");
		out.println("\t<title>Hello Servlet</title>");
		out.println("</head>\n<body>");
		out.println("\t<h3>Hello Servlet World</h3>");
		out.println("<a href=\"index.jsp\">Home</a><br>\n</body>\n</html>");
		out.close();
	}
}
