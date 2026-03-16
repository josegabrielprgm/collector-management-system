package br.com.jose.codcolpr.menucolecionador;

import java.util.Scanner;

import br.com.jose.cadcolpr.persistence.CarroDAO;
import br.com.jose.cadcolpr.persistence.ColecionadorDAO;

public class ApagarCol {

	private Scanner scanner;
	private ColecionadorDAO colDao;
	private CarroDAO carDao;

	public ApagarCol(Scanner scanner, ColecionadorDAO colDao, CarroDAO carDAO) {

		this.scanner = scanner;
		this.colDao = colDao;
		this.carDao = carDAO;
	}

	public void apagarCol() {

		Listar listar = new Listar(scanner, colDao);
		listar.listar();

		System.out.println();
		System.out.print("Digite o CPF do colecionador que deseja apagar: ");
		String cpfApaga = scanner.nextLine();

		cpfApaga = cpfApaga.replace(".", "").replace("-", "").replace(" ", "");

		carDao.apagarByCpf(cpfApaga);
		colDao.apagar(cpfApaga);

		System.out.println("Apagado com sucesso!");

	}
}
