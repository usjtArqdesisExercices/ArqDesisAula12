package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExtratoDAO;
import model.Data;
import model.Extrato;
import to.ExtratoTO;
import util.JSonFacade;

@WebServlet("/Extrato")
public class ServicoExtrato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * configurar a request e a response para todos os métodos
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		super.service(request, response);
	}

	/*
	 * Lista Extrato
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pChave = request.getParameter("chave");
		String pDataInicial = request.getParameter("dataInicial");
		String pDataFinal = request.getParameter("dataFinal");
		Date dataInicial = null;
		Date dataFinal = null;
		int id = 1;
		Extrato extrato = new Extrato();
		ArrayList<ExtratoTO> listaExtrato = null;

		PrintWriter out = response.getWriter();

		Connection conn = (Connection) request.getAttribute("conexao");
		ExtratoDAO extratoDAO = new ExtratoDAO(conn);

		try {
			dataInicial = Data.retornaTipoDate(pDataInicial);
			dataFinal = Data.retornaTipoDate(pDataFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			if (pChave != null && pChave.length() > 0 && pChave.equals("7")) {

				extrato.extratoDias(7);
				listaExtrato = extrato.consultaExtrato(id, extratoDAO);

			} else if (pChave != null && pChave.length() > 0 && pChave.equals("15")) {

				extrato.extratoDias(15);
				listaExtrato = extrato.consultaExtrato(id, extratoDAO);
			} else if (pDataInicial != null && pDataFinal != null & pDataInicial.length() > 0
					&& pDataFinal.length() > 0) {

				extrato.setDataInicial(dataInicial);
				extrato.setDataFinal(dataFinal);
				listaExtrato = extrato.consultaExtrato(id, extratoDAO);
			}

			out.println(JSonFacade.ExtratoToJSon(listaExtrato));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}

	}

}
