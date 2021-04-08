package br.ufpb.dcx.sandro;

import java.util.List;

public class Amigo extends SistemaAmigo{
	
	private String nome;
	private String email;
	private String emailAmigoSorteado;
	
	public Amigo(String nome, String email, List<Amigo> nomeAmigo) {
		this.nome = nome;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailAmigoSorteado() {
		return emailAmigoSorteado;
	}

	public void setEmailAmigoSorteado(String emailAmigoSorteado) {
		this.emailAmigoSorteado = emailAmigoSorteado;
	}

}
