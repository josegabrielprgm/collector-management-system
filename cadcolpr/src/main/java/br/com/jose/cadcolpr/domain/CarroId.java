package br.com.jose.cadcolpr.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * The primary key class for the carro database table.
 * 
 */
@Embeddable

public class CarroId {

	@Column(name = "cod_carro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer codCarro;

	@Column(insertable = false, updatable = false)
	private String cpf;

	public CarroId() {
	}

	public Integer getCodCarro() {
		return this.codCarro;
	}

	public void setCodCarro(Integer codCarro) {
		this.codCarro = codCarro;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CarroId)) {
			return false;
		}
		CarroId castOther = (CarroId) other;
		return this.codCarro.equals(castOther.codCarro) && this.cpf.equals(castOther.cpf);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codCarro.hashCode();
		hash = hash * prime + this.cpf.hashCode();

		return hash;
	}
}