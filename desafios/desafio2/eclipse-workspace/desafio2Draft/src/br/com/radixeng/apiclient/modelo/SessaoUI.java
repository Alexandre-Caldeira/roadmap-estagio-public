package br.com.radixeng.apiclient.modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

import tech.tablesaw.api.DateTimeColumn;
import tech.tablesaw.api.FloatColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.TimeSeriesPlot;
import tech.tablesaw.plotly.components.Config;


public class SessaoUI {
	private static ClientCache clientCache;
	private static int numDeSessoes;
	private int idSessao = 0;
	private String nomeDaSessao = "Sessao Radix " +System.getProperty("user.name");

	public SessaoUI() {
		idSessao = numDeSessoes++;
		System.out.println("\nIniciando " +nomeDaSessao+" #"+idSessao+".");
		clientCache = ClientCache.getInstance();
	}
	
	//TODO
	public ClientCache getParametros() {
		
		return null;
	}
	
	public void plotDados(String tag) {
//			List<PIValue> cacheCliente){
//		System.out.println("Dados carregados para as variaveis");
		// sysout cacheCliente.getTags().toString();
		
//		System.out.println("Qual variavel deseja visualizar?");
		// int indiceTag = this.receberDados( 1 );	
		//TODO: implementar desenho do grafico
		
		
		Table tabela = Table.create(tag);
		DateTimeColumn datas = DateTimeColumn.create("Tempo");
		
//		clientCache.getPIValue(tag).getTimestamps().forEach(d -> System.out.println(d));
		
		clientCache.getPIValue(tag).getTimestamps().forEach(d -> datas.append(d));
		
//		String nome;
//		if (clientCache.getPIValue(tag).getUnidade().compareTo("")==0) {
//			nome = "Magnitude"+clientCache.getPIValue(tag).getUnidade();
//		}else {
//			nome = "Magnitude";
//		}
//		
		String yLabel = "Magnitude ["+clientCache.getPIValue(tag).getUnidade()+"]";
		FloatColumn valores = FloatColumn.create(yLabel);
		clientCache.getPIValue(tag).getValores().forEach(v -> valores.append(v));
		
		tabela.addColumns(datas,valores);
		
		System.out.println(tabela.print());
		
		Plot.show(TimeSeriesPlot.create(tag,tabela,"Tempo",yLabel));
		
	}
	
	public ClientCache getClientCache() {
		return clientCache;
	}


	
}
