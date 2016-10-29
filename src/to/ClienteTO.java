package to;

public class ClienteTO {

	public static int idCliente = -1;
	private String password;
	private int agencia;
	private int conta;

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
	
	@Override
	public String toString() {
		return "ClienteTO > [ idCliente= " + idCliente + ", Agencia= " + agencia + ", Conta= " + conta + " Senha= " + password +" ]";
	}

}
