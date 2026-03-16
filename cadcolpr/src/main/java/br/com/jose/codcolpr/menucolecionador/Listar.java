package br.com.jose.codcolpr.menucolecionador;

import java.util.Scanner;

import br.com.jose.cadcolpr.domain.Colecionador;
import br.com.jose.cadcolpr.persistence.ColecionadorDAO;
import br.com.jose.codcolpr.util.Func;

public class Listar {

	private Scanner scanner;
	private ColecionadorDAO colDao;

	public Listar(Scanner scanner, ColecionadorDAO colDao) {
		this.scanner = scanner;
		this.colDao = colDao;
	}

	public void listar() {

		var lista = colDao.listar();

		if (lista.isEmpty()) {
			System.out.println("Lista está vazia!");
			return;
		}

		System.out.println("___________________________________________________");
		System.out.print(Func.getTamtr("CPF", 15));
		System.out.print("|");
		System.out.print(Func.getTamtr("Nome", 20));
		System.out.print("|");
		System.out.println("Telefone");

		System.out.println("---------------------------------------------------");

		for (Colecionador c : lista) {
			System.out.print(Func.getTamtr(c.getCpf(), 15));
			System.out.print("|");
			System.out.print(Func.getTamtr(c.getNome(), 20));
			System.out.print("|");
			System.out.println(c.getTelefone());

			System.out.println("---------------------------------------------------");
		}
	}
}