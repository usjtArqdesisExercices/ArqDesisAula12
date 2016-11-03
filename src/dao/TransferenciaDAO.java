package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import to.ClienteTO;
import to.TransferenciaTO;

public class TransferenciaDAO {

	private Connection conn;

	public TransferenciaDAO(Connection conn) {
		this.conn = conn;
	}

	public TransferenciaDAO() {

	}

	public TransferenciaTO efetuarTransferencia(TransferenciaTO transferenciaTO, ClienteTO clienteTOCred,
			ClienteTO clienteTODeb) {

		String sqlInsert = "INSERT INTO Transferencia (CodClienteCred, CodClienteDeb, ValorTransferencia, SaldoCliCred, SaldoCliDeb, DataTransferencia) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, clienteTOCred.getIdCliente());
			stm.setInt(2, clienteTODeb.getIdCliente());
			stm.setDouble(3, transferenciaTO.getValorTransferencia());
			stm.setDouble(4, clienteTOCred.getSaldo());
			stm.setDouble(5, clienteTODeb.getSaldo());
			stm.setDate(6, transferenciaTO.getData());
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return transferenciaTO;
	}

}