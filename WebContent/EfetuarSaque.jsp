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

	<div class="efetuarSaque" id="mainDiv" align="center"
		class="page-header">

		<div id="titleBankLine" align="center">
			<h1>Saque</h1>
		</div>

		<c:if test="${not empty ultimoSaldo.saldoAtual}">
			<script type="text/javascript">
				$(window).load(function() {
					$('#saldo-modal').modal('show');
				});
			</script>
		</c:if>

		<!-- Modal -->
		<div class="modal fade" id="saldo-modal" tabindex="-1" role="dialog"
			aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h3 class="modal-title" id="modalLabel">Saldo Atual</h3>
					</div>
					<div class="modal-body">R$ ${ultimoSaldo.saldoAtual}</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Sair</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal -->
		<form action="Controller.do" method="post" style="width: 50%">
			<table>
				<tr>
					<td align="left">
						<!-- Opções de Saque Lado esquerdo -->
						<div id="withdrawOptions1">

							<div align="center" id="submitButton" id="10ReaisButton">
								<button type="submit" class="btn btn-porimary" name="command"
									value="Saque10Reais">R$ 10</button>
							</div>
							<div align="center" id="submitButton" id="20ReaisButton">
								<button type="submit" class="btn btn-porimary" name="command"
									value="Saque20Reais">R$ 20</button>
							</div>

							<div align="center" id="submitButton" id="50ReaisButton">
								<button type="submit" class="btn btn-porimary" name="command"
									value="Saque50Reais">R$ 50</button>
							</div>
						</div>
					</td>

					<td align="center">
						<!-- Opção de Saque Digitado -->
						<div>
							<label class="sr-only" for="inputWithdrawValue">Valor</label> <input
								min="0" max="1000" value="0.00" type="number"
								class="form-control" id="inputWithdrawValue" name="data[valor]"
								style="width: 50%; margin: -3px; border: 2px"
								placeholder="Digite um valor" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required>
							<br>
							<button type="submit" class="btn btn-porimary" name="command"
								value="SaqueOutroValor">Confirma</button>
						</div>
					</td>

					<td align="right">
						<!-- Opções de Saque Lado direito -->
						<div id="withdrawOptions2" align="right">
							<div align="center" id="submitButton" id="100ReaisButton">
								<button type="submit" class="btn btn-porimary" name="command"
									value="Saque100Reais">R$ 100</button>
							</div>

							<div align="center" id="submitButton" id="200ReaisButton">
								<button type="submit" class="btn btn-porimary" name="command"
									value="Saque200Reais">R$ 200</button>
							</div>

							<div align="center" id="submitButton" id="500ReaisButton">
								<button type="submit" class="btn btn-porimary" name="command"
									value="Saque500Reais">R$ 500</button>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- /#main -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>

</html>