package br.com.radixeng.apiclient.modelo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.math3.util.Pair;

public class PIValue implements IValue {
	
	private LinkedList<Float> valores;
	private LinkedList<LocalDateTime> timestamps;
	private String WebId;
	private String Unidade;
	private Map<Integer,Pair<LocalDateTime,Float>> referencia; // Interface para o ClientCache e Usuario
	
	public PIValue() {
		this.valores = new LinkedList<Float>();
		this.timestamps = new LinkedList<LocalDateTime>();
	}
	
	// Getters
	public LinkedList<Float> getValores() {
		return valores;
	}	
	public LinkedList<Float> getValor() {
		return valores;
	}
	public LinkedList<LocalDateTime> getTimestamps() {
		return timestamps;
	}
	public Map<Integer, Pair<LocalDateTime, Float>> getReferencia() {
		return referencia;
	}
	public String getWebId() {
		return WebId;
	}
	public String getUnidade() {
		return this.Unidade;
	}
	
	// Setters
	public void addTimestamp(LocalDateTime timestamp) {
		this.timestamps.add(timestamp);
	}
	public void addValor(Float val) {
		this.valores.add(val);
	}
	public void setWebId(String webId) {
		WebId = webId;
	}
	public void setUnidade(String unidade) {
		Unidade = unidade;
	}
	
	public void setReferencia() {			// Deve ser chamado sempre ao final de buscarDados (HttpRequester) 
		this.referencia= new HashMap<>();
		
		Iterator<Float> itV = valores.iterator();
		Iterator<LocalDateTime> itT = timestamps.iterator();
		int c = 0;
		while(itV.hasNext()){
			referencia.put(c++, new Pair<LocalDateTime,Float>(itT.next(),itV.next()));
		}
	}
	
	public void resetUsandoReferencia(){
		timestamps.clear();
		valores.clear();

		referencia.forEach(
			(chave, par) -> {
				valores.add(par.getValue());	
				timestamps.add(par.getKey());		
			}
		);	
	}
	
	public void remove(Float valor){	
		referencia.forEach(
			(chave, par) -> {
				if (par.getValue()==valor) {
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
	
}
