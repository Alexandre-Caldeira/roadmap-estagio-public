``` java
package br.com.radixeng.apiclient.testes;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Builder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


import br.com.radixeng.apiclient.modelo.TempTag;

public class TestaGetWebId {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException, InterruptedException{
		TempTag tagAtual = new TempTag("");
		
		if (args.length>0) {
			tagAtual.setNome(args[0].toUpperCase().trim());
			
			switch (tagAtual.getNome()) {
				case "SINUSOID":
					tagAtual.setWebId(getWebId("%3ASINUSOID"));					
					break;
					
				case "SINUSOIDU":
					tagAtual.setWebId(getWebId("%3ASINUSOIDU"));
					break;
				
				case "CDT158":
					tagAtual.setWebId(getWebId("%3ACDT158"));
					break;
					
				case "CDEP158":
					tagAtual.setWebId(getWebId("%3ACDEP158"));
					break;
				
				default:
					System.out.println("Tag desconhecida ou inválida!");
					break;
			}
		}else {
			System.out.println("Tag desconhecida ou inválida!");
		}
		System.out.println("WebId: \n\n\t"+ tagAtual.getWebId());
	}
	
	public static String getWebId(String nome) throws NoSuchAlgorithmException, KeyManagementException, IOException, InterruptedException {
		
        TrustManager[] trustAllCerts = new TrustManager[] {(TrustManager) new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
        };
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("XXXXXXXXXXX/piwebapi/search/query?q=name"+nome))
			    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		
		Builder constroiClient = HttpClient.newBuilder().sslContext(sc);
		HttpResponse<String> response = constroiClient.build().send(request, HttpResponse.BodyHandlers.ofString());
		
		String jsonString = response.body().toString();

		System.out.println(jsonString);
		
		JsonObject jsonobject = jsonFromString(jsonString);
//		String WebId = jsonobject.getString("WebId");
		
//		jsonobject.forEach((t, u) -> System.out.println(t));
		System.out.println(jsonobject);
		
		Set<String> keys = jsonobject.keySet();
		
		keys.forEach(t -> System.out.println(t));

		System.out.println(jsonobject.get("Items").asJsonArray().get(0).asJsonObject().getString("WebId"));
//				.asJsonObject().get("WebId"));
		
		
		
		return ""; // WebId;
	}
	

	private static JsonObject jsonFromString(String jsonObjectStr) {

	    JsonReader jsonReader = Json.createReader(new StringReader(jsonObjectStr));
	    
	    JsonObject object = jsonReader.readObject();
	    jsonReader.close();

	    return object;
	}
}



```