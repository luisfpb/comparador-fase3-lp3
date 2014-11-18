<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.mackenzie.ep.buscador.model.Produtos"%>
<%@page import="com.mackenzie.ep.buscador.model.Produto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comparador</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<%
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(Cookie cookie : cookies){
	    		if(cookie.getName().equals("user")) userName = cookie.getValue();
	    	}
		}
		if(userName == null) response.sendRedirect("login.jsp");
	%>
	<p class="marca">Comparador</p>

	<form action="FrontControllerServlet" method="GET" class="centerForm">
		<input type="text" name="term" placeholder="Busca" class="tamText" />
		<input type="hidden" name="control" value='ComparaProduto' /> <input
			type="submit" value="" class="submit" />
	</form>

	<%
		if(request.getAttribute("produtos") != null){
	                    Produtos produtos = (Produtos)request.getAttribute("produtos");
	                            for (Produto produto : produtos.getProduto()) {
	                            	out.print("<table class=\"produto\">");
	                            	out.print("<tr><th class=\"nomeProduto\">" + produto.getNome()+"</th></tr>");
	                            	out.print("<tr><td>" + produto.getDescricao()+"</td><td class=\"valor\">R$"+produto.getValor()+"</td></tr>");
	                            	out.print("<tr><td class=\"space\">Fornecido por <span class=\"amarelo\">" + produto.getIdLoja().getNome()+"</span></td></tr>");
	                            	out.print("<table>");
	                            }
	                        
	                    }
	%>
</body>
</html>