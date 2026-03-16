package br.com.jose.codcolpr.menucarro;

import java.util.Scanner;

import br.com.jose.cadcolpr.domain.Carro;
import br.com.jose.cadcolpr.domain.Colecionador;
import br.com.jose.cadcolpr.persistence.CarroDAO;

public class ListarCar {
	private Scanner scanner;
	private CarroDAO carDAO;

	public ListarCar(Scanner scanner, CarroDAO carDAO) {
		this.scanner = scanner;
		this.carDAO = carDAO;
	}

	public void listarCar() {

		var lista = carDAO.listar();

		if (lista.isEmpty()) {
			System.out.println("Lista está vazia!");
		}
		for (Carro carro : lista) {
			System.out.println("__________________________________");
			System.out.println();
			System.out.println("Informações do carro");
			System.out.println();
			Colecionador colecionador = carro.getColecionador();
			System.out.println("CPF do dono: " + carro.getId().getCpf());
			System.out.println("Nome do dono: " + colecionador.getNome());
			System.out.println("Apelido do carro: " + carro.getApelido());
			System.out.println("Placa do carro: " + carro.getPlaca());
			System.out.println("Ano de fabricação: " + carro.getAnoFab());
			System.out.println();
			System.out.println("__________________________________");
		}
	}
}
