package pedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	private Date dataPedido;
	private StatusPedido status;
	private List<ItemPedido> Itens;
	private Cliente cliente;
	
	public Pedido(Date dataPedido, StatusPedido status, Cliente cliente) {
		this.dataPedido = dataPedido;
		this.status = status;
		this.cliente = cliente;
		this.Itens = new ArrayList<ItemPedido>();
	}
	
	public Date getDataPedido() {
		return dataPedido;
	}
	public StatusPedido getStatus() {
		return status;
	}
	public List<ItemPedido> getItens() {
		return Itens;
	}
	public Cliente getCliente() {
		return cliente;
	}
	
	public void adicionarItem(ItemPedido item) {
		this.Itens.add(item);
	}
	
	public void removerItem(ItemPedido item) {
		this.Itens.remove(item);
	}
	
	public double total() {
		double total = 0;
		for(ItemPedido item : this.Itens) {
			total = total + (item.SubTotal());
		}
		return total;
	}
}
