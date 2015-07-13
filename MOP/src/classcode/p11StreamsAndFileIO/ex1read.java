package classcode.p11StreamsAndFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ex1read {

	public static int obterValorPago(String fileName, int numAluno,
			String data1, String data2) throws IOException {
		int valorTotal = 0;
		boolean inDate = false;
		Scanner fileScan = new Scanner(new File("file1.txt"));
		while (fileScan.hasNextLine()) {
			String line = fileScan.nextLine();

			Scanner lineScan = new Scanner(line);
			// ver se a linha e null
			if (lineScan.hasNext()) {
				String auxDate = lineScan.next();
				if (auxDate.equals(data1)) {
					inDate = true;
				}

				if (inDate) {
					while (lineScan.hasNextInt()) {
						if (lineScan.nextInt() == numAluno) {
							valorTotal += lineScan.nextInt();
						}
					}
					lineScan.close();
					if (auxDate.equals(data2)) {
						inDate = false;
						break; 
					}
				}
			}
		}
		fileScan.close();
		return valorTotal;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(obterValorPago("file1.txt", 40010, "2014/01/01",
				"2014/01/02"));
	}
}