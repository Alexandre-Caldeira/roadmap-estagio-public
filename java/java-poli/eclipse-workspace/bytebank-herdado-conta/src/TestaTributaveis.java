
public class TestaTributaveis {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(222,333);
		cc.deposita(100.0);
		
		SeguroDeVida sdv = new SeguroDeVida();
		
		CalculadorDeImposto cdv = new CalculadorDeImposto();
		cdv.registra(cc);
		cdv.registra(sdv);
		
		System.out.println(cdv.getTotalImposto());
	}
}
