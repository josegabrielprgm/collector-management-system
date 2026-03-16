package br.com.jose.codcolpr.menucarro;

import java.util.Scanner;

import br.com.jose.cadcolpr.persistence.CarroDAO;
import br.com.jose.cadcolpr.persistence.ColecionadorDAO;
import br.com.jose.codcolpr.limpaconsole.LimparConsole;
import br.com.jose.codcolpr.menucolecionador.Listar;
import br.com.jose.codcolpr.menuprincipal.MenuPrincipal;

public class MenuCarro {

	private Scanner scanner;

	public MenuCarro(Scanner scanner) {

		this.scanner = scanner;
	}

	public void menuCarro() {

		CarroDAO carDAO = new CarroDAO();
		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		System.out.println();
		System.out.println("Menu Colecionador");

		System.out.println("_____________________________");
		System.out.println("1- Listar carros");
		System.out.println("2- Novo carro");
		System.out.println("3- Alterar carro");
		System.out.println("4- Apagar carro");
		System.out.println("5- Voltar para o menu pricipal");
		System.out.print("Selecione:");

		int numopcao = Integer.parseInt(scanner.nextLine());

		switch (numopcao) {
		case 1:
			LimparConsole limpar = new LimparConsole();
			limpar.limparTela();
			ListarCar listarCarro = new ListarCar(scanner, carDAO);
			listarCarro.listarCar();
			break;

		case 2:
			LimparConsole limpar1 = new LimparConsole();
			limpar1.limparTela();
			Listar listar = new Listar(scanner, colecionadorDAO);
			listar.listar();

			AdicionarCarro adicionarCar = new AdicionarCarro(scanner, carDAO, colecionadorDAO);
			adicionarCar.adicionarCarros();
			break;

		case 3:
			LimparConsole limpar2 = new LimparConsole();
			limpar2.limparTela();

			Listar listar1 = new Listar(scanner, colecionadorDAO);
			listar1.listar();

			AlterarCarro alterarCarro = new AlterarCarro(scanner, carDAO);
			alterarCarro.alterarCar();
			break;
		case 4:

			LimparConsole limpar3 = new LimparConsole();
			limpar3.limparTela();

			Listar listar2 = new Listar(scanner, colecionadorDAO);
			listar2.listar();

			ApagarCarro apagarCarro = new ApagarCarro(scanner, carDAO);
			apagarCarro.apagarCarro();

			MenuPrincipal menuPrincipal = new MenuPrincipal(scanner);
			menuPrincipal.mostraMenu();

			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
	}

}
