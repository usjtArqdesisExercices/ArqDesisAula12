package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import to.ClienteTO;

public class ClienteDAO {

	private Connection conn;

	public ClienteDAO(Connection conn) {
		this.conn = conn;
	}
	
	public ClienteDAO() {
		
	}

	public boolean validar(ClienteTO clienteTO) {
		
		String sqlSelect = "SELECT C.idCliente, C.Agencia, C.Conta FROM CLIENTE C WHERE C.Senha = ? and C.Agencia = ? and C.Conta = ?";
		
		try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			stm.setString(1, clienteTO.getPassword());
			stm.setInt(2, clienteTO.getAgencia());
			stm.setInt(3, clienteTO.getConta());

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {

					ClienteTO.idCliente = rs.getInt("idCliente");

					stm.close();

					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return false;
	}

}
