package padroes.observer.observadores;

import padroes.state.estados.Estado;

public class Consumidor implements Observador {

	@Override
	public void update(String evento, Estado estado) {
		String mensagem;
		switch (evento){
			case "SAIU_PARA_ENTREGA":
				mensagem = "Cliente: vou buscar pedido.";
				break;
			default:
				mensagem = "Cliente: evento "+evento+" nao me interessa.";
				break;
		}
		
		System.out.println(mensagem);
	}

}
