package br.com.radixeng.apiclient.testes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Builder;
import java.net.http.HttpRequest;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.json.JsonObject;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import br.com.radixeng.apiclient.modelo.HttpRequester;
import br.com.radixeng.apiclient.modelo.SessaoUI;

public class TestaGetDados {

	public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException, InterruptedException  {
		SessaoUI ui = new SessaoUI();
		
		// https://gist.github.com/matthewromano/4178946
        TrustManager[] trustAllCerts = new TrustManager[] {(TrustManager) new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {return null;}
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }
        };
        
        // Cria contexto SSL com TrustManager que aceita qualquer certificado (ignora validacao de cert.)
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        
        
		// Do Insomnia, usa token de autenticacao gerado para acessar a API (verifique conexao com VPN): 
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("XXXXXXXXXXX/piwebapi/streams/F1DP72-6XVl5302c_uD52V8M7AAQAAAAUElBRlNFUlZFUjIwMThcU0lOVVNPSUQ/recorded?maxCount=10&selectedFields=Items.Value&startTime=-2y"))
			    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		
//		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//		System.out.println(response.body());
	
		//TODO: refatorar para closeable client
		// constroi cliente HTTP com contexto SSL que ignora validacao de certificado:
		Builder constroiClient = HttpClient.newBuilder().sslContext(sc);
		
		// Envia, de fato, o requerimento GET HTTP:
		HttpResponse<String> response = constroiClient.build().send(request, HttpResponse.BodyHandlers.ofString());
		
		// Cria objeto json a partir de string da resposta do requerimento
		JsonObject jsonobject = HttpRequester.jsonFromString(response.body().toString());
		
		jsonobject.get("Items").asJsonArray().forEach(t -> System.out.println(t.asJsonObject().get("Value").toString()));
		
//		System.out.println("WebId: \n\n\t"+ tagAtual.ge/////////////tWebId());
		
//		return jsonobject.get("Items").asJsonArray().get(0).asJsonObject().getString("WebId"); // WebId;
	}
	
	

}
