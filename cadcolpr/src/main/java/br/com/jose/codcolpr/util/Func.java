package br.com.jose.codcolpr.util;

public class Func {

	public static String getTamtr(String texto, int tamanhoTotal) {
		
		return String.format("%-" + tamanhoTotal + "s", texto);
	}
}
