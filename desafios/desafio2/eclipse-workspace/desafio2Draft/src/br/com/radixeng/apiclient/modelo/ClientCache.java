package br.com.radixeng.apiclient.modelo;

import java.util.HashMap;
import java.util.Map;

// Singleton de dados local
// Referencia https://refactoring.guru/pt-br/design-patterns/singleton/java/example
public final class ClientCache {

	private static ClientCache instancia;
	private Map<String, PIValue> cacheCliente;
	
	// Construtor privado proibe criacao "desregrada" de instancias
	private ClientCache() {
		this.cacheCliente = new HashMap<>();
		System.out.println("Cache local construido.\n");
	}
	
	// Controla criacao de instancias, chama construtor: 
	public static ClientCache getInstance() {
		if (instancia == null) {
			instancia = new ClientCache();
		}
		return instancia;
	}

	public PIValue getPIValue(String tag) {
		return cacheCliente.get(tag);
	}

	public void setTag(String tag ,PIValue pivalues) {
		this.cacheCliente.put(tag, pivalues);
	}
	
}
