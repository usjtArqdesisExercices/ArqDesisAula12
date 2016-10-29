package command;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExtratoDAO;
import model.Data;
import model.Extrato;
import to.ExtratoTO;

public class ExtratoOutraData implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		extrato.setDataInicial(dataInicial);
		extrato.setDataFinal(dataFinal);
		
		Connection conn = (Connection) request.getAttribute("conexao");
		ExtratoDAO extratoDAO = new ExtratoDAO(conn);

		listaExtrato = extrato.consultaExtrato(id, extratoDAO);

		session.setAttribute("listaExtrato", listaExtrato);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EfetuarExtrato.jsp");
		dispatcher.forward(request, response);

	}

}