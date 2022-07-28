package br.com.radixeng.apiclient.testes;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.TimeZone;

import br.com.radixeng.apiclient.modelo.SessaoUI;

// Abstrair
public class TestaFluxoData {
	public static void main(String[] args) {
		SessaoUI ui = new SessaoUI();
//		HttpRequester requeridor = new HttpRequester();
		
//		03/03/2022 12:00:00
//		//TODO: contaTentativas, pede de novo

		System.out.println(">> Informe a data de inicio:\n");
		try (Scanner scanner = new Scanner(System.in)) {
			String respostaUI = scanner.hasNextLine() ? scanner.nextLine().replace(" ", "") :"";
	        
			LocalDateTime dataInicio = LocalDateTime.parse(respostaUI, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss"))
									.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
			
			System.out.println("\n>> Informe a data de fim:\n");
	
			String respostaUI2 = scanner.hasNextLine() ? scanner.nextLine().replace(" ", "") :"";
			
	        LocalDateTime dataFim = LocalDateTime.parse(respostaUI2, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss"))
	        						.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
	        

	        System.out.println(dataInicio);	
	        System.out.println(dataFim);	
			
			scanner.close();
			
			
		}
		
	}
}
