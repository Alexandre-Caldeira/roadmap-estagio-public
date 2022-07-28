package desafio1;

public abstract class Analista { // nao pode ser instanciada
	protected float media;
	protected Registro registro;
	protected String caminho = "";
	
	public Analista(SessaoUI sessao) {
		// Analistas precisam dos seus dados!
		this.registro = sessao.registro;
	}
	
	public float calculaMedia() {
		float soma=0;
		for(int c = 0; c < registro.getDadosInformados().length; c++) {
			soma+= registro.getDado(c);
		}
		
		// reseta atributo media e retorna
		this.media = soma/registro.getDadosInformados().length;
		return this.media;
	} 
	
	public String getMedia() {
		// verifica que media foi calculada, formata string e retorna:
		this.calculaMedia();
		String strMedia =String.format( "%f" ,this.media).replace(".", ",");
		
		// TODO remove trailing zeros with .replaceAll("0", "")+"0" ?
		
		return strMedia;
	}
	
	// TODO: certificar que caminho faz sentido / existe, add GUI
	public String getCaminhoPadrao() {
		return caminho;
	}
	
	public void setCaminhoPadrao(String caminhoPadrao) {
		this.caminho = caminhoPadrao;
	}
	
}
