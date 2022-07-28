package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class TestaWrappers {
	public static void main(String[] args) {
		
		int[] idades = new int[5];
		String[] nomes = new String[5];
		
		int idade = 29;
		List numeros = new ArrayList();
		numeros.add(29); // autoboxing 
		
		Integer idadeRef = Integer.valueOf(29); // autoboxing
		int valor = idadeRef.intValue(); // unboxing
				
		List<Integer> numeros2 = new ArrayList<Integer>();
		numeros2.add(29); // Autoboxing
		
		String s = args[0];
		System.out.println(Integer.parseInt(s)); // parsing
		System.out.println(idadeRef.doubleValue());
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.SIZE);
		System.out.println(Integer.BYTES);
		
        Double dRef = Double.valueOf(3.2);//autoboxing
        System.out.println(dRef.doubleValue());//unboxing

        Boolean bRef = Boolean.FALSE;
        System.out.println(bRef.booleanValue());

        Number refNumero = Integer.valueOf(29);

        List<Number> lista = new ArrayList<>();
        lista.add(10);
        lista.add(32.6);
        lista.add(25.6f);
	}
}
