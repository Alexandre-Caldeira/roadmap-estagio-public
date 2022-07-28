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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.json.JsonObject;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import br.com.radixeng.apiclient.modelo.HttpRequester;
import br.com.radixeng.apiclient.modelo.SessaoUI;

public class TestaMap {
	public static void main(String[] args)  throws NoSuchAlgorithmException, KeyManagementException, IOException, InterruptedException {
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
		
		
		
//		jsonobject.get("Items").asJsonArray().forEach(t -> System.out.println(t.asJsonObject().get("Value").getValueType()));
//		jsonobject.get("Items").asJsonArray().forEach(t -> System.out.println(t.asJsonObject().get("Timestamp").getValueType()));
//		jsonobject.get("Items").asJsonArray().forEach(t -> System.out.println(t.asJsonObject().get("Timestamp")));
		
		Map<String, LinkedList<Float>> CacheTeste = new HashMap<>();
		
		LinkedList<Float> meuPIVALUE1 = new LinkedList<Float>();
		
		//TODO: Popular um PIValue
		jsonobject.get("Items").asJsonArray().forEach(
				// sera que nao consigo fugir de parseFloat( .toString() ) ?
				o -> meuPIVALUE1.add(Float.parseFloat( o.asJsonObject().get("Value").toString()))
		);
		
		CacheTeste.put("CDT158",meuPIVALUE1);
		
		HttpRequest request2 = HttpRequest.newBuilder()
			    .uri(URI.create("XXXXXXXXXXX/piwebapi/streams/F1DP72-6XVl5302c_uD52V8M7AAQAAAAUElBRlNFUlZFUjIwMThcU0lOVVNPSUQ/recorded?selectedFields=Items.Value%3BItems.Timestamp&startTime=03%2F03%2F2022%2012%3A00%3A00&endTime=03%2F04%2F2022%2016%3A00%3A00"))
			    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		HttpResponse<String> response2 = constroiClient.build().send(request2, HttpResponse.BodyHandlers.ofString());
		JsonObject jsonobject2 = HttpRequester.jsonFromString(response2.body().toString());
		
		LinkedList<Float> meuPIVALUE2 = new LinkedList<Float>();
		
		//TODO: Popular um PIValue
		jsonobject2.get("Items").asJsonArray().forEach(
				// sera que nao consigo fugir de parseFloat( .toString() ) ?
				o -> meuPIVALUE2.add(Float.parseFloat( o.asJsonObject().get("Value").toString()))
		);
		
		
		CacheTeste.put("SINUSOID",meuPIVALUE2);
		
		CacheTeste.values().forEach( e -> System.out.println(e));
		
		/*
		// Testando recep��o dos dados
		testando.forEach(e -> {
			if(e<100) {
				System.out.println(e);
	    }});
	    */
		

	}

}
