package padroes.state.estados;

import padroes.state.Pedido;

public class EstadoEntregue extends Estado {
	
	private String nome = "ENTREGUE";
	
	public EstadoEntregue(Pedido pedido) {
		super(pedido);
	}
	
	private String mensagemJaFoiEntregue() {
		return "Pedido "+pedido.getNome()+") fechado (ja foi entregue).";
	}

	@Override
	public String criar() {
		return mensagemJaFoiEntregue();
	}

	@Override
	public String preparar() {
		return mensagemJaFoiEntregue();
	}

	@Override
	public String enviar() {
		return mensagemJaFoiEntregue();
	}

	@Override
	public String fechar() {
		return mensagemJaFoiEntregue();
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
