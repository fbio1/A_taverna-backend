package com.ataverna.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "item")
@Table
public class Item extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "enciclopedia_id")
	@JsonIgnore
	private Enciclopedia enciclopedia;

	public Item() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Enciclopedia getEnciclopedia() {
		return enciclopedia;
	}

	public void setEnciclopedia(Enciclopedia enciclopedia) {
		this.enciclopedia = enciclopedia;
	}

}
