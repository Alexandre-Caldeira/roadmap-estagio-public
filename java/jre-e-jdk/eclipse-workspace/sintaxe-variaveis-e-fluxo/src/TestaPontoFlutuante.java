
public class TestaPontoFlutuante {

	public static void main(String[] args) {
		double salario;
		salario = 1250.70;
		System.out.println("O sal�rio � " + salario);
		
		double idade =37; // int em double funciona, n�o o contr�rio.
		// int naoPode = 3.14; // n�o funciona
		
		double divisao = 3.14 /2;
		System.out.println(divisao);
		
		int outraDivisao = 5/2; // divis�o inteira � truncada
		System.out.println(outraDivisao);
		
		double novaTentativa = 5/2;
		System.out.println(novaTentativa);	// resulta em 2.0 pois a 
											// evaluation ocorre da 
											// direita para esquerda.
		
		double agoraVai = 5.0/2;
		System.out.println(agoraVai);
		
	}
}
