package br.com.jose.codcolpr.menucolecionador;

import java.util.Scanner;

import br.com.jose.cadcolpr.domain.Colecionador;
import br.com.jose.cadcolpr.persistence.ColecionadorDAO;
import br.com.jose.codcolpr.util.Func;

public class BuscarColecionador {

	private Scanner scanner;
	private ColecionadorDAO colDao;

	public BuscarColecionador(Scanner scanner, ColecionadorDAO colDao) {
		this.scanner = scanner;
		this.colDao = colDao;
	}

	public void listar() {

		var lista = colDao.listar();

		if (lista.isEmpty()) {
			System.out.println("Lista está vazia!");
			return;
		}

		System.out.println("________________________________________________________________");
		System.out.print(Func.getTamtr("CPF", 15));
		System.out.print("|");
		System.out.print(Func.getTamtr("Nome", 20));
		System.out.print("|");
		System.out.print(Func.getTamtr("Telefone", 15));
		System.out.print("|");
		System.out.println("Idade");

		System.out.println("----------------------------------------------------------------");

		for (Colecionador c : lista) {
			System.out.print(Func.getTamtr(c.getCpf(), 15));
			System.out.print("|");
			System.out.print(Func.getTamtr(c.getNome(), 20));
			System.out.print("|");
			System.out.print(Func.getTamtr(c.getTelefone(), 15));
			System.out.print("|");
			System.out.println(c.getIdade());

			System.out.println("----------------------------------------------------------------");
		}
	}
}