package com.ataverna.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "bestiario")
@Table
public class Bestiario extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String descricao;

	@ManyToOne
	@JoinColumn(name = "partidaRPG_id")
	@JsonIgnore
	private PartidaRPG partidaRPG;

//	@OneToMany(mappedBy = "bestiario", fetch = FetchType.EAGER, orphanRemoval = true)
//	@Fetch(FetchMode.SUBSELECT)
//	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
//	private List<Criatura> criaturas;

	public Bestiario() {
//		criaturas = new ArrayList<>();
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

	public PartidaRPG getPartidaRPG() {
		return partidaRPG;
	}

	public void setPartidaRPG(PartidaRPG partidaRPG) {
		this.partidaRPG = partidaRPG;
	}

//	public List<Criatura> getCriaturas() {
//		return criaturas;
//	}
//
//	public void setCriaturas(List<Criatura> criaturas) {
//		this.criaturas = criaturas;
//	}
//
//	public void add(Criatura criatura) {
//		criaturas.add(criatura);
//		criatura.setBestiario(this);
//	}
//
//	public void removeAnalise(Criatura criatura) {
//		criaturas.remove(criatura);
//		criatura.setBestiario(null);
//	}

}
