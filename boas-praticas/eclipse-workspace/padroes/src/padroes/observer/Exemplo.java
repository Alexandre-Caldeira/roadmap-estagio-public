package padroes.observer;

import padroes.observer.observadores.Consumidor;
import padroes.observer.observadores.Entregador;
import padroes.observer.observadores.Restaurante;

//  Aplicativo de entregas
public class Exemplo {
	
	public static void main(String[] args) {
		
		String[] eventos = {"CRIADO","EM_PREPARACAO","SAIU_PARA_ENTREGA","ENTREGUE"};
		PedidoNotificavel pizza = new PedidoNotificavel("pizza",eventos);
		
		Restaurante restaurante = new Restaurante();
		
		pizza.eventos.subscribe("CRIADO", restaurante);
		pizza.eventos.subscribe("ENTREGUE", restaurante);
		pizza.eventos.subscribe("SAIU_PARA_ENTREGA", new Consumidor());
		pizza.eventos.subscribe("EM_PREPARACAO", new Entregador());
		
		
		System.out.println(pizza.prepararPedido());	
		System.out.println(pizza.enviarPedido());
		System.out.println(pizza.fecharPedido());
		
	}

}
