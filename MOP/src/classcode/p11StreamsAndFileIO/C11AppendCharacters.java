package classcode.p11StreamsAndFileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Cria um ficheiro com caracteres e faz append nesse ficheiro
 * 
 * @author Ant�nio Te�filo
 * 
 */
public class C11AppendCharacters {
	public static void main(String[] args) throws IOException {
		String fileName = "AppendFileChars.txt";
		PrintWriter fout = null;

		try {
			fout = new PrintWriter(fileName);
			fout.println("Primeira linha.");
			fout.close();

			// a escrita no FileOutputStream ser� realizada em modo Append, ou
			// seja no final do ficheiro
			fout = new PrintWriter(new FileWriter(fileName, true));
			fout.println("Segunda linha.");
			fout.close();
		} finally {
			if (fout != null) {
				fout.close();
			}
		}
		System.out.println("End of main...");
	}
}
