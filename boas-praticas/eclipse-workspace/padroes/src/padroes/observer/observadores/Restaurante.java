package padroes.observer.observadores;

import padroes.state.estados.Estado;

public class Restaurante implements Observador {

	@Override
	public void update(String evento, Estado estado) {
		String mensagem;
		switch (evento){
			case "CRIADO":
				mensagem = "Restaurante: vou inicar preparacao do pedido.";
				break;
			case "ENTREGUE":
				mensagem = "Restaurante: vou fechar pedido.";
				break;
			default:
				mensagem = "Restaurante: evento "+evento+" nao me interessa.";
				break;
		}
		
		System.out.println(mensagem);
	}

}
