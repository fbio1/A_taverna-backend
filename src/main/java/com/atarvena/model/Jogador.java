package com.atarvena.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "jogador")
@Table
public class Jogador extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private FichaPersonagem fichaPersonagem;
	
	@ManyToOne
	@JoinColumn(name = "partidaRPG_id")
	@JsonIgnore
	private PartidaRPG partidaRPG;

	public Jogador() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public FichaPersonagem getFichaPersonagem() {
		return fichaPersonagem;
	}

	public void setFichaPersonagem(FichaPersonagem fichaPersonagem) {
		this.fichaPersonagem = fichaPersonagem;
	}

}
