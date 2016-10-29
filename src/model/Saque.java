package model;

import java.sql.Date;
import model.Extrato;
import dao.ExtratoDAO;
import dao.SaqueDAO;
import to.ExtratoTO;
import to.SaqueTO;

public class Saque {

	public int idCliente;
	public double valorSaque;
	public double saldoAtual;
	public Date data;

	public Saque() {

	}

	public double getValorSaque() {
		return valorSaque;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}

	public Date getData() {
		return data;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public void setData(Date data) {

		this.data = data;
	}

	public void setValorSaque(double valorSaque) {
		this.valorSaque = valorSaque;
	}

	public void efetuarSaque(SaqueDAO saqueDAO) {

		Data date = new Data();
		data = (Date) date.retornaDataHoje();

		saqueDAO.efetuarSaque(getSaqueTO());
	}

	public void salvaMovBanc(ExtratoDAO extratoDAO) {

		Extrato extrato = new Extrato();
		ExtratoTO extratoTO = new ExtratoTO();
		
		extratoTO.setIdCliente(idCliente);
		extratoTO.setSaldoAtual(saldoAtual);
		extratoTO.setValorMovimentacao(valorSaque);
		extratoTO.setIdTipoMovimentacao(2);
		extratoTO.setTipoCredDeb(2);
		extratoTO.setData((java.sql.Date) data);

		extrato.salvaExtrato(extratoTO, extratoDAO);
	}

	public void carregaUtilmoSaque(int id, SaqueDAO saqueDAO) {

		SaqueTO saqueTO = saqueDAO.carregaUtilmoSaque(id);

		idCliente = saqueTO.getIdCliente();
		valorSaque = saqueTO.getValorSaque();
		saldoAtual = saqueTO.getSaldoAtual();
		data = saqueTO.getData();

	}

	public SaqueTO getSaqueTO() {
		SaqueTO saqueTO = new SaqueTO();
		saqueTO.setIdCliente(idCliente);
		saqueTO.setValorSaque(valorSaque);
		saqueTO.setSaldoAtual(saldoAtual);
		saqueTO.setData(data);

		return saqueTO;
	}

	/*
	 * @Override public boolean equals(Object obj) { if (this == obj) return
	 * true; if (obj == null) return false; if (getClass() != obj.getClass())
	 * return false; Saque other = (Saque) obj; if (idCliente !=
	 * other.idCliente) return false; if (saldoAtual != other.saldoAtual) return
	 * false; if (valorSaque != other.valorSaque) return false; if (data ==
	 * null) { if (other.data != null) return false; } else if
	 * (!data.equals(other.data)) return false; return true; }
	 */

}