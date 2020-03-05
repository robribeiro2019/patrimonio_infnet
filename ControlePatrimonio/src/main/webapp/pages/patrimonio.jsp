<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="templates/header.jsp"></jsp:include>
	
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
    <form class="form-horizontal" action="<c:url value='/PatrSrv?action=new'/>" method="post" >

          <legend>Detalhe do Patrimônio (incluir)</legend>

          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">Descrição</label>
            <div class="col-sm-10">
              <input type="text" id="descricao" name="descricao" placeholder="Descrição" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">Localização</label>
            <div class="col-sm-10">
              <input type="text" id="localizacao" name="localizacao" placeholder="Localização" class="form-control">
            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <div class="pull-right">
                <button type="button" class="btn btn-default" onclick="history.go(-1);" name="cancel">Voltar</button>
                <button type="submit" class="btn btn-primary" name="save">Save</button>
              </div>
            </div>
          </div>
          <div class="form-group">
            <h1>${requestScope.error}</h1>
          </div>
      </form>
    </div>
</div>
	
</body>
</html>