package br.com.jose.codcolpr.menucarro;

import java.util.List;
import java.util.Scanner;

import br.com.jose.cadcolpr.domain.Carro;
import br.com.jose.cadcolpr.domain.CarroId;
import br.com.jose.cadcolpr.domain.Colecionador;
import br.com.jose.cadcolpr.persistence.CarroDAO;
import br.com.jose.cadcolpr.persistence.ColecionadorDAO;

public class AdicionarCarro {

	private Scanner scanner;
	private CarroDAO carDAO;
	private ColecionadorDAO colecionadorDAO;

	public AdicionarCarro(Scanner scanner, CarroDAO carDAO, ColecionadorDAO colecionadorDAO) {
		this.scanner = scanner;
		this.carDAO = carDAO;
		this.colecionadorDAO = colecionadorDAO;
	}

	public void adicionarCarros() {

		List<Colecionador> lista = colecionadorDAO.listar();

		System.out.println();
		System.out.print("Digite seu CPF do usuario: ");
		String cpf = scanner.nextLine();

		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");

		Colecionador col = null;

		for (Colecionador colecionador : lista) {
			if (colecionador.getCpf().equals(cpf)) {

				col = colecionador;
				break;
			}
		}
		if (col != null) {

			System.out.print("Digite a placa do carro: ");
			String placaCar = scanner.nextLine();

			System.out.print("Digite o apelido do carro: ");
			String apelidoCar = scanner.nextLine();

			System.out.print("Digite o ano da fabricação: ");
			int anoFab = Integer.parseInt(scanner.nextLine());
			System.out.println();

			Carro carro = new Carro();

			carro.setId(new CarroId());
			carro.getId().setCpf(cpf);
			carro.setPlaca(placaCar);
			carro.setApelido(apelidoCar);
			carro.setAnoFab(anoFab);
			carro.setColecionador(col);

			carDAO.criar(carro);
			System.out.println("Carro adicionado para " + col.getNome() + "!");
		} else {
			System.out.println("CPF não encontrado");

		}

	}
}
