package padroes.observer.observadores;

import padroes.state.estados.Estado;

public class Entregador implements Observador{

	@Override
	public void update(String evento, Estado estado) {
		String mensagem;
		switch (evento){
			case "EM_PREPARACAO":
				mensagem = "Entregador: vou pegar pedido.";
				break;
			default:
				mensagem = "Entregador: evento "+evento+" nao me interessa.";
				break;
		}
		
		System.out.println(mensagem);
	}
	
}
