package padroes.state.estados;

import padroes.state.Pedido;

public abstract class Estado {
	protected Pedido pedido;
	private String nome;
	
	public Estado(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public abstract String criar();		// onCreate()
	public abstract String preparar();	// onPrepare()
	public abstract String enviar();	// onSend()
	public abstract String fechar();	// onClose()
	public abstract String getNome();
}