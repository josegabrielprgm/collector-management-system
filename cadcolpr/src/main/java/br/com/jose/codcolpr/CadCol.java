package br.com.jose.codcolpr;

import java.util.Scanner;

import br.com.jose.codcolpr.menuprincipal.MenuPrincipal;

public class CadCol {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		MenuPrincipal menu = new MenuPrincipal(scanner);

		menu.mostraMenu();

	}

}
