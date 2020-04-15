package br.edu.sc.senac.demo.demoproject;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Client")
public class ClientEntity implements Serializable {

	private static final long serialVersionUID = -4299686595771526274L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String nome;
	private String  dataNascimento;
	private String email;
	private String id;
	
	protected ClientEntity() {
		
	}
	
	public ClientEntity(String nome, String dataNascimento, String email, String id) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.id = id;
	}
	
	public String getClientId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "ClientEntity [ClientId=" + this.id + ", name=" + this.nome + ", birthDate=" + this.dataNascimento + ", email=" + this.email + "]";
	}

	public String getName() {
		return this.nome;
	}

	public void setName(final String nome) {
		if (nome != null) {
			this.nome = nome;
		}
	}

	public String getBirthDate() {
		return this.dataNascimento;
	}

	public void setBirthDate(final String birthDate) {
		if (birthDate != null) {
			this.dataNascimento = birthDate;
		}
	}

	public String getEmail() {
		return this.email;
	}

	public void setPrice(final String email) {
		if (email != null) {
			this.email = email;
		}
	}

}
