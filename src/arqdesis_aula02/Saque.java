package arqdesis_aula02;

import java.util.Date;

public class Saque {

	public int		idCliente;
	public double	valorSaque;
	public double	saldoAtual;
	public Date		data;
	
	public Saque(int idCliente, double valorSaque, double saldoAtual) {
		super();
		this.idCliente = idCliente;
		this.valorSaque = valorSaque;
		this.saldoAtual = saldoAtual;
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
	
	public void efetuarSaque(){
		
		SaqueDAO saqueDAO = new SaqueDAO();
		SaqueTO saqueTO = new SaqueTO();
				
		saqueTO.setIdCliente(idCliente);
		saqueTO.setSaldoAtual(saldoAtual);
		saqueTO.setValorSaque(valorSaque);
		saqueTO.setData((java.sql.Date) data);
		saqueDAO.efetuarSaque(saqueTO);
	}
	
	public void createDate(){
		
		Date minhaData = new Date();  
		long mili =  minhaData.getTime();  
		java.sql.Date dataSQL = new java.sql.Date(mili); 
		
		setData(dataSQL);
		
	}
	

}
