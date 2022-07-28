package padroes.state.estados;

import padroes.state.Pedido;

public class EstadoCriado extends Estado {
	
	private String nome = "CRIADO";
	
	public EstadoCriado(Pedido pedido) {
		super(pedido);
		System.out.println("Criando pedido... ("+pedido.getNome()+")");
	}

	@Override
	public String criar() {
		return "Pedido ("+pedido.getNome()+") ja foi criado.";
	}

	@Override
	public
	String preparar() {
		pedido.mudarEstado(new EstadoEmPreparacao(pedido));
		String acao = pedido.prepararPedido();
		return acao;
	}

	@Override
	public String enviar() {
		// logica de envio de pedido
		return "Pedido criado ("+pedido.getNome()+") nao exige preparacao, enviando...";
	}

	@Override
	public String fechar() {
		// logica para cancelar pedido...
		return "Cancelando pedido criado ("+pedido.getNome()+"), fechando...";
	}

	@Override
	public String getNome() {
		return this.nome;
	}


}
