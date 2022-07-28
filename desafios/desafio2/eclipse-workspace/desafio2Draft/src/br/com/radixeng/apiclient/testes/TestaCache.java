package br.com.radixeng.apiclient.testes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Builder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.json.JsonObject;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import br.com.radixeng.apiclient.modelo.ClientCache;
import br.com.radixeng.apiclient.modelo.HttpRequester;
import br.com.radixeng.apiclient.modelo.PIValue;
import br.com.radixeng.apiclient.modelo.SessaoUI;

public class TestaCache {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException, InterruptedException {
		SessaoUI ui = new SessaoUI();
		
		TrustManager[] trustAllCerts = new TrustManager[] {(TrustManager) new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {return null;}
            public void checkClientTrusted(X509Certificate[] certs, String authType) {}
            public void checkServerTrusted(X509Certificate[] certs, String authType) {}
        }
    };
    SSLContext sc = SSLContext.getInstance("SSL");
    sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpRequest request = HttpRequest.newBuilder()
        	    .uri(URI.create("XXXXXXXXXXX/piwebapi/streams/F1DP72-6XVl5302c_uD52V8M7AAwAAAAUElBRlNFUlZFUjIwMThcQ0RUMTU4/recorded?selectedFields=Items.Value%3BItems.Timestamp&startTime=03%2F03%2F2022%209%3A00%3A00&endTime=03%2F04%2F2022%2012%3A00%3A00"))
        	    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
        	    .method("GET", HttpRequest.BodyPublishers.noBody())
        	    .build();
		Builder constroiClient = HttpClient.newBuilder().sslContext(sc);
		HttpResponse<String> response = constroiClient.build().send(request, HttpResponse.BodyHandlers.ofString());
		JsonObject jsonobject = HttpRequester.jsonFromString(response.body().toString());
		

		ClientCache CacheTeste = ClientCache.getInstance();
		
		PIValue meuPIVALUE1 = new PIValue();
		
		
		jsonobject.get("Items").asJsonArray().forEach(
				// sera que nao consigo fugir de parseFloat( .toString() ) ?
//				jsonobject.get("Items").asJsonArray().getValuesAs(Float);
				o -> meuPIVALUE1.addValor(Float.parseFloat( o.asJsonObject().get("Value").toString()))
		);
		
		jsonobject.get("Items").asJsonArray().forEach(
//				o -> System.out.println(o.asJsonObject().get("Timestamp").toString().replaceAll("[A-Z]|\"", ""))
//				o -> System.out.println(LocalDateTime.parse(o.asJsonObject().get("Timestamp").toString().replaceAll("[A-Z]|\"", ""), DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss")))
				o -> meuPIVALUE1.addTimestamp(LocalDateTime.parse(o.asJsonObject().get("Timestamp").toString().replaceAll("[A-Z]|\"", ""), DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss")))
		);
		
		CacheTeste.setTag("CDT158", meuPIVALUE1);
		
		// mostrar 10 primeiros dados
		System.out.println("\nPrimeiros 10 dados da tag CDT158: ");
		for (int i=0; i<10; i++ ) {
			System.out.println(CacheTeste.getPIValue("CDT158").getTimestamps().get(i).toString()+ 
								" -> "+CacheTeste.getPIValue("CDT158").getValores().get(i).toString());
		}
				
		HttpRequest request2 = HttpRequest.newBuilder()
			    .uri(URI.create("XXXXXXXXXXX/piwebapi/streams/F1DP72-6XVl5302c_uD52V8M7AAQAAAAUElBRlNFUlZFUjIwMThcU0lOVVNPSUQ/recorded?selectedFields=Items.Value%3BItems.Timestamp&startTime=03%2F03%2F2022%2012%3A00%3A00&endTime=03%2F04%2F2022%2016%3A00%3A00"))
			    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		HttpResponse<String> response2 = constroiClient.build().send(request2, HttpResponse.BodyHandlers.ofString());
		JsonObject jsonobject2 = HttpRequester.jsonFromString(response2.body().toString());

		PIValue meuPIVALUE2 = new PIValue();
		
				
		jsonobject2.get("Items").asJsonArray().forEach(
				o -> meuPIVALUE2.addValor(Float.parseFloat( o.asJsonObject().get("Value").toString()))
		);
		
		jsonobject2.get("Items").asJsonArray().forEach(
				o -> meuPIVALUE2.addTimestamp(LocalDateTime.parse(o.asJsonObject().get("Timestamp").toString().replaceAll("[A-Z]|\"", ""), DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss")))
		);
		
		CacheTeste.setTag("SINUSOID", meuPIVALUE2);
		
		// mostrar 10 primeiros dados
		System.out.println("\nPrimeiros 10 dados da tag SINUSOID: ");
		for (int i=0; i<10; i++ ) {
			System.out.println(CacheTeste.getPIValue("SINUSOID").getTimestamps().get(i).toString()+ 
								" -> "+CacheTeste.getPIValue("SINUSOID").getValores().get(i).toString());
		}
		
	}
}
