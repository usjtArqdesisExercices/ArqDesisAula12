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

public class Saque10Reais implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session;
		Connection conn;
		SaqueDAO saqueDAO;
		Saque saque;
		ExtratoDAO extratoDAO;
		ClienteTO clienteTO;
		double saldoAtual = -1.00;
		
		session = request.getSession();
		clienteTO = (ClienteTO) session.getAttribute("logado");
		int id = clienteTO.getIdCliente();

		session = request.getSession();
		conn = (Connection) request.getAttribute("conexao");
		saqueDAO = new SaqueDAO(conn);
		
		saque = new Saque();
		saque.carregaUtilmoSaque(id, saqueDAO);
		
		saldoAtual = saque.getSaqueTO().getSaldoAtual();
		
		saque.setValorSaque(10);
		saque.setSaldoAtual(saldoAtual - 10);
		saque.efetuarSaque(saqueDAO);

		extratoDAO = new ExtratoDAO(conn);
		saque.salvaMovBanc(extratoDAO);
		
		session = request.getSession();
		session.setAttribute("ultimoSaldo", saque.getSaqueTO());

		RequestDispatcher dispatcher = request.getRequestDispatcher("EfetuarSaque.jsp");
		dispatcher.forward(request, response);
	}

}
