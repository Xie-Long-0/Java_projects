<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>A simple JSP page</title>
    
  </head>
  
  <body>
  	<div style="color: #0000ff">
  		<h3>Hello, World</h3>
  		This time now is: <%= new java.util.Date() %><br>
        <a href="index.jsp">Home</a><br>
  	</div>
  </body>
</html>
