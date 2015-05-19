package classcode.p11StreamsAndFileIO;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Teste ao m�todo printf de PrintWriter
 * 
 */

public class C04Printf {

	public static void main(String[] args) throws IOException {

		// printf("%?", val) - o % indica que se segue na string a mostrar um
		// argumento que deve ser interpretado com a formata��o indicada: d -
		// inteiro, x - inteiro em hexadecimal, c - caracter, s - string, b -
		// bin�rio, f - float/double, n - imprime '%'. Ver
		// "Format string syntax" do help de printf. Pode-se indicar a dimens�o
		// do campo a escrever, alinhamento � esquerda ou direita, etc.

		System.out.println("Execu��o...");

		// PrintWriter pw = new PrintWriter(System.out);
		PrintWriter pw = new PrintWriter("f.txt");

		// uma string de controlo, simples, s� com %n que � o fim de linha
		pw.printf("Segunda-feira, dia 13 de Maio de 2013%n");

		// uma string de controlo com argumentos de: string, int, string, int
		int dia = 13, ano = 2013;
		String diaSemana = "Segunda-feira", mes = "Maio";
		pw.printf("%s, dia %d de %s de %d%n", diaSemana, dia, mes, ano);

		// uma string de controlo com um argumento boolean
		boolean isDomingo = false;
		pw.printf("Hoje � domingo -> %b%n", isDomingo);

		// escrita de um float e de um double
		float f = 2.3f;
		pw.printf("float f -> %f%n", f);
		double d = 4.04;
		pw.printf("double d -> %f%n", d);

		// formata��es

		// dimens�o do campo, alinhamentos, preenchimento das casas � esquerda,
		// com sinal
		int dim = 100;
		pw.printf("Inteiros -> %6d, %06d, %1$-6d, %+d%n", dim, dim, -dim);

		// formata��es com n�meros decimais: dimens�o total, n� casa decimais
		pw.printf("Double 5.1 -> %05.1f%n", d);
		pw.printf("Double 5.1 -> %05.1f%n", 10000 * d);

		// escrita de uma string com defini��o din�mica
		dim = 5;
		String formatString = "Inteiros -> %0" + dim + "d, %0" + 2 * dim + "d ";
		pw.printf(formatString, 100, 200);

		pw.close();
	}
}
