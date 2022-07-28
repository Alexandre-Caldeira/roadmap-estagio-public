package br.com.radixeng.apiclient.modelo;

import java.util.HashMap;
import java.util.Map;

public final class ClientCache {
	
	private static ClientCache instancia;
	private Map<String, IValue> cacheCliente;
	//TODO: implementar persistencia
	//TODO: implementar hit/miss: contar e otimizar
	//TODO: implementar verificacao de valores/autenticacao expirada 
	
	private ClientCache() {
		this.cacheCliente = new HashMap<>();
		System.out.println("Cache local de runtime construido.");
	}
	
	public static ClientCache getInstance() {
		if (instancia == null) {
			instancia = new ClientCache();
		}
		return instancia;
	}

	public IValue getData(String chave) {
		return cacheCliente.get(chave); 
	}

	public void setData(String chave ,IValue valores) {
		this.cacheCliente.put(chave, valores);
	}
	
	public int getTamanho() {
		return cacheCliente.size();
	}

}
