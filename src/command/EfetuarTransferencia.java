package command;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDAO;
import dao.ExtratoDAO;
import dao.SaldoDAO;
import dao.TransferenciaDAO;
import model.Cliente;
import model.Data;
import model.Saldo;
import model.Transferencia;
import to.ClienteTO;
import to.SaldoTO;

public class EfetuarTransferencia implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session;
		Connection conn;
		ClienteDAO clienteDAO;
		SaldoDAO saldoDAO;
		TransferenciaDAO transferenciaDAO;
		ExtratoDAO extratoDAO;
		Transferencia transferencia;
		Cliente cliente;
		Saldo saldo;
		ClienteTO clienteTODeb;
		ClienteTO clienteTOCred;
		SaldoTO saldoTO;

		String pAgenciaCred = request.getParameter("data[agencia]");
		String pContaCred = request.getParameter("data[conta]");
		String pValorTransferencia = request.getParameter("data[valorTransf]");
		int agenciaCred = -1;
		int contaCred = -1;
		double valorTransferencia = -1.00;

		try {
			if (pAgenciaCred != null && !pAgenciaCred.equals("")) {
				agenciaCred = Integer.parseInt(pAgenciaCred);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		try {
			if (pContaCred != null && !pContaCred.equals("")) {
				contaCred = Integer.parseInt(pContaCred);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		try {
			if (pValorTransferencia != null && valorTransferencia <= 0) {
				valorTransferencia = Integer.parseInt(pValorTransferencia);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		conn = (Connection) request.getAttribute("conexao");
		clienteDAO = new ClienteDAO(conn);
		saldoDAO = new SaldoDAO(conn);
		transferenciaDAO = new TransferenciaDAO(conn);
		extratoDAO = new ExtratoDAO(conn);

		session = request.getSession();
		clienteTODeb = (ClienteTO) session.getAttribute("logado");

		Data data = new Data();

		cliente = new Cliente(-1, "", agenciaCred, contaCred);
		clienteTOCred = cliente.carregaCliente(clienteDAO);

		cliente = new Cliente(-1 ,"", clienteTODeb.getAgencia(), clienteTODeb.getConta());
		clienteTODeb = cliente.carregaCliente(clienteDAO);

		transferencia = new Transferencia(valorTransferencia, (Date) data.retornaDataHoje());

		saldo = new Saldo(clienteTOCred.getIdCliente());
		saldoTO = saldo.carregaSaldo(saldoDAO);
		clienteTOCred.setSaldo(saldoTO.getSaldo() + valorTransferencia);
		saldo.setSaldo(saldoTO.getSaldo() + valorTransferencia);
		saldo.atualizaSaldo(saldoDAO);

		saldo = new Saldo(clienteTODeb.getIdCliente());
		saldoTO = saldo.carregaSaldo(saldoDAO);
		clienteTODeb.setSaldo(saldoTO.getSaldo() - valorTransferencia);
		saldo.setSaldo(saldoTO.getSaldo() - valorTransferencia);
		saldo.atualizaSaldo(saldoDAO);

		transferencia.efetuarTransferencia(transferenciaDAO, clienteTOCred, clienteTODeb);

		transferencia.salvaMovBanc(clienteTOCred, extratoDAO, 1);
		transferencia.salvaMovBanc(clienteTODeb, extratoDAO, 2);

		session = request.getSession();
		session.setAttribute("transferencia", clienteTODeb);

		response.sendRedirect("EfetuarTransferencia.jsp");
	}

}
