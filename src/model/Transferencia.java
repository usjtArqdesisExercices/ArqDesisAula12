package model;

import java.sql.Date;

import dao.ExtratoDAO;
import dao.TransferenciaDAO;
import to.ClienteTO;
import to.ExtratoTO;
import to.TransferenciaTO;

public class Transferencia {

	private double valorTransferencia;
	private Date data;

	public Transferencia() {
		super();
	}

	public Transferencia(double valorTransferencia, Date data) {
		super();
		this.valorTransferencia = valorTransferencia;
		this.data = data;
	}

	public double getValorTransferencia() {
		return valorTransferencia;
	}

	public Date getData() {
		return data;
	}

	public void setValorTransferencia(double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public void efetuarTransferencia(TransferenciaDAO transferenciaDAO, ClienteTO clienteTOCred, ClienteTO clienteTODeb){
		
		transferenciaDAO.efetuarTransferencia(getTransferenciaTO(), clienteTOCred, clienteTODeb);
	}
	
	public void salvaMovBanc(ClienteTO clienteTO, ExtratoDAO extratoDAO, int tipoCredDeb ) {

		Extrato extrato = new Extrato();
		ExtratoTO extratoTO = new ExtratoTO();
		
		extratoTO.setIdCliente(clienteTO.getIdCliente());
		extratoTO.setSaldoAtual(clienteTO.getSaldo());
		extratoTO.setValorMovimentacao(valorTransferencia);
		extratoTO.setIdTipoMovimentacao(1);
		extratoTO.setTipoCredDeb(tipoCredDeb);
		extratoTO.setData((java.sql.Date) data);

		extrato.salvaExtrato(extratoTO, extratoDAO);
	}
	
	public TransferenciaTO getTransferenciaTO(){
		
		TransferenciaTO transferenciaTO = new TransferenciaTO();
		
		transferenciaTO.setValorTransferencia(valorTransferencia);
		transferenciaTO.setData(data);
		
		return transferenciaTO;
	}

	/*
	 * public void salvaMovBanc(ExtratoDAO extratoDAO) {
	 * 
	 * Extrato extrato = new Extrato(); ExtratoTO extratoTOCred = new
	 * ExtratoTO(); ExtratoTO extratoTODeb = new ExtratoTO();
	 * 
	 * extratoTODeb.setIdCliente(idCliente);
	 * extratoTODeb.setSaldoAtual(saldoAtual);
	 * extratoTODeb.setValorMovimentacao(valorSaque);
	 * extratoTODeb.setIdTipoMovimentacao(2); extratoTODeb.setTipoCredDeb(2);
	 * extratoTODeb.setData((java.sql.Date) data);
	 * 
	 * extrato.salvaExtrato(extratoTODeb, extratoDAO); }
	 */

}
