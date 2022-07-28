package br.com.radixeng.apiclient.testes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Builder;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


public class TestaHttp {
	public static void main(String[] args) throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException{
		// Create a trust manager that does not validate certificate chains
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
 
        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
       
        
        
        
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("XXXXXXXXXXX/piwebapi/search/query?q=name%3ACDEP158"))
			    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		
		Builder constroiClient = HttpClient.newBuilder().sslContext(sc);
		
		
		HttpResponse<String> response = constroiClient.build().send(request, HttpResponse.BodyHandlers.ofString());
//		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		
//		ObjectMapper objectMapper = new ObjectMapper();
//		String jsonResposta = response.body(); 
//		System.out.println(response.body());
		System.out.println(response.body().toString());
		
	}
	
}
