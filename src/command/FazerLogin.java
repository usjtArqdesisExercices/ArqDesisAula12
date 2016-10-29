package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;

public class FazerLogin implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pPassword = request.getParameter("data[senha]");
		String pAgencia = request.getParameter("data[agencia]");
		String pConta = request.getParameter("data[conta]");
		int agencia = -1;
		int conta = -1;

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

		Cliente cliente = new Cliente(pPassword, agencia, conta);
		HttpSession session = request.getSession();
		if (cliente.validar()) {
			session.setAttribute("logado", cliente.clienteGetTO());
			System.out.println("Logou " + cliente.clienteGetTO());
		} else {
			System.out.println("Não Logou " + cliente.clienteGetTO());
			throw new ServletException("Agencia/Conta inválidos");
		}
		response.sendRedirect("AcessAccount.jsp");
	}

}
