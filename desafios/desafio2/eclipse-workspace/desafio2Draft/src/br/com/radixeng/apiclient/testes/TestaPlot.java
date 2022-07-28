package br.com.radixeng.apiclient.testes;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.radixeng.apiclient.modelo.HttpRequester;
import br.com.radixeng.apiclient.modelo.PIValue;
import br.com.radixeng.apiclient.modelo.SessaoUI;
import tech.tablesaw.api.DateTimeColumn;
import tech.tablesaw.api.FloatColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.TimeSeriesPlot;
import tech.tablesaw.plotly.components.Figure;

//TODO: abstrair
public class TestaPlot {
	public static void main(String[] args) {
		SessaoUI ui = new SessaoUI();
		HttpRequester requeridor = new HttpRequester();
		
//		String tag = "SINUSOID";
//		String tag = "CDT158";
		String tag = "CDEP158";
		ui.getClientCache().setTag(tag, new PIValue());
		ui.getClientCache().getPIValue(tag).setWebId(requeridor.getWebId(tag));
		
		System.out.println("\n"+"Tag: "+tag+" WebId: \n\n\t"+ ui.getClientCache().getPIValue(tag).getWebId());
		
		String dataInicio = "03/03/2022 12:00:00".replace(" ", "");
		String dataFim = "09/03/2022 15:00:00".replace(" ", "");
		LocalDateTime inicio =  LocalDateTime.parse(dataInicio, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss"))
								.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
		LocalDateTime fim =  LocalDateTime.parse(dataFim, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss"))
				.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
		
		
		HttpRequester.buscarDados(tag, inicio, fim, ui.getClientCache());
//		ui.getClientCache()
//		Collection<Column> colecaoValores = 
				
		
		Table tabela = Table.create("tag");
		DateTimeColumn datas = DateTimeColumn.create("datas");
		ui.getClientCache().getPIValue(tag).getTimestamps().forEach(d -> System.out.println(d));
		
		ui.getClientCache().getPIValue(tag).getTimestamps().forEach(d -> datas.append(d));
		
		FloatColumn valores = FloatColumn.create("valores");
		ui.getClientCache().getPIValue(tag).getValores().forEach(v -> valores.append(v));
		
		tabela.addColumns(datas,valores);
		
//				ui.getClientCache().getPIValue(tag).getTimestamps());
//		tabela.addColumns()
			
		
//				tag,ui.getClientCache().getPIValue(tag).getTimestamps(), ui.getClientCache().getPIValue(tag).getValores());
		
		System.out.println("\n _____________________");
		
		System.out.println(tabela.print());
		
		System.out.println("\n _____________________");
		
		Figure timeseries = TimeSeriesPlot.create(tag,tabela,"datas","valores");
		
		Logger LOGGER = LoggerFactory.getLogger(Plot.class);
		
		
		System.out.println(LOGGER.isErrorEnabled());
		
		Plot.show(timeseries);
		
		
	}
}
