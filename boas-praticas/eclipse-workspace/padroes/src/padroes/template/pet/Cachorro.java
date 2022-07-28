package padroes.template.pet;

public class Cachorro extends Pet{

	public Cachorro(String nome) {
		super(nome);
	}

	public boolean estaSujo() {
		return true;
	}
 
	public void pegarPet(){
		System.out.println("Correndo atras de "+ this.nome+".");
	}
	
	public void molharPet(){
		System.out.println("Molhando "+ this.nome);
	}
	
	public void passarShampoo(){
		System.out.println("Passando shampoo em "+ this.nome+".");
	}
	
	public void secarPet(){
		System.out.println("Secando "+ this.nome+".");
	}
	
	public void passarPerfume(){
		System.out.println("Perfumando "+ this.nome+".");
	}
	
	public void guardarPet(){
		System.out.println("Guardando "+this.nome+" na casinha.");
	}

}
