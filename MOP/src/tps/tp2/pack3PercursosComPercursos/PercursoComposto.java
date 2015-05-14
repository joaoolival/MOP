package tps.tp2.pack3PercursosComPercursos;

import java.util.Arrays;

/**
 * Classe que suporta um percurso composto por vários percursos simples ou
 * compostos. A classe tem de ter pelo menos um percurso. Não admite localidades
 * repetidas. Os nomes das localidades são case-sensitive.Os percursos têm de
 * estar em sequência, ou seja, onde termina o percurso de índice 0 tem de ser
 * onde se inicia o percurso de índice 1 e assim sucessivamente ... Num percurso
 * composto considera-se que os seus percursos compostos estão em sequência
 * (depois) de todos os percursos simples.
 */
public class PercursoComposto {

	/**
	 * Nome do percurso, deve respeitar a regra de validação dos nomes em
	 * percurso simples
	 */
	private String nome;

	/**
	 * Array com os percursos simples. Os elementos devem ser colocados nos
	 * índices menores.
	 */
	private PercursoSimples[] percursosSimples;

	/**
	 * Nº de percursos simples
	 */
	private int nPercursosSimples;

	/**
	 * Array com os percursos compostos. Os elementos devem ser colocados nos
	 * índices menores.
	 */
	private PercursoComposto[] percursosCompostos;

	/**
	 * Nº de percursos compostos
	 */
	private int nPercursosCompostos;

	/**
	 * Constructor que recebe apenas um percurso simples, além do nome e do nº
	 * máximo de percursos. Sugestão: chamar outro construtor.
	 * 
	 * @param nome
	 *            Nome do percurso simples
	 * @param percursoSimples
	 *            Percurso a guardar
	 * @param maxPercursos
	 *            Nº máximo de percursos a suportar
	 */
	public PercursoComposto(String nome, PercursoSimples percursoSimples,
			int maxPercursos) {
		this(nome, new PercursoSimples[] { percursoSimples }, maxPercursos);

	}

	/**
	 * Constructor que recebe apenas um percurso composto, além do nome e do nº
	 * máximo de percursos. Sugestão: chamar outro construtor.
	 * 
	 * @param nome
	 *            Nome do percurso composto
	 * @param percursoComposto
	 *            Percurso composto a guardar
	 * @param maxPercursos
	 *            Nº máximo de percursos a suportar
	 */
	public PercursoComposto(String nome, PercursoComposto percursoComposto,
			int maxPercursos) {
		this(nome, new PercursoComposto[] { percursoComposto }, maxPercursos);
	}

	/**
	 * Constructor que recebe um array percursos simples, além do nome e do nº
	 * máximo de percursos. O array não pode ter nulls, os seus percursos têm de
	 * estar em sequência e não pode haver repetições de localidades. Sugestão:
	 * chamar outro construtor.
	 * 
	 * @param nome
	 *            Nome do percurso simples
	 * @param percursosSimples
	 *            Percursos a guardar
	 * @param maxPercursos
	 *            Nº máximo de percursos a suportar
	 */
	public PercursoComposto(String nome, PercursoSimples[] percursosSimples,
			int maxPercursos) {
		this(nome, percursosSimples, new PercursoComposto[] {}, maxPercursos);
	}

	/**
	 * Constructor que recebe um array percursos compostos, além do nome e do nº
	 * máximo de percursos. O array não pode ter nulls, os seus percursos têm de
	 * estar em sequência e não pode haver repetições de localidades.
	 * Considera-se que os percursos compostos recebidos, em si, estão bem
	 * formados. Sugestão: chamar outro construtor.
	 * 
	 * @param nome
	 *            Nome do percurso composto
	 * @param percursosCompostos
	 *            Percursos compostos a guardar
	 * @param maxPercursos
	 *            Nº máximo de percursos a suportar
	 */
	public PercursoComposto(String nome, PercursoComposto[] percursosCompostos,
			int maxPercursos) {
		this(nome, new PercursoSimples[] {}, percursosCompostos, maxPercursos);
	}

	/**
	 * Constructor que recebe um array percursos simples e um array de percursos
	 * compostos, além do nome e do nº máximo de percursos. Os array têm de ter
	 * no conjunto pelo menos um percurso simples. Os percursos simples
	 * recebidos no array consideram-se como ficando antes dos percursos
	 * compostos recebidos no array e têm de estar em sequência e FALTA não pode
	 * haver repetições de localidades sob nenhuma forma FALTA. Considera-se que
	 * os percursos compostos recebidos, em si, estão bem formados. Sugestão:
	 * chamar os métodos de adicionar no final.
	 * 
	 * @param nome
	 *            Nome do percurso composto, deve ser validado pelo método em
	 *            percurso simples
	 * @param percursosSimples
	 *            Percursos simples a guardar
	 * @param percursosCompostos
	 *            Percursos compostos a guardar
	 * @param maxPercursos
	 *            Nº máximo de percursos a suportar
	 */
	public PercursoComposto(String nome, PercursoSimples[] percursosSimples,
			PercursoComposto[] percursosCompostos, int maxPercursos) {
		// verifica nome
		if (!(PercursoSimples.validarNomeDeLocal(nome)))
			throw new IllegalArgumentException("Nome inválido -> " + nome);

		// verifica se caso nao existam PC se existem PS
		if (percursosCompostos.length == 0) {
			if (percursosSimples.length == 0)
				throw new IllegalArgumentException(
						"Tem de ter pelo menos um percurso simples");
		}

		// verifica se algum PS e null e se ha sequencia entre eles
		for (int i = 0; i < percursosSimples.length; i++) {
			
			if (percursosSimples[i] == null)
				throw new IllegalArgumentException(
						"Array de percursos simples inválido, contem nulls -> "
								+ percursosSimples);
			
			if(percursosSimples[i].getInicio().equals(percursosSimples[i].getFim()))
				throw new IllegalArgumentException(
						"Array de percursos simples inválido, este percurso simples comeca e acaba no mesmo sitio -> "
								+ percursosSimples[i]);
			if (i < (percursosSimples.length - 1)
					&& (!(percursosSimples[i].getFim()
							.equals(percursosSimples[i + 1].getInicio()))))
				throw new IllegalArgumentException(
						"Array de percursos simples inválido, nao esta em sequencia -> "
								+ percursosSimples);
		}
		// verifica se algum PC e null e se ha sequencia entre eles
		for (int i = 0; i < percursosCompostos.length; i++) {
			if (percursosCompostos[i] == null)
				throw new IllegalArgumentException(
						"Array de percursos compostos inválido, contem nulls -> "
								+ percursosCompostos);

			if (i < (percursosCompostos.length - 1)
					&& (!(percursosCompostos[i].getFim()
							.equals(percursosCompostos[i + 1].getInicio()))))
				throw new IllegalArgumentException(
						"Array de percursos simples inválido, nao esta em sequencia -> "
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
		// grava variaveis
		this.nome = nome;
		// caso o array de PS seja null ou vazio
		if (percursosSimples == null || percursosSimples.length == 0) {
			nPercursosSimples = 0;
			this.percursosSimples = new PercursoSimples[maxPercursos];
		} else {
			this.nPercursosSimples = percursosSimples.length;
			this.percursosSimples = Arrays.copyOf(percursosSimples,
					maxPercursos);
		}
		// caso o array de PC seja null ou vazio
		if (percursosCompostos == null || percursosCompostos.length == 0) {
			nPercursosCompostos = 0;
			this.percursosCompostos = new PercursoComposto[maxPercursos];
		} else {
			this.nPercursosCompostos = percursosCompostos.length;
			this.percursosCompostos = Arrays.copyOf(percursosCompostos,
					maxPercursos);
		}

	}

	/**
	 * Copy constructor, deve criar uma cópia profunda do percurso recebido.
	 * 
	 * @param pc
	 *            Percurso a copiar
	 */
	// o copyOfRange retira as posicoes vazias dos arrays
	public PercursoComposto(PercursoComposto pc) {
		this(pc.nome, Arrays.copyOfRange(pc.percursosSimples, 0,
				pc.nPercursosSimples), Arrays.copyOfRange(
				pc.percursosCompostos, 0, pc.nPercursosCompostos),
				pc.percursosSimples.length);
	}

	/**
	 * Deve criar uma cópia profunda do percurso corrente
	 * 
	 * @return O percurso composto que é uma cópia profunda do percurso composto
	 *         corrente
	 */
	// o copyOfRange retira as posicoes vazias dos arrays
	public PercursoComposto clone() {
		return new PercursoComposto(nome, Arrays.copyOfRange(percursosSimples,
				0, nPercursosSimples), Arrays.copyOfRange(percursosCompostos,
				0, nPercursosCompostos), percursosSimples.length);
	}

	/**
	 * Deve adicionar o percurso simples no final, desde que este esteja em
	 * sequência e haja espaço. Não pode adicionar se já existirem percursos
	 * compostos ou se a nova localidade já existir. Sugestão: utilizar os
	 * métodos de getLocalidades e haveRepetições.
	 * 
	 * @param percurso
	 *            Percurso simples a adicionar
	 * @return True se adicionou
	 */
	public boolean addicionarPercursoSimplesNoFinal(PercursoSimples percurso) {
		// se houver percursos compostos da false
		if (nPercursosCompostos > 0)
			return false;
		// se nao houver espaço da false
		if (nPercursosSimples == percursosSimples.length)
			return false;
		// se houverem repeticoes ou nao tiver em sequencia da false
		if (haveRepetitions(getLocalidades(),
				new String[] { percurso.getFim() })
				|| getLocalidades()[getNumLocalidades() - 1] != percurso
						.getInicio())
			return false;
		if (nPercursosSimples == percursosSimples.length)
			return false;
		// caso nao retorne false actualiza o array com o percurso a inserir e o
		// numero de percursos
		percursosSimples[nPercursosSimples] = percurso;
		nPercursosSimples++;
		return true;
	}

	/**
	 * Deve adicionar o percurso composto no final, desde que este esteja em
	 * sequência e haja espaço. Não pode adicionar as novas localidades já
	 * existirem. Sugestão: utilizar os métodos de getLocalidades e
	 * haveRepetições.
	 * 
	 * @param percurso
	 *            Percurso composto a adicionar
	 * @return True se adicionou
	 */
	public boolean addicionarPercursoCompostoNoFinal(PercursoComposto percurso) {
		// se nao houver espaço
		if (nPercursosCompostos == percursosCompostos.length)
			return false;
		// se nao estiver em sequencia
		if (!(getFim().equals(percurso.getInicio())))
			return false;
		// se houve repeticoes
		if (haveRepetitions(
				getLocalidades(),
				Arrays.copyOfRange(percurso.getLocalidades(), 1,
						(percurso.getLocalidades().length))))
			return false;
		// actualiza o array
		percursosCompostos[nPercursosCompostos] = percurso;
		nPercursosCompostos++;
		return true;
	}

	/**
	 * Método que retorna true se há repetições entre os dois arrays. Sugere-se
	 * a ordenação de um array, e percorrer o outro e para cada elemento dele
	 * fazer uma pesquisa binária no array ordenado.
	 * 
	 * @param locs1
	 *            Array1 com localidades
	 * @param locs2
	 *            Array2 com localidades
	 * @return True se alguma localidade em Array1 existe em array2, false caso
	 *         contrário
	 */
	private static boolean haveRepetitions(String[] locs1, String[] locs2) {
		for (int i = 0; i < locs1.length; i++) {
			for (int j = 0; j < locs2.length; j++) {
				// se um percurso do locs1 for igual a um percurso locs2
				if (locs1[i].equals(locs2[j])) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Obtém todas as localidades distintas existentes do percurso, mesmo as de
	 * início e de fim. Deve devolver as localidades num novo array e sem
	 * posições a null. Sugestão: utilizar o método getNumLocalidades para saber
	 * préviamente quantas localidades há.
	 * 
	 * @return O novo array com todas as localidades existentes no percurso
	 *         composto
	 */
	private String[] getLocalidades() {
		String[] aux = new String[getNumLocalidades()];
		int intAux = 0;
		// se houver percursos simples
		if (nPercursosSimples > 0) {
			// insere o inicio do primeiro PS
			aux[0] = percursosSimples[0].getInicio();
			intAux++;
			// insere todos as localizacoes de fim de cada PS
			for (int i = 0; i < nPercursosSimples; i++) {
				aux[intAux] = percursosSimples[i].getFim();
				intAux++;
			}
		}
		// se houver percursos compostos
		if (nPercursosCompostos > 0) {
			// percorre todos os percursos compostos
			for (int i = 0; i < nPercursosCompostos; i++) {
				// se nao houver PS retira a localizacao inicial de cada PC
				if (nPercursosSimples == 0 && i == 0) {
					aux[intAux] = percursosCompostos[i].percursosSimples[0]
							.getInicio();
					intAux++;
				}
				// retira a loc final de cada PS de cada PC do
				// percursosCompostos
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
	 * Obtém o número de localidades distintas existentes dentro do percurso
	 * composto actual. Devem ser incluidas as localidades de início e de fim do
	 * percurso.
	 * 
	 * @return Número de localidades distintas existentes dentro deste percurso
	 *         composto
	 */
	private int getNumLocalidades() {
		// um percursos simples bem formado nao repete localidades
		// operador ternario caso nao existam percursos simples
		int aux = nPercursosSimples > 0 ? nPercursosSimples + 1 : 0;
		if (nPercursosCompostos > 0) {
			for (int i = 0; i < nPercursosCompostos; i++) {
				// se nao for o primeiro percurso composto nao e preciso por a localidade de inicio
				aux += i>0 ? percursosCompostos[i].getNumLocalidades() -1 : percursosCompostos[i].getNumLocalidades();
			}
		}
		return aux;
	}

	/**
	 * Deve adicionar o percurso simples no início, desde que este esteja em
	 * sequência e haja espaço. Não adicionar caso provoque uma repetição de
	 * localidades. Sugestão: utilizar o getLocalidades e haveRepetitions.
	 * 
	 * @param percurso
	 *            Percurso simples a adicionar
	 * @return True se adicionou, ou false em caso contrário
	 */
	public boolean addicionarPercursoSimplesNoInicio(PercursoSimples percurso) {
		// se nao houver espaco
		if (nPercursosSimples == percursosSimples.length)
			return false;
		// se nao estiver em sequencia
		if (!(percurso.getFim().equals(percursosSimples[0].getInicio())))
			return false;
		// se nao houver repeticoes
		if (haveRepetitions(new String[] { percurso.getInicio() },
				getLocalidades()))
			return false;

		// faz shift a todas posicoes para a direira
		System.arraycopy(percursosSimples, 0, percursosSimples, 1,
				nPercursosSimples);
		// acrescenta o percurso
		percursosSimples[0] = percurso;
		nPercursosSimples++;
		return true;
	}

	/**
	 * Deve adicionar o percurso composto recebido no início deste percurso
	 * composto. Não pode adicionar se já existirem percursos simples, se
	 * provocar uma repetição de localidades, ou se não existir espaço.
	 * Sugestão: verificar a repetição das localidades utilizando os métodos
	 * getLocalidades e haveRepetitions.
	 * 
	 * @param percurso
	 *            Percurso composto a adicionar
	 * @return True se adicionou, ou false caso contrário
	 */
	public boolean addicionarPercursoCompostoNoInicio(PercursoComposto percurso) {
		// verefica de ha percursos simples
		if (nPercursosSimples > 0)
			return false;
		// verifica se ha espaco
		if (nPercursosCompostos == percursosCompostos.length)
			return false;
		// verifica a sequencia
		if (!(percurso.getLocalidades()[percurso.getNumLocalidades() - 1]
				.equals(getLocalidades()[0])))
			return false;
		// verifica se ha repetiçoes
		if (haveRepetitions(
				Arrays.copyOfRange(percurso.getLocalidades(), 0,
						(percurso.getLocalidades().length) - 1),
				getLocalidades()))
			return false;
		// faz shift ao array
		System.arraycopy(percursosCompostos, 0, percursosCompostos, 1,
				nPercursosCompostos);
		// insere percurso
		percursosCompostos[0] = percurso;
		nPercursosCompostos++;
		return true;
	}

	/**
	 * Devolve o início do percurso
	 * 
	 * @return O local de início do percurso
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
	 * Devolve a distância do percurso, que deve ser o somatório das distâncias
	 * dos seus percursos
	 * 
	 * @return A distância do percurso
	 */
	public int getDistancia() {
		int aux = 0;
		// se houver percursos simples
		if (nPercursosSimples > 0) {
			for (int i = 0; i < nPercursosSimples; i++) {
				aux += percursosSimples[i].getDistancia();
			}
		}
		// se houver percursos compostos
		if (nPercursosCompostos > 0) {
			for (int i = 0; i < nPercursosCompostos; i++) {
				aux += percursosCompostos[i].getDistancia();
			}
		}
		return aux;
	}

	/**
	 * Devolve o declive do percurso, que deve ser o somatório dos declives dos
	 * seus percursos
	 * 
	 * @return O declive do percurso
	 */
	public int getDeclive() {
		int aux = 0;
		// se houver percursos simples
		if (nPercursosSimples > 0) {
			for (int i = 0; i < nPercursosSimples; i++) {
				aux += percursosSimples[i].getDeclive();
			}
		}
		// se houver percursos compostos
		if (nPercursosCompostos > 0) {
			for (int i = 0; i < nPercursosCompostos; i++) {
				aux += percursosCompostos[i].getDeclive();
			}
		}
		return aux;
	}

	/**
	 * Devolve o declive do percurso, que deve ser o somatório dos declives dos
	 * seus percursos, mas só se deve considerar os declives positivos
	 * 
	 * @return O declive acumulado do percurso mas só considerando os declives
	 *         positivos
	 */
	public int getSubidaAcumulada() {
		int aux = 0;
		// se houver percursos simples
		if (nPercursosSimples > 0) {
			for (int i = 0; i < nPercursosSimples; i++) {
				if (percursosSimples[i].getDeclive() > 0)
					aux += percursosSimples[i].getDeclive();
			}
		}
		
		// se houver percursos compostos
		if (nPercursosCompostos > 0) {
			for (int i = 0; i < nPercursosCompostos; i++) {
				aux += percursosCompostos[i].getSubidaAcumulada();
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
	 * Devolve uma string com uma descrição do percurso, tal como: NORTE_SUL de
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
	 * seguido da informação do toString deste objecto. Depois deve mostrar os
	 * seus percursos, um por linha, chamando os seus métodos de print, mas
	 * passando como prefixo o prefixo recebido mas prefixado de 2 espaços.
	 * 
	 * @param prefix
	 *            Prefixo a colocar antes da informação do toString e também na
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

		// =====================================================================
		System.out.println(strSeparator);
		System.out.println("Teste ao adicionar PercursoSimples No Início");
		pc1.print("> ");
		System.out.println();

		boolean result = pc1.addicionarPercursoSimplesNoInicio(ps4);
		System.out.println("A adição de " + ps4 + " deu -> " + result);
		System.out.println();

		pc1.print("> ");
		System.out.println();

		// =====================================================================
		System.out.println(strSeparator);
		System.out.println("Teste ao adicionar PercursoSimples No Final");
		pc1.print("> ");
		System.out.println();

		result = pc1.addicionarPercursoSimplesNoFinal(ps3);
		System.out.println("A adição de " + ps3 + " deu -> " + result);
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
		System.out.println("A adição de " + ps3 + " deu -> " + result);
		System.out.println();

		pc1.print("> ");
		System.out.println();

		// =====================================================================
		// TAMOS AQUI
		System.out.println(strSeparator);
		System.out.println("Teste ao adicionar PercursoComposto No Inicio");
		pc2.print("> ");
		System.out.println();

		result = pc2.addicionarPercursoCompostoNoInicio(new PercursoComposto(
				"SAGRESFARO", ps4, 20));
		System.out.println("A adição de " + ps4 + " deu -> " + result);
		System.out.println();

		pc2.print("> ");
		System.out.println();
		// =====================================================================
		System.out.println(strSeparator);
		System.out
				.println("Teste ao adicionar PercursoComposto No Inicio com erro");
		pc1.print("> ");
		System.out.println();

		result = pc1.addicionarPercursoCompostoNoInicio(pc2);
		System.out.println("A adição de " + pc2 + " deu -> " + result);
		System.out.println();

		pc1.print("> ");
		System.out.println();

		//
		// =====================================================================

		System.out.println(strSeparator);
		System.out.println("Teste ao adicionar PercursoComposto No Final");
		PercursoComposto pc6 = new PercursoComposto("sul",
				new PercursoComposto("ss", new PercursoSimples[] { ps4, ps1 },
						20), 20);
		pc6.print("> ");
		System.out.println();

		PercursoComposto pc7 = new PercursoComposto("centro",
				new PercursoSimples[] { ps2, ps3 }, 20);

		result = pc6.addicionarPercursoCompostoNoFinal(pc7);
		System.out.println("A adição de " + pc7 + " deu -> " + result);
		System.out.println();

		pc6.print("> ");
		System.out.println();

		// =====================================================================
		System.out.println(strSeparator);
		System.out.println("Teste ao copia profunda");
		PercursoComposto testCopiaProfunda = new PercursoComposto(pc6);
		testCopiaProfunda.print("> "); // System.out.println(strSeparator);
		System.out.println("Teste ao clone");

		pc6.print("> ");
		System.out.println();

		PercursoComposto pc8 = pc6.clone();
		pc8.print("> ");
		System.out.println();

		PercursoComposto pcA = new PercursoComposto("wa",
				new PercursoSimples[] { new PercursoSimples("vVC",
						"Viana do Castelo", "Caminha", 70_000, 20) }, 20);

		result = pc6.addicionarPercursoCompostoNoFinal(pcA);

		System.out.println("Adicionado " + pcA + " ao pc original, deu -> "
				+ result);
		System.out.println();

		pc8.print("> ");
		System.out.println();

		//
		// =================================================================
		System.out.println(strSeparator);
		System.out.println("Teste ao subidaAcumulada");
		pc6.print("> ");
		System.out.println();
		System.out.println(pc6 + " tem uma subida acumulada de -> "
				+ pc6.getSubidaAcumulada());
		
		System.out.println();
		System.out.println("-------------------------------------OUTROS TESTES---------------------------------------");
		System.out.println();
		
		System.out.println("numero de localidades pc6 -> " + pc6.getNumLocalidades());
		System.out.println(Arrays.toString(pc6.getLocalidades()));
		

	}
}
