package br.edu.sc.senac.demo.demoproject;

public class ClientDTO {
	
	public static final ClientDTO NULL_VALUE = new ClientDTO(Long.valueOf(0), "", "", "");
	private Long clientId;
	private String nome;
	private String dataNascimento;
	private String email;

	public ClientDTO(Long clientId, String nome, String dataNascimento, String email) {
		this.clientId = clientId;
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
	
	public Long getClientId() {
		return this.clientId;
	}
	
	

}
