package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Cliente;
import to.ClienteTO;
import to.ExtratoTO;

public class JSonFacade {

	public static StringBuilder montaJSon(HttpServletRequest request) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		return sb;
	}

	public static String ExtratoToJSon(ArrayList<ExtratoTO> lista) {
		JSONArray vetor = new JSONArray();
		for (ExtratoTO extratoTO : lista) {
			JSONObject object = new JSONObject();
			try {
				object.put("idCliente", extratoTO.getIdCliente());
				object.put("valorMovimentacao", extratoTO.getValorMovimentacao());
				object.put("saldoAtual", extratoTO.getSaldoAtual());
				object.put("idTipoMovimentacao", extratoTO.getIdTipoMovimentacao());
				object.put("tipoCredDeb", extratoTO.getTipoCredDeb());
				object.put("data", extratoTO.getData());
				vetor.put(object);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return vetor.toString();
	}

	public static Cliente jSonToCliente(String json) throws IOException {
		try {
			JSONObject registro = new JSONObject(json);
			int agencia = registro.getInt("agencia");
			int conta = registro.getInt("conta");
			String password = registro.getString("senha");
			return new Cliente(-1 ,password, agencia, conta);
		} catch (JSONException jsone) {
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}

	public static Cliente jSonToTransferencia(String json) throws IOException {
		try {
			JSONObject registro = new JSONObject(json);
			int idClienteDeb = registro.getInt("data[idCliente]");
			int agencia = registro.getInt("data[agencia]");
			int conta = registro.getInt("data[conta]");
			double valorTransferencia = registro.getInt("data[valorTransf]");
			return new Cliente(idClienteDeb, "", agencia, conta);
		} catch (JSONException jsone) {
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}

	public static String clienteToJSon(ClienteTO clienteTO) throws IOException {
		JSONObject object = new JSONObject();
		try {
			object.put("idCliete", clienteTO.getIdCliente());
			object.put("agencia", clienteTO.getAgencia());
			object.put("conta", clienteTO.getConta());
			object.put("senha", clienteTO.getPassword());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}

	public static String errorToJSon(Exception e) {
		JSONObject object = new JSONObject();
		try {
			object.put("error", e.toString());
		} catch (JSONException e1) {
			e.printStackTrace();
		}
		return object.toString();
	}
}
