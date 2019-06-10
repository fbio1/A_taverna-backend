package com.ataverna.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity(name = "fichaPersonagem")
@Table
public class FichaPersonagem extends AbstractModel<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String historio;

	private String tendencia;

//	@OneToOne
//	@JoinColumn(name = "invetario_id", nullable = false)
//	private Inventario inventario;
//
//	@OneToOne
//	@JoinColumn(name = "equipamentos_id", nullable = false)
//	private Equipamentos equipamentos;

	private String classe;

	private String raca;

	private String level;

	private String atributos;

	private String magias;

	private String pericias;

	private String preoficiencia;

	private String estudos;

	@OneToOne
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private Jogador jogador;

	public FichaPersonagem() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getHistorio() {
		return historio;
	}

	public void setHistorio(String historio) {
		this.historio = historio;
	}

	public String getTendencia() {
		return tendencia;
	}

	public void setTendencia(String tendencia) {
		this.tendencia = tendencia;
	}

//	public Inventario getInventario() {
//		return inventario;
//	}
//
//	public void setInventario(Inventario inventario) {
//		this.inventario = inventario;
//	}
//
//	public Equipamentos getEquipamentos() {
//		return equipamentos;
//	}
//
//	public void setEquipamentos(Equipamentos equipamentos) {
//		this.equipamentos = equipamentos;
//	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getAtributos() {
		return atributos;
	}

	public void setAtributos(String atributos) {
		this.atributos = atributos;
	}

	public String getMagias() {
		return magias;
	}

	public void setMagias(String magias) {
		this.magias = magias;
	}

	public String getPericias() {
		return pericias;
	}

	public void setPericias(String pericias) {
		this.pericias = pericias;
	}

	public String getPreoficiencia() {
		return preoficiencia;
	}

	public void setPreoficiencia(String preoficiencia) {
		this.preoficiencia = preoficiencia;
	}

	public String getEstudos() {
		return estudos;
	}

	public void setEstudos(String estudos) {
		this.estudos = estudos;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

}
