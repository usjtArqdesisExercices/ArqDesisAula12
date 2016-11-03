package to;

import java.sql.Date;

public class TransferenciaTO {

	private double valorTransferencia;
	private Date data;

	public TransferenciaTO() {
		super();
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

}
