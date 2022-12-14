package bytebank;

public class CriaConta {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 200;
		System.out.println("Saldo: "+primeiraConta.saldo+"\n");
		
		// recebe salario
		primeiraConta.saldo += 100;
		System.out.println("Saldo atual: "+primeiraConta.saldo+"\n");
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = 50;
		System.out.println("Primeira conta tem saldo : "+primeiraConta.saldo);
		System.out.println("Segunda conta tem saldo : "+segundaConta.saldo);
		
		// Instanciacao inicia com zero:
		System.out.println("\n"+primeiraConta.agencia); 
		System.out.println(primeiraConta.numero);
		
		segundaConta.agencia = 146;
		System.out.println(segundaConta.agencia);
		
		// instanciacao sem default: 
		// double: 0.0 / int: 0 / boolean: false / char: 0x
		
		if (primeiraConta == segundaConta) {
			System.out.println("mesma conta");
		}else {
			System.out.println("contas diferentes");
		}
		System.out.println(primeiraConta);
		System.out.println(segundaConta);
	}
}
