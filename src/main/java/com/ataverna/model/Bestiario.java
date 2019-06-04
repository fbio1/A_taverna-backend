package com.ataverna.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "bestiario")
@Table
public class Bestiario extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "bestiario", fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<Criatura> criaturas;

	public Bestiario() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public List<Criatura> getCriaturas() {
		return criaturas;
	}

	public void setCriaturas(List<Criatura> criaturas) {
		this.criaturas = criaturas;
	}

	/*public void addAnalise(Analise novaAnalise) {
		listaAnalise.add(novaAnalise);
		novaAnalise.setSolicitacao(this);
	}

	public void removeAnalise(Analise removeAnalise) {
		listaAnalise.remove(removeAnalise);
		removeAnalise.setSolicitacao(null);
	}*/

}
