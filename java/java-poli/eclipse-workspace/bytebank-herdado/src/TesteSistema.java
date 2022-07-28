
public class TesteSistema {

	public static void main(String[] args) {
		Gerente g = new Gerente();
		g.setSenha(3333);
		
		SistemaInterno si = new SistemaInterno();
		si.autentica(g);
		
		Administrador adm = new Administrador();
		adm.setSenha(2222);
		si.autentica(adm);

	}
}
