package br.com.jose.codcolpr.menucarro;

import java.util.Scanner;

import br.com.jose.cadcolpr.domain.Carro;
import br.com.jose.cadcolpr.domain.Colecionador;
import br.com.jose.cadcolpr.persistence.CarroDAO;

public class AlterarCarro {

	private Scanner scanner;
	private CarroDAO carDAO;

	public AlterarCarro(Scanner scanner, CarroDAO carDAO) {
		this.scanner = scanner;
		this.carDAO = carDAO;
	}

	public void alterarCar() {
		Carro carro = null;

		var lista = carDAO.listar();

		ListarCar listarCar = new ListarCar(scanner, carDAO);
		listarCar.listarCar();

		System.out.print("Digite o CPF do colecionador que deseja alterar o carro: ");
		String cpf = scanner.nextLine();

		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");

		for (Carro c : lista) {
			if (c.getId().getCpf().equals(cpf)) {
				carro = c;
				break;
			}

		}

		if (carro != null) {
			System.out.print("Apelido [" + carro.getApelido() + "]: ");
			String nomeCarro = scanner.nextLine();

			if (!nomeCarro.isEmpty()) {

				carro.setApelido(nomeCarro);

			}

			System.out.print("Digite o ano do carro: ");
			int anoFab = Integer.parseInt(scanner.nextLine());

			System.out.println("Digite a placa do carro: ");
			String placaCar = scanner.nextLine();

			carro.setAnoFab(anoFab);
			carro.setPlaca(placaCar);
			carro.setApelido(nomeCarro);

			System.out.println("Carro alterado com sucesso!");
			System.out.println("__________________________________");
			System.out.println();
			Colecionador colecionador = carro.getColecionador();
			System.out.println("CPF do dono: " + carro.getId().getCpf());
			System.out.println("Nome do dono: " + colecionador.getNome());
			System.out.println("Apelido do carro: " + carro.getApelido());
			System.out.println("Placa do carro: " + carro.getPlaca());
			System.out.println("Ano de fabricação: " + carro.getAnoFab());
			System.out.println();
			System.out.println("__________________________________");
			carDAO.atualizar(carro);
		} else {
			System.out.println("Colecionador não encontrado!");
			AlterarCarro alterarCarro = new AlterarCarro(scanner, carDAO);
			alterarCarro.alterarCar();
		}
	}

}
