<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String nome = request.getParameter("nome");
		String end = request.getParameter("end");
		String cel = request.getParameter("cel");
		String idade = request.getParameter("idade");
		
		out.println("<div class 'imprime'> <h2> Nome:"+nome+ "<br> Endereço: "+
		end+"<br> Celular: "+cel+ "<br> Idade: " + idade+"</h2></div>");
	%>

</body>
</html>