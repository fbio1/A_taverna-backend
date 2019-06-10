package com.ataverna.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "grimorio")
@Table
public class Grimorio extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	@OneToMany(mappedBy = "grimorio", fetch = FetchType.EAGER, orphanRemoval = true)
//	@Fetch(FetchMode.SUBSELECT)
//	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
//	private List<Magia> magias;

	private String nome;

	private String descricao;

	@ManyToOne
	@JoinColumn(name = "partidaRPG_id")
	@JsonIgnore
	private PartidaRPG partidaRPG;

	public Grimorio() {
//		magias = new ArrayList<>();
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

//	public List<Magia> getMagias() {
//		return magias;
//	}
//
//	public void setMagias(List<Magia> magias) {
//		this.magias = magias;
//	}
//	
//	public void add(Magia magia) {
//		magias.add(magia);
//		magia.setGrimorio(this);
//	}
//
//	public void removeAnalise(Magia magia) {
//		magias.remove(magia);
//		magia.setGrimorio(null);
//	}

}
