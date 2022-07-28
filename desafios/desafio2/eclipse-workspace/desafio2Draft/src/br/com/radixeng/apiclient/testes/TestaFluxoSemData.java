package br.com.radixeng.apiclient.testes;

import java.util.Scanner;

import br.com.radixeng.apiclient.modelo.HttpRequester;
import br.com.radixeng.apiclient.modelo.PIValue;
import br.com.radixeng.apiclient.modelo.SessaoUI;

//TODO: Abstrair amanha
public class TestaFluxoSemData {
	public static void main(String[] args) {
		SessaoUI ui = new SessaoUI();
		HttpRequester requeridor = new HttpRequester();
		
		System.out.println(">> Informe um ou mais tags separados por virgula:");
		try (Scanner scanner = new Scanner(System.in)) {
			String[] respostaUI = scanner.hasNext() ? scanner.next().toUpperCase().split(",") : new String[0];
			
			if (respostaUI.length>0) {
				for (String tag: respostaUI) {
					ui.getClientCache().setTag(tag, new PIValue());
					ui.getClientCache().getPIValue(tag).setWebId(requeridor.getWebId(tag));
					
					requeridor.popularCache(tag, ui.getClientCache());
					System.out.println("\nWebId: \n\n\t"+ ui.getClientCache().getPIValue(tag).getWebId());
				}
				
				// mostrar 10 primeiros dados
				for (String tag: respostaUI) {
					System.out.println("\nPrimeiros 10 dados da tag: "+tag);
					for (int i=0; i<10; i++ ) {
						System.out.println(ui.getClientCache().getPIValue(tag.toUpperCase()).getTimestamps().get(i).toString()+ 
											" => "+ui.getClientCache().getPIValue(tag.toUpperCase()).getValores().get(i).toString());
					}
				}
				
			}else {
				//TODO: contaTentativas, pede de novo
			}
		}
		
//		cdep158,sinusoid,cdt158,sinusoidu
//		cdep158,sinusoid
//		sinusoid,sinusoidu	
//		System.out.println(">> Informe a data de inicio:\n");
//		ui.getClientCache()
//		System.out.println(">> Informe a data de fim:\n");
//		HttpRequester.buscarDados(null, null);

	}
}
