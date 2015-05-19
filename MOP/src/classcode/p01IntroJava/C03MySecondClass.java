package classcode.p01IntroJava;

/**
 *  Uma classe existe dentro de um package. Para se utilizar qualquer 
 *  classe num programa � necess�rio especificar o package de cada uma.
 *  java.util.Scanner(System.in) que est� dentro do main, refere a classe
 *  java.util.Scanner que portanto est� dentro do package java.util. No 
 *  se se declara o import de java.util.Scanner ou java.util.* a classe 
 *  Scanner fica acess�vel sem se ter de indicar a localiza��o completa 
 *  do seu package cada vez que se pretende utilizar uma refer�cnia a
 *  Scanner, tal como acontece em "Scanner keyboard = ".
 *  
 *  
 *  Um import permite declarar a localiza��o de uma classe ou conjunto de 
 *  classes, o que pertime utilizar essa(s) classe(s) sem se ter que indicar 
 *  sempre o seu package. 
 */
import java.util.Scanner;

/**
 * Programa que calcula o dobro de um valor introduzido pelo utilizador
 */
public class C03MySecondClass {

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		System.out.println("Ol� pessoal.");

		// Declarar uma vari�vel do tipo java.util.Scanner que � uma classe
		// auxiliar que permite a leitura da consola de uma forma pr�tica
		Scanner keyboard = new java.util.Scanner(System.in);

		// Indicar ao utilizador que deve introduzir um inteiro
		System.out.print("Introduza um inteiro -> ");

		// Ler um inteiro da consola e coloc�-lo na vari�vel val
		int val = keyboard.nextInt();

		// Mostrar na consola o valor lido, para verificar que a leitura est�
		// correcta
		System.out.println("O inteiro lido foi -> " + val);

		// Calcular o dobro do valor recebido. Facil...
		int dobro = val * 2;

		// Escrever na consola o resultado, com um texto esclarecedor
		System.out.println("O dobro  de " + val + " � -> " + dobro);

		// fechar o keyboard
		keyboard.close();
	}
}
