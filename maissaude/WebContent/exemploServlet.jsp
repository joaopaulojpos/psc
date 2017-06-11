<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
System.out.println("Teste Scriptlet");
%>

	<form action="exemploServlet" method="POST">
		Nome: <input type="text" name="nome"  /><br />
		E-mail: <input type="text" name="email" /><br />
		Endereco: <input type="text" name="endereco" /><br />
		Data Nascimento: <input type="text" name="dataNascimento" /><br />
		
		<input type="submit" value="Gravar" />
	</form>
</body>
</html>
