package br.edu.sc.senac.demo.demoproject;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Client")
final class ClientEntity implements Serializable {

	private static final long serialVersionUID = 8773632339802381906L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String birthDate;
	
	private String email;
	
	protected ClientEntity() {
		
	}
	
	public ClientEntity(String name, String birthDate, String email) {
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
	}
	
	public Long getClientId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "ClientEntity [ClientId=" + this.id + ", name=" + this.name + ", birthDate=" + this.birthDate + ", email=" + this.email + "]";
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		if (name != null) {
			this.name = name;
		}
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(final String birthDate) {
		if (birthDate != null) {
			this.birthDate = birthDate;
		}
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		if (email != null) {
			this.email = email;
		}
	}

}
