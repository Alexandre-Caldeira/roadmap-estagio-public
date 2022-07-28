package padroes.observer;

import padroes.state.Pedido;
import padroes.state.estados.Estado;

//Concrete Publisher
public class PedidoNotificavel extends Pedido {

	public ServidorDelivery eventos; // EventManager events
	
	public PedidoNotificavel(String nome, String[] eventos) {
		super(nome);
		this.eventos = new ServidorDelivery(eventos);
	}
	
	@Override
	public void mudarEstado(Estado estado) {
		this.estado = estado;
		eventos.notify(getEstado(), estado);
	}

}
