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
	
    <form action="Controller.do" method="post" class="form-inline" role="form">
    
    	<div id="divLabes" align="center" >
	        <div class="form-group">
	            <label class="sr-only" for="inputAccount" >Conta</label>
	            <input type="text" class="form-control" id="inputAccount" name="data[conta]" placeholder="Conta" maxlength="3">
	        </div>
	        
	        <div class="form-group">
	            <label class="sr-only" for="inputAgency">Agência</label>
	            <input type="text" class="form-control" id="inputAgency" name="data[agencia]" placeholder="Agência" maxlength="3">
	        </div>
	                
	        <div class="form-group">
	            <label class="sr-only" for="inputPassword">Senha</label>
	            <input type="password" class="form-control" id="inputPassword" name="data[senha]" placeholder="Senha" maxlength="6">
	        </div>
		</div>	        
        <br>
		<div align="center" id="loginButton">
	    	<button type="submit" class="btn btn-porimary" name="command" value="FazerLogin">Login</button>
		</div>
        
    </form>
    <br>
</div>

</body>
</html>