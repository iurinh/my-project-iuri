<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Principal Cadastro de Jogos</title>
</head>
<body>
<h1>Verifique o banco antes de rodar a nossa aplicaçao</h1>

<br>
CREATE DATABASE `dbjogo` /*!40100 DEFAULT CHARACTER SET utf8 */; <br>
<br>
CREATE TABLE `jogo` (<br>
  `id` int(11) NOT NULL AUTO_INCREMENT,<br>
  `nome` varchar(45) NOT NULL DEFAULT 'Nao Nomeado',<br>
  `nivel` int(11) NOT NULL DEFAULT '0',<br>
  PRIMARY KEY (`id`)<br>
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;<br>
<br>
<br>
<br>
Caso ja tenha o banco cadastrado clique <a href="./jogo.jsp">aqui!</a>
</body>
</html>