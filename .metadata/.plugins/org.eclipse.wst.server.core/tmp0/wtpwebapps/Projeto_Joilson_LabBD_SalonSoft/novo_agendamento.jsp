<%@page import="control.ControllerAgendamento"%>
<%@page import="entity.Servico"%>
<%@page import="entity.Cliente"%>
<%@page import="entity.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="entity.Agendamento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salon soft - Novo Agendamento</title>
</head>
<body>
	<a href="./index.jsp"><h1>Salon Soft - Seu salao aqui e agora</h1></a>
	<%
		ControllerAgendamento ctrl = new ControllerAgendamento();
	%>

	<h3>Registre aqui seu novo Agendamento</h3>

	<form action="./ControllerAgendamento" method="post">
		<table>
			<tr>
				<td>Data: </td>
				<td><input type="text" name="txtData"/></td>
			</tr>
			<tr>
				<td>Horario: </td>
				<td><input type="text" name="txtHorario"/></td>
			</tr>
			<tr>
				<td>Cliente: </td>
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
			</tr>
			<tr>
				<td>Funcionario: </td>
				<td>
					<select name="idFuncionario">
						<option value="0">Selecione um Funcionario</option>
						<%
							List<Funcionario> lsFuncionarios = ctrl.getListaFuncionarios();
							for(int i=0; i<lsClientes.size();i++){
						%>
							<option id=<%=lsFuncionarios.get(i).getId() %> value="<%=lsFuncionarios.get(i).getId() %>"><%=lsFuncionarios.get(i).getNome() %></option>
						<%
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>Servico: </td>
				<td>
					<select name="idServico">
						<option value="0">Selecione um Servico</option>
						<%
							List<Servico> lsServicos = ctrl.getListaServicos();
							for(int i=0; i<lsClientes.size();i++){
						%>
							<option id=<%=lsServicos.get(i).getIdServico() %> value="<%=lsServicos.get(i).getIdServico() %>"><%=lsServicos.get(i).getNome() %></option>
						<%
							}
						%>
					</select>
				</td>
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