package command;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExtratoDAO;
import dao.SaqueDAO;
import model.Saque;
import to.ClienteTO;

public class SaqueOutroValor implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session;
		ClienteTO clienteTO;
		Connection conn;
		SaqueDAO saqueDAO;
		ExtratoDAO extratoDAO;
		double saldoAtual = -1.00;
		String pValor = request.getParameter("data[valor]");

		session = request.getSession();
		clienteTO = (ClienteTO) session.getAttribute("logado");
		int id = clienteTO.getIdCliente();
		double valorSaque = -1.00;

		try {
			if (pValor != null && !pValor.equals("")) {
				valorSaque = Double.parseDouble(pValor);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		conn = (Connection) request.getAttribute("conexao");
		saqueDAO = new SaqueDAO(conn);

		Saque saque = new Saque();
		saque.carregaUtilmoSaque(id, saqueDAO);

		saldoAtual = saque.getSaqueTO().getSaldoAtual();

		saque.setSaldoAtual(saldoAtual - valorSaque);
		saque.efetuarSaque(saqueDAO);

		extratoDAO = new ExtratoDAO(conn);
		saque.salvaMovBanc(extratoDAO);

		session = request.getSession();
		session.setAttribute("ultimoSaldo", saque.getSaqueTO());

		RequestDispatcher dispatcher = request.getRequestDispatcher("EfetuarSaque.jsp");
		dispatcher.forward(request, response);
	}

}
