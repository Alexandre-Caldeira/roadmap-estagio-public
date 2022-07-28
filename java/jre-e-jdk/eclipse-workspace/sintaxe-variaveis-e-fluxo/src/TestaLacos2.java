
public class TestaLacos2 {

	public static void main(String[] args) {
		/* funciona
		for (int linha = 0; linha <10; linha++) {
			for (int coluna = 0; coluna <10; coluna++) {
				if (coluna > linha) {
					break;
				}
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		// Também funciona:
		for (int linha = 0; linha <10; linha++) {
			for (int coluna = 0; coluna <= linha; coluna++)
				System.out.print("*");
			System.out.println();
		}
	}
}
