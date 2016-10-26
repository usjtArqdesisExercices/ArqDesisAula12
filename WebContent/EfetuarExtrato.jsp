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

	<!-- Barra superior com os menus de navegação -->
	<c:import url="menu.jsp" />
	
	<div id="mainDiv" class="efetuarExtrato">

		<div id="titleBankLine" align="center">
			<h1>Extrato</h1>
		</div>

		<div id="tableExtractOptions" align="center">
			<form action="Extrato.do" method="post">
				<table style="width: 25%">
					<tr>
						<td align="right">
							<div id="submitButton" id="7DiasButton">
								<button type="submit" class="btn btn-porimary" name="acao"
									value="7Dias">7 Dias</button>
								&nbsp;
							</div>
						</td>
						<td align="left">
							<div id="submitButton" id="15DiasButton">
								&nbsp;
								<button type="submit" class="btn btn-porimary" name="acao"
									value="15Dias">15 Dias</button>
							</div>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div id=divInitialDate>
								<br>
								<h4 align="center">
									<label class="sr-only" for="inputInitialDate">Data
										Inical</label>
								</h4>
								<input type="date" class="form-control" id="inputInitialDate"
									size="5px" style="width: 100%; margin: -3px"
									placeholder="Data Inicial" min="1979-12-31" max="2100-01-01"
									name="data[dataInicial]">
							</div>
						</td>
						<td align="left">
							<div id=divFinalDate>
								<br>
								<h4 align="center">
									<label class="sr-only" for="inputFinalDate">Data Final</label>
								</h4>
								<input type="date" class="form-control" id="inputFinalDate"
									size="5px" style="width: 100%; margin: -3px"
									placeholder="Data Final" name="data[dataFinal]"
									min="1979-12-31" max="2100-01-01">
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><br>
							<button type="submit" class="btn btn-porimary" name="acao"
								value="outraData">Confirma</button>
						<td>
					</tr>
				</table>
			</form>
		</div>

		<jsp:useBean id="listaExtrato" class="to.ListaExtrato" scope="request" />
		<c:set var="tipoMov" scope="session" value="#" />
		<c:if test="${not empty listaExtrato}">
			<c:if test="${not empty listaExtrato.extrato}">
				<div id="list" class="row">
					<div class="table-responsive col-md-12" align="center">
						<table class="table table-striped" style="width: 50%">
							<thead>
								<tr>
									<th>Valor Da Movimentacao</th>
									<th>Valor Saldo Atual</th>
									<th>Tipo Movimentação</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="varExtrato" items="${listaExtrato.extrato}"
									varStatus="loop">
									<tr>
										<td>${varExtrato.valorMovimentacao }</td>
										<td>${varExtrato.saldoAtual }</td>


										<c:if test="${varExtrato.idTipoMovimentacao == '1'}">
											<c:set var="tipoMov" scope="session" value="TRANSFERENCIA" />
										</c:if>
										<c:if test="${varExtrato.idTipoMovimentacao == '2'}">
											<c:set var="tipoMov" scope="session" value="SAQUE" />
										</c:if>
										<c:if test="${varExtrato.idTipoMovimentacao == '3'}">
											<c:set var="tipoMov" scope="session" value="DEBITO AUTO." />
										</c:if>

										<td><c:out value="${tipoMov}" /></td>

										<c:if
											test="${varExtrato.data != listaExtrato.extrato[loop.index + 1].data && data != '#' || loop.last}">
											<tr align="right">
												<td colspan="3">Saldo do Dia: <c:out
														value="${varExtrato.saldoAtual }" /> / Data Movimentação:
													<c:out value="${varExtrato.data }" /></td>
											</tr>
										</c:if>

									</tr>
								</c:forEach>

							</tbody>
						</table>

					</div>
				</div>
				<!-- /#list -->

			</c:if>
		</c:if>

	</div>

	<!-- /#main -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>

</html>