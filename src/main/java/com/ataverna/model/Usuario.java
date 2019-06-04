package com.ataverna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity(name = "usuario")
@Table
public class Usuario extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "O campo username não pode ser nulo.")
	@Column(unique = true)
	private String username;

	@NotBlank(message = "O campo senha não pode ser nulo.")
	@Column(unique = true/* , length = 8 */)
	private String senha;

	@Email(message = "O campo email é inválido.")
	@Column(unique = true)
	private String email;

	public Usuario() {
	}

	public Usuario(@NotBlank(message = "O campo username não pode ser nulo.") String username,
			@NotBlank(message = "O campo senha não pode ser nulo.") String senha,
			@Email(message = "O campo email é inválido.") String email) {
		super();
		this.username = username;
		this.senha = senha;
		this.email = email;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
