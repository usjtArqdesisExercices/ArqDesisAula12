package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import to.ExtratoTO;

public class ExtratoDAO {

	private Connection conn;

	public ExtratoDAO(Connection conn) {
		this.conn = conn;
	}

	public ExtratoDAO() {

	}

	public void salvaExtrato(ExtratoTO to) {

		String sqlInsert = "INSERT INTO MOVIMENTACAO_BANCARIA (CodCliente, IdTipoMovimentacao, TipoCredDeb, ValorMovimentacao, SaldoAtual, DataMovimentacao) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			stm.setInt(1, to.getIdCliente());
			stm.setInt(2, to.getIdTipoMovimentacao()); // 1 - Transferencia / 2
														// -
														// Saque / 3 - Debito
														// Auto
			stm.setInt(3, to.getTipoCredDeb()); // 1 - Credito / 2 - Debito
			stm.setDouble(4, to.getValorMovimentacao());
			stm.setDouble(5, to.getSaldoAtual());
			stm.setDate(6, to.getData());
			stm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<ExtratoTO> consultaExtrato(int idCliente, Date dataInicial, Date dataFinal) {

		ExtratoTO extratoTO;
		ArrayList<ExtratoTO> listaExtrato = new ArrayList<>();

		String sqlSelect = "SELECT * FROM MOVIMENTACAO_BANCARIA WHERE CodCliente = ? and DataMovimentacao >= ? and DataMovimentacao <= ?";

		try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idCliente);
			stm.setDate(2, dataInicial);
			stm.setDate(3, dataFinal);

			try (ResultSet rs = stm.executeQuery();) {

				while (rs.next()) {

					extratoTO = new ExtratoTO();
					extratoTO.setIdCliente(rs.getInt("CodCliente"));
					extratoTO.setIdTipoMovimentacao(rs.getInt("IdTipoMovimentacao"));
					extratoTO.setTipoCredDeb(rs.getInt("TipoCredDeb"));
					extratoTO.setValorMovimentacao(rs.getDouble("ValorMovimentacao"));
					extratoTO.setSaldoAtual(rs.getDouble("SaldoAtual"));
					extratoTO.setData(rs.getDate("DataMovimentacao"));
					listaExtrato.add(extratoTO);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaExtrato;
	}

}