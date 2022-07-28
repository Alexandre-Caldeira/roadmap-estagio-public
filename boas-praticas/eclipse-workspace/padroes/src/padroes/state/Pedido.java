package padroes.state;

import padroes.state.estados.Estado;
import padroes.state.estados.EstadoCriado;

public class Pedido {
	protected Estado estado; // protected para usar no Observer
	private String nome;
	
	public Pedido(String nome) {
		// inicia pedido, criando:
		this.nome = nome;
		this.estado = new EstadoCriado(this);
	}

	public void mudarEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String criarPedido() {
		return estado.criar();
	}
	
	public String prepararPedido() {
		return estado.preparar();
	}
	
	public String enviarPedido() {
		return estado.enviar();
	}
	
	public String fecharPedido() {
		return estado.fechar();
	}
	
	// getters e setters
	public String getEstado() {
		return estado.getNome();
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
