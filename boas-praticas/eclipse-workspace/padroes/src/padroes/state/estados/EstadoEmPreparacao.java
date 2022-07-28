package padroes.state.estados;

import padroes.state.Pedido;

public class EstadoEmPreparacao extends Estado {

	private String nome = "EM_PREPARACAO";
	
	public EstadoEmPreparacao(Pedido pedido) {
		super(pedido);
	}

	@Override
	public String criar() {
		return "Ja foi criado e esta em preparacao!";
	}

	@Override
	public String preparar() {
		return "Pedido ("+pedido.getNome()+") comecou a ser preparado.";
	}

	@Override
	public String enviar() {
		pedido.mudarEstado(new EstadoSaiuParaEntrega(pedido));
		return "Pedido ("+pedido.getNome()+") saiu para entrega.";
	}

	@Override
	public String fechar() {
		return "Ainda esta em preparacao!";
	}

	@Override
	public String getNome() {
		return this.nome;
	}


}
