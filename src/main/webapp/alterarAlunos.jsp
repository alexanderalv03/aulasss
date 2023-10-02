<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.jp.senac.model.Aluno" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Aluno</title>
</head>
<body>

<%Aluno aluno = (Aluno) request.getAttribute("aluno"); %>

<h2>Alterar Aluno:</h2>


<form action="ConfirmarAlteracaoServlet" method="post">

<input type="hidden" name="nomeAntigo" value="<%=aluno.getNome() %>">

Nome:
<input type="text" name="nome" value="<%=aluno.getNome() %>">
Idade:
<input type="text" name="idade value="<%=aluno.getIdade() %>">

Semestre

<select name="semestre">
	<option value="Primeiro" <%=aluno.getSemestre().equals("Primeiro")? "selected" : "" %>>Primeiro</option>
	<option value="Segundo" <%=aluno.getSemestre().equals("Segundo")? "selected" : "" %>>Segundo</option>

</select>


Genero
<!-- Realizar a operação de selecionar corretamente o genero

Dica: ternario com a opção checked

 -->
<input type="submit" value="Confirmar Alteração">
<a href="ListarAlunos.jsp">Voltar</a>

</form>
</body>
</html>