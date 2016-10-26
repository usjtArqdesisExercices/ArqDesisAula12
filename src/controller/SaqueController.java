package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Saque;

/**
 * Servlet implementation class SaqueController
 */
@WebServlet("/Saque.do")
public class SaqueController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double saldoAtual;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pAcao = request.getParameter("acao");
		String pValor = request.getParameter("data[valor]");
		String pId = "1";
		saldoAtual = -1.00;
		int id = 2;
		double valorSaque = 0.00;

		try {
			if (!pId.equals("")) {
				id = Integer.parseInt(pId);
			} else if (!pValor.equals("")) {
				valorSaque = Double.parseDouble(pValor);
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
		try {
			if (!pValor.equals("")) {
				valorSaque = Double.parseDouble(pValor);
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}

		Saque saque = new Saque();

		saque.setIdCliente(id);
		saque.carregaUtilmoSaque();
		saldoAtual = saque.getSaldoAtual();

		RequestDispatcher view = null;

		if (pAcao.equals("10Reais")) {

			saque = new Saque(id, 10, (saldoAtual - 10));
			saque.efetuarSaque();

			request.setAttribute("mostrarSaldo", saque.carregaUtilmoSaque());
			view = request.getRequestDispatcher("EfetuarSaque.jsp");
		} else if (pAcao.equals("20Reais")) {

			saque = new Saque(id, 20, (saldoAtual - 20));
			saque.efetuarSaque();

			request.setAttribute("mostrarSaldo", saque.carregaUtilmoSaque());
			view = request.getRequestDispatcher("EfetuarSaque.jsp");
		} else if (pAcao.equals("50Reais")) {

			saque = new Saque(id, 50, (saldoAtual - 50));
			saque.efetuarSaque();

			request.setAttribute("mostrarSaldo", saque.carregaUtilmoSaque());
			view = request.getRequestDispatcher("EfetuarSaque.jsp");
		} else if (pAcao.equals("100Reais")) {

			saque = new Saque(id, 100, (saldoAtual - 100));
			saque.efetuarSaque();

			request.setAttribute("mostrarSaldo", saque.carregaUtilmoSaque());
			view = request.getRequestDispatcher("EfetuarSaque.jsp");
		} else if (pAcao.equals("200Reais")) {

			saque = new Saque(id, 200, (saldoAtual - 200));
			saque.efetuarSaque();

			request.setAttribute("mostrarSaldo", saque.carregaUtilmoSaque());
			view = request.getRequestDispatcher("EfetuarSaque.jsp");
		} else if (pAcao.equals("500Reais")) {

			saque = new Saque(id, 500, (saldoAtual - 500));
			saque.efetuarSaque();

			request.setAttribute("mostrarSaldo", saque.carregaUtilmoSaque());
			view = request.getRequestDispatcher("EfetuarSaque.jsp");
		} else if (pAcao.equals("outroValor")) {

			saque = new Saque(id, valorSaque, (saldoAtual - valorSaque));
			saque.efetuarSaque();

			request.setAttribute("mostrarSaldo", saque.carregaUtilmoSaque());
			view = request.getRequestDispatcher("EfetuarSaque.jsp");
		}

		view.forward(request, response);
	}

}
