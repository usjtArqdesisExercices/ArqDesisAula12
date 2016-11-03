package model;

import dao.ClienteDAO;
import to.ClienteTO;

public class Cliente {

	private int idCliente;
	private String password;
	private int agencia;
	private int conta;
	private double saldo;

	public Cliente(Integer idCliente, String password, int agencia, int conta) {
		super();
		this.idCliente = idCliente;
		this.password = password;
		this.agencia = agencia;
		this.conta = conta;
	}
	
	public Cliente() {
		super();
	}

	public int getIdCliente() {
		return idCliente;
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
	
	public double getSaldo() {
		return saldo;
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

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public ClienteTO carregaCliente(ClienteDAO clienteDAO){
		
		return clienteDAO.carregaCliente(clienteGetTO());
	}

	public ClienteTO clienteGetTO() {

		ClienteTO clienteTO = new ClienteTO();

		clienteTO.setIdCliente(idCliente);
		clienteTO.setAgencia(agencia);
		clienteTO.setConta(conta);
		clienteTO.setPassword(password);
		clienteTO.setSaldo(saldo);

		return clienteTO;

	}
}
