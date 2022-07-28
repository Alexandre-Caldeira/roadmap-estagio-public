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


import br.com.radixeng.apiclient.modelo.TesterTag;

//DONE: abstrair para metodo em classe 
// Possiveis casos de refatoracao:
//	- Novo dataserver tem mais de uma tag com nomes usados aqui
//	- Resposta JSON do requerimento mudou de estrutura e WebId nao se encontra onde buscamos

public class TestaGetWebId {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException, InterruptedException{
		TesterTag tagAtual = new TesterTag("");
		
		if (args.length>0) {
			tagAtual.setNome(args[0].toUpperCase().trim());
			
			switch (tagAtual.getNome()) {
				//TODO: URL encode fora do insomnia (via codigo) 
			
				case "SINUSOID":	// F1DP72-6XVl5302c_uD52V8M7AAQAAAAUElBRlNFUlZFUjIwMThcU0lOVVNPSUQ
					tagAtual.setWebId(getWebId("%3ASINUSOID"));					
					break;
					
				case "SINUSOIDU":	// F1DP72-6XVl5302c_uD52V8M7AAgAAAAUElBRlNFUlZFUjIwMThcU0lOVVNPSURV
					tagAtual.setWebId(getWebId("%3ASINUSOIDU"));
					break;
				
				case "CDT158":		// F1DP72-6XVl5302c_uD52V8M7AAwAAAAUElBRlNFUlZFUjIwMThcQ0RUMTU4
					tagAtual.setWebId(getWebId("%3ACDT158"));
					break;
					
				case "CDEP158":		// F1DP72-6XVl5302c_uD52V8M7ABQAAAAUElBRlNFUlZFUjIwMThcQ0RFUDE1OA
					tagAtual.setWebId(getWebId("%3ACDEP158"));
					break;
				
				default:
					System.out.println("Tag desconhecida ou inv�lida!");
					break;
			}
		}else {
			System.out.println("Tag desconhecida ou inv�lida!");
		}
		System.out.println("WebId: \n\n\t"+ tagAtual.getWebId());
	}
	
	public static String getWebId(String nome) throws NoSuchAlgorithmException, KeyManagementException, IOException, InterruptedException {
		
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
			    .uri(URI.create("XXXXXXXXXXX/piwebapi/search/query?q=name"+nome))
			    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		
		//TODO: refatorar para closeable client
		// constroi cliente HTTP com contexto SSL que ignora validacao de certificado:
		Builder constroiClient = HttpClient.newBuilder().sslContext(sc);
		
		// Envia, de fato, o requerimento GET HTTP:
		HttpResponse<String> response = constroiClient.build().send(request, HttpResponse.BodyHandlers.ofString());
		
		// Cria objeto json a partir de string da resposta do requerimento
		JsonObject jsonobject = jsonFromString(response.body().toString());
		
		return jsonobject.get("Items").asJsonArray().get(0).asJsonObject().getString("WebId"); // WebId;
	}
	

	// https://stackoverflow.com/questions/9151619/how-to-iterate-over-a-jsonobject
	// https://stackoverflow.com/questions/25948000/how-to-convert-string-to-jsonobject
	private static JsonObject jsonFromString(String jsonObjectStr) {

	    JsonReader jsonReader = Json.createReader(new StringReader(jsonObjectStr));
	    
	    JsonObject object = jsonReader.readObject();
	    jsonReader.close();

	    return object;
	}
}


