package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AcessAccountReiniciar implements Command {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("listaExtrato", null);

		RequestDispatcher dispatcher = request.getRequestDispatcher("AcessAccount.jsp");
		dispatcher.forward(request, response);
	}

}
