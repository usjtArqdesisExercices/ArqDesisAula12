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

	<!-- Barra superior com os menus de navegação -->
	<c:import url="menu.jsp" />

	<div class="acessAccount" id="mainDiv">

	<div id="titleBankLine" align="center">
		<h1>BankLine</h1>
	</div>
	    
	    <div id="tableButtonOptions" align="center">
		    <table style="width:20%">
		    	<tr>
		    		<td>
					<div align="center" id="submitButton" id="withdrawButton">
				    	<a href="Controller.do?command=SaqueReiniciar"><button type="submit" class="btn btn-porimary">Saque</button></a>
					</div>
					</td>
					
					<td>
					<div align="center" id="submitButton" id="depositButton">
				    	<a href="#"><button type="submit" class="btn btn-porimary">Deposito</button></a>
					</div>
					</td>
			
					<td>
					<div align="center" id="submitButton" id="TransferButton">
				    	<a href="#"><button type="submit" class="btn btn-porimary">Transferencia</button></a>
					</div>
					</td>
					
					<td>
					<div align="center" id="submitButton" id="ExtractButton">
				    	<a href="Controller.do?command=ExtratoReiniciar"><button type="submit" class="btn btn-porimary">Extrato</button></a>
					</div>
					</td>
				</tr>
			</table>
		</div>
        
	</div>
	
</body>

</html>