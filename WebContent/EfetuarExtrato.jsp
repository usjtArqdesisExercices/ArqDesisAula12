<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Caixa Eletrônico - BankLine</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/loginStyle.css" />
</head>

<body>

	<div class="efetuarExtrato">

		<div id="titleBankLine" align="center">
			<h1>Extrato</h1>
		</div>

		<div id="tableExtractOptions" align="center">
			<table style="width: 25%">
				<tr>
					<td align="right">
						<div id="submitButton" id="7DiasButton">
							<button type="submit" class="btn btn-porimary">
								<a href="EfetuarSaque.jsp">7 Dias</a>
							</button>
							&nbsp;
						</div>
					</td>
					<td align="left">
						<div id="submitButton" id="15DiasButton">
							&nbsp;
							<button type="submit" class="btn btn-porimary">
								<a href="EfetuarTransferencia.jsp">15 Dias</a>
							</button>
						</div>
					</td>
				</tr>
				<tr>
					<td align="right">
						<div id=divInitialDate>
							<br>
							<form class="form-inline" action='' method='post'
								style="width: 200px">
								<p>
									<label class="sr-only" for="inputInitialDate"><h4 align="center">Data
											Inical</h4> </label><input type="date" class="form-control"
										id="inputInitialDate" size="5px"
										style="width: 100%; margin: -3px"
										placeholder="Data Inicial">
								</p>
							</form>
						</div>
					</td>
					<td align="left">
						<div id=divFinalDate>
							<br>
							<form class="form-inline" action='' method='post'
								style="width: 200px">
								<p>
									<label class="sr-only" for="inputFinalDate"><h4 align="center">
											Data Final</h4></label> <input type="date" class="form-control"
										id="inputFinalDate" size="5px"
										style="width: 100%; margin: -3px"
										placeholder="Data Final">
								</p>
							</form>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-porimary">
							<a href="EfetuarTransferencia.jsp">Confirma</a>
						</button>
					<td>
				</tr>
			</table>
		</div>
	</div>

</body>

</html>