<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">
<title>Patrimonio</title>
</head>
<body>

	<jsp:include page="templates/header.jsp"></jsp:include>


<div class="container">
	<div class="row col-md-6 col-md-offset-2 custyle">
		<table class="table table-striped custab">
			<thead>
			<a href="<c:url value='pages/patrimonio.jsp' />" class="btn btn-primary btn-xs pull-right"><b>+</b> Adicionar novo patrimônio</a>
		    <tr>
		        <th>ID</th>
		        <th>Descrição</th>
		        <th>Localização</th>
		        <th class="text-center">Action</th>
		    </tr>
			</thead>
<!-- 			teste -->
		    <tr>
			    <td>1</td>
			    <td>teste nome</td>
			    <td>teste localizacao</td>
			    <td class="text-center">
		    	<a class='btn btn-info btn-xs' onclick="document.getElementById('myform').submit()"><span class="glyphicon glyphicon-edit"></span> Editar</a> 
		    	<a class='btn btn-danger btn-xs' onclick="document.getElementById('myform').submit()" ><span class="glyphicon glyphicon-remove"></span> Excluir</a>
		     	</td>
		  </tr>  
<!-- 		   fim doteste -->
			<c:forEach var="patrimonio" items="${lista_patrimonio}" >
		    <tr>
			    <td>${patrimonio.id}</td>
			    <td>${patrimonio.nome}</td>
			    <td>${patrimonio.localizacao}</td>
			    <td class="text-center">
		    	<a class='btn btn-info btn-xs' onclick="document.getElementById('myform').submit()"><span class="glyphicon glyphicon-edit"></span> Editar</a> 
		    	<a class='btn btn-danger btn-xs' onclick="document.getElementById('myform').submit()" ><span class="glyphicon glyphicon-remove"></span> Excluir</a>
		     	</td>
		  </tr>  
		  </c:forEach>        
	  </table>
  </div>
</div>
    
</body>
</html>