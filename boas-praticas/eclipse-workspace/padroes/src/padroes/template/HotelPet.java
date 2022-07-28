package padroes.template;

import padroes.template.pet.Cachorro;
import padroes.template.pet.Gato;
import padroes.template.pet.Peixe;
import padroes.template.pet.Pet;

public class HotelPet { 
	public static void main(String[] args) {
		Cachorro diana = new Cachorro("Diana");
		Gato juma = new Gato("Juma");
		Peixe dourado = new Peixe("Dourado");
		
		Pet[] pets = {diana, juma, dourado};
		for (Pet p: pets) {
			p.darBanho();
			System.out.println();
		}
	}
}
