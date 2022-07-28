package br.com.radixeng.apiclient.testes;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import br.com.radixeng.apiclient.modelo.ClientCache;
import br.com.radixeng.apiclient.modelo.HttpRequester;
import br.com.radixeng.apiclient.modelo.IMethod;
import br.com.radixeng.apiclient.modelo.PIValue;
import br.com.radixeng.apiclient.modelo.SessaoUI;

public class TestaFluxo {
	public static void main(String[] args) {
		SessaoUI ui = new SessaoUI();
		HttpRequester requeridor = new HttpRequester();
		
		System.out.println(">> Informe um ou mais tags separados por virgula:");
		try (Scanner scanner = new Scanner(System.in)) {
			String[] respostaUI = scanner.hasNextLine() ? scanner.nextLine().toUpperCase().split(",") : new String[0];
			
			if (respostaUI.length>0) {
				for (String tag: respostaUI) {
					ui.getClientCache().setTag(tag, new PIValue());
					ui.getClientCache().getPIValue(tag).setWebId(requeridor.getWebId(tag));
					ui.getClientCache().getPIValue(tag).setUnidade(requeridor.getUnidade(tag));
					
					System.out.println("\n"+"Tag: "+tag+" em "+ui.getClientCache().getPIValue(tag).getUnidade()
										   +", WebId: \n\n\t"+ ui.getClientCache().getPIValue(tag).getWebId());
					
				}
				
				
				
				System.out.println(">> Informe a data de inicio:\n");
				String respostaUI2 = scanner.hasNextLine() ? scanner.nextLine().replace(" ", "") :"";
		        
				LocalDateTime dataInicio = LocalDateTime.parse(respostaUI2, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss"))
										.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
				
				System.out.println("\n>> Informe a data de fim:\n");
		
				String respostaUI3 = scanner.hasNextLine() ? scanner.nextLine().replace(" ", "") :"";
				
		        LocalDateTime dataFim = LocalDateTime.parse(respostaUI3, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss"))
		        						.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
		        
	
		        System.out.println(dataInicio);	
		        System.out.println(dataFim);	
				
				scanner.close();
					
				// mostrar 10 primeiros dados
				for (String tag: respostaUI) {
//					HttpRequester.buscarDados(tag, dataInicio, dataFim, ui.getClientCache());
//					System.out.println("\nPrimeiros 10 dados da tag: "+tag);
//					for (int i=0; i<10; i++ ) {
//						System.out.println(ui.getClientCache().getPIValue(tag.toUpperCase()).getTimestamps().get(i).toString()+ 
//											" => "+ui.getClientCache().getPIValue(tag.toUpperCase()).getValores().get(i).toString());
//					}
					
//					ui.getClientCache().getPIValue(tag).mostraDadosConsole();
					
					HttpRequester.buscarDados(tag, dataInicio, dataFim, ui.getClientCache(), new RemoveMaiorQueCem());
//					HttpRequester.buscarDados(tag, dataInicio, dataFim, ui.getClientCache(), new RemoveInvalidos());
					
//					ui.getClientCache().getPIValue(tag).getReferencia().forEach((t, u) -> System.out.println(t.toString()+": "+u.toString()));
					ui.plotDados(tag);
					
				}
				
				
				
			}else {
				//TODO: contaTentativas, pede de novo
			}
		}
	}
	
	public static class RemoveInvalidos implements IMethod{
		
		@Override
		public PIValue trata(PIValue cacheCliente) {
			return IMethod.super.trata(cacheCliente);
		}
	}

	public static class RemoveMaiorQueCem implements IMethod {

		@Override
		public PIValue trata(PIValue cacheCliente) {
			
			// Eu tinha pensado em usar assim, mas lembrei que nao funciona! :C
			// Exception in thread "main" java.util.ConcurrentModificationException
//			cacheCliente.getValores().forEach(
//				v -> {
//					if (v>100) {
//						cacheCliente.remove(v);
//					} 
//				}
//			);
			
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
	
}



// sinusoid,sinusoidu,cdt158,cdep158
// sinusoid,cdt158
// 03/03/2022 12:00:00
// 04/03/2022 15:00:00
//
// cdt158
// 03/01/2022 12:00:00
// 13/01/2022 12:00:00