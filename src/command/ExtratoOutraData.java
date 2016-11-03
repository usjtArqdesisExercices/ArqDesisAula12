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
import to.ClienteTO;
import to.ExtratoTO;

public class ExtratoOutraData implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session;
		Extrato extrato = new Extrato();
		ClienteTO clienteTO;
		ArrayList<ExtratoTO> listaExtrato = null;
		Connection conn;
		ExtratoDAO extratoDAO;
		
		session = request.getSession();
		clienteTO = (ClienteTO) session.getAttribute("logado");
		int id = clienteTO.getIdCliente();
		
		String pDataInicial = request.getParameter("data[dataInicial]");
		String pDataFinal = request.getParameter("data[dataFinal]");
		

		Date dataInicial = null;
		Date dataFinal = null;
		
		try {
			dataInicial = Data.retornaTipoDate(pDataInicial);
			dataFinal = Data.retornaTipoDate(pDataFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extrato.setDataInicial(dataInicial);
		extrato.setDataFinal(dataFinal);
		
		session = request.getSession();
		conn = (Connection) request.getAttribute("conexao");
		extratoDAO = new ExtratoDAO(conn);

		listaExtrato = extrato.consultaExtrato(id, extratoDAO);

		session = request.getSession();
		session.setAttribute("listaExtrato", listaExtrato);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EfetuarExtrato.jsp");
		dispatcher.forward(request, response);

	}

}