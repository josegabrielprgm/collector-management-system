package br.com.jose.codcolpr.menucolecionador;

import java.util.Scanner;

import br.com.jose.cadcolpr.domain.Colecionador;
import br.com.jose.cadcolpr.persistence.ColecionadorDAO;

public class AdicionaCol {

	private Scanner scanner;
	private ColecionadorDAO colDao;

	public AdicionaCol(Scanner scanner, ColecionadorDAO colDao) {
		this.scanner = scanner;
		this.colDao = colDao;

	}

	public void adicionaCol() {

		System.out.println();
		System.out.print("Digite seu CPF: ");
		String cpf = scanner.nextLine();

		cpf = cpf.replace(".", "").replace("-", "").replace(" ", "");

		if (cpf.length() != 11) {
			System.out.println("O CPF deve conter 11 dígitos.");
			return;
		}

		var lista = colDao.listar();

		for (Colecionador colecionador : lista) {
			if (colecionador.getCpf().equals(cpf)) {

				System.out.println("CPF já cadastrado");

				return;

			}
		}
		Colecionador col = new Colecionador();

		System.out.print("Digite seu nome: ");
		String nomeAdic = scanner.nextLine();

		System.out.print("Digite seu telefone: ");
		String tel = scanner.nextLine();

		tel = tel.replace("(", "").replace(")", "").replace("-", "").replace(" ", "");

		while (tel.length() != 11) {
			System.out.println("O número de telefone deve conter apenas 11 dígitos");

			System.out.print("Digite seu telefone: ");
			tel = scanner.nextLine();

			tel = tel.replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
		}
		int idade = 0;
		while (idade <= 0 || idade > 120) {

			try {
				System.out.print("Digite sua idade: ");
				idade = Integer.parseInt(scanner.nextLine());

				if (idade <= 0 || idade > 120) {
					System.out.println("Digite uma idade válida.");
				}

			} catch (NumberFormatException e) {
				System.out.println("Digite apenas números ");
			}
		}
		col.setCpf(cpf);
		col.setNome(nomeAdic);
		col.setTelefone(tel);
		col.setIdade(idade);

		colDao.criar(col);

		System.out.println("Novo colecionador adicionado com sucesso!");

	}
}
