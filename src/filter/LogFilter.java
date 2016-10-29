package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import to.ClienteTO;

@WebFilter("/*")
public class LogFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		ClienteTO clienteTO = (ClienteTO) session.getAttribute("logado");

		if (clienteTO == null) {
			System.out.println(req.getParameter("command"));
		} else {
			System.out.println(clienteTO.getAgencia() + " -> " + req.getParameter("command"));
		}

		chain.doFilter(request, response);

		if (clienteTO == null) {
			System.out.println(req.getParameter("command"));
		} else {
			System.out.println(req.getParameter("command") + " -> " + clienteTO.getAgencia());
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
