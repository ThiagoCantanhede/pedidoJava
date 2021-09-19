package pedido;

public class ItemPedido {
	public int quantidade;
	public Produto produto;
	
	public Double SubTotal() {
		return this.quantidade * this.produto.preco;
	}
	
}
