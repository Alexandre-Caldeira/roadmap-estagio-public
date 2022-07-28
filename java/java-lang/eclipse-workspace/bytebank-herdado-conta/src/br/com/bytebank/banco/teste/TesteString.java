package br.com.bytebank.banco.teste;

public class TesteString {
	public static void main(String[] args) {
		String nome = "Alura";
		String nome2 = new String("Alura");

		nome.replace("A","a");
		System.out.println(nome);
		
		nome2 = nome.replace("A","a");	
		System.out.println(nome2);
	}
}
