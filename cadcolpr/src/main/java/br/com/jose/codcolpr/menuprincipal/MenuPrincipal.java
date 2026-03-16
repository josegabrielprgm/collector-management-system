package br.com.jose.codcolpr.menuprincipal;

import java.util.Scanner;

import br.com.jose.codcolpr.menucarro.MenuCarro;
import br.com.jose.codcolpr.menucolecionador.MenuColecionador;

public class MenuPrincipal {

	private Scanner scanner;

	public MenuPrincipal(Scanner scanner) {
		this.scanner = scanner;
	}

	public void mostraMenu() {

		boolean repete = true;

		while (repete) {

			String reset = "\u001B[0m";
			String verde = "\u001B[32m";
			String azul = "\u001B[34m";
			String amarelo = "\u001B[33m";

			System.out.println();

			System.out.println(verde + "╔════════════════════════════════════╗" + reset);
			System.out.println(verde + "║                                    ║" + reset);
			System.out.println(verde + "║            BEM VINDO!              ║" + reset);
			System.out.println(verde + "║                                    ║" + reset);
			System.out.println(verde + "║       Sistema iniciado com         ║" + reset);
			System.out.println(verde + "║             sucesso!               ║" + reset);
			System.out.println(verde + "║                                    ║" + reset);
			System.out.println(verde + "╚════════════════════════════════════╝" + reset);

			System.out.println(azul + "╔════════════════════════════════════╗" + reset);
			System.out.println(azul + "║              MENU                  ║" + reset);
			System.out.println(azul + "╠════════════════════════════════════╣" + reset);
			System.out.println(azul + "║  1 ➜ Colecionador                  ║" + reset);
			System.out.println(azul + "║  2 ➜ Carro                         ║" + reset);
			System.out.println(azul + "║  0 ➜ Sair                          ║" + reset);
			System.out.println(azul + "╠════════════════════════════════════╣" + reset);

			System.out.print(amarelo + "   Escolha uma opção: " + reset);

			int numopcao = Integer.parseInt(scanner.nextLine());

			System.out.println("_________________________");

			switch (numopcao) {
			case 1:
				MenuColecionador menu = new MenuColecionador(scanner);
				menu.menuColecionador();
				break;

			case 2:
				MenuCarro menuCarro = new MenuCarro(scanner);
				menuCarro.menuCarro();

				break;

			case 0:
				repete = false;
				System.out.println("Sistema finalizado");
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}

			System.out.println("_________________________");

		}
	}
}
