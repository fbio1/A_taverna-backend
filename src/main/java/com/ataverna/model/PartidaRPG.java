package com.ataverna.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "partidaRPG")
@Table
public class PartidaRPG extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "O nome da história não pode ser nulo.")
	private String nome;

	@OneToOne (mappedBy = "partidaRPG", orphanRemoval = true)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })	
	private Mestre mestre;

	@OneToMany(mappedBy = "partidaRPG", fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<Jogador> jogadores;

	@OneToMany(mappedBy = "partidaRPG", fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<Bestiario> bestiario;

	@OneToMany(mappedBy = "partidaRPG", fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<Grimorio> grimorio;

	@OneToOne (mappedBy = "partidaRPG", orphanRemoval = true)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })	
	private Historia historia;

	@OneToMany(mappedBy = "partidaRPG", fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<Enciclopedia> enciclopedia;

	@OneToMany(mappedBy = "partidaRPG", fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<Mapa> mapas;

	public PartidaRPG() {
		mestre = new Mestre();
		bestiario = new ArrayList<>();
		grimorio = new ArrayList<>();
		historia = new Historia();
		enciclopedia = new ArrayList<>();
		mapas = new ArrayList<>();
		jogadores = new ArrayList<>();
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

	public Mestre getMestre() {
		return mestre;
	}

	public void setMestre(Mestre mestre) {
		this.mestre = mestre;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Historia getHistoria() {
		return historia;
	}

	public void setHistoria(Historia historia) {
		this.historia = historia;
	}

	public List<Mapa> getMapas() {
		return mapas;
	}

	public void setMapas(List<Mapa> mapas) {
		this.mapas = mapas;
	}

	public List<Bestiario> getBestiario() {
		return bestiario;
	}

	public void setBestiario(List<Bestiario> bestiario) {
		this.bestiario = bestiario;
	}

	public List<Grimorio> getGrimorio() {
		return grimorio;
	}

	public void setGrimorio(List<Grimorio> grimorio) {
		this.grimorio = grimorio;
	}

	public List<Enciclopedia> getEnciclopedia() {
		return enciclopedia;
	}

	public void setEnciclopedia(List<Enciclopedia> enciclopedia) {
		this.enciclopedia = enciclopedia;
	}

	public void addMapa(Mapa mapa) {
		mapas.add(mapa);
		mapa.setPartidaRPG(this);
	}

	public void removeMapa(Mapa mapa) {
		mapas.remove(mapa);
		mapa.setPartidaRPG(null);
	}

	public void addJogador(Jogador jogador) {
		jogadores.add(jogador);
		jogador.setPartidaRPG(this);
	}

	public void removeJogador(Jogador jogador) {
		jogadores.remove(jogador);
		jogador.setPartidaRPG(null);
	}

}
