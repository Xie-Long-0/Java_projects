<%--
  Created by IntelliJ IDEA.
  User: XieLong
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.*" %>

<html>
<head>
    <title>DataSource Test</title>
</head>
<body>
    <%
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/bookDS");
            Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM books";
            ResultSet rs = stmt.executeQuery(sql);
            out.println("<table border=1>\n" +
                    "<tr><td>书号</td><td>书名</td><td>作者</td><td>价格</td></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getString(1) +
                        "</td><td>" + rs.getString(2) +
                        "</td><td>" + rs.getString(3) +
                        "</td><td>" + rs.getString(5) + "</td></tr>");
            }
            out.println("</table>");
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    %>
    <br>
    <a href="index.jsp">Home</a>
</body>
</html>
