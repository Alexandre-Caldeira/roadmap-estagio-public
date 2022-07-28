package br.com.radixeng.apiclient.modelo;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

//TODO: Gerar e gerenciar autenticacao via codigo, verificando se expirou e armazenando no ClientCache
//TODO: Apresentar e gerenciar resultados das HTTP Request/Response
//TODO: Abstrair gets, melhorar uso de HttpClient e HttpRequest
//TODO: Abstrair HttpRequest builder com URI encoding, removendo boilerplate
//TODO: Abstrair maxCount em buscarDados

//Casos previsiveis de refatoracao:
//- Novo dataserver tem mais de uma tag com nomes usados aqui
//- Resposta JSON do requerimento mudou de estrutura e WebId nao se encontra onde buscamos

public class HttpRequester {
	
	public static SSLContext sslContext;
	private static final int maxCount = 100000;
	
	// Construtor inicia Builder de HttpClient sem validacao de certificado: 
	public HttpRequester() {

		// Cria TrustManager que aceita qualquer certificado (ignora validacao de cert.):
		TrustManager[] trustAllCerts = new TrustManager[] {(TrustManager) new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {return null;}
            public void checkClientTrusted(X509Certificate[] certs, String authType) {}
            public void checkServerTrusted(X509Certificate[] certs, String authType) {}
        	}
	    };

		// Cria contexto SSL com TrustManager definido:
		try {
			sslContext = SSLContext.getInstance("SSL");
		} catch (NoSuchAlgorithmException ex1) {
			ex1.printStackTrace();
		}
	    try {
	    	sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
		} catch (KeyManagementException ex2) {
			ex2.printStackTrace();
		}
	    
	}
	
	// Query API para capturar unidade de medida da tag
	public String getUnidade(String tag) {

		String uri = "XXXXXXXXXXX/piwebapi/search/query?q=name%3A"+tag;
		
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create(uri))
			    .header("Authorization", "Basic ###########")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		
		//FIXED: java.lang.IndexOutOfBoundsException: Index 0 para query bem-sucedida vazia
		try {
			
			JsonObject jsonobject = jsonFromString(getResponse(request).body().toString());
			
			return jsonobject.get("Items").asJsonArray().get(0).asJsonObject().getString("UoM");
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return "";
		} catch (IndexOutOfBoundsException e) {
			
			System.out.println("\nNome de tag invalida!");
			System.out.println(e.toString());
			return "";
		} catch (NullPointerException en) {
			System.out.println("\nTag "+tag+" nao possui unidade!");
			return "-";
		}
	}
		
	// Query API para coletar WebId, similar a getUnidade()
	public String getWebId(String tag){	
		String uri = "XXXXXXXX/piwebapi/search/query?q=name%3A"+tag;
		
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create(uri))
			    .header("Authorization", "Basic XXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();

		try {
			
			JsonObject jsonobject = jsonFromString(getResponse(request).body().toString());
			
			return jsonobject.get("Items").asJsonArray().get(0).asJsonObject().getString("WebId");
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return "";
		} catch (IndexOutOfBoundsException e) {
			
			System.out.println("Nome de tag invalida!");
			System.out.println(e.toString());
			return "";
		}
	}
	
	// Abstraido do Insomnia, usa token de autenticacao gerado para acessar a API (verifique conexao com VPN):
	public static void buscarDados(String tag, LocalDateTime inicio, LocalDateTime fim, ClientCache cache){

		String uri = "XXXXXXXXXXXXX/piwebapi/streams/"+((PIValue) cache.getData(tag)).getWebId()
				+"/recorded?maxCount="+maxCount
				+"&selectedFields=Items.Value%3BItems.Timestamp"
				+"&startTime="+inicio
				+"&endTime=" +fim;

		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create(uri))
			    .header("Authorization", "Basic ##################")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();

		try {
			
			JsonObject jsonobject = jsonFromString(getResponse(request).body().toString());
			
			// Para cada item do JSON recebido do requerimento, guardar no cache da tag especifica o valor:
			// Chama parseValues em cada objeto para converter valores invalidos como:
			// "{"Name":"Shutdown","Value":254,"IsSystem":true}"
			// em valores Float -1, pois todas as variaveis do sistema sao positivas. 
			jsonobject.get("Items").asJsonArray().forEach(o -> ((PIValue) cache.getData(tag)).addValor(parseValues(o)));
			
			// Para cada item do JSON recebido do requerimento, remover via regex letras e " da string 
			// Timestamp, transformar em Local datetime e guardar no cache da tag especifica:
			jsonobject.get("Items").asJsonArray().forEach(
					o -> ((PIValue) cache.getData(tag)).addTimestamp(
								LocalDateTime.parse(o.asJsonObject().get("Timestamp").toString().replaceAll("[A-Z]|\"", ""), 
													DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss")))
			);
			
			// Sempre setar referencia para facilitar remocao sincronizada
			((PIValue) cache.getData(tag)).setReferencia();
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Nome de tag invalida!");
			System.out.println(e.toString());
		}
	}
	
	// Sobrecarga que aplica tratamento de dados
	public static void buscarDados(String tag, LocalDateTime inicio, LocalDateTime fim, ClientCache cache, IMethod metodoTratamento){
		String uri = "XXXXXXXXXXXXXXXXXX/piwebapi/streams/"+((PIValue) cache.getData(tag)).getWebId()
				+"/recorded?maxCount="+maxCount
				+"&selectedFields=Items.Value%3BItems.Timestamp"
				+"&startTime="+inicio+":00Z"
				+"&endTime=" +fim+":00Z";
		
//			+"/recorded?selectedFields=Items.Value%3BItems.Timestamp&startTime=03%2F03%2F2022%209%3A00%3A00&endTime=03%2F04%2F2022%2012%3A00%3A00";
		
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create(uri))
			    .header("Authorization", "Basic #################")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		
		try {
			
			JsonObject jsonobject = jsonFromString(getResponse(request).body().toString());
			
			jsonobject.get("Items").asJsonArray().forEach(o -> ((PIValue) cache.getData(tag)).addValor(parseValues(o)));
			
			jsonobject.get("Items").asJsonArray().forEach(
					o -> ((PIValue) cache.getData(tag)).addTimestamp(
								LocalDateTime.parse(o.asJsonObject().get("Timestamp").toString().replaceAll("[A-Z]|\"", "").subSequence(0, 18), 
													DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss")))
			);
			
			// Sempre setar referencia para facilitar remocao sincronizada
			((PIValue) cache.getData(tag)).setReferencia();
			cache.setData(tag, metodoTratamento.trata( (PIValue) cache.getData(tag)));
			
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Nome de tag invalida!");
			System.out.println(e.toString());
		}
	}
	
	// Reader dedicado a converter json em string, elimina boilerplate:
	public static JsonObject jsonFromString(String jsonObjectStr) {
	    JsonReader jsonReader = Json.createReader(new StringReader(jsonObjectStr));	    
	    JsonObject object = jsonReader.readObject();
	    jsonReader.close();
	    return object;
	}
	
	// Constroi cliente HTTP com contexto SSL especifico, elimina boilerplate:
	public static HttpResponse<String> getResponse(HttpRequest request) throws IOException, InterruptedException{
		HttpResponse<String> response = HttpClient.newBuilder().sslContext(HttpRequester.sslContext).build().send(request, HttpResponse.BodyHandlers.ofString());
		return response;
	}
	
	//TODO: abstrair/refatorar para qualquer variavel, usar flags melhores para valores invalidos  
	private static float parseValues(JsonValue o) {
		if (o.asJsonObject().get("Value").getValueType().toString().compareTo("NUMBER") ==0 ) {
			return Float.parseFloat(o.asJsonObject().get("Value").toString());
		} else {
			return -1f;
		}
	}
	
}
