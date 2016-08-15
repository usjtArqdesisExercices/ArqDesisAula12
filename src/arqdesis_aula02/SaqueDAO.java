package arqdesis_aula02;


import java.sql.Connection;
import java.sql.PreparedStatement;
import arqdesis_aula02.ConnectionFactory;

public class SaqueDAO {

	public SaqueDAO() {
		

	}

	public void efetuarSaque(SaqueTO to) {

		String sqlInsert = "INSERT INTO Saque (CodCliente, ValorSaque, SaldoAtual, DataSaque) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm =conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getIdCliente());
			stm.setDouble(2, to.getValorSaque());
			stm.setDouble(3, to.getSaldoAtual());
			stm.setDate(4, to.getData());
			stm.execute();
			stm.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
