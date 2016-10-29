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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import to.ClienteTO;

@WebFilter("/*")
public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		ClienteTO logado = (ClienteTO) session.getAttribute("logado");
		String path = req.getContextPath();
		String uri = req.getRequestURI();
		String comando = req.getParameter("command");
		
		//System.out.println("Req.: " + req + "\nSession:" + session + "\nLogado = " + logado + "\nPath: " + path + "\nUri: " + uri + "\nComando: " + comando);
		 
		if (comando == null) {
			comando = "";
		}
		
		if (logado == null && !uri.equals(path + "/Index.jsp") && !comando.equals("FazerLogin")) {

			((HttpServletResponse) response).sendRedirect(path + "/Index.jsp");
		} else {

			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
