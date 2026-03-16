package br.com.jose.codcolpr.menucarro;

import java.util.Scanner;

import br.com.jose.cadcolpr.persistence.CarroDAO;

public class ApagarCarro {

	private Scanner scanner;
	private CarroDAO carDAO;

	public ApagarCarro(Scanner scanner, CarroDAO carroDAO) {
		this.scanner = scanner;
		this.carDAO = carroDAO;
	}

	public void apagarCarro() {

		ListarCar listar = new ListarCar(scanner, carDAO);
		listar.listarCar();

		System.out.println();
		System.out.println("Digite o CPF do colecionador que deseja apagar: ");
		String cpfApaga = scanner.nextLine();

		carDAO.apagarByCpf(cpfApaga);
		carDAO.apagar(cpfApaga);

		System.out.println("Apagado com sucesso!");
	}

}
