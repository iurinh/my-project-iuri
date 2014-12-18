<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Principal</title>
</head>
<body>

<%
	String msg = (String) request.getAttribute("MSG");
	if ("".equals(msg) || msg == null) 
		msg = "";
%>

<h1>Pagina Principal - INDEX</h1>

	<table>
		<tr>
			<td><h3><%= msg %></h3></td>
		</tr>
	</table>
</body>
</html>