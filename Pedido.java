public class Pedido{
	int numero;
	Cliente cliente;
	java.time.LocalDate dataPedido;
	float preco;
	java.time.LocalDate dataEntrega;

	Pedido(int pNumero, Cliente pCliente, float pPreco){
		numero = pNumero;
		cliente = pCliente;
		preco = pPreco;
		dataPedido = java.time.LocalDate.now();
		dataEntrega = java.time.LocalDate.now();
		dataEntrega = dataEntrega.plusDays(14);
	}

	Pedido(int pNumero, Cliente pCliente, float pPreco, java.time.LocalDate pDataEntrega){
		numero = pNumero;
		cliente = pCliente;
		preco = pPreco * 1.20f;
		dataPedido = java.time.LocalDate.now();
		dataEntrega = java.time.LocalDate.now();
	}

	public boolean EntregueNoPrazo(){
		if(dataEntrega.isEqual(dataPedido)){
			return true;
		}
		else{
			return false;
		}
	}

	public void toString(Pedido pedido){
		System.out.println("Nome: " + pedido.cliente.nome);
		System.out.println("Preco: " + pedido.preco);
		System.out.println("Entregue no prazo: " + pedido.EntregueNoPrazo());
	}

	public static void main(){
		Cliente cliente1 = new Cliente("Fulano", 9999, "Rua A");
		Cliente cliente2 = new Cliente("Ciclano", 8888, "Rua B");

		Pedido pedido1 = new Pedido(1, cliente1, 500);
		Pedido pedido2 = new Pedido(2, cliente2, 500, java.time.LocalDate.now());

		pedido1.toString(pedido1);
		pedido2.toString(pedido2);
	}
}