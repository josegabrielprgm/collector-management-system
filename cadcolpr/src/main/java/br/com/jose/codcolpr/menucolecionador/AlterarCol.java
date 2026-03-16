package br.com.jose.codcolpr.menucolecionador;

import java.util.Scanner;

import br.com.jose.cadcolpr.domain.Colecionador;
import br.com.jose.cadcolpr.persistence.ColecionadorDAO;

public class AlterarCol {
	private Scanner scanner;
	private ColecionadorDAO colDao;

	public AlterarCol(Scanner scanner, ColecionadorDAO colDao) {
		this.scanner = scanner;
		this.colDao = colDao;

	}

	public void alterarCol() {

		Colecionador col = null;

		var lista = colDao.listar();

		if (lista.isEmpty()) {
			System.out.println("Lista está vazia!");
			return;
		}
		Listar listar = new Listar(scanner, colDao);
		listar.listar();

		System.out.print("Digite o CPF do colecionador que deseja alterar: ");
		String cpf = scanner.nextLine();

		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");

		for (Colecionador c : lista) {
			if (c.getCpf().equals(cpf)) {
				col = c;
				break;
			}

		}

		if (col != null) {
			System.out.print("Nome [" + col.getNome() + "]: ");
			String nome = scanner.nextLine();

			System.out.print("Digite seu telefone [" + col.getTelefone() + "]: ");
			String tel = scanner.nextLine();

			System.out.print("Digite sua idade [" + col.getIdade() + "]: ");
			String idadestr = scanner.nextLine();

			if (!nome.isEmpty()) {

				col.setNome(nome);

			} else if (!tel.isEmpty()) {
				col.setTelefone(tel);

			} else if (!idadestr.isEmpty()) {
				int idade = Integer.parseInt(idadestr);

				col.setIdade(idade);
			}

			colDao.atualizar(col);
		} else {
			System.out.println("Colecionador não encontrado!");
			AlterarCol alterarcol = new AlterarCol(scanner, colDao);
			alterarcol.alterarCol();
		}

	}
}
