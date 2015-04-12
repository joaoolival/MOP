package oldClass.tp1;

import java.util.Random;

public class P03ArraysExtractUniqsAndReps {

	/*
	 * Faça o programa P03ArraysExtractUniqsAndRepsOld que: declare dois arrays de
	 * 10 inteiros, iniciados com recurso ao gerador aleatório Random, com
	 * valores compreendidos entre 0 e 20 (os dois inclusive) mas que não tenham
	 * repetições dentro do mesmo array (repetindo a geração aleatória se
	 * necessário); mostre o conteúdo dos dois arrays na consola; obtenha num
	 * array somente os valores que não têm repetições entre os dois array
	 * iniciais; obtenha num outro array somente os valores que têm repetições
	 * entre os dois array iniciais; os dois array finais devem ter a dimensão
	 * exacta para conterem os devidos elementos; e mostre o conteúdo dos dois
	 * arrays finais na consola. Exemplo da utilização do gerador aleatório:
	 * “Random.nextInt(10)” devolve um valor aleatório no intervalo [0..9].
	 * Exemplo do pretendido: a1 = [2, 6, 8, 4, 9], a2 = [5, 6, 2, 7, 8], array
	 * de únicos = [4, 9, 5, 7], array de repetidos = [2, 6, 8]. A ordem dos
	 * elementos nos array s finais não é relevante.
	 */

	public static void main(String[] args) {
		Random random = new Random();
		int[] a1 = new int[5];
		int[] a2 = new int[5];

		// ciclo que que insere valores diferentes aleatorios no array a1
		for (int i = 0; i < a1.length; i++) {
			a1[i] = random.nextInt(20);
			for (int j = 0; j < i;) {
				if (a1[i] == a1[j]) {
					a1[i] = random.nextInt(20);
					j = 0;
				} else {
					j++;
				}
			}
		}
		// ciclo que que insere valores diferentes aleatorios no array a2
		for (int i = 0; i < a2.length; i++) {
			a2[i] = random.nextInt(20);
			for (int j = 0; j < i; j++) {
				if (a2[i] == a2[j]) {
					a2[i] = random.nextInt(20);
					j = -1;
				}
			}
		}

		// mostrar o array a1
		System.out.print("a1 -> [");
		for (int i = 0; i < a1.length; i++)
			System.out.print(a1[i] + (i < a1.length - 1 ? ", " : ""));
		System.out.print("]");

		System.out.println("");
		System.out.println("");

		// mostrar o array a2
		System.out.print("a2 -> [");
		for (int i = 0; i < a2.length; i++)
			System.out.print(a2[i] + (i < a2.length - 1 ? ", " : ""));
		System.out.print("]");

		// ciclo que conta o numero de repeticoes
		int rep = 0;
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a2.length; j++) {
				if (a1[i] == a2[j]) {
					rep++;
				}
			}
		}

		// ciclo que insere o valores repetidos num novo array
		int[] repArray = new int[rep];
		int repIndex = 0;
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a2.length; j++) {
				if (a1[i] == a2[j]) {
					repArray[repIndex] = a1[i];
					repIndex++;
				}
			}
		}

		System.out.println("");
		System.out.println("");

		// ciclo que mostra todas as repeticoes
		System.out.print("rep -> [");
		for (int i = 0; i < repArray.length; i++)
			System.out.print(repArray[i]
					+ (i < repArray.length - 1 ? ", " : ""));
		System.out.println("]");

		System.out.println("");

		// ciclo que conta o numero de numeros que nao se repetem
		int uniq = 0;
		boolean uniqBool = true;
		int[] auxUniq = new int[10];
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a2.length; j++) {
				if (a1[i] == a2[j]) {
					uniqBool = false;
				}
			}
			if (uniqBool) {
				// numeros que nao se repetem sao postos no array auxiliar
				auxUniq[uniq] = a1[i];
				uniq++;
			}
			uniqBool = true;
		}

		uniqBool = true;
		for (int i = 0; i < a2.length; i++) {
			for (int j = 0; j < a1.length; j++) {
				if (a2[i] == a1[j]) {
					uniqBool = false;
				}
			}
			if (uniqBool) {
				// numeros que nao se repetem sao postos no array auxiliar
				auxUniq[uniq] = a2[i];
				uniq++;
			}
			uniqBool = true;
		}
		// ciclo que insere os valores do array auxiliar num array final
		int[] uniqArray = new int[uniq];
		for (int i = 0; i < uniqArray.length; i++) {
			uniqArray[i] = auxUniq[i];
		}
		// show do array final
		System.out.print("uniq -> [");
		for (int i = 0; i < uniqArray.length; i++)
			System.out.print(uniqArray[i]
					+ (i < uniqArray.length - 1 ? ", " : ""));
		System.out.print("]");

	}

}
