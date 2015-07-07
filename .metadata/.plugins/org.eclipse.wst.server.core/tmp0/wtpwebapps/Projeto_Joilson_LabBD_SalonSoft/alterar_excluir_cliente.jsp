<%@page import="java.util.List"%>
<%@page import="entity.Cliente"%>
<%@page import="control.ControllerCliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salon Soft - Alterar ou Excluir Cliente</title>
</head>
<body>
	<a href="./index.jsp"><h1>Salon Soft - Seu salao aqui e agora</h1></a>
	<%
		ControllerCliente ctrl = new ControllerCliente();
		Cliente cliente = (Cliente) request.getAttribute("Cliente");
		
		if(cliente == null)
			cliente = ctrl.getClienteVazio();
	%>

	<h3>Altere ou exclua aqui o Cliente</h3>

	<form action="./ControllerCliente" method="post">
		<table>
			<tr>
				<td>
					<select name="idCliente">
						<option value="0">Selecione um Cliente</option>
						<%
							List<Cliente> lsClientes = ctrl.getListaClientes();
							for(int i=0; i<lsClientes.size();i++){
						%>
							<option id=<%=lsClientes.get(i).getId() %> value="<%=lsClientes.get(i).getId() %>"><%=lsClientes.get(i).getNome() %></option>
						<%
							}
						%>
					</select>
				</td>
				<td><input type="submit" name="cmd" value="Pesquisar" onclick=""/></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>Nome: </td>
				<td><input type="text" name="txtNome" value="<%=cliente.getNome() %>"/></td>
			</tr>
			<tr>
				<td>Telefone: </td>
				<td><input type="text" name="txtTelefone" value="<%=cliente.getTelefone() %>"/></td>
			</tr>
			<tr>
				<td>Celular: </td>
				<td><input type="text" name="txtCelular" value="<%=cliente.getCelular() %>"/></td>
			</tr>
			<tr>
				<td>E-mail: </td>
				<td><input type="text" name="txtEmail" value="<%=cliente.getEmail() %>"/></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type="submit" name="cmd" value="Excluir"/></td>
				<td><input type="submit" name="cmd" value="Alterar"/></td>
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