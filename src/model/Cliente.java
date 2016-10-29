package model;

import dao.ClienteDAO;
import to.ClienteTO;

public class Cliente {

	private String password;
	private int agencia;
	private int conta;

	public Cliente(String password, int agencia, int conta) {
		super();
		this.password = password;
		this.agencia = agencia;
		this.conta = conta;
	}

	public String getPassword() {
		return password;
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public boolean validar() {

		ClienteTO clienteTO = clienteGetTO();
		ClienteDAO clienteDAO = new ClienteDAO();

		return clienteDAO.validar(clienteTO);
	}

	public ClienteTO clienteGetTO() {

		ClienteTO clienteTO = new ClienteTO();

		clienteTO.setAgencia(agencia);
		clienteTO.setConta(conta);
		clienteTO.setPassword(password);

		return clienteTO;

	}
}
