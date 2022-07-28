package br.com.radixeng.apiclient.modelo;

public class TesterTag {
	private String nomeTag;
	private String WebId ="INDEFINIDO";
	
	public TesterTag(String nomeTag) {
		this.nomeTag = nomeTag;
	}
	public String getNome() {
		return this.nomeTag;	
	}
	public void setNome(String nomeNovo) {
		this.nomeTag = nomeNovo;
	}
	public String getWebId() {
		return this.WebId;
	}
	public void setWebId(String newId) {
		this.WebId = newId;
	}
}
