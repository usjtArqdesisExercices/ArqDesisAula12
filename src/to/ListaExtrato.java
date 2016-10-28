package to;

import java.util.ArrayList;

public class ListaExtrato {
	ArrayList<ExtratoTO> extrato;
	ArrayList<SaqueTO> saque;

	public ArrayList<ExtratoTO> getExtrato() {
		return extrato;
	}

	public void setExtrato(ArrayList<ExtratoTO> extrato) {
		this.extrato = extrato;
	}
	
	public ArrayList<SaqueTO> getSaldo() {
		return saque;
	}

	public void setSaldo(ArrayList<SaqueTO> saque) {
		this.saque = saque;
	}
	
}
