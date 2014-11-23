<%@page import="control.ControllerServico"%>
<%@page import="java.util.List"%>
<%@page import="entity.Servico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salon Soft - Alterar ou Excluir Servico</title>
</head>
<body>
	<a href="./index.jsp"><h1>Salon Soft - Seu salao aqui e agora</h1></a>
	<%
		ControllerServico ctrl = new ControllerServico();
		Servico servico = (Servico) request.getAttribute("Servico");
		
		if(servico == null)
			servico = ctrl.getServicoVazio();
	%>

	<h3>Altere ou exclua aqui o Servico</h3>

	<form action="./ControllerServico" method="post">
		<table>
			<tr>
				<td>
					<select name="idServico">
						<option value="0">Selecione um Servico</option>
						<%
							List<Servico> lsServicos = ctrl.getListaServicos();
							for(int i=0; i<lsServicos.size();i++){
						%>
							<option id=<%=lsServicos.get(i).getIdServico() %> value="<%=lsServicos.get(i).getIdServico() %>"><%=lsServicos.get(i).getNome() %></option>
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
				<td><input type="text" name="txtNome" value="<%=servico.getNome() %>"/></td>
			</tr>
			<tr>
				<td>Valor: R$</td>
				<td><input type="text" name="txtValor" value="<%=servico.getValor() %>"/></td>
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