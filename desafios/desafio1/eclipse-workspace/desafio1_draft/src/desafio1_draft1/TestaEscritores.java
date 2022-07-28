package desafio1_draft1;

public class TestaEscritores {
	public static void main(String[] args) {
		EscritorDeTexto edtxt = new EscritorDeTexto(5);
		
		edtxt.mostraDados();
		
		int idx = 0;
		edtxt.setDado(4, idx++);
		edtxt.setDado(3, idx++);
		edtxt.setDado(8, idx++);
		edtxt.setDado(1, idx++);
		edtxt.setDado(2, idx++);
		
		edtxt.mostraDados();
		
		System.out.println(edtxt.getMedia());
	
		EscritorDeTabela edtab = new EscritorDeTabela(1);
		edtab.mostraDados();
		edtxt.mostraDados();
	}
}
