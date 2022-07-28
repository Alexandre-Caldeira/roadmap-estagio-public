package br.com.radixeng.apiclient.app;

import br.com.radixeng.apiclient.modelo.ClientCache;
import br.com.radixeng.apiclient.modelo.HttpRequester;
import br.com.radixeng.apiclient.modelo.IMethod;
import br.com.radixeng.apiclient.modelo.PIValue;
import br.com.radixeng.apiclient.modelo.SessaoUI;

public class ApiClient {
	public static void main(String[] args) {
			SessaoUI ui = new SessaoUI(ClientCache.getInstance());
			
			HttpRequester requeridor = new HttpRequester();
//			ui.iniciarClient(requeridor);
//			ui.iniciarClient(requeridor, new RemoveInvalidos());
//			ui.iniciarClient(requeridor, new RemoveMaiorQue100());
//			ui.iniciarClient(requeridor, new RemoveHoraPar());
			ui.iniciarClient(requeridor, new TrocaInvalidosPorAnterior());
		  
	}
	
	public static class RemoveInvalidos implements IMethod{
		
		@Override
		public PIValue trata(PIValue cacheCliente) {
			return IMethod.super.trata(cacheCliente);
		}
	}
	
	public static class RemoveMaiorQue100 implements IMethod {
	
		@Override
		public PIValue trata(PIValue cacheCliente) {
			
			cacheCliente.getReferencia().forEach(
				(chave, par) -> {
					if(par.getValue() > 100) {
						cacheCliente.remove(par.getValue());
					}
				}
			);
	
			return cacheCliente;
		}
	} 
	
	public static class RemoveHoraPar implements IMethod {
		
		@Override
		public PIValue trata(PIValue cacheCliente) {
			
			cacheCliente.getReferencia().forEach(
				(chave, par) -> {
					if(par.getKey().getDayOfMonth() % 2 == 0) {
						cacheCliente.remove(par.getKey());
					}
				}
			);
	
			return cacheCliente;
		}
	}
	
	public static class TrocaInvalidosPorAnterior implements IMethod {
		
		@Override
		public PIValue trata(PIValue cacheCliente) {

			cacheCliente.getReferencia().forEach(
				(chave, par ) -> {
					if(par.getValue() < 0) {
						cacheCliente.getReferencia().keySet().forEach(
							t -> {
								// se estamos olhando para o valor atual invalido:
								if (cacheCliente.getReferencia().get(t).getValue() == par.getValue()) {
									if (t>0 ) {
										
										// se o valor anterior nao era invalido, use ele
										if(cacheCliente.getReferencia().get(t-1).getValue() > 0) {
											cacheCliente.getReferencia().replace(t, cacheCliente.getReferencia().get(t-1));
										}else {
											// se nao, use o proximo
											cacheCliente.getReferencia().replace(t, cacheCliente.getReferencia().get(t+1));
										}
										
										if (t == cacheCliente.getReferencia().keySet().size()) {
											// se for o ultimo valor, use o penultimo
											cacheCliente.getReferencia().replace(t, cacheCliente.getReferencia().get(t-1));
										}
									}else {
										// se for o primeiro valor, use o proximo valor
										cacheCliente.getReferencia().replace(t, cacheCliente.getReferencia().get(t+1));
									}
								}
							}
						);

						cacheCliente.resetUsandoReferencia();
						
					}
				}
			);
	
			return cacheCliente;
		}
	}
}


//sinusoid,sinusoidu,cdt158,cdep158
//sinusoid,cdt158,cdep158
//sinusoid,cdt158
//03/03/2022 12:00:00
//04/03/2022 15:00:00
//03/01/2019 12:00:00
//
//cdt158
//03/01/2022 12:00:00
//13/01/2022 12:00:00
//04/01/2022 12:00:00
//04/02/2022 12:00:00