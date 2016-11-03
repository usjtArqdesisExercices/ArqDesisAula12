package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.SaldoTO;

public class SaldoDAO {

	private Connection conn;

	public SaldoDAO(Connection conn) {
		this.conn = conn;
	}

	public SaldoDAO() {

	}

	public SaldoTO carregaSaldo(SaldoTO saldoTO) {

		String sqlSelect = "SELECT S.CodCliente, S.Valor FROM SALDO S WHERE S.CodCliente = ?";

		try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			stm.setInt(1, saldoTO.getIdCliente());

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {

					saldoTO.setIdCliente(rs.getInt("CodCliente"));
					saldoTO.setSaldo(rs.getDouble("Valor"));

					stm.close();

					return saldoTO;
				} else {
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return null;
	}

	public void atualizaSaldo(SaldoTO saldoTO) {

		String sqlSelect = "UPDATE SALDO S set S.Valor = ? WHERE S.CodCliente = ?";

		try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			stm.setDouble(1, saldoTO.getSaldo());
			stm.setInt(2, saldoTO.getIdCliente());
			
			stm.execute();

		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

	}

}
