<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Meu Primeiro JSP</title>
</head>
<body>
	<%
		String nome = "Paulo";
		out.println(nome);
	%>
	<h1>18 de outubro de 2022</h1>
	
	<form action="home.jsp" method="post">
		<input type="text" name="vlr1">
		<input type="text" name="vlr2">
		<input type="submit" value="Somar">
	</form>
	<h2>
		<%
			if(request.getMethod().equals("POST")){
				double n1 = Double.parseDouble(request.getParameter("vlr1"));
				double n2 = Double.parseDouble(request.getParameter("vlr2"));
				double soma = n1+n2;
				out.println("A Soma �: "+ soma);
			}
		%>
	</h2>
	
	<form action="home.jsp" method="post">
		<input type="text" name="vlr1">
		<input type="text" name="vlr2">
		<input type="submit" value="Subtrair">
	</form>
	<h2>
		<%
			if(request.getMethod().equals("POST")){
				double n1 = Double.parseDouble(request.getParameter("vlr1"));
				double n2 = Double.parseDouble(request.getParameter("vlr2"));
				double sub = n1-n2;
				out.println("A Subtra��o �: "+ sub);
			}
		%>
	</h2>
	
	<form action="home.jsp" method="post">
		<input type="text" name="vlr1">
		<input type="text" name="vlr2">
		<input type="submit" value="Multiplicar">
	</form>
	<h2>
		<%
			if(request.getMethod().equals("POST")){
				double n1 = Double.parseDouble(request.getParameter("vlr1"));
				double n2 = Double.parseDouble(request.getParameter("vlr2"));
				double mult = n1*n2;
				out.println("A Multiplica��o �: "+ mult);
			}
		%>
	</h2>
	
	<form action="home.jsp" method="post">
		<input type="text" name="vlr1">
		<input type="text" name="vlr2">
		<input type="submit" value="Divis�o">
	</form>
	<h2>
		<%
			if(request.getMethod().equals("POST")){
				double n1 = Double.parseDouble(request.getParameter("vlr1"));
				double n2 = Double.parseDouble(request.getParameter("vlr2"));
				double div = n1/n2;
				out.println("A Divis�o �: "+ div);
			}
		%>
	</h2>
	
	

</body>
</html>