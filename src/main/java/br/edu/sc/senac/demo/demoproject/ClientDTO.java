package br.edu.sc.senac.demo.demoproject;

public class ClientDTO {
	private String nome;
	private String  dataNascimento;
	private String email;

	
	public ClientDTO(String nome, String dataNascimento, String email) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}

	public String getName() {
		return this.nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}
	
	

}
