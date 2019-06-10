package com.ataverna.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "historia")
@Table
public class Historia extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String tema;

	private String titulo;

	private String descricao;

	@OneToOne
	@JoinColumn(name = "partidaRPG_id")
	@JsonIgnore
	private PartidaRPG partidaRPG;

	public Historia() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PartidaRPG getPartidaRPG() {
		return partidaRPG;
	}

	public void setPartidaRPG(PartidaRPG partidaRPG) {
		this.partidaRPG = partidaRPG;
	}

}
