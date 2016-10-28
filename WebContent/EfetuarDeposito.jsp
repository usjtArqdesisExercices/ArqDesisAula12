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

	<div class="acessAccount">

	<div id="titleBankLine" align="center">
		<h1>BankLine</h1>
	</div>
	    
		<div align="center" id="submitButton" id="withdrawButton">
	    	<a href="EfetuarSaque.jsp" ><button type="submit" class="btn btn-porimary">Saque</button></a>
		</div>
		
		<div align="center" id="submitButton" id="depositButton">
	    	<a href="EfetuarDeposito.jsp" ><button type="submit" class="btn btn-porimary">Deposito</button></a>
		</div>

		<div align="center" id="submitButton" id="TransferButton">
	    	<a href="EfetuarTransferencia.jsp" ><button type="submit" class="btn btn-porimary">Transferencia</button></a>
		</div>
		
		<div align="center" id="submitButton" id="ExtractButton">
	    	<a href="EfetuarExtrato.jsp" ><button type="submit" class="btn btn-porimary">Extrato</button></a>
		</div>						
        
	</div>

</body>

</html>