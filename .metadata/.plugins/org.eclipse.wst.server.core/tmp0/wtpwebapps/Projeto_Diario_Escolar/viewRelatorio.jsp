<%@page import="control.ControllerRelatorio"%>
<%@page import="model.entity.Relatorio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatorio do Dia</title>
</head>
<body>
	
	<form action="./ControllerRelatorio" method="post">
		
		<table>
			<tr>
				<td>Data do Relatório: </td>
				<td><input type="text" name="txtData" value="${relatorio.dia}"></td>
			</tr>
			<tr>
				<td>Descrição: </td>
				<td><input type="text" name="txtDescricao" value="${relatorio.descricao}"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type="submit" name="cmd" value="Adicionar"></td>
				<td><input type="submit" name="cmd" value="Alterar"></td>
				<td><input type="submit" name="cmd" value="Remover"></td>
			</tr>
		</table>
		<table border="1">
			<tr>
				<td>ID</td>
				<td>Data</td>
				<td>Descrição</td>
			</tr>
				<%
				ControllerRelatorio ctrl = new ControllerRelatorio(); 
				try{
					for (Relatorio dadosRelatorio : ctrl.obterRelatorios()) {
						%>
						<tr>
							<td><%=dadosRelatorio.getId() %> </td>
							<td><%=dadosRelatorio.getDia() %> </td>
							<td><%=dadosRelatorio.getDescricao() %> </td>
						</tr>
						<%
					}
				}catch(Exception e){
					%>ERRO AO CARREGAR TABELA DE RELATORIOS<br><%
					System.out.println(e.getMessage());
				}
				%>
			</tr>
		</table>
		<%= request.getAttribute("MSG") %>
		</form>
</body>
</html>