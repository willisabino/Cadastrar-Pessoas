<%@page import="br.com.cadastrarpessoa.servlet.PessoaServlet"%>
<%@page import="br.com.cadastrarpessoa.service.PessoaService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.cadastrarpessoa.model.Pessoa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Pessoas</title>
<link rel="stylesheet" href="estilo.css">
</head>

<body>

	<form action="pessoaservlet" method="post">

		<h1>Cadastro de Pessoas</h1>

		<p hidden="hidden">
			<label for="id">ID</label>
			<input type="text" name="id" id="id" onload='alteraTipoInput()' value="${ cadastro.id }">
		</p>
		<p>
			<label for="nome">Nome</label> 
			<input type="text" name="nome" id="nome" required value="${ cadastro.nome }">
		</p>
		<p>
			<label for="nome">Idade</label> 
			<input type="text" name="idade" id="idade" onload='alteraTipoInput()' required min="0" max="99" value="${ cadastro.idade }">
		</p>
		<p>
			<label for="sexo">Sexo</label> <select name="sexo" id="sexo">
				<option>Selecione um Sexo:</option>
				<option value="1">Masculino</option>
				<option value="2">Feminino</option>
			</select>
		</p>
		<p>
			<input type="submit" value="Inserir" id="inserir" name="acao"> 
			<input type="submit" value="Alterar" id="alterar" name="acao"> 
			<input type="submit" value="Limpar" id="limpar" name="acao">
			<input type="hidden" name="acao">
			<input type="button" value="gravarJavaScript" onclick="funcaoGravar()">
		</p>
	</form>

	<c:if test="${ empty listaPessoa }">
		<p>Não Há Contatos Cadastrados</p>
	</c:if>

	<c:if test="${ not empty listaPessoa }">

		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Idade</th>
					<th>Sexo</th>
					<th>Data Cadastro</th>
					<th>Alterar</th>
					<th>Editar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ listaPessoa }" var="listaPessoas">

					<tr>
						<td>${ listaPessoas.id }</td>
						<td>${ listaPessoas.nome }</td>
						<td>${ listaPessoas.idade }</td>
						<td>${ listaPessoas.sexo }</td>
						<td><fmt:formatDate value="${ listaPessoas.dataCadastro }" pattern="dd/MM/yyy" /></td>
						<td><a href="alterarCadastro?id=${listaPessoas.id}" onclick='bloquear()'>O</a></td>
						<td><a href="removePessoaServlet?id=${listaPessoas.id}" onclick="return confirm('Tem certeza que deseja apagar o contato ${ listaPessoas.nome }?')">X</a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

	</c:if>

	<script src="js.js"></script>
</body>
</html>