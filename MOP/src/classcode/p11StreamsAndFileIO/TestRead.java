package classcode.p11StreamsAndFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestRead {
	public static void main(String[] args) {
		try {
			Scanner fileScan = new Scanner(new File("file1.txt"));
			int numLines = 0;
			while(fileScan.hasNextLine()){
				String line = fileScan.nextLine();
				System.out.println(line);
				numLines++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
