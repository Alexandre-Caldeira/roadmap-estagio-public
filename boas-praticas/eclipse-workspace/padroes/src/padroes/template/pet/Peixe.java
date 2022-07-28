package padroes.template.pet;

public class Peixe extends Pet{

	public Peixe(String nome) {
		super(nome);
	}

	public boolean estaSujo() {
		System.out.println("Peixa nao toma banho! Lave o aquario.");
		return false;
	}
 
	public void pegarPet(){}
	public void molharPet(){}
	public void passarShampoo(){}
	public void secarPet(){}
	public void passarPerfume(){}
	public void guardarPet(){}

}
