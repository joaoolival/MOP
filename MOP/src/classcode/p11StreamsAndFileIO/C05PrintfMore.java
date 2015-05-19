package classcode.p11StreamsAndFileIO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Formata��o de output atrav�s do m�todo format de PrintStream (%d - escrita de
 * um inteiro, %c - escrita de um caracter, %s - escrita de um string, %b -
 * escrita de um booleano, %f - escrita de um float)
 * 
 * @author Ant�nio Te�filo
 * 
 */
public class C05PrintfMore {
	public static void main(String[] args) {
		String fileName = "Formats.txt";

		// PrintStream out = System.out; // experimentar com system.out
		PrintWriter out = null;
		try {
			// out = new PrintWriter(System.out, true); // fileName);
			out = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			System.err.println("Erro na abertura do ficheiro");
			System.exit(1);
		}

		int i = 2;
		double r = Math.sqrt(i);

		out.println("The square root of " + i + " is " + r + ".");

		out.print("The square root of ");
		out.print(i);
		out.print(" is ");
		out.print(r);
		out.println(".");

		// o %d indica que se segue um inteiro
		// o %.5f indica que se segue um float e que deve ser escrita com cinco
		// casas decimais.
		// o %n coloca um fim de linha
		out.format("The square root of %d is %.5f %n", i, r);
		// escrita do float a oito caracteres dos quais cinco s�o decimais
		out.format("The square root of %03d is %08.5f %n", i, r);
		out.format("The square root of %d is %08.5f %n", 4, 2.0);
		out.format("The square root of %d is %08.5f %n", 4, 200.0);

		int dia = 7;
		// escrita de um inteiro com dois digitos (m�nimo) e com zeros � direita
		out.format("Hoje � dia %02d%n", dia);

		// o %s indica que se segue uma string; o sinal de menos depois do %
		// indica que o alinhamento � � esquerda
		out.format("%5d - %-10s - %10s.%n", 53450, "Jo�o", "Lisboa");
		out.format("%5d - %-10s - %10s.%n", 2355, "Ana", "Porto");
		out.format("%5d - %-10s - %10s.%n", 56363, "Manuel", "Coimbra");
		out.format("%5d - %-10s - %10s.%n", 567, "Daniela", "Faro");

		out.format("%s%n", "Ol� bom dia");

		boolean isSummer = false;
		out.format("Is Summer? %b", isSummer);
		// out.flush();
		out.close(); // verificar que sem close o fichiero fica vazio

		System.out.println("Ficheiro " + fileName + " gerado");
	}
}
