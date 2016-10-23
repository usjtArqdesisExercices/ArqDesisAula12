<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<title>Caixa Eletrônico - BankLine</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/loginStyle.css" />
</head>
<body>

<div class="login">

	<div id="titleBankLine" align="center">
		<h1>BankLine</h1>
	</div>
    <form class="form-inline" role="form">
    
    	<div id="divLabes" align="center" >
	        <div class="form-group">
	            <label class="sr-only" for="inputAccount">Conta</label>
	            <input type="text" class="form-control" id="inputAccount" placeholder="Conta">
	        </div>
	        
	        <div class="form-group">
	            <label class="sr-only" for="inputAgency">Agência</label>
	            <input type="text" class="form-control" id="inputAgency" placeholder="Agência">
	        </div>
	                
	        <div class="form-group">
	            <label class="sr-only" for="inputPassword">Senha</label>
	            <input type="password" class="form-control" id="inputPassword" placeholder="Senha">
	        </div>
		</div>	        
        
		<div align="center" id="submitButton" id="loginButton">
	    	<button type="submit" class="btn btn-porimary"><a href="AcessAccount.jsp" >Login</a></button>
		</div>
        
    </form>
    <br>
</div>

</body>
</html>