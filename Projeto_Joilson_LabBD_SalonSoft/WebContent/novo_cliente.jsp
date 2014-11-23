<%@page import="entity.Cliente"%>
<%@page import="control.ControllerCliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salon soft - Novo Cliente</title>
</head>
<body>
	<a href="./index.jsp"><h1>Salon Soft - Seu salao aqui e agora</h1></a>
	<%
		ControllerCliente ctrl = new ControllerCliente();
	%>

	<h3>Registre aqui seu novo Cliente</h3>

	<form action="./ControllerCliente" method="post">
		<table>
			<tr>
				<td>Nome: </td>
				<td><input type="text" name="txtNome"/></td>
			</tr>
			<tr>
				<td>Telefone: </td>
				<td><input type="text" name="txtTelefone"/></td>
			</tr>
			<tr>
				<td>Celular: </td>
				<td><input type="text" name="txtCelular"/></td>
			</tr>
			<tr>
				<td>E-mail: </td>
				<td><input type="text" name="txtEmail"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="cmd" value="Adicionar" /></td></td>
				<td><input type="submit" name="cmd" value="LimparFormulario" /></td></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>
					<%
						String message = (String) request.getAttribute("MSG");
						if(message == null)
							message = "";
					%>
					<h3><%=message %></h3>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>