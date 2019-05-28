package com.atarvena.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "mapa")
@Table
public class Mapa extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "O campo nome não pode ser nulo")
	private String nome;

	private String descricao;

	private String eventos;

	private String nocs; // EU NAO SEI O QUE SER ISSO

	private String lojas;

	private String lugares;

	@ManyToOne
	@JoinColumn(name = "partidaRPG_id")
	@JsonIgnore
	private PartidaRPG partidaRPG;

	public Mapa() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEventos() {
		return eventos;
	}

	public void setEventos(String eventos) {
		this.eventos = eventos;
	}

	public String getNocs() {
		return nocs;
	}

	public void setNocs(String nocs) {
		this.nocs = nocs;
	}

	public String getLojas() {
		return lojas;
	}

	public void setLojas(String lojas) {
		this.lojas = lojas;
	}

	public String getLugares() {
		return lugares;
	}

	public void setLugares(String lugares) {
		this.lugares = lugares;
	}

	public PartidaRPG getPartidaRPG() {
		return partidaRPG;
	}

	public void setPartidaRPG(PartidaRPG partidaRPG) {
		this.partidaRPG = partidaRPG;
	}

}
