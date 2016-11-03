package command;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExtratoDAO;
import model.Extrato;
import to.ClienteTO;
import to.ExtratoTO;

public class Extrato7Dias implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session;
		Extrato extrato = new Extrato();
		ArrayList<ExtratoTO> listaExtrato = null;
		Connection conn;
		ExtratoDAO extratoDAO;

		session = request.getSession();
		ClienteTO clienteTO = (ClienteTO) session.getAttribute("logado");
		int id = clienteTO.getIdCliente();

		session = request.getSession();
		conn = (Connection) request.getAttribute("conexao");
		extratoDAO = new ExtratoDAO(conn);

		extrato.extratoDias(7);
		listaExtrato = extrato.consultaExtrato(id, extratoDAO);

		session.setAttribute("listaExtrato", listaExtrato);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EfetuarExtrato.jsp");
		dispatcher.forward(request, response);

	}

}