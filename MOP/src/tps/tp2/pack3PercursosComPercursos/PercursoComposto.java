package tps.tp2.pack3PercursosComPercursos;

import java.util.Arrays;

/**
 * Classe que suporta um percurso composto por v�rios percursos simples ou
 * compostos. A classe tem de ter pelo menos um percurso. N�o admite localidades
 * repetidas. Os nomes das localidades s�o case-sensitive.Os percursos t�m de
 * estar em sequ�ncia, ou seja, onde termina o percurso de �ndice 0 tem de ser
 * onde se inicia o percurso de �ndice 1 e assim sucessivamente ... Num percurso
 * composto considera-se que os seus percursos compostos est�o em sequ�ncia
 * (depois) de todos os percursos simples.
 */
public class PercursoComposto {

	/**
	 * Nome do percurso, deve respeitar a regra de valida��o dos nomes em
	 * percurso simples
	 */
	private String nome;

	/**
	 * Array com os percursos simples. Os elementos devem ser colocados nos
	 * �ndices menores.
	 */
	private PercursoSimples[] percursosSimples;

	/**
	 * N� de percursos simples
	 */
	private int nPercursosSimples;

	/**
	 * Array com os percursos compostos. Os elementos devem ser colocados nos
	 * �ndices menores.
	 */
	private PercursoComposto[] percursosCompostos;

	/**
	 * N� de percursos compostos
	 */
	private int nPercursosCompostos;

	/**
	 * Constructor que recebe apenas um percurso simples, al�m do nome e do n�
	 * m�ximo de percursos. Sugest�o: chamar outro construtor.
	 * 
	 * @param nome
	 *            Nome do percurso simples
	 * @param percursoSimples
	 *            Percurso a guardar
	 * @param maxPercursos
	 *            N� m�ximo de percursos a suportar
	 */
	public PercursoComposto(String nome, PercursoSimples percursoSimples,
			int maxPercursos) {
		this(nome, new PercursoSimples[] { percursoSimples }, maxPercursos);

	}

	/**
	 * Constructor que recebe apenas um percurso composto, al�m do nome e do n�
	 * m�ximo de percursos. Sugest�o: chamar outro construtor.
	 * 
	 * @param nome
	 *            Nome do percurso composto
	 * @param percursoComposto
	 *            Percurso composto a guardar
	 * @param maxPercursos
	 *            N� m�ximo de percursos a suportar
	 */
	public PercursoComposto(String nome, PercursoComposto percursoComposto,
			int maxPercursos) {
		this(nome, new PercursoComposto[] { percursoComposto }, maxPercursos);
	}

	/**
	 * Constructor que recebe um array percursos simples, al�m do nome e do n�
	 * m�ximo de percursos. O array n�o pode ter nulls, os seus percursos t�m de
	 * estar em sequ�ncia e n�o pode haver repeti��es de localidades. Sugest�o:
	 * chamar outro construtor.
	 * 
	 * @param nome
	 *            Nome do percurso simples
	 * @param percursosSimples
	 *            Percursos a guardar
	 * @param maxPercursos
	 *            N� m�ximo de percursos a suportar
	 */
	public PercursoComposto(String nome, PercursoSimples[] percursosSimples,
			int maxPercursos) {
		this(nome, percursosSimples, new PercursoComposto[] {}, maxPercursos);
	}

	/**
	 * Constructor que recebe um array percursos compostos, al�m do nome e do n�
	 * m�ximo de percursos. O array n�o pode ter nulls, os seus percursos t�m de
	 * estar em sequ�ncia e n�o pode haver repeti��es de localidades.
	 * Considera-se que os percursos compostos recebidos, em si, est�o bem
	 * formados. Sugest�o: chamar outro construtor.
	 * 
	 * @param nome
	 *            Nome do percurso composto
	 * @param percursosCompostos
	 *            Percursos compostos a guardar
	 * @param maxPercursos
	 *            N� m�ximo de percursos a suportar
	 */
	public PercursoComposto(String nome, PercursoComposto[] percursosCompostos,
			int maxPercursos) {
		this(nome, new PercursoSimples[] {}, percursosCompostos, maxPercursos);
	}

	/**
	 * Constructor que recebe um array percursos simples e um array de percursos
	 * compostos, al�m do nome e do n� m�ximo de percursos. Os array t�m de ter
	 * no conjunto pelo menos um percurso simples. Os percursos simples
	 * recebidos no array consideram-se como ficando antes dos percursos
	 * compostos recebidos no array e t�m de estar em sequ�ncia e FALTA n�o pode
	 * haver repeti��es de localidades sob nenhuma forma FALTA. Considera-se que
	 * os percursos compostos recebidos, em si, est�o bem formados. Sugest�o:
	 * chamar os m�todos de adicionar no final.
	 * 
	 * @param nome
	 *            Nome do percurso composto, deve ser validado pelo m�todo em
	 *            percurso simples
	 * @param percursosSimples
	 *            Percursos simples a guardar
	 * @param percursosCompostos
	 *            Percursos compostos a guardar
	 * @param maxPercursos
	 *            N� m�ximo de percursos a suportar
	 */
	public PercursoComposto(String nome, PercursoSimples[] percursosSimples,
			PercursoComposto[] percursosCompostos, int maxPercursos) {
		if (!(PercursoSimples.validarNomeDeLocal(nome)))
			throw new IllegalArgumentException("Nome inv�lido -> " + nome);

		if (percursosCompostos.length == 0) {
			if (percursosSimples.length == 0)
				throw new IllegalArgumentException(
						"Tem de ter pelo menos um percurso simples");
		}

		for (int i = 0; i < percursosSimples.length; i++) {
			if (percursosSimples[i] == null)
				throw new IllegalArgumentException(
						"Array de percursos simples inv�lido, contem nulls -> "
								+ percursosSimples);
			if (i < (percursosSimples.length - 1)
					&& (!percursosSimples[i].getFim().equals(
							percursosSimples[i + 1].getInicio())))
				throw new IllegalArgumentException(
						"Array de percursos simples inv�lido, nao esta em sequencia -> "
								+ percursosSimples);
		}

		for (int i = 0; i < percursosCompostos.length; i++) {
			if (percursosCompostos[i] == null)
				throw new IllegalArgumentException(
						"Array de percursos compostos inv�lido, contem nulls -> "
								+ percursosCompostos);
		}

		if (percursosSimples.length > 0
				&& percursosCompostos.length > 0
				&& (!percursosSimples[percursosSimples.length - 1].getFim()
						.equals(percursosCompostos[0].percursosSimples[0]
								.getInicio()))) {
			throw new IllegalArgumentException(
					"Array de percursos simples nao coincide com  percursos compostos pois nao esta em sequencia -> "
							+ percursosSimples + percursosCompostos);
		}

		this.nome = nome;
		this.nPercursosSimples = percursosSimples.length;
		this.nPercursosCompostos = percursosCompostos.length;

		// cria array com o max tamanho
		PercursoSimples[] percursosFullLength = new PercursoSimples[maxPercursos];
		System.arraycopy(percursosSimples, 0, percursosFullLength, 0,
				percursosSimples.length);
		this.percursosSimples = percursosFullLength;

		PercursoComposto[] percursosCompostosFullLength = new PercursoComposto[maxPercursos];
		System.arraycopy(percursosCompostos, 0, percursosCompostosFullLength,
				0, percursosCompostos.length);
		this.percursosCompostos = percursosCompostosFullLength;

	}

	/**
	 * Copy constructor, deve criar uma c�pia profunda do percurso recebido.
	 * 
	 * @param pc
	 *            Percurso a copiar
	 */
	public PercursoComposto(PercursoComposto pc) {
		this(pc.nome, Arrays.copyOfRange(pc.percursosSimples, 0,
				pc.nPercursosSimples), Arrays.copyOfRange(
				pc.percursosCompostos, 0, pc.nPercursosCompostos),
				pc.percursosSimples.length);
	}

	/**
	 * Deve criar uma c�pia profunda do percurso corrente
	 * 
	 * @return O percurso composto que � uma c�pia profunda do percurso composto
	 *         corrente
	 */
	public PercursoComposto clone() {
		return new PercursoComposto(nome, Arrays.copyOfRange(percursosSimples,
				0, nPercursosSimples), Arrays.copyOfRange(percursosCompostos,
				0, nPercursosCompostos), percursosSimples.length);
	}

	/**
	 * Deve adicionar o percurso simples no final, desde que este esteja em
	 * sequ�ncia e haja espa�o. N�o pode adicionar se j� existirem percursos
	 * compostos ou se a nova localidade j� existir. Sugest�o: utilizar os
	 * m�todos de getLocalidades e haveRepeti��es.
	 * 
	 * @param percurso
	 *            Percurso simples a adicionar
	 * @return True se adicionou
	 */
	public boolean addicionarPercursoSimplesNoFinal(PercursoSimples percurso) {
		//se houver percursos compostos da false
		if (nPercursosCompostos > 0)
			return false;
		//se houverem repeticoes ou nao tiver em sequencia da false
		if (haveRepetitions(getLocalidades(),
				new String[] { percurso.getFim() })
				|| getLocalidades()[getNumLocalidades() - 1] != percurso
						.getInicio())
			return false;
		//caso nao retorne false actualiza o array e o numero de percursos
		percursosSimples[nPercursosSimples] = percurso;
		nPercursosSimples++;
		return true;
	}

	/**
	 * Deve adicionar o percurso composto no final, desde que este esteja em
	 * sequ�ncia e haja espa�o. N�o pode adicionar as novas localidades j�
	 * existirem. Sugest�o: utilizar os m�todos de getLocalidades e
	 * haveRepeti��es.
	 * 
	 * @param percurso
	 *            Percurso composto a adicionar
	 * @return True se adicionou
	 */
	public boolean addicionarPercursoCompostoNoFinal(PercursoComposto percurso) {
		// TODO
		return false;
	}

	/**
	 * M�todo que retorna true se h� repeti��es entre os dois arrays. Sugere-se
	 * a ordena��o de um array, e percorrer o outro e para cada elemento dele
	 * fazer uma pesquisa bin�ria no array ordenado.
	 * 
	 * @param locs1
	 *            Array1 com localidades
	 * @param locs2
	 *            Array2 com localidades
	 * @return True se alguma localidade em Array1 existe em array2, false caso
	 *         contr�rio
	 */
	private static boolean haveRepetitions(String[] locs1, String[] locs2) {
		for (int i = 0; i < locs1.length; i++) {
			for (int j = 0; j < locs2.length; j++) {
				if (locs1[i].equals(locs2[j])) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Obt�m todas as localidades distintas existentes do percurso, mesmo as de
	 * in�cio e de fim. Deve devolver as localidades num novo array e sem
	 * posi��es a null. Sugest�o: utilizar o m�todo getNumLocalidades para saber
	 * pr�viamente quantas localidades h�.
	 * 
	 * @return O novo array com todas as localidades existentes no percurso
	 *         composto
	 */
	private String[] getLocalidades() {
		String[] aux = new String[getNumLocalidades()];
		int intAux = 0;

		if (nPercursosSimples > 0) {
			aux[0] = percursosSimples[0].getInicio();
			intAux++;
			for (int i = 0; i < nPercursosSimples; i++) {
				aux[intAux] = percursosSimples[i].getFim();
				intAux++;
			}
		}

		if (nPercursosCompostos > 0) {
			for (int i = 0; i < nPercursosCompostos; i++) {
				for (int j = 0; j < percursosCompostos[i].nPercursosSimples; j++) {
					aux[intAux] = percursosCompostos[i].percursosSimples[j]
							.getFim();
					intAux++;
				}
			}
		}

		return aux;
	}

	/**
	 * Obt�m o n�mero de localidades distintas existentes dentro do percurso
	 * composto actual. Devem ser incluidas as localidades de in�cio e de fim do
	 * percurso.
	 * 
	 * @return N�mero de localidades distintas existentes dentro deste percurso
	 *         composto
	 */
	private int getNumLocalidades() {
		// um percursos simples bem formado nao repete localidades
		int aux = nPercursosSimples > 0 ? nPercursosSimples + 1 : 0;
		if (nPercursosCompostos > 0) {
			for (int i = 0; i < nPercursosCompostos; i++) {
				// ternario pois no primeiro percurso composto nao e preciso
				// contar a primeira localidade pois ja esta contabilizada nos
				// simples
				aux += i < 1 ? percursosCompostos[i].nPercursosSimples
						: percursosCompostos[i].nPercursosSimples + 1;
			}
		}
		return aux;
	}

	/**
	 * Deve adicionar o percurso simples no in�cio, desde que este esteja em
	 * sequ�ncia e haja espa�o. N�o adicionar caso provoque uma repeti��o de
	 * localidades. Sugest�o: utilizar o getLocalidades e haveRepetitions.
	 * 
	 * @param percurso
	 *            Percurso simples a adicionar
	 * @return True se adicionou, ou false em caso contr�rio
	 */
	public boolean addicionarPercursoSimplesNoInicio(PercursoSimples percurso) {
		// TODO
		return false;
	}

	/**
	 * Deve adicionar o percurso composto recebido no in�cio deste percurso
	 * composto. N�o pode adicionar se j� existirem percursos simples, se
	 * provocar uma repeti��o de localidades, ou se n�o existir espa�o.
	 * Sugest�o: verificar a repeti��o das localidades utilizando os m�todos
	 * getLocalidades e haveRepetitions.
	 * 
	 * @param percurso
	 *            Percurso composto a adicionar
	 * @return True se adicionou, ou false caso contr�rio
	 */
	public boolean addicionarPercursoCompostoNoInicio(PercursoComposto percurso) {
		// TODO
		return false;
	}

	/**
	 * Devolve o in�cio do percurso
	 * 
	 * @return O local de in�cio do percurso
	 */
	public String getInicio() {
		/*
		 * if (nPercursosSimples > 0) return percursosSimples[0].getInicio(); if
		 * (nPercursosCompostos > 0) return
		 * percursosCompostos[0].percursosSimples[0].getInicio(); return null;
		 */
		return getLocalidades()[0];

	}

	/**
	 * Devolve o fim do percurso
	 * 
	 * @return O local de fim do percurso
	 */
	public String getFim() {
		/*
		 * if (nPercursosCompostos > 0) return
		 * percursosCompostos[nPercursosCompostos
		 * -1].percursosSimples[this.nPercursosSimples-1].getFim(); if
		 * (nPercursosSimples > 0) return
		 * percursosSimples[nPercursosSimples].getFim(); return null;
		 */
		return getLocalidades()[getNumLocalidades() - 1];
	}

	/**
	 * Devolve a dist�ncia do percurso, que deve ser o somat�rio das dist�ncias
	 * dos seus percursos
	 * 
	 * @return A dist�ncia do percurso
	 */
	public int getDistancia() {
		int aux = 0;
		if (nPercursosSimples > 0) {
			for (int i = 0; i < nPercursosSimples; i++) {
				aux += percursosSimples[i].getDistancia();
			}
		}

		if (nPercursosCompostos > 0) {
			for (int i = 0; i < nPercursosCompostos; i++) {
				for (int j = 0; j < percursosCompostos[i].nPercursosSimples; j++) {
					aux += percursosCompostos[i].percursosSimples[j]
							.getDistancia();
				}
			}
		}
		return aux;
	}

	/**
	 * Devolve o declive do percurso, que deve ser o somat�rio dos declives dos
	 * seus percursos
	 * 
	 * @return O declive do percurso
	 */
	public int getDeclive() {
		int aux = 0;
		if (nPercursosSimples > 0) {
			for (int i = 0; i < nPercursosSimples; i++) {
				aux += percursosSimples[i].getDeclive();
			}
		}
		if (nPercursosCompostos > 0) {
			for (int i = 0; i < nPercursosCompostos; i++) {
				for (int j = 0; j < percursosCompostos[i].nPercursosSimples; j++) {
					aux += percursosCompostos[i].percursosSimples[j]
							.getDeclive();
				}
			}
		}
		return aux;
	}

	/**
	 * Devolve o declive do percurso, que deve ser o somat�rio dos declives dos
	 * seus percursos, mas s� se deve considerar os declives positivos
	 * 
	 * @return O declive acumulado do percurso mas s� considerando os declives
	 *         positivos
	 */
	public int getSubidaAcumulada() {
		int aux = 0;
		if (nPercursosSimples > 0) {
			for (int i = 0; i < nPercursosSimples; i++) {
				if (percursosSimples[i].getDeclive() >= 0)
					aux += percursosSimples[i].getDeclive();
			}
		}
		if (nPercursosCompostos > 0) {
			for (int i = 0; i < nPercursosCompostos; i++) {
				for (int j = 0; j < percursosCompostos[i].nPercursosSimples; j++) {
					if (percursosCompostos[i].percursosSimples[j].getDeclive() >= 0)
						aux += percursosCompostos[i].percursosSimples[j]
								.getDeclive();
				}
			}
		}
		return aux;
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
	 * Devolve uma string com uma descri��o do percurso, tal como: NORTE_SUL de
	 * Sagres para Lisboa, com 345000 metros, com 0 de declive, com 2 percursos
	 * simples e 1 percuros compostos
	 * 
	 * @return O string que descreve o percurso
	 */
	public String toString() {
		return nome + " de " + getInicio() + " para " + getFim() + ", com "
				+ getDistancia() + " metros , com " + getDeclive()
				+ " de declive, com " + nPercursosSimples
				+ " percursos simples e " + nPercursosCompostos
				+ " percursos compostos";
	}

	/**
	 * Imprime na consola o percurso. Deve mostrar na primeiro linha o prefixo
	 * seguido da informa��o do toString deste objecto. Depois deve mostrar os
	 * seus percursos, um por linha, chamando os seus m�todos de print, mas
	 * passando como prefixo o prefixo recebido mas prefixado de 2 espa�os.
	 * 
	 * @param prefix
	 *            Prefixo a colocar antes da informa��o do toString e tamb�m na
	 *            parte de mostrar os percursos.
	 */
	public void print(String prefix) {
		System.out.println(prefix + toString());
		if (nPercursosSimples > 0) {
			for (int i = 0; i < nPercursosSimples; i++) {
				percursosSimples[i].print("  " + prefix);
			}
		}
		if (nPercursosCompostos > 0) {
			for (int i = 0; i < nPercursosCompostos; i++) {
				// recursivamente chama o print e imprime os seus percursos
				// simples
				percursosCompostos[i].print("  " + prefix);
			}

		}
	}

	/**
	 * Main, para testes
	 * 
	 * @param args
	 *            Argumentos do main
	 */
	public static void main(String[] args) {
		PercursoSimples ps1, ps2, ps3, ps4;

		ps1 = new PercursoSimples("A2", "Faro", "Lisboa", 278_000, 10);
		ps2 = new PercursoSimples("A1", "Lisboa", "Porto", 317_000, 20);
		ps3 = new PercursoSimples("A28", "Porto", "Viana do Castelo", 73_800,
				30);
		ps4 = new PercursoSimples("A23", "Sagres", "Faro", 67_000, -10);

		String strSeparator = " ---------------------------------------------------------------- ";

		// =====================================================================
		System.out.println(strSeparator);
		System.out.println("Teste ao construtor com PercursoSimples");
		PercursoComposto pcA1 = new PercursoComposto("PSA1", ps1, 20);
		pcA1.print("> ");
		System.out.println();

		// =====================================================================
		System.out.println(strSeparator);
		System.out.println("Teste ao construtor com array de PercursoSimples");
		PercursoComposto pc1 = new PercursoComposto("NORTE_SUL",
				new PercursoSimples[] { ps1, ps2 }, 20);
		pc1.print("> ");
		System.out.println();

		// =====================================================================
		System.out.println(strSeparator);
		System.out.println("Teste ao construtor com PercursoComposto");
		PercursoComposto pc2 = new PercursoComposto("NORTE_SUL_V2",
				new PercursoComposto("NORTE_SUL", new PercursoSimples[] { ps1,
						ps2 }, 20), 20);
		pc2.print("> ");
		System.out.println();

		// =====================================================================
		System.out.println(strSeparator);
		System.out.println("Teste ao construtor com array de PercursoComposto");
		PercursoComposto pc3 = new PercursoComposto("NORTE_SUL_V2",
				new PercursoComposto[] { pc1 }, 20);
		pc3.print("> ");
		System.out.println();

		// =====================================================================
		System.out.println(strSeparator);
		System.out
				.println("Teste ao construtor com arrays de PercursoSimple e PercursoComposto");
		PercursoComposto pc4 = new PercursoComposto("SUL_NORTE",
				new PercursoSimples[] { ps1, ps2 },
				new PercursoComposto[] { new PercursoComposto("NN", ps3, 20) },
				20);
		pc4.print("> ");
		System.out.println();

		// TESTE
		System.out.println(pc4.getNumLocalidades());
		System.out.println(Arrays.toString(pc4.getLocalidades()));
		System.out.println(pc4.getInicio());
		System.out.println(pc4.getFim());

		// TESTE

		// =====================================================================
		System.out.println(strSeparator);
		System.out.println("Teste ao adicionar PercursoSimples No In�cio");

		pc1.addicionarPercursoSimplesNoInicio(ps4);
		pc1.print("> ");
		System.out.println();

		// =====================================================================
		System.out.println(strSeparator);
		System.out.println("Teste ao adicionar PercursoSimples No Final");
		pc1.print("> ");
		System.out.println();

		boolean result = pc1.addicionarPercursoSimplesNoFinal(ps3);
		System.out.println("A adi��o de " + ps3 + " deu -> " + result);
		System.out.println();

		pc1.print("> ");
		System.out.println();

		// =====================================================================
		System.out.println(strSeparator);
		System.out
				.println("Teste ao adicionar PercursoSimples No Final com erro");
		pc1.print("> ");
		System.out.println();

		result = pc1.addicionarPercursoSimplesNoFinal(ps3);
		System.out.println("A adi��o de " + ps3 + " deu -> " + result);
		System.out.println();

		pc1.print("> ");
		System.out.println();

		// =====================================================================
		/*
		 * System.out.println(strSeparator);
		 * System.out.println("Teste ao adicionar PercursoComposto No Inicio");
		 * pc2.print("> "); System.out.println();
		 * 
		 * result = pc2.addicionarPercursoCompostoNoInicio(new PercursoComposto(
		 * "SAGRESFARO", ps4, 20)); System.out.println("A adi��o de " + ps4 +
		 * " deu -> " + result); System.out.println();
		 * 
		 * pc2.print("> "); System.out.println();
		 * 
		 * //
		 * =====================================================================
		 * System.out.println(strSeparator); System.out
		 * .println("Teste ao adicionar PercursoComposto No Inicio com erro");
		 * pc1.print("> "); System.out.println();
		 * 
		 * result = pc1.addicionarPercursoCompostoNoInicio(pc2);
		 * System.out.println("A adi��o de " + pc2 + " deu -> " + result);
		 * System.out.println();
		 * 
		 * pc1.print("> "); System.out.println();
		 * 
		 * //
		 * =====================================================================
		 * System.out.println(strSeparator);
		 * System.out.println("Teste ao adicionar PercursoComposto No Final");
		 * PercursoComposto pc6 = new PercursoComposto("sul", new
		 * PercursoComposto("ss", new PercursoSimples[] { ps4, ps1 }, 20), 20);
		 * pc6.print("> "); System.out.println();
		 * 
		 * PercursoComposto pc7 = new PercursoComposto("centro", new
		 * PercursoSimples[] { ps2, ps3 }, 20);
		 * 
		 * result = pc6.addicionarPercursoCompostoNoFinal(pc7);
		 * System.out.println("A adi��o de " + pc7 + " deu -> " + result);
		 * System.out.println();
		 * 
		 * pc6.print("> "); System.out.println();
		 * 
		 * //
		 * =====================================================================
		 * //TESTE System.out.println(strSeparator);
		 * System.out.println("Teste ao copia profunda"); PercursoComposto
		 * testCopiaProfunda = new PercursoComposto(pc6);
		 * testCopiaProfunda.print("> "); // System.out.println(strSeparator);
		 * System.out.println("Teste ao clone");
		 * 
		 * pc6.print("> "); System.out.println();
		 * 
		 * PercursoComposto pc8 = pc6.clone(); pc8.print("> ");
		 * System.out.println();
		 * 
		 * PercursoComposto pcA = new PercursoComposto("wa", new
		 * PercursoSimples[] { new PercursoSimples("vVC", "Viana do Castelo",
		 * "Caminha", 70_000, 20) }, 20);
		 * 
		 * result = pc6.addicionarPercursoCompostoNoFinal(pcA);
		 * 
		 * System.out.println("Adicionado " + pcA + " ao pc original, deu -> " +
		 * result); System.out.println();
		 * 
		 * pc8.print("> "); System.out.println();
		 * 
		 * //
		 * =====================================================================
		 * System.out.println(strSeparator);
		 * System.out.println("Teste ao subidaAcumulada"); pc6.print("> ");
		 * System.out.println(); System.out.println(pc6 +
		 * " tem uma subida acumulada de -> " + pc6.getSubidaAcumulada());
		 */
	}
}
