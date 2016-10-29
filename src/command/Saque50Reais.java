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

public class Saque50Reais implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pId = "1"; // request.getParameter("idCliente");
		double saldoAtual = -1.00;
		int id = -1;

		try {
			if (pId != null && !pId.equals("")) {
				id = Integer.parseInt(pId);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		Connection conn = (Connection) request.getAttribute("conexao");
		SaqueDAO saqueDAO = new SaqueDAO(conn);
		
		Saque saque = new Saque();
		saque.carregaUtilmoSaque(id, saqueDAO);
		
		saldoAtual = saque.getSaqueTO().getSaldoAtual();
		
		saque.setSaldoAtual(saldoAtual - 50);
		saque.efetuarSaque(saqueDAO);
		
		ExtratoDAO extratoDAO = new ExtratoDAO(conn);
		saque.salvaMovBanc(extratoDAO);

		HttpSession session = request.getSession();
		session.setAttribute("ultimoSaldo", saque.getSaqueTO());

		RequestDispatcher dispatcher = request.getRequestDispatcher("EfetuarSaque.jsp");
		dispatcher.forward(request, response);
	}

}
