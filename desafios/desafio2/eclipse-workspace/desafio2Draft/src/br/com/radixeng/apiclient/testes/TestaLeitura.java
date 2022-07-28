package br.com.radixeng.apiclient.testes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.json.JsonObject;
import javax.json.JsonValue;

import br.com.radixeng.apiclient.modelo.ClientCache;
import br.com.radixeng.apiclient.modelo.HttpRequester;
import br.com.radixeng.apiclient.modelo.PIValue;
import br.com.radixeng.apiclient.modelo.SessaoUI;

public class TestaLeitura {
	
	public static void main(String[] args) {
		
		SessaoUI ui = new SessaoUI();
		HttpRequester requeridor = new HttpRequester();
		ClientCache cache = ui.getClientCache();
		
		String tag = "SINUSOID";
		ui.getClientCache().setTag(tag, new PIValue());
		ui.getClientCache().getPIValue(tag).setWebId(requeridor.getWebId(tag));

		String uri = "XXXXXXXXXXX/piwebapi/streams/"+cache.getPIValue(tag).getWebId()
				+"/recorded?maxCount=10&selectedFields=Items.Value%3BItems.Timestamp&startTime=-2y";
	
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create(uri))
			    .header("Authorization", "Basic XXXXXXXXXXXXXXXXXXXXXXXX")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		
		HttpResponse<String> response;
		try {
			
			JsonObject jsonobject = HttpRequester.jsonFromString(requeridor.getResponse(request).body().toString());
	
//			jsonobject.get("Items").asJsonArray().forEach(
//					o -> cache.getPIValue(tag).addValor(Float.parseFloat(o.asJsonObject().get("Value").toString())));
			
//			cache.getPIValue(tag).addValor(Float.parseFloat(o.asJsonObject().get("Value").toString()))
//			cache.getPIValue(tag).addValor(
			
//			 System.out.println(parseValues(o.asJsonObject().get("Value"))) 
			jsonobject.get("Items").asJsonArray().forEach(o -> System.out.println(parseValues(o)));
			
			
			
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Nome de tag invalida!");
			System.out.println(e.toString());
		}
	}
	
	public static float parseValues(JsonValue o) {
		if (o.asJsonObject().get("Value").getValueType().toString().compareTo("NUMBER") ==0 ) {
			return Float.parseFloat(o.asJsonObject().get("Value").toString());
		} else {
			return -1f;
		}
	}

}
