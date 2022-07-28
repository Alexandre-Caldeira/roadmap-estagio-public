package br.com.radixeng.apiclient.proceduraltests;

import br.com.radixeng.apiclient.modelo.ClientCache;
import br.com.radixeng.apiclient.modelo.HttpRequester;
import br.com.radixeng.apiclient.modelo.PIValue;
import br.com.radixeng.apiclient.modelo.SessaoUI;

public class TestaGetWebId {
	public static void main(String[] args) {
		
		SessaoUI ui = new SessaoUI(ClientCache.getInstance());
		HttpRequester requeridor = new HttpRequester();
		
		String[] tags = {"SINUSOID","SINUSOIDU","CDT158","CDEP158"};
		
		for (String tag: tags) {
			ui.getClientCache().setData(tag, new PIValue());
			ui.getClientCache().getValue(tag).setWebId(requeridor.getWebId(tag));
			ui.getClientCache().getValue(tag).setUnidade(requeridor.getUnidade(tag));
			
			System.out.println("\n"+"Tag: "+tag+" em "+ui.getClientCache().getValue(tag).getUnidade()
								   +", WebId: \n\n\t"+ ui.getClientCache().getValue(tag).getWebId());
		}
		
	}
}
