package tps.tp2.pack2Percursos;

import java.util.Arrays;

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
		// caso o nome nao seja valido
		if (!(PercursoSimples.validarNomeDeLocal(nome)))
			throw new IllegalArgumentException("Nome inv�lido -> " + nome);
		
		for (int i = 0; i < percursos.length; i++) {
			// caso alguma posicao do array de percursos seja null
			if (percursos[i] == null)
				throw new IllegalArgumentException(
						"Array de percursos inv�lido pois contem nulls -> "
								+ percursos);
			// caso os varios percursos nao estejam em sequencia
			if (i < (percursos.length - 1)
					&& (!(percursos[i].getFim().equals(percursos[i + 1].getInicio()))))
				throw new IllegalArgumentException(
						"Array de percursos inv�lido nao esta em sequencia -> "
								+ percursos);
		}
		
		this.nome = nome;
		this.nPercursos = percursos.length;

		// grava os percursos mas um array com o tamanho do maximo de percursos
		this.percursos = Arrays.copyOf(percursos,
				maxPercursos);
	}

	/**
	 * Copy constructor, deve criar uma c�pia do percurso recebido. Essa c�pia
	 * deve ser uma c�pia profunda.
	 * 
	 * @param pc
	 *            Percurso a copiar
	 */
	public PercursoComposto(PercursoComposto pc) {
		this(pc.nome, Arrays.copyOfRange(pc.percursos, 0, pc.nPercursos), pc.percursos.length);
	}

	/**
	 * Deve criar uma c�pia profunda do percurso corrente
	 */
	public PercursoComposto clone() {
		return new PercursoComposto(nome, Arrays.copyOfRange(percursos, 0, nPercursos), percursos.length);
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
		//adiciona caso esteja em sequencia
		if ((percursos[nPercursos - 1].getFim().equals(percurso.getInicio()))
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
		//adiciona caso esteja em sequencia
		if (percurso.getFim().equals(percursos[0].getInicio())
				&& percursos.length != nPercursos) {
			//faz shift ao array para inserir o novo percurso
			System.arraycopy(percursos, 0, percursos, 1, percursos.length - 1);
			percursos[0] = percurso;
			nPercursos += 1;
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
		// caso a localidade a remover seja a primeira
		if (percursos[0].getInicio().equals(localidade)) {
			PercursoSimples[] removePart = Arrays.copyOfRange(percursos, 0,
					nPercursos);
			//limpa o array
			for (int i = 0; i < nPercursos; i++) {
				percursos[i] = null;
			}
			nPercursos = 0;
			return removePart;
		}
		// percorre todas as localidades de fim e compara com a localidade
		for (int i = 0; i < nPercursos; i++) {
			if (percursos[i].getFim().equals(localidade)) {
				aux = i;
				break;
			}
			// caso nao encontre
			if (i == nPercursos - 1)
				return null;
		}
		// incremento no aux para criar array das remo�oes
		aux += 1;
		PercursoSimples[] removePart = Arrays.copyOfRange(percursos, aux,
				nPercursos);

		int length = nPercursos;
		// for para eliminar percursos nao pretendidos do array de percursos
		for (; aux < length; aux++) {
			percursos[aux] = null;
			nPercursos--;
		}
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
		// caso seja a ultima localidade 
		if (percursos[nPercursos - 1].getFim().equals(localidade)) {
			PercursoSimples[] removePart = Arrays.copyOfRange(percursos, 0,
					nPercursos);
			//esvazia o array
			for (int i = 0; i < nPercursos; i++) {
				percursos[i] = null;
			}
			nPercursos = 0;
			return removePart;
		}
		//caso a localidade seja a algum inicio de um PS
		for (int i = 0; i < nPercursos; i++) {
			if (percursos[i].getInicio().equals(localidade)) {
				aux = i;
				break;
			}
		}
		// se nao encontrar nao remove nada
		if (aux == 0)
			return null;
		
		// a parte a remover ate a localidade
		PercursoSimples[] removePart = Arrays.copyOfRange(percursos, 0, aux);
		//shiftar o array com as localidades que vamos ficar
		System.arraycopy(percursos, aux, percursos, 0, nPercursos - aux);
		int length = nPercursos;
		//colocar a null os elementos do array que foram eliminados
		for (int i = length - aux; i < length; i++) {
			percursos[i] = null;
			nPercursos--;
		}
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
		for (int i = 0; i < nPercursos; i++) {
			if (localidade.equals(percursos[i].getInicio()))
				return i;
		}
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
		return percursos[nPercursos - 1].getFim();
	}

	/**
	 * Devolve a dist�ncia do percurso, que deve ser o somat�rio das dist�ncias
	 * dos seus percursos
	 * 
	 * @return A dist�ncia do percurso
	 */
	public int getDistancia() {
		int distancia = 0;
		for (int i = 0; i < nPercursos; i++) {
			distancia += percursos[i].getDistancia();
		}
		return distancia;
	}

	/**
	 * Devolve o declive do percurso, que deve ser o somat�rio dos declives dos
	 * seus percursos
	 * 
	 * @return O declive do percurso
	 */
	public int getDeclive() {
		int declive = 0;
		for (int i = 0; i < nPercursos; i++) {
			declive += percursos[i].getDeclive();
		}
		return declive;
	}

	/**
	 * Devolve o declive do percurso, que deve ser o somat�rio dos declives dos
	 * seus percursos, mas s� se deve considerar os declives positivos
	 * 
	 * @return O declive acumulado do percurso mas s� considerando os declives
	 *         positivos
	 */
	public int getSubidaAcumulada() {
		int declive = 0;
		for (int i = 0; i < nPercursos; i++) {
			if(percursos[i].getDeclive() >=0){ 
				declive += percursos[i].getDeclive();}
		}
		return declive;
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
		return nome + " de " + getInicio() + " para " + getFim() + " com "
				+ getDistancia() + " metros , com declive " + getDeclive()
				+ " e com " + nPercursos + " percursos";
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

		PercursoSimples[] percursos = new PercursoSimples[] { ps1, ps2 };

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

		PercursoSimples ps4 = new PercursoSimples("A23", "Sagres", "Faro",
				67_000, 0);
		pc1.addicionarPercursoNoInicio(ps4);
		pc1.print("> ");
		System.out.println();

		// clone
		System.out.println("Clone:");
		PercursoComposto pc2 = pc1.clone();
		pc1.print("> ");
		System.out.println();

		// removerPercursosNoFim
		PercursoSimples[] psx = pc1.removerPercursosNoFimDesde("Lisboa");
		pc1.print("> ");
		System.out.println("Percursos removidos -> " + Arrays.toString(psx));
		System.out.println();

		// removerPercursosNoInicio
		PercursoSimples[] psx2 = pc2.removerPercursosNoInicioAte("Lisboa");
		pc2.print("> ");
		System.out.println("Percursos removidos -> " + Arrays.toString(psx2));
		
		
		
		System.out.println();
		System.out.println("-------------------------------------OUTROS TESTES---------------------------------------");
		System.out.println();
		
		//PS para testes
		PercursoSimples psTEST = new PercursoSimples("A4", "Porto", "Braga",
				317_000, 0);
		
		//PC para testes
		PercursoComposto pcTEST = new PercursoComposto("PERCURSO_TEST",
				percursos, 4);
		
		//teste a adicionar percurso no final
		boolean resultTEST = pcTEST.addicionarPercursoNoFinal(psTEST);
		pcTEST.print("> ");
		System.out.println();
		System.out.println("A adi��o de " + psTEST + " deu -> " + resultTEST);
		System.out.println();
		
		//teste a remocao no fim desde porto
		System.out.println("remocao no fim desde Porto");
		System.out.println(Arrays.toString(pcTEST
				.removerPercursosNoFimDesde("Porto")));

		pcTEST.print("> ");
		System.out.println();

		//teste a remocao no inicio desde lisboa
		System.out.println("remocao no inicio ate Lisboa");
		System.out.println(Arrays.toString(pcTEST
				.removerPercursosNoInicioAte("Lisboa")));

		pcTEST.print("> ");
		System.out.println();
		
		//teste a findLocalidade
		System.out.println(pcTEST.findLocalidade("Lisboa"));
	}

}