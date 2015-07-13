package classcode.p11StreamsAndFileIO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Tests {

	public static void main(String[] args) {
		try {
			String s1 = "2014/01/01  40000 250  40000 35  40010 35  40222 1000";
			String s2 = "2014/01/02  40000 250  40000 35  40010 35  40222 1000";
			String s3 = "2014/01/03  40000 250  40000 35  40010 35  40222 1000";
			String s4 = "2014/01/04  40000 250  40000 35  40010 35  40222 1000";
			String s5 = "2014/01/05  40000 250  40000 35  40010 35  40222 1000";
			
			String[] s = new String[]{s1,s2,s3,s4,s5};
			PrintWriter pw = new PrintWriter("file1.txt");
			for (int i = 0; i < s.length; i++) {
				pw.println(s[i]);
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
