package br.com.jose.cadcolpr.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

/**
 * The persistent class for the carro database table.
 * 
 */
@Entity
public class Carro {

	@EmbeddedId
	private CarroId id;

	@Column(name = "ano_fab")
	private int anoFab;

	@Column(name = "apelido")
	private String apelido;

	@Column(name = "placa")
	private String placa;

	@ManyToOne
	private Colecionador colecionador;

	public Carro() {
	}

	public CarroId getId() {
		return this.id;
	}

	public void setId(CarroId id) {
		this.id = id;
	}

	public int getAnoFab() {
		return this.anoFab;
	}

	public void setAnoFab(int anoFab) {
		this.anoFab = anoFab;
	}

	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", anoFab=" + anoFab + ", apelido=" + apelido + ", placa=" + placa + "]";
	}

	public Colecionador getColecionador() {
		return colecionador;
	}

	public void setColecionador(Colecionador colecionador) {
		this.colecionador = colecionador;
	}

}