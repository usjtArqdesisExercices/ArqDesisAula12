package model;

import dao.SaldoDAO;
import to.SaldoTO;

public class Saldo {

	private int idCliente;
	private double saldo;

	public Saldo() {
		super();
	}

	public Saldo(int idCliente) {
		super();
		this.idCliente = idCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public SaldoTO carregaSaldo(SaldoDAO saldoDAO) {

		return saldoDAO.carregaSaldo(saldoGetTO());
	}

	public SaldoTO saldoGetTO() {

		SaldoTO saldoTO = new SaldoTO();

		saldoTO.setIdCliente(idCliente);
		saldoTO.setSaldo(saldo);

		return saldoTO;
	}

	public void atualizaSaldo(SaldoDAO saldoDAO) {

		saldoDAO.atualizaSaldo(saldoGetTO());
	}
}
