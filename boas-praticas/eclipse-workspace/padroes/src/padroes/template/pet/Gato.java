package padroes.template.pet;


public class Gato extends Pet{

	public Gato(String nome) {
		super(nome);
	}

	public boolean estaSujo() {
		return true; 
	}

	public void pegarPet(){
		System.out.println("Correndo atras de "+ this.nome+".");
	}
	
	public void molharPet(){
		System.out.println("Molhando "+ this.nome+".");
	}
	
	public void passarShampoo(){
		System.out.println("Passando shampoo em "+ this.nome+".");
	}
	public void secarPet(){
		// nao precisa secar o gato
	}
	public void passarPerfume(){
		// gato odeia perfume
	}
	
	public void guardarPet(){
		System.out.println("Soltando "+this.nome+".");
	}
}
