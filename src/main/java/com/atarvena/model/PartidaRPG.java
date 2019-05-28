package com.atarvena.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "partidaRPG")
@Table
public class PartidaRPG extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "mestre_id", nullable = false)
	private Mestre mestre;

	@OneToMany(mappedBy = "partidaRPG", fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<Jogador> jogadores;

	@ManyToOne
	@JoinColumn(name = "bestiario_id", nullable = false)
	private Bestiario bestiario;

	@ManyToOne
	@JoinColumn(name = "grimorio_id", nullable = false)
	private Grimorio grimorio;

	@ManyToOne
	@JoinColumn(name = "historia_id", nullable = false)
	private Historia historia;

	@ManyToOne
	@JoinColumn(name = "enciclopedia_id", nullable = false)
	private Enciclopedia enciclopedia;

	@OneToMany(mappedBy = "partidaRPG", fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<Mapa> mapas;

	public PartidaRPG() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
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

	public Bestiario getBestiario() {
		return bestiario;
	}

	public void setBestiario(Bestiario bestiario) {
		this.bestiario = bestiario;
	}

	public Grimorio getGrimorio() {
		return grimorio;
	}

	public void setGrimorio(Grimorio grimorio) {
		this.grimorio = grimorio;
	}

	public Historia getHistoria() {
		return historia;
	}

	public void setHistoria(Historia historia) {
		this.historia = historia;
	}

	public Enciclopedia getEnciclopedia() {
		return enciclopedia;
	}

	public void setEnciclopedia(Enciclopedia enciclopedia) {
		this.enciclopedia = enciclopedia;
	}

	public List<Mapa> getMapas() {
		return mapas;
	}

	public void setMapas(List<Mapa> mapas) {
		this.mapas = mapas;
	}
	
	/*public void addAnalise(Analise novaAnalise) {
		listaAnalise.add(novaAnalise);
		novaAnalise.setSolicitacao(this);
	}

	public void removeAnalise(Analise removeAnalise) {
		listaAnalise.remove(removeAnalise);
		removeAnalise.setSolicitacao(null);
	}
	
	public void addAnalise(Analise novaAnalise) {
		listaAnalise.add(novaAnalise);
		novaAnalise.setSolicitacao(this);
	}

	public void removeAnalise(Analise removeAnalise) {
		listaAnalise.remove(removeAnalise);
		removeAnalise.setSolicitacao(null);
	}*/

}
