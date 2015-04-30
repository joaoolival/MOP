package tps.tp2.pack2Percursos;

import java.util.Arrays;

//para que serve o maxPercuros?
//o que gravar no nPercursos?

/**
 * Classe que suporta um percurso composto por v�rios percursos simples
 */
public class PercursoComposto {

	/**
	 * Nome do percurso, deve respeitar a regra de valida��o dos nomes em
	 * percurso simples
	 */
	private String nome;

	/**
	 * Array com os percursos simples. Os elementos devem ser colocados nos
	 * �ndices menores. Tem de ter pelo menos um percurso. N�o admite
	 * localidades repetidas. Os percursos t�m de estar em sequ�ncia, ou seja,
	 * onde termina o percurso de �ndice 0 tem de ser onde se inicia o percurso
	 * de �ndice 1 e assim sucessivamente ...
	 */
	private PercursoSimples[] percursos;

	/**
	 * N� de percursos
	 */
	private int nPercursos;

	/**
	 * Constructor que recebe apenas um percurso, al�m do nome e do n� m�ximo de
	 * percursos. Este constructor deve chamar o constructor que a ele se segue.
	 * 
	 * @param nome
	 *            Nome do percurso
	 * @param percurso
	 *            Percurso a ser guardado
	 * @param maxPercursos
	 *            N� m�ximo de percursos suportado
	 */
	public PercursoComposto(String nome, PercursoSimples percurso,
			int maxPercursos) {
		this(nome, new PercursoSimples[] { percurso }, maxPercursos);
	}

	/**
	 * Constructor que recebe o nome, um array de percursos e o m�ximo de
	 * percursos a suportar. Em caso de argumentos inv�lidos deve ser lan�ada a
	 * excep��o IllegalArgumentException com uma mensagem a indicar o erro
	 * ocorrido e o argumento inv�lido.
	 * 
	 * @param nome
	 *            Nome do percurso
	 * @param percursos
	 *            Percursos a serem guardados. O array n�o pode conter nulls,
	 *            tem de conter pelo menos um percurso e os seus percursos devem
	 *            estar em sequ�ncia.
	 * @param maxPercursos
	 *            N� m�ximo de percursos suportado
	 */
	public PercursoComposto(String nome, PercursoSimples[] percursos,
			int maxPercursos) {
		if (!(PercursoSimples.validarNomeDeLocal(nome)))
			throw new IllegalArgumentException("Nome inv�lido -> " + nome);

		for (int i = 0; i < percursos.length; i++) {
			if (percursos[i] == null)
				throw new IllegalArgumentException(
						"Array de percursos inv�lido pois contem nulls -> "
								+ percursos);

			if (i < (percursos.length - 1)
					&& (percursos[i].getFim() != percursos[i + 1].getInicio()))
				throw new IllegalArgumentException(
						"Array de percursos inv�lido nao esta em sequencia -> "
								+ percursos);
		}

		this.nome = nome;
		this.nPercursos = percursos.length;

		// cria array com o max tamanho
		PercursoSimples[] percursosFullLength = new PercursoSimples[maxPercursos];
		System.arraycopy(percursos, 0, percursosFullLength, 0, percursos.length);
		this.percursos = percursosFullLength;

	}

	/**
	 * Copy constructor, deve criar uma c�pia do percurso recebido. Essa c�pia
	 * deve ser uma c�pia profunda.
	 * 
	 * @param pc
	 *            Percurso a copiar
	 */
	public PercursoComposto(PercursoComposto pc) {
		this(pc.nome, pc.percursos, pc.nPercursos);
	}

	/**
	 * Deve criar uma c�pia profunda do percurso corrente
	 */
	public PercursoComposto clone() {
		return new PercursoComposto(this.nome, this.percursos, this.nPercursos);
	}

	/**
	 * Deve adicionar o percurso no final, desde que este esteja em sequ�ncia e
	 * haja espa�o
	 * 
	 * @param percurso
	 *            Percurso a adicionar
	 * @return True se adicionou
	 */
	public boolean addicionarPercursoNoFinal(PercursoSimples percurso) {
		if ((percursos[nPercursos - 1].getFim() == percurso.getInicio())
				&& percursos.length != nPercursos) {
			percursos[nPercursos] = percurso;
			nPercursos += 1;
			return true;
		}
		return false;
	}

	/**
	 * Deve adicionar o percurso no in�cio, desde que este esteja em sequ�ncia e
	 * haja espa�o
	 * 
	 * @param percurso
	 *            Percurso a adicionar
	 * @return True se adicionou
	 */
	public boolean addicionarPercursoNoInicio(PercursoSimples percurso) {
		if (percurso.getFim() == percursos[0].getInicio()
				&& percursos.length != nPercursos) {
			nPercursos += 1;
			System.arraycopy(percursos, 0, percursos, 1, percursos.length - 1);
			percursos[0] = percurso;
			return true;
		}
		return false;
	}

	/**
	 * Deve remover e devolver todos os percursos desde o ponto da localidade
	 * recebida. Exemplo: percurso com a-b/b-c/c-d/d-e,
	 * removerPercursoNoFimDesde(c), deve resultar no percurso com a-b/b-c e
	 * deve devolver c-d/d-e.
	 * 
	 * @param localidade
	 *            Local a partir do qual se deve remover os percursos
	 * @return Os percursos removido ou null caso n�o remova nada
	 */
	public PercursoSimples[] removerPercursosNoFimDesde(String localidade) {
		int aux = 0;

		System.out.println("array inical -> " + Arrays.toString(percursos));
		if (percursos[0].getInicio() == localidade) {
			PercursoSimples[] removePart = Arrays.copyOfRange(percursos, 0,
					nPercursos);
			for (int i = 0; i < nPercursos; i++) {
				percursos[i] = null;
			}
			nPercursos = 0;
			System.out.println("array final -> " + Arrays.toString(percursos));
			return removePart;
		}
		for (int i = 0; i < nPercursos; i++) {
			if (percursos[i].getFim() == localidade) {
				aux = i;
				break;
			}
			if (i == nPercursos - 1)
				return null;
		}
		// incremento no aux para criar array das remo�oes
		aux += 1;
		PercursoSimples[] removePart = Arrays.copyOfRange(percursos, aux,
				nPercursos);

		int length = nPercursos;
		for (; aux < length; aux++) {
			percursos[aux] = null;
			nPercursos--;
		}
		System.out.println("array final -> " + Arrays.toString(percursos));
		return removePart;
	}

	/**
	 * Deve remover e devolver todos os percursos desde o in�cio at� ao ponto da
	 * localidade recebida. Exemplo: percurso com a-b/b-c/c-d/d-e,
	 * removerPercursoNoInicioAte(c), deve resultar no percurso com c-d/d-e e
	 * devolver a-b/b-c.
	 * 
	 * @param localidade
	 *            Local at� � qual se deve remover os percursos
	 * @return Os percursos removido ou null caso n�o remova nada
	 */
	public PercursoSimples[] removerPercursosNoInicioAte(String localidade) {
		int aux = 0;

		System.out.println("array inical -> " + Arrays.toString(percursos));
		if (percursos[nPercursos-1].getFim() == localidade) {
			PercursoSimples[] removePart = Arrays.copyOfRange(percursos, 0,
					nPercursos);
			for (int i = 0; i < nPercursos; i++) {
				percursos[i] = null;
			}
			nPercursos = 0;
			System.out.println("array final -> " + Arrays.toString(percursos));
			return removePart;
		}
		for (int i = 0; i < nPercursos; i++) {
			if (percursos[i].getInicio() == localidade) {
				aux = i;
				break;
			}
		}
		if (aux == 0)
			return null;
		// incremento no aux para criar array das remo�oes
		//aux += 1;
		PercursoSimples[] removePart = Arrays.copyOfRange(percursos, 0,
				aux);
		System.arraycopy(percursos, aux, percursos, 0 , nPercursos-aux);

		int length = nPercursos;
		for (int i = length - aux; i < length; i++) {
			percursos[i] = null;
			nPercursos--;
		}
		System.out.println("array final -> " + Arrays.toString(percursos));
		return removePart;
	}

	/**
	 * Deve devolver o �ndice do percurso em que a localidade � in�cio, ou -1
	 * caso n�o encontre
	 * 
	 * @param localidade
	 *            Local a procurar
	 * @return o �ndice do percurso que tem a localidade recebida como in�cio ou
	 *         null caso n�o a encontre
	 */
	private int findLocalidade(String localidade) {
		// TODO
		return -1;
	}

	/**
	 * Devolve o in�cio do percurso
	 * 
	 * @return O local de in�cio do percurso
	 */
	public String getInicio() {
		return percursos[0].getInicio();
	}

	/**
	 * Devolve o fim do percurso
	 * 
	 * @return O local de fim do percurso
	 */
	public String getFim() {
		return percursos[nPercursos-1].getFim();
	}

	/**
	 * Devolve a dist�ncia do percurso, que deve ser o somat�rio das dist�ncias
	 * dos seus percursos
	 * 
	 * @return A dist�ncia do percurso
	 */
	public int getDistancia() {
		// TODO
		return 0;
	}

	/**
	 * Devolve o declive do percurso, que deve ser o somat�rio dos declives dos
	 * seus percursos
	 * 
	 * @return O declive do percurso
	 */
	public int getDeclive() {
		// TODO
		return 0;
	}

	/**
	 * Devolve o declive do percurso, que deve ser o somat�rio dos declives dos
	 * seus percursos, mas s� se deve considerar os declives positivos
	 * 
	 * @return O declive acumulado do percurso mas s� considerando os declives
	 *         positivos
	 */
	public int getSubidaAcumulada() {
		// TODO
		return 0;
	}

	/**
	 * Devolve o nome do percurso
	 * 
	 * @return O nome do percurso
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do percurso
	 * 
	 * @param nome
	 *            O novo nome do percurso
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Devolve uma string com uma descriu��o do percurso, tal como:
	 * "NORTE_SUL de Sagres para Lisboa, com 345000 metros, com 0 de declive e com 2 percursos"
	 * 
	 * @return O string que descreve o percurso
	 */
	public String toString() {
		return nome + " de " + this.getInicio() + " para " + this.getFim()
				+ " com " + this.getDistancia() + " metros , com declive "
				+ this.getDeclive() + " e com " + nPercursos + " percursos";
	}

	/**
	 * Imprime na consola o percurso. Deve mostrar na primeiro linha o prefixo
	 * seguido da informa��o do toString deste objecto. Depois deve mostrar os
	 * seus percursos, um por linha, chamando os seus m�todos de print, mas
	 * passando como prefixo o prefixo recebido e prefixado de 3 espa�os.
	 * 
	 * @param prefix
	 *            Prefixo a colocar antes da informa��o do toString e tamb�m na
	 *            parte de mostrar os percursos.
	 */
	public void print(String prefix) {
		System.out.println(prefix + toString());
		for (int i = 0; i < nPercursos; i++) {
			percursos[i].print("   " + prefix);
		}
	}

	/**
	 * Main, para testes
	 * 
	 * @param args
	 *            Argumentos do main
	 */
	public static void main(String[] args) {
		PercursoSimples ps1 = new PercursoSimples("A2", "Faro", "Lisboa",
				278_000, 0);
		PercursoSimples ps2 = new PercursoSimples("A1", "Lisboa", "Porto",
				317_000, 0);

		PercursoSimples psTEST = new PercursoSimples("A4", "Porto", "Braga",
				317_000, 0);

		PercursoSimples[] percursos = new PercursoSimples[] { ps1, ps2 };

		PercursoComposto pcTEST = new PercursoComposto("NORTE_SUL", percursos,
				4);
		boolean resultTEST = pcTEST.addicionarPercursoNoFinal(psTEST);
		pcTEST.print("> ");
		System.out.println();
		System.out.println("A adi��o de " + psTEST + " deu -> " + resultTEST);
		System.out.println();

		System.out
				.println("-----------------------------Meu teste---------------------------------");
		//System.out.println("remocao no fim desde");
		//System.out.println(Arrays.toString(pcTEST
		//		.removerPercursosNoFimDesde("Porto")));
		//
		System.out.println("remocao no inicio ate");
		System.out.println(Arrays.toString(pcTEST.removerPercursosNoInicioAte("Lisboa")));
		System.out
		.println("-----------------------------Meu teste---------------------------------");

		PercursoComposto pc1 = new PercursoComposto("NORTE_SUL", percursos, 20);
		pc1.print("> ");
		System.out.println();

		PercursoSimples ps3 = new PercursoSimples("A1", "Porto",
				"Viana Do Castelo", 73_800, 0);
		boolean result = pc1.addicionarPercursoNoFinal(ps3);
		pc1.print("> ");
		System.out.println();

		System.out.println("A adi��o de " + ps3 + " deu -> " + result);
		System.out.println();
		/*
		 * PercursoSimples ps4 = new PercursoSimples("A23", "Sagres", "Faro",
		 * 67_000, 0); pc1.addicionarPercursoNoInicio(ps4); pc1.print("> ");
		 * System.out.println();
		 * 
		 * // clone System.out.println("Clone:"); PercursoComposto pc2 =
		 * pc1.clone(); pc1.print("> "); System.out.println();
		 * 
		 * // removerPercursosNoFim PercursoSimples[] psx =
		 * pc1.removerPercursosNoFimDesde("Lisboa"); pc1.print("> ");
		 * System.out.println("Percursos removidos -> " + Arrays.toString(psx));
		 * System.out.println();
		 * 
		 * // removerPercursosNoInicio
		 * 
		 * PercursoSimples[] psx2 = pc2.removerPercursosNoInicioAte("Lisboa");
		 * pc2.print("> "); System.out.println("Percursos removidos -> " +
		 * Arrays.toString(psx2));
		 */
	}

}