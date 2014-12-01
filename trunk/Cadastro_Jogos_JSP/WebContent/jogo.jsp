<%@page import="entity.Jogo"%>
<%@page import="control.JogosController"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Jogos</title>
</head>
<body>
<h1>Cadastre seus jogos aqui ou de uma olhadinha na sua coleção!</h1>

<%
	JogosController ctrl = new JogosController();
	List<Jogo> lsJogo = ctrl.getListaJogo();
	
	String message = (String) request.getAttribute("MSG");
	
	Jogo jogo = (Jogo) request.getAttribute("Jogo");
	if(jogo == null)
		jogo = new Jogo();
	
	if(message == null) message = "";
%>

<form action="./JogosController" method="post">

	<table>
		<tr>
			<td>Nome do Joguinho:</td>
			<td><input type="text" value="<%= jogo.getNome() %>" name="txtNome"/></td>
		</tr>
		<tr>
			<td>Nivel do Joguinho:</td>
			<td><input type="text" value="<%= jogo.getNivel() %>" name="txtNivel"/></td>
		</tr>
	</table>

	<table>
		<tr>
			<td><select name="ComboBoxJogos">
				<option value="0">Selecione seu Joguinho</option>
					<% for(int i = 0; i < lsJogo.size(); i++) { %>
				<option id=<%= lsJogo.get(i).getId() %> value="<%= lsJogo.get(i).getId() %>"> <%= lsJogo.get(i).getNome() %> </option>
					<% } %>
				</select>
			</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td><input type="submit" value="Incluir" name="cmd"/></td>
			<td><input type="submit" value="Pesquisar" name="cmd"/></td>
			<td><input type="submit" value="Atualizar" name="cmd"/></td>
			<td><input type="submit" value="Deletar" name="cmd"/></td>
			<td><input type="submit" value="Limpar" name="cmd" /></td>
		</tr>
	</table>
	
	<h4><%= message %></h4>
	
	<table border="1">
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>Nivel</td>
		</tr>
		
		<% for(int i = 0; i < lsJogo.size(); i++){ %>
		<tr>	
			<td><%= lsJogo.get(i).getId() %></td>
			<td><%= lsJogo.get(i).getNome() %></td>
			<td><%= lsJogo.get(i).getNivel() %></td>
		</tr>
		<% } %>
	</table>
</form>
</body>
</html>