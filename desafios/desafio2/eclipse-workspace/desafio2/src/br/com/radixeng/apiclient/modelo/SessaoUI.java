package br.com.radixeng.apiclient.modelo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import tech.tablesaw.api.DateTimeColumn;
import tech.tablesaw.api.FloatColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.TimeSeriesPlot;

public class SessaoUI {
	private ClientCache clientCache;
	private static int numDeSessoes;
	private int idSessao = 0;
	private String nomeDaSessao = "Sessao Radix " +System.getProperty("user.name");
	
	public SessaoUI(ClientCache instanciaDeCache) {
		idSessao = numDeSessoes++;
		System.out.println("\nIniciando " +nomeDaSessao+" #"+idSessao+".\n");
		clientCache = instanciaDeCache;
		// Injecao de dependencia: usuario (ApiClient) que deve passar instancia
	}
		
	// Getters
	public ClientCache getClientCache() {
		return clientCache;
	}
	
	// Metodos	
	public void plotDados(String tag) {
		Table tabela = Table.create(tag);
		
		DateTimeColumn datas = DateTimeColumn.create("Tempo");
		((PIValue) clientCache.getData(tag)).getTimestamps().forEach(d -> datas.append(d));
		
		String yLabel = "Magnitude ["+((PIValue) clientCache.getData(tag)).getUnidade()+"]";
		FloatColumn valores = FloatColumn.create(yLabel);
		((PIValue) clientCache.getData(tag)).getValores().forEach(v -> valores.append(v));
		
		tabela.addColumns(datas,valores); // retornar tabela?
				
		Plot.show(TimeSeriesPlot.create(tag,tabela,"Tempo",yLabel));
	}

	public void iniciarClient(HttpRequester requeridor) {
		System.out.println(">> Informe um ou mais tags separados por virgula:");
		System.out.print("\n>> ");
		try (Scanner scanner = new Scanner(System.in)) {
			String[] respostaUI = scanner.hasNextLine() ? scanner.nextLine().toUpperCase().split(",") : new String[0];
			
			
			System.out.println("\n>> Informe a data de inicio:");
			System.out.print("\n>> ");
			String respostaUI2 = scanner.hasNextLine() ? scanner.nextLine().replace(" ", "") :"";
	        
			LocalDateTime dataInicio = LocalDateTime.parse(respostaUI2, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss"))
									.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
			
			System.out.println("\n>> Informe a data de fim:");
			System.out.print("\n>> ");
	
			String respostaUI3 = scanner.hasNextLine() ? scanner.nextLine().replace(" ", "") :"";
			
	        LocalDateTime dataFim = LocalDateTime.parse(respostaUI3, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss"))
	        						.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
	        
	        
	        if (respostaUI.length>0) {
				for (String tag: respostaUI) {
					this.clientCache.setData(tag, new PIValue());
					((PIValue) this.clientCache.getData(tag)).setWebId(requeridor.getWebId(tag));
					((PIValue) this.clientCache.getData(tag)).setUnidade(requeridor.getUnidade(tag));
					HttpRequester.buscarDados(tag, dataInicio, dataFim, this.clientCache);
				}
				
		        //TODO: tratar casos em que buscarDados falhou
		        System.out.println("\nDados carregados para as variaveis");
		        int c = 1;
		        for (String tag: respostaUI) {
		        	System.out.println("\t"+c++ +") "+tag);
				}
		        
		        System.out.println("\nQual variavel deseja visualizar?");
		        System.out.println("\n -1) Interromper");
		        System.out.println("\n -2) Todas as variaveis");
		        System.out.print("\n>> ");
		        int respostaUI4 = scanner.hasNext() ? Integer.parseInt(scanner.next().trim()) :-1;
		        scanner.close(); 
		        
		        switch(respostaUI4) {
		        	case -1:
		        		break;
		        		
		        	case -2:
		        		for(String tag: respostaUI) {
		        			this.plotDados(tag);
		        		}
		        		break; 
		        		
		        	default:
		        		this.plotDados(respostaUI[respostaUI4-1]);
		        		break;
		        }
				
		        System.out.println("\n Finalizando sessao...");
			}else {
				System.out.println("\n Nenhuma resposta recebida. Finalizando sessao...");
			}
		}
	}
	
	public void iniciarClient(HttpRequester requeridor, IMethod metodoTratamento) {
		System.out.println(">> Informe um ou mais tags separados por virgula:");
		System.out.print("\n>> ");
		
		try (Scanner scanner = new Scanner(System.in)) {
			String[] respostaUI = scanner.hasNextLine() ? scanner.nextLine().toUpperCase().split(",") : new String[0];
			
			
			System.out.println("\n>> Informe a data de inicio:");
			System.out.print("\n>> ");
			String respostaUI2 = scanner.hasNextLine() ? scanner.nextLine().replace(" ", "") :"";
	        
			LocalDateTime dataInicio = LocalDateTime.parse(respostaUI2, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss"))
									.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
			
			System.out.println("\n>> Informe a data de fim:");
			System.out.print("\n>> ");
			String respostaUI3 = scanner.hasNextLine() ? scanner.nextLine().replace(" ", "") :"";
			
	        LocalDateTime dataFim = LocalDateTime.parse(respostaUI3, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss"))
	        						.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
	        
	        
	        if (respostaUI.length>0) {
				for (String tag: respostaUI) {
					this.clientCache.setData(tag, new PIValue());
					((PIValue) this.clientCache.getData(tag)).setWebId(requeridor.getWebId(tag));
					((PIValue) this.clientCache.getData(tag)).setUnidade(requeridor.getUnidade(tag));
					HttpRequester.buscarDados(tag, dataInicio, dataFim, this.clientCache, metodoTratamento);
				}
				
		        //TODO: tratar casos em que buscarDados falhou
		        System.out.println("\nDados carregados para as variaveis");
		        int c = 1;
		        for (String tag: respostaUI) {
		        	System.out.println("\t"+c++ +") "+tag);
				}
		        
		        System.out.println("\nQual variavel deseja visualizar?");
		        System.out.println("\n -1) Interromper");
		        System.out.println("\n -2) Todas as variaveis");
		        System.out.print("\n>> ");
		        int respostaUI4 = scanner.hasNext() ? Integer.parseInt(scanner.next().trim()) :-1;
		        scanner.close(); 
		        
		        switch(respostaUI4) {
		        	case -1:
		        		break;
		        		
		        	case -2:
		        		for(String tag: respostaUI) {
		        			this.plotDados(tag);
		        		}
		        		break; 
		        		
		        	default:
		        		this.plotDados(respostaUI[respostaUI4-1]);
		        		break;
		        }
				
		        System.out.println("\n Finalizando sessao...");
			}else {
				System.out.println("\n Nenhuma resposta recebida. Finalizando sessao...");
			}
		}
	}
	
}
