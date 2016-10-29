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

		ArrayList<ExtratoTO>  listaExtrato;

		listaExtrato = extratoDAO.consultaExtrato(idCliente, (java.sql.Date) dataInicial, (java.sql.Date) dataFinal);
		
		return listaExtrato;
	}

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Extrato other = (Extrato) obj;
		if (idCliente != other.idCliente)
			return false;
		if (saldoAtual != other.saldoAtual)
			return false;
		if (valorMovimentacao != other.valorMovimentacao)
			return false;
		if (IdTipoMovimentacao != other.IdTipoMovimentacao)
			return false;
		if (tipoCredDeb != other.tipoCredDeb)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (dataInicial == null) {
			if (other.dataInicial != null)
				return false;
		} else if (!dataInicial.equals(other.dataInicial))
			return false;
		if (dataFinal == null) {
			if (other.dataFinal != null)
				return false;
		} else if (!dataFinal.equals(other.dataFinal))
			return false;
		return true;
	}*/

}
