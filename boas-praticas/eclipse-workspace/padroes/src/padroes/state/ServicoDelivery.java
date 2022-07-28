package padroes.state;

public class ServicoDelivery {
	public static void main(String[] args) {
		Pedido pizza = new Pedido("pizza");
		
//		System.out.println(pizza.getEstado());

//		System.out.println(pizza.criarPedido());
		
		System.out.println(pizza.prepararPedido());
		
//		System.out.println(pizza.criarPedido());
		
		System.out.println(pizza.enviarPedido());
		
		System.out.println(pizza.fecharPedido());
		
	}
}
