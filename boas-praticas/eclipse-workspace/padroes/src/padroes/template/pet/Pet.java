package padroes.template.pet;

public abstract class Pet {
	
	public String nome;
	
	public Pet(String nome) {
		this.nome = nome; 
	}
	
	// passos para dar banho (TEMPLATE)
	public void darBanho() {
		
		if (estaSujo()) {
			pegarPet();
			molharPet();
			passarShampoo();
			secarPet();
			passarPerfume();
			guardarPet();
		}
		
	} 
	
	// cada etapa para ser executada
	public abstract boolean estaSujo();
	public abstract void pegarPet();
	public abstract void molharPet();
	public abstract void passarShampoo();
	public abstract void secarPet();
	public abstract void passarPerfume();
	public abstract void guardarPet();
}
