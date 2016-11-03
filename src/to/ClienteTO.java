package to;

public class ClienteTO {

	private int idCliente = -1;
	private String password;
	private int agencia;
	private int conta;
	private double saldo;

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

	@Override
	public String toString() {
		return "ClienteTO > [ idCliente= " + idCliente + ", Agencia= " + agencia + ", Conta= " + conta + " Senha= "
				+ password + " ]";
	}

}
