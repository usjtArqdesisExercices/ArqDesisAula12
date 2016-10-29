package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import to.SaqueTO;

public class SaqueDAO {

	private Connection conn;

	public SaqueDAO(Connection conn) {
		this.conn = conn;
	}

	public SaqueDAO() {

	}

	public SaqueTO efetuarSaque(SaqueTO to) {

		String sqlInsert = "INSERT INTO Saque (CodCliente, ValorSaque, SaldoAtual, DataSaque) VALUES (?, ?, ?, ?)";

		try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getIdCliente());
			stm.setDouble(2, to.getValorSaque());
			stm.setDouble(3, to.getSaldoAtual());
			stm.setDate(4, to.getData());
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return to;
	}

	public SaqueTO carregaUtilmoSaque(int idCliente) {

		SaqueTO saqueTO = new SaqueTO();
		saqueTO.setIdCliente(idCliente);

		String sqlSelect = "SELECT * FROM Saque where idSaque = (select max(idSaque) from SAQUE where CodCliente = ?)";

		try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			stm.setInt(1, idCliente);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {

					saqueTO.setIdCliente(rs.getInt("CodCliente"));
					saqueTO.setSaldoAtual(rs.getDouble("SaldoAtual"));
					saqueTO.setValorSaque(rs.getDouble("ValorSaque"));
					saqueTO.setData(rs.getDate("DataSaque"));

				}
			}

		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}

		return saqueTO;
	}

}