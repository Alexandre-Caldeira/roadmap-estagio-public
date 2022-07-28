package br.com.radixeng.apiclient.tests;

import br.com.radixeng.apiclient.modelo.ClientCache;
import br.com.radixeng.apiclient.modelo.HttpRequester;
import br.com.radixeng.apiclient.modelo.IMethod;
import br.com.radixeng.apiclient.modelo.PIValue;
import br.com.radixeng.apiclient.modelo.SessaoUI;

//sinusoid,sinusoidu,cdt158,cdep158
//sinusoid,cdt158,cdep158
//sinusoid,cdt158
//03/03/2022 12:00:00
//04/03/2022 15:00:00
//
//cdt158
//03/01/2022 12:00:00
//13/01/2022 12:00:00
//04/01/2022 12:00:00
//04/02/2022 12:00:00

public class TestaFluxoUI {
	public static void main(String[] args) {
		SessaoUI ui = new SessaoUI(ClientCache.getInstance());
		
		HttpRequester requeridor = new HttpRequester();
		
		ui.iniciarClient(requeridor,new RemoveInvalidos());
//		ui.iniciarClient(requeridor);
	  
	}

	public static class RemoveInvalidos implements IMethod{
		@Override
		public PIValue trata(PIValue cacheCliente) {
			return IMethod.super.trata(cacheCliente);
		}
	}
}
