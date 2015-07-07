<%@page import="control.ControllerFuncionario"%>
<%@page import="java.util.List"%>
<%@page import="entity.Funcionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salon Soft - Alterar ou Excluir Funcionario</title>
</head>
<body>
	<a href="./index.jsp"><h1>Salon Soft - Seu salao aqui e agora</h1></a>
	<%
		ControllerFuncionario ctrl = new ControllerFuncionario();
		Funcionario funcionario = (Funcionario) request.getAttribute("Funcionario");
		
		if(funcionario == null)
			funcionario = ctrl.getFuncionarioVazio();
	%>

	<h3>Altere ou exclua aqui o Funcionario</h3>

	<form action="./ControllerFuncionario" method="post">
		<table>
			<tr>
				<td>
					<select name="idFuncionario">
						<option value="0">Selecione um Funcionario</option>
						<%
							List<Funcionario> lsFuncionarios = ctrl.getListaFuncionarios();
							for(int i=0; i<lsFuncionarios.size();i++){
						%>
							<option id=<%=lsFuncionarios.get(i).getId() %> value="<%=lsFuncionarios.get(i).getId() %>"><%=lsFuncionarios.get(i).getNome() %></option>
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
				<td><input type="text" name="txtNome" value="<%=funcionario.getNome() %>"/></td>
			</tr>
			<tr>
				<td>Telefone: </td>
				<td><input type="text" name="txtTelefone" value="<%=funcionario.getTelefone() %>"/></td>
			</tr>
			<tr>
				<td>Celular: </td>
				<td><input type="text" name="txtCelular" value="<%=funcionario.getCelular() %>"/></td>
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