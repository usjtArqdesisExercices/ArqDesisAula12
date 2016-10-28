package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Data;
import model.Extrato;
import to.ExtratoTO;

@WebServlet("/Extrato.do")
public class ExtratoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pAcao = request.getParameter("acao");
		String pId = "1"; // request.getParameter("idUser");
		String pDataInicial = request.getParameter("data[dataInicial]");
		String pDataFinal = request.getParameter("data[dataFinal]");
		Extrato extrato = new Extrato();
		ArrayList<ExtratoTO> listaExtrato = null;
		HttpSession session = request.getSession();
		Date dataInicial = null;
		Date dataFinal = null;
		int id = 1;

		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		try {
			dataInicial = Data.retornaTipoDate(pDataInicial);
			dataFinal = Data.retornaTipoDate(pDataFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (pAcao.equals("7Dias")) {

			extrato.extratoDias(7);
			listaExtrato = extrato.consultaExtrato(id);

			session.setAttribute("listaExtrato", listaExtrato);
		} else if (pAcao.equals("15Dias")) {
			extrato.extratoDias(15);
			listaExtrato = extrato.consultaExtrato(id);

			session.setAttribute("listaExtrato", listaExtrato);
		} else if (pAcao.equals("outraData")) {

			extrato.setDataInicial(dataInicial);
			extrato.setDataFinal(dataFinal);
			listaExtrato = extrato.consultaExtrato(id);

			session.setAttribute("listaExtrato", listaExtrato);
		} else if (pAcao.equals("reiniciar")) {

			session.setAttribute("listaExtrato", null);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("EfetuarExtrato.jsp");
		dispatcher.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}