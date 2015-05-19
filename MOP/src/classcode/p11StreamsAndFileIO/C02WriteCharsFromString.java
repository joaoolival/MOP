package classcode.p11StreamsAndFileIO;

import java.io.IOException;

/**
 * Mostra os caracteres print�veis do Cp1252 mas provenientes de uma string.
 */

public class C02WriteCharsFromString {

	public static void main(String[] args) throws IOException {

		String[] chars = { "................", "................",
				" !\"#$%&'()*+,-./", "0123456789:;<=>?", "@ABCDEFGHIJKLMNO",
				"PQRSTUVWXYZ[\\]^_", "`abcdefghijklmno", "pqrstuvwxyz{|}~",
				"????????????????", "????????????????", "����������������",
				"����������������", "����������������", "����������������",
				"����������������", "����������������" };

		for (int i = 0; i < chars.length; i++) {
			System.out.println(chars[i]);
		}
	}
}
