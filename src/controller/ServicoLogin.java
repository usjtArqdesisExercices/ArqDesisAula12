package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;
import util.JSonFacade;

@WebServlet("/Login")
public class ServicoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * configurar a request e a response para todos os metodos
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
	 * Faz Login CLientes
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pPassword = request.getParameter("senha");
		String pAgencia = request.getParameter("agencia");
		String pConta = request.getParameter("conta");
		int agencia = -1;
		int conta = -1;

		PrintWriter out = response.getWriter();

		Connection conn = (Connection) request.getAttribute("conexao");
		ClienteDAO clienteDAO = new ClienteDAO(conn);	

		try {
			if (pAgencia != null && !pAgencia.equals("")) {
				agencia = Integer.parseInt(pAgencia);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		try {
			if (pConta != null && !pConta.equals("")) {
				conta = Integer.parseInt(pConta);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		Cliente cliente = new Cliente(-1, pPassword, agencia, conta);
		
		if (clienteDAO.validar(cliente.clienteGetTO())) {
		
			System.out.println("Logou " + cliente.clienteGetTO());
		} else {
			System.out.println("Não Logou " + cliente.clienteGetTO());
			throw new ServletException("Agencia/Conta inválidos");
		}

		try {
			if (clienteDAO.validar(cliente.clienteGetTO())) {
				out.println(JSonFacade.clienteToJSon(cliente.clienteGetTO()));		
				System.out.println("Logou " + cliente.clienteGetTO());
			} else {
				System.out.println("Não Logou " + cliente.clienteGetTO());
				throw new ServletException("Agencia/Conta inválidos");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}

	}

}
