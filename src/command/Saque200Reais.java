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

public class Saque200Reais implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session;
		ClienteTO clienteTO;
		Connection conn;
		SaqueDAO saqueDAO;
		ExtratoDAO extratoDAO;
		double saldoAtual = -1.00;

		session = request.getSession();
		clienteTO = (ClienteTO) session.getAttribute("logado");
		int id = clienteTO.getIdCliente();

		conn = (Connection) request.getAttribute("conexao");
		saqueDAO = new SaqueDAO(conn);
		
		Saque saque = new Saque();
		saque.carregaUtilmoSaque(id, saqueDAO);
		
		saldoAtual = saque.getSaqueTO().getSaldoAtual();
		
		saque.setValorSaque(200);
		saque.setSaldoAtual(saldoAtual - saque.getValorSaque());
		saque.efetuarSaque(saqueDAO);
		
		extratoDAO = new ExtratoDAO(conn);
		saque.salvaMovBanc(extratoDAO);
		
		session = request.getSession();
		session.setAttribute("ultimoSaldo", saque.getSaqueTO());

		RequestDispatcher dispatcher = request.getRequestDispatcher("EfetuarSaque.jsp");
		dispatcher.forward(request, response);
	}

}
