package br.com.radixeng.apiclient.proceduraltests;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import br.com.radixeng.apiclient.modelo.ClientCache;
import br.com.radixeng.apiclient.modelo.HttpRequester;
import br.com.radixeng.apiclient.modelo.IMethod;
import br.com.radixeng.apiclient.modelo.PIValue;
import br.com.radixeng.apiclient.modelo.SessaoUI;

public class TestaBuscarDados {
	public static void main(String[] args) {
		SessaoUI ui = new SessaoUI(ClientCache.getInstance());
		HttpRequester requeridor = new HttpRequester();
		
		String[] tags = {"SINUSOID","SINUSOIDU","CDT158","CDEP158"};
		
		String dataInicio = "03/03/2022 12:00:00".replace(" ", "");
		String dataFim = "09/03/2022 15:00:00".replace(" ", "");
		LocalDateTime inicio =  LocalDateTime.parse(dataInicio, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss"))
								.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
		LocalDateTime fim =  LocalDateTime.parse(dataFim, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss"))
				.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
		
		for (String tag: tags) {
			ui.getClientCache().setData(tag, new PIValue());
			ui.getClientCache().getValue(tag).setWebId(requeridor.getWebId(tag));
			ui.getClientCache().getValue(tag).setUnidade(requeridor.getUnidade(tag));
			HttpRequester.buscarDados(tag, inicio, fim, ui.getClientCache());
			ui.plotDados(tag);
		}
		
		for (String tag: tags) {
			HttpRequester.buscarDados(tag, inicio, fim, ui.getClientCache(), new RemoveInvalidos());
			ui.plotDados(tag);
		}
		
		for (String tag: tags) {
			HttpRequester.buscarDados(tag, inicio, fim, ui.getClientCache(), new RemoveMaiorQue80());
			ui.plotDados(tag);
		}
	}
	
	public static class RemoveInvalidos implements IMethod{
			
			@Override
			public PIValue trata(PIValue cacheCliente) {
				return IMethod.super.trata(cacheCliente);
			}
	}
	
	public static class RemoveMaiorQue80 implements IMethod {

		@Override
		public PIValue trata(PIValue cacheCliente) {
			
			cacheCliente.getReferencia().forEach(
				(chave, par) -> {
					if(par.getValue() > 80) {
						cacheCliente.remove(par.getValue());
					}
				}
			);

			return cacheCliente;
		}
	} 
}
