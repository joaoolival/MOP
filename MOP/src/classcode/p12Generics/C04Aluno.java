package classcode.p12Generics;

import java.util.Arrays;

/**
 * C04aluno implementa a interface Comparable, pelo que � ent�o compar�vel
 * segundo a defini��o de Comparable, ou seja, implementa o m�todo compareTo
 */
public class C04Aluno implements Comparable<C04Aluno> {

	private String name;
	private int numero;
	private int nUCTerminadas;

	private C04Aluno(String name, int num, int nUCTerminadas) {
		this.name = name;
		this.numero = num;
		this.nUCTerminadas = nUCTerminadas;
	}

	// m�todo que implementa a ordem natural de compara��o
	public int compareTo(C04Aluno p) {
		if (p == null)
			throw new NullPointerException();
		return name.compareTo(p.name);
	}

	public String toString() {
		return name + " " + numero + " " + nUCTerminadas;
	}

	public static void main(String[] args) {
		C04Aluno[] alunos = { new C04Aluno("Jos�", 10000, 5),
				new C04Aluno("Maria", 20000, 3),
				new C04Aluno("Filipa", 15000, 4) };

		System.out.println("Array at beginning -> " + Arrays.toString(alunos));

		Arrays.sort(alunos);
		System.out.println("Array after sorting by natural order -> "
				+ Arrays.toString(alunos));

	}
}
