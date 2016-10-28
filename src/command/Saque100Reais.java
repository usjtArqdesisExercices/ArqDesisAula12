package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Saque;

public class Saque100Reais implements Command {

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

		Saque saque = new Saque();
		saque.carregaUtilmoSaque(id);
		saldoAtual = saque.getSaqueTO().getSaldoAtual();
		saque.getSaqueTO().setSaldoAtual(saldoAtual - 100);
		saque.efetuarSaque();

		HttpSession session = request.getSession();
		session.setAttribute("ultimoSaldo", saque.getSaqueTO());

		RequestDispatcher dispatcher = request.getRequestDispatcher("EfetuarSaque.jsp");
		dispatcher.forward(request, response);
	}

}
