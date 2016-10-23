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

	<div class="efetuarSaque" align="center">

		<div id="titleBankLine" align="center">
			<h1>BankLine</h1>
		</div>

		<table style="width:50%">
		
			<tr>
				<td align="left">
			   		 <!-- Opções de Saque Lado esquerdo -->	    
			    	<div id="withdrawOptions1">
					    <ul>
							<div align="center" id="submitButton" id="10ReaisButton">
						    	<button type="submit" class="btn btn-porimary"><a href="EfetuarSaque.jsp" >R$ 10</a></button>
							</div>
							
							<div align="center" id="submitButton" id="20ReaisButton">
						    	<button type="submit" class="btn btn-porimary"><a href="EfetuarDeposito.jsp" >R$ 20</a></button>
							</div>
					
							<div align="center" id="submitButton" id="50ReaisButton">
						    	<button type="submit" class="btn btn-porimary"><a href="EfetuarTransferencia.jsp" >R$ 50</a></button>
							</div>
						</ul>
					</div>
				</td>
		
				<td align="center">
					<!-- Opção de Saque Digitado -->
					<div>
						<form action='' method='post' style="width:200px">
				            <label class="sr-only" for="inputWithdrawValue">Valor</label>
				            <input type="text" class="form-control" id="inputWithdrawValue" size="5px"
				            		style="width:100%;margin:-3px;border:2px" placeholder="Digite um valor">
			            </form>			
					</div>
				</td>
				
				<td align="right">
					<!-- Opções de Saque Lado direito -->
			    	<div id="withdrawOptions2" align="right">
					    <ul>		
							<div align="center" id="submitButton" id="100ReaisButton">
						    	<button type="submit" class="btn btn-porimary"><a href="EfetuarExtrato.jsp" >R$ 100</a></button>
							</div>
							
							<div align="center" id="submitButton" id="200ReaisButton">
						    	<button type="submit" class="btn btn-porimary"><a href="EfetuarTransferencia.jsp" >R$ 200</a></button>
							</div>
							
							<div align="center" id="submitButton" id="500ReaisButton">
						    	<button type="submit" class="btn btn-porimary"><a href="EfetuarExtrato.jsp" >R$ 500</a></button>
							</div>
						</ul>
					</div>
				</td>
			</tr>
				
		</table>		
        
	</div>

</body>

</html>