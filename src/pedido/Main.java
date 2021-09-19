package pedido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String nome;
		String email;
		Date nascimento;
		
		System.out.println("Entre com os dados do cliente:");
		System.out.print("Nome:");
		nome = sc.nextLine();

		System.out.print("Email:");
		email = sc.nextLine();
		
		System.out.print("Nascimento:");
		nascimento = sdf.parse(sc.next());
		sc.nextLine();

		Cliente cliente = new Cliente(nome, email, nascimento);
		Pedido pedido = new Pedido(new Date(), StatusPedido.PAGAMENTO_PENDENTE, cliente);
		
		System.out.print("Informe a quantidade de produtos do pedido");
		int quantidade = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<quantidade; i++) {
			Produto produto = new Produto();
			System.out.print("Nome do produto: ");
			produto.nome = sc.nextLine();
			
			System.out.print("Preço do produto: ");
			produto.preco = sc.nextDouble();
			sc.nextLine();

			System.out.print("Quantidade do produto: ");
			int quantidadeProduto = sc.nextInt();
			sc.nextLine();
		
			ItemPedido item = new ItemPedido();
			item.produto = produto;
			item.quantidade = quantidadeProduto;
			
			pedido.adicionarItem(item);
		}
		
		System.out.println("RESUMO DO PEDIDO:");
		System.out.println("Status: " + pedido.getStatus());
		System.out.println("Cliente: " + pedido.getCliente().getNome() + "(" + pedido.getCliente().getNascimento() +")"+ pedido.getCliente().getEmail());
		System.out.println("Itens:");
		for(ItemPedido item : pedido.getItens()) {
			System.out.println(item.produto.nome + ", " + item.produto.preco + ", Quantidade:" + item.quantidade + ", Subtotal: " + item.SubTotal());
		}		
		
		System.out.print("Total do pedido: " + pedido.total());
		
		
		sc.close();

	}

}
