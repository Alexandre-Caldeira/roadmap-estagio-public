package br.com.radixeng.apiclient.modelo;

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


//Possiveis casos de refatoracao:
//	- Novo dataserver tem mais de uma tag com nomes usados aqui
//	- Resposta JSON do requerimento mudou de estrutura e WebId nao se encontra onde buscamos
public class HttpRequester {
	
	public static SSLContext sslContext;
	
	// Construtor inicia Builder de HttpClient sem validacao de certificado: 
	public HttpRequester() {
		// https://gist.github.com/matthewromano/4178946
		// Cria TrustManager que aceita qualquer certificado (ignora validacao de cert.):
		TrustManager[] trustAllCerts = new TrustManager[] {(TrustManager) new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {return null;}
            public void checkClientTrusted(X509Certificate[] certs, String authType) {}
            public void checkServerTrusted(X509Certificate[] certs, String authType) {}
        	}
	    };
		
		//TODO: melhorar NoSuchAlgorithmException display
		// Cria contexto SSL com TrustManager definido:
		try {
			this.sslContext = SSLContext.getInstance("SSL");
		} catch (NoSuchAlgorithmException ex1) {
			ex1.printStackTrace();
		}
	    
	    //TODO: melhorar KeyManagementException display
	    try {
	    	this.sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
		} catch (KeyManagementException ex2) {
			ex2.printStackTrace();
		}
	    
	}
	
	public static void buscarDados(String tag, LocalDateTime inicio, LocalDateTime fim, ClientCache cache){

		// Do Insomnia, usa token de autenticacao gerado para acessar a API (verifique conexao com VPN):
		//TODO: abstrair maxCount
		String uri = "XXXXXXXXXXX/piwebapi/streams/"+cache.getPIValue(tag).getWebId()
				+"/recorded?maxCount=1000"
				+"&selectedFields=Items.Value%3BItems.Timestamp"
				+"&startTime="+inicio+":00Z"
				+"&endTime=" +fim+":00Z";
//		+"/recorded?selectedFields=Items.Value%3BItems.Timestamp&startTime=03%2F03%2F2022%209%3A00%3A00&endTime=03%2F04%2F2022%2012%3A00%3A00";
		
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create(uri))
			    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		
		HttpResponse<String> response;
		try {
			
			JsonObject jsonobject = jsonFromString(getResponse(request).body().toString());
			// Para cada item do JSON recebido do requerimento, guardar no cache da tag especifica o valor:
			
			//TODO: fix java.lang.NumberFormatException
			// when "{"Name":"Shutdown","Value":254,"IsSystem":true}"
			jsonobject.get("Items").asJsonArray().forEach(o -> cache.getPIValue(tag).addValor(parseValues(o)));
			
			// Para cada item do JSON recebido do requerimento, remover via regex letras e " da string 
			// Timestamp, transformar em Local datetime e guardar no cache da tag especifica:
			jsonobject.get("Items").asJsonArray().forEach(
					o -> cache.getPIValue(tag).addTimestamp(
								LocalDateTime.parse(o.asJsonObject().get("Timestamp").toString().replaceAll("[A-Z]|\"", ""), 
													DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss")))
			);
			
			cache.getPIValue(tag).setReferencia();
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Nome de tag invalida!");
			System.out.println(e.toString());
		}
	}
	
	public static void buscarDados(String tag, LocalDateTime inicio, LocalDateTime fim, ClientCache cache, IMethod metodoTratamento){
		// Do Insomnia, usa token de autenticacao gerado para acessar a API (verifique conexao com VPN):
		//TODO: abstrair maxCount
		String uri = "XXXXXXXXXXX/piwebapi/streams/"+cache.getPIValue(tag).getWebId()
				+"/recorded?maxCount=1000"
				+"&selectedFields=Items.Value%3BItems.Timestamp"
				+"&startTime="+inicio+":00Z"
				+"&endTime=" +fim+":00Z";
//			+"/recorded?selectedFields=Items.Value%3BItems.Timestamp&startTime=03%2F03%2F2022%209%3A00%3A00&endTime=03%2F04%2F2022%2012%3A00%3A00";
		
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create(uri))
			    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		
		HttpResponse<String> response;
		try {
			
			JsonObject jsonobject = jsonFromString(getResponse(request).body().toString());
			// Para cada item do JSON recebido do requerimento, guardar no cache da tag especifica o valor:
			
			//TODO: fix java.lang.NumberFormatException
			// when "{"Name":"Shutdown","Value":254,"IsSystem":true}"
			jsonobject.get("Items").asJsonArray().forEach(o -> cache.getPIValue(tag).addValor(parseValues(o)));
			
			// Para cada item do JSON recebido do requerimento, remover via regex letras e " da string 
			// Timestamp, transformar em Local datetime e guardar no cache da tag especifica:
			jsonobject.get("Items").asJsonArray().forEach(
					o -> cache.getPIValue(tag).addTimestamp(
								LocalDateTime.parse(o.asJsonObject().get("Timestamp").toString().replaceAll("[A-Z]|\"", ""), 
													DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss")))
			);
//			jsonobject.get("Items").asJsonArray().forEach(
//					o -> cache.getPIValue(tag).addTimestamp(
//								LocalDateTime.parse(o.asJsonObject().get("Timestamp").toString().replaceAll("[A-Z]|\"", ""), 
//											new DateTimeFormatterBuilder().appendPattern("yyyy-MM-ddHH:mm:ss").appendPattern("yyyy-MM-ddHH:mm:SS").toFormatter()))
//			);
//			jsonobject.get("Items").asJsonArray().forEach(
//			o -> cache.getPIValue(tag).addTimestamp(
//						LocalDateTime.parse(o.asJsonObject().get("Timestamp").toString().replaceAll("[A-Z]|\"", ""), 
//											DateTimeFormatter.ofPattern("[yyyy-MM-ddHH:mm:ss]|[yyyy-MM-ddHH:mm:SS]")))
//			);
			
			cache.getPIValue(tag).setReferencia();
			
			cache.setTag(tag, metodoTratamento.trata(cache.getPIValue(tag)));
			
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Nome de tag invalida!");
			System.out.println(e.toString());
		}
	}
	
	//TODO: transformar em "buscarDados"
	// populaCache com dados de 2hrs atras
	public void popularCache(String tag, ClientCache cache) {
		
		
		// Do Insomnia, usa token de autenticacao gerado para acessar a API (verifique conexao com VPN): 
		String uri = "XXXXXXXXXXX/piwebapi/streams/"+cache.getPIValue(tag).getWebId()
				+"/recorded?maxCount=10&selectedFields=Items.Value%3BItems.Timestamp&startTime=-2y";
//		+"/recorded?selectedFields=Items.Value%3BItems.Timestamp&startTime=03%2F03%2F2022%209%3A00%3A00&endTime=03%2F04%2F2022%2012%3A00%3A00";
		
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create(uri))
			    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		
		HttpResponse<String> response;
		try {
			
			JsonObject jsonobject = jsonFromString(getResponse(request).body().toString());
			// Para cada item do JSON recebido do requerimento, guardar no cache da tag especifica o valor:
			
			//TODO: fix java.lang.NumberFormatException
			// when "{"Name":"Shutdown","Value":254,"IsSystem":true}"
			jsonobject.get("Items").asJsonArray().forEach(o -> cache.getPIValue(tag).addValor(parseValues(o)));
			
			// Para cada item do JSON recebido do requerimento, remover via regex letras e " da string 
			// Timestamp, transformar em Local datetime e guardar no cache da tag especifica:
			jsonobject.get("Items").asJsonArray().forEach(
					o -> cache.getPIValue(tag).addTimestamp(LocalDateTime.parse(o.asJsonObject().get("Timestamp").toString().replaceAll("[A-Z]|\"", ""), DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss")))
			);
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Nome de tag invalida!");
			System.out.println(e.toString());
		}
	}
	
	private static float parseValues(JsonValue o) {
		if (o.asJsonObject().get("Value").getValueType().toString().compareTo("NUMBER") ==0 ) {
			return Float.parseFloat(o.asJsonObject().get("Value").toString());
		} else {
			return -1f;
		}
	}
	
	//TODO: abstrair autenticacao, tratar 404 e 400:
	public String getWebId(String tag){	
		
		// Constroi uri de pedido para GET WebId da tag dada: 
		String uri = "XXXXXXXXXXX/piwebapi/search/query?q=name%3A"+tag;
		
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create(uri))
			    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		
		// Envia requerimento GET HTTP:
		//TODO: melhorar display das excecoes de HTTP Request/Response
		//TODO: refatorar para closeable client
		//DONE: fix java.lang.IndexOutOfBoundsException: Index 0 para query bem-sucedida vazia
		HttpResponse<String> response;
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

	// https://stackoverflow.com/questions/9151619/how-to-iterate-over-a-jsonobject
	// https://stackoverflow.com/questions/25948000/how-to-convert-string-to-jsonobject
	public static JsonObject jsonFromString(String jsonObjectStr) {

	    JsonReader jsonReader = Json.createReader(new StringReader(jsonObjectStr));
	    
	    JsonObject object = jsonReader.readObject();
	    jsonReader.close();

	    return object;
	}
	
	public static HttpResponse<String> getResponse(HttpRequest request) throws IOException, InterruptedException{
		 // constroi cliente HTTP com contexto SSL que ignora validacao de certificado e faz requerimento:
		HttpResponse<String> response = HttpClient.newBuilder().sslContext(HttpRequester.sslContext).build().send(request, HttpResponse.BodyHandlers.ofString());
		return response;
	}

	public String getUnidade(String tag) {

		// Constroi uri de pedido para GET WebId da tag dada: 
		String uri = "XXXXXXXXXXX/piwebapi/search/query?q=name%3A"+tag;
		
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create(uri))
			    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		
		// Envia requerimento GET HTTP:
		//TODO: melhorar display das excecoes de HTTP Request/Response
		//TODO: refatorar para closeable client
		//DONE: fix java.lang.IndexOutOfBoundsException: Index 0 para query bem-sucedida vazia
		HttpResponse<String> response;
		try {
			
			JsonObject jsonobject = jsonFromString(getResponse(request).body().toString());
			
			return jsonobject.get("Items").asJsonArray().get(0).asJsonObject().getString("UoM");
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return "";
		} catch (IndexOutOfBoundsException e) {
			
			System.out.println("Nome de tag invalida!");
			System.out.println(e.toString());
			return "";
		} catch (NullPointerException en) {
			System.out.println("Tag "+tag+" nao possui unidade.");
			return "";
		}
	}
	
}
