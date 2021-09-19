package pedido;

import java.util.Date;

public class Cliente {
	
	private String nome;
	private String email;
	private Date nascimento;
	
	public Cliente(String nome, String email, Date nascimento) {
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		
	}

	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public Date getNascimento() {
		return nascimento;
	}

}
