package br.com.jose.codcolpr.menucolecionador;

import java.util.Scanner;

import br.com.jose.cadcolpr.persistence.CarroDAO;
import br.com.jose.cadcolpr.persistence.ColecionadorDAO;
import br.com.jose.codcolpr.limpaconsole.LimparConsole;
import br.com.jose.codcolpr.menuprincipal.MenuPrincipal;

public class MenuColecionador {

	private Scanner scanner;

	public MenuColecionador(Scanner scanner) {

		this.scanner = scanner;

	}

	public void menuColecionador() {

		ColecionadorDAO colDao = new ColecionadorDAO();
		CarroDAO carDao = new CarroDAO();

		System.out.println();
		System.out.println("Menu Colecionador");

		System.out.println("_____________________________");
		System.out.println("1- Listar");
		System.out.println("2- Novo colecionador");
		System.out.println("3- Alterar colecionador");
		System.out.println("4- Apagar");
		System.out.println("5- Buscar colecionador por CPF");
		System.out.println("6- Voltar para o menu principal");
		System.out.print("Selecione:");

		int numopcao = Integer.parseInt(scanner.nextLine());

		System.out.println("_____________________________");

		switch (numopcao) {
		case 1:

			LimparConsole limpar = new LimparConsole();
			limpar.limparTela();

			Listar listar = new Listar(scanner, colDao);
			listar.listar();

			MenuColecionador menu = new MenuColecionador(scanner);
			menu.menuColecionador();
			break;
		case 2:

			LimparConsole limpar1 = new LimparConsole();
			limpar1.limparTela();

			AdicionaCol adicionar = new AdicionaCol(scanner, colDao);
			adicionar.adicionaCol();

			MenuColecionador menu1 = new MenuColecionador(scanner);
			menu1.menuColecionador();
			break;

		case 3:

			LimparConsole limpar2 = new LimparConsole();
			limpar2.limparTela();

			AlterarCol altCol = new AlterarCol(scanner, colDao);
			altCol.alterarCol();

			MenuColecionador menu2 = new MenuColecionador(scanner);
			menu2.menuColecionador();

			break;

		case 4:

			LimparConsole limpar3 = new LimparConsole();
			limpar3.limparTela();

			ApagarCol apagarCol = new ApagarCol(scanner, colDao, carDao);
			apagarCol.apagarCol();

			MenuColecionador menu3 = new MenuColecionador(scanner);
			menu3.menuColecionador();

			break;

		case 5:

			LimparConsole limpar5 = new LimparConsole();
			limpar5.limparTela();

			BuscarColecionador listaEspecif = new BuscarColecionador(scanner, colDao);
			listaEspecif.listar();

			break;

		case 6:

			LimparConsole limpar4 = new LimparConsole();
			limpar4.limparTela();

			MenuPrincipal menuPrincipal = new MenuPrincipal(scanner);
			menuPrincipal.mostraMenu();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}
}
