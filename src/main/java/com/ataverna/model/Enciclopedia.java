package com.ataverna.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "enciclopedia")
@Table
public class Enciclopedia extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	@OneToMany(mappedBy = "enciclopedia", fetch = FetchType.EAGER, orphanRemoval = true)
//	@Fetch(FetchMode.SUBSELECT)
//	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
//	private List<Item> itens;

	private String nome;
	private String descricao;
	private String atributo;
	private String efeito;
	private double preco;

	@ManyToOne
	@JoinColumn(name = "partidaRPG_id")
	@JsonIgnore
	private PartidaRPG partidaRPG;

	public Enciclopedia() {
//		itens = new ArrayList<>();
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

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getEfeito() {
		return efeito;
	}

	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public PartidaRPG getPartidaRPG() {
		return partidaRPG;
	}

	public void setPartidaRPG(PartidaRPG partidaRPG) {
		this.partidaRPG = partidaRPG;
	}

//	public List<Item> getItens() {
//		return itens;
//	}
//
//	public void setItens(List<Item> itens) {
//		this.itens = itens;
//	}
//	
//	public void add(Item item) {
//		itens.add(item);
//		item.setEnciclopedia(this);
//	}
//
//	public void removeAnalise(Item item) {
//		itens.remove(item);
//		item.setEnciclopedia(null);
//	}

}
