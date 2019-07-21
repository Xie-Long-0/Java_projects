<%--
  Created by IntelliJ IDEA.
  User: XieLong
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Count Test</title>
</head>
<body>
    <h3>欢迎您，您的IP地址为：<%= request.getRemoteAddr() %></h3>
    <h4 style="color: blue">自程序启动以来，该页面已被访问 <%= application.getAttribute("viewcount") %> 次</h4>
    <a href="index.jsp">Home</a>
</body>
</html>
