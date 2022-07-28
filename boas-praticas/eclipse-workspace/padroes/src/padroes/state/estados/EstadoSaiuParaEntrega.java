package padroes.state.estados;

import padroes.state.Pedido;

public class EstadoSaiuParaEntrega extends Estado {

	private String nome = "SAIU_PARA_ENTREGA";
	
	public EstadoSaiuParaEntrega(Pedido pedido) {
		super(pedido);
	}

	@Override
	public String criar() {
		return "Pedido ("+pedido.getNome()+") ja foi criado e saiu para entrega.";
	}

	@Override
	public String preparar() {
		return "Pedido ("+pedido.getNome()+") ja foi preparado e saiu para entrega.";
	}

	@Override
	public String enviar() {
		return "Pedido ("+pedido.getNome()+") ja saiu para entrega.";
	}

	@Override
	public String fechar() {
		pedido.mudarEstado(new EstadoEntregue(pedido));
		return "Pedido ("+pedido.getNome()+") fechado (entregue).";
	}

	@Override
	public String getNome() {
		return this.nome;
	}


}
