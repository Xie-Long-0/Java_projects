<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>square.jsp page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<table border='1' cellspacing='0' cellpadding='5' >
  		<tr>
  			<th>number</th><th>squared</th>
  		</tr>
  		<% for (int i = 1; i < 10; i++) { %>
  			<tr>
  				<td><%= i %></td><td><%= (i * i) %></td>
  			</tr>
  		<% } %>
  	</table><br>
	<a href="index.jsp">Home</a><br>
  </body>
</html>
