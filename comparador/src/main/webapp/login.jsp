<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	LOgin
	<%
	try{
		Boolean logged = (Boolean)request.getAttribute("logged"); 
		if(!logged){
			out.print("<font color=red>Either user name or password is wrong.</font>");
		}
		else {String userName = null;
			Cookie[] cookies = request.getCookies();
			if(cookies !=null)
				response.sendRedirect("comparador.jsp");
		}
	}catch (Exception ex){}
%>
	<form action="LoginServlet" method="POST" class="centerForm">
		<input type="text" name="login" placeholder="Login" class="tamText" />
		<input type="text" name="senha" placeholder="Senha" class="tamText" />
		<input type="hidden" name="control" value='Login' /> <input
			type="submit" value="" class="submit" />
	</form>
</body>
</html>