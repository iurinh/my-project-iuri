<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<%
	String msg = (String) request.getAttribute("MSG");
	if ("".equals(msg) || msg == null) 
		msg = "";
%>

<h1>Seja Bem Vindo!</h1>
<br>
<br> Por favor! 
<br> Insira seu login e senha para acessar nosso sistema.
<br>
<br>
<form action="./LoginController" method="post">
	<table>
		<tr>
			<td>Login: </td>
			<td><input type="text" name="txtLogin"></td>
		</tr>
		<tr>
			<td>Senha: </td>
			<td><input type="text" name="txtSenha"></td>
		</tr>
		<tr>
			<td>Tipo de Acesso: </td>
			<td><select name="cbAcesso">
				<option value="0">Selecione um tipo de acesso</option>
				<option value="1">1 - Administrador"</option>
				<option value="2">2 - Gerente"</option>
				<option value="3">3 - Professor"</option>
			</td>
		</tr>
		
		<tr>
			<td><input type="submit" name="cmd" value="Acessar"></td>
			<td><input type="submit" name="cmd" value="Limpar"></td>
			<td><input type="submit" name="cmd" value="Adicionar"></td>
		</tr>
	</table>
	<br>
	<table>
		<tr>
			<td><h3><%= msg %></h3></td>
		</tr>
	</table>
</form>
</body>
</html>