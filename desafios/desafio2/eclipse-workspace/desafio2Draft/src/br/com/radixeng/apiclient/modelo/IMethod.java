package br.com.radixeng.apiclient.modelo;

public interface IMethod {
	
	public default PIValue trata(PIValue cacheCliente) {
		cacheCliente.getReferencia().forEach(
				(chave, par) -> {
					// FAZ ALGO COM valor: par.getValue() ou data: par.getKey()
					if(par.getValue()<0) { 
						cacheCliente.remove(par.getValue());
					}
				}
			);

		return cacheCliente;
	};
}
