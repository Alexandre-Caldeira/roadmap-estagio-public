
public class TestaValores {

	public static void main(String[] args) {
		int primeiro = 5;
		int segundo = 7;
		segundo = primeiro;
		primeiro = 10;
		
		System.out.println(segundo);	// passa por c�pia (valor) 
										// diferente de Python (por ref.)
	}
}
