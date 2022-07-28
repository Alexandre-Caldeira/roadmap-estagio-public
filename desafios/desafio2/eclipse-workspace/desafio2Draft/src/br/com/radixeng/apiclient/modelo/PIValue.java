package br.com.radixeng.apiclient.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.json.JsonObject;

import org.apache.commons.math3.util.Pair;

public class PIValue {
	
	
	private LinkedList<Float> valores;
	private LinkedList<LocalDateTime> timestamps;
	private String WebId;
	private String Unidade;
	private Map<Integer,Pair<LocalDateTime,Float>> referencia;
	//TODO: refatorar ClientCache para acessar sempre pela referencia?
	
	public PIValue() {
		this.valores = new LinkedList<Float>();
		this.timestamps = new LinkedList<LocalDateTime>();
	}

	public void mostraDadosConsole() {
		Iterator<Float> itV = valores.iterator();
		Iterator<LocalDateTime> itT = timestamps.iterator();
		
		while(itV.hasNext()){
		       System.out.println(itV.next().toString()+ " -> " + itT.next().toString());
		}
	}
	
	public LinkedList<LocalDateTime> getTimestamps() {
		return timestamps;
	}

	public void addTimestamp(LocalDateTime timestamp) {
		this.timestamps.add(timestamp);
	}
	
	public void addValor(Float val) {
		this.valores.add(val);
	}
	
	public LinkedList<Float> getValores() {
		return valores;
	}
	
	public LinkedList<Float> getValor() {
		return valores;
	}
	
	
	public void remove(Float valor){	
		referencia.forEach(
			(chave, par) -> {
				if (par.getValue()==valor) {
					System.out.println(par.getValue());
					valores.removeFirstOccurrence(par.getValue());
					timestamps.removeFirstOccurrence(par.getKey());
				}
			}
	    );
		this.setReferencia();
	}
	
	public void remove(LocalDateTime data){
		this.getReferencia().forEach(
			(chave, par) -> {
				if(par.getKey().equals(data)) {
					valores.removeFirstOccurrence(par.getValue());
					timestamps.removeFirstOccurrence(par.getKey());
				}
			}
	    );
		this.setReferencia();
	}

	public String getWebId() {
		return WebId;
	}

	public void setWebId(String webId) {
		WebId = webId;
	}

	public String getUnidade() {
		return this.Unidade;
	}
	public void setUnidade(String unidade) {
		Unidade = unidade;
	}

	public void setReferencia() {
		this.referencia= new HashMap<>();
		
		Iterator<Float> itV = valores.iterator();
		Iterator<LocalDateTime> itT = timestamps.iterator();
		int c = 0;
		while(itV.hasNext()){
			referencia.put(c++, new Pair<LocalDateTime,Float>(itT.next(),itV.next()));
		}
	}
	public Map<Integer, Pair<LocalDateTime, Float>> getReferencia() {
		return referencia;
	}
	
}
