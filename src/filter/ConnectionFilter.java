package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import factory.ConnectionFactory;

@WebFilter("/*")
public class ConnectionFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			new ConnectionFactory();
			Connection connection = ConnectionFactory.obtemConexao();

			request.setAttribute("conexao", connection);
			
			System.out.println("ABRIU CONEXAO");

			chain.doFilter(request, response);

			System.out.println("FECHOU CONEXAO");
			connection.close();

		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
