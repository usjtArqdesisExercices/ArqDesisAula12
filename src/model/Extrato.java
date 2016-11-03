package model;

import java.util.ArrayList;
import java.util.Date;
import dao.ExtratoDAO;
import to.ExtratoTO;

public class Extrato {

	private Date dataInicial;
	private Date dataFinal;

	public Date getDataInicial() {
		return dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public void extratoDias(int numeroDias) {

		Data data = new Data();

		setDataInicial(data.retornaData(numeroDias));
		setDataFinal(data.retornaDataHoje());
	}

	public void salvaExtrato(ExtratoTO extratoTO, ExtratoDAO extratoDAO) {

		extratoDAO.salvaExtrato(extratoTO);

	}

	public ArrayList<ExtratoTO> consultaExtrato(int idCliente, ExtratoDAO extratoDAO) {

		ArrayList<ExtratoTO> listaExtrato;

		listaExtrato = extratoDAO.consultaExtrato(idCliente, (java.sql.Date) dataInicial, (java.sql.Date) dataFinal);

		return listaExtrato;
	}

}
