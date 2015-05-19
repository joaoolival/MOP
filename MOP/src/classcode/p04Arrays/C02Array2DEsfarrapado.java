package classcode.p04Arrays;

/**
 * Teste a um array 2d esfarrapado, ou seja um array em que a 2ª dimensão pode
 * variar para cada elemento da 1ª dimensão
 */
public class C02Array2DEsfarrapado {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// criar a primeira dimesão
		int[][] tabela2 = new int[11][];

		// criar a segunda dimensão, que é variável e inicializar o array
		for (int i = 0; i < tabela2.length; i++) {
			// a 2ª dimensão varia
			tabela2[i] = new int[i < 6 ? i + 1 : 11 - i];
			// inicializar o elementos do array
			for (int j = 0; j < tabela2[i].length; j++) {
				tabela2[i][j] = (int) (Math.random() * 100);
			}
		}

		// mostrar o array na consola
		for (int i = 0; i < tabela2.length; i++) {
			for (int x = 0; x < tabela2[i].length; x++) {
				System.out.print(tabela2[i][x] + " ");
			}
			System.out.println();
		}

	}

}
