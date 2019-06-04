package com.ataverna.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "equipamentos")
@Table
public class Equipamentos extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private int conjunto;

	private int atributos;

	public Equipamentos() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public int getConjunto() {
		return conjunto;
	}

	public void setConjunto(int conjunto) {
		this.conjunto = conjunto;
	}

	public int getAtributos() {
		return atributos;
	}

	public void setAtributos(int atributos) {
		this.atributos = atributos;
	}

}
