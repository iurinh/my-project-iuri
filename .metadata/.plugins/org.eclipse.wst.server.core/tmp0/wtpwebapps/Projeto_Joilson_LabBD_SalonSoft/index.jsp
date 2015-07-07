<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Principal</title>
</head>
<body>
	<h1>Salon Soft - Seu salao aqui e agora</h1>
	<h3>Selecione uma das opções:</h3>
	
	<form action="./ControllerCliente" method="post">
		<table border="1">
			<tr>
				<td><a href="./novo_cliente.jsp">Novo Cliente</a></td>
				<td><a href="./novo_funcionario.jsp">Novo Funcionario</a></td>
				<td><a href="./novo_servico.jsp">Novo Servico</a></td>
				<td><a href="./novo_agendamento.jsp">Novo Agendamento</a></td>
			</tr>
			<tr>
				<td><a href="./alterar_excluir_cliente.jsp">Alterar/Excluir Cliente</a></td>
				<td><a href="./alterar_excluir_funcionario.jsp">Alterar/Excluir Funcinoario</a></td>
				<td><a href="./alterar_excluir_servico.jsp">Alterar/Excluir Servico</a></td>
				<td><a href="./alterar_excluir_agendamento.jsp">Alterar/Excluir Agendamento</a></td>
			</tr>
		</table>
	</form>
</body>
</html>