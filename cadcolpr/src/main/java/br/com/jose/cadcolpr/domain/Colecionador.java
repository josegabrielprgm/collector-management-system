package br.com.jose.cadcolpr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * The persistent class for the colecionador database table.
 * 
 */
@Entity
public class Colecionador {

	@Id
	private String cpf;

	private String nome;

	private String telefone;

	private int idade;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int colecionadorCod;

	public Colecionador() {
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getColecionadorcol() {
		return this.colecionadorCod;
	}

	public void setColecionadorcol(int colecionadorCod) {
		this.colecionadorCod = colecionadorCod;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}