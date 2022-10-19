<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css"/>
<title>Calculadora JSP</title>
</head>
<body>
	<%
		String nome = "Paulo Soares de Moura";
		out.println(nome);
	%>
	<h1>Calculadora JSP</h1>
	
	<form action="operacoes.jsp" method="post" name="calc">
		<input type="text" name="vlr1" placeholder="Nro. 1">
		<input type="text" name="vlr2" placeholder="Nro. 2">
		<br><br>
		<input type="submit" value="+" name="btn">
		<input type="submit" value="-" name="btn">
		<input type="submit" value="*" name="btn">
		<input type="submit" value="/" name="btn">
		<input type="submit" value="%" name="btn">
		<input type="submit" value="R%" name="btn">
	</form>
	<br><br>
	<form action="imprime.jsp" method="post" name="cad">
		Nome: <input type="text" name="nome">
		Endereço: <input type="text" name="end">
		Celular: <input type="text" name="cel">
		Idade: <input type="text" name="idade">
		
		<br><br>
		<input type="reset" value="Limpar" name="btn">
		<input type="submit" value="Cadastrar" name="btn">
		
	</form>

</body>
</html>