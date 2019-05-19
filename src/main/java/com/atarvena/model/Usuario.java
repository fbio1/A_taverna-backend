package com.atarvena.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity(name = "usuario")
public class Usuario extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Email(message = "O campo email é inválido.")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "O campo nome não pode ser nulo.")
	private String nome;

	// @CPF(message = "O campo CPF é inválido.")
	@NotBlank(message = "O campo CPF não pode ser nulo.")
	@Column(unique = true, length = 16)
	private String cpf;

	public Usuario() {
		super();
	}

	public Usuario(Integer id, @Email(message = "O campo email é inválido.") String email,
			@NotBlank(message = "O campo nome não pode ser nulo.") String nome,
			@NotBlank(message = "O campo CPF não pode ser nulo.") String cpf) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
