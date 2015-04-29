package classcode.p06ClassesAndObjects;

/**
 * 
 */
class Biblioteca {
	// arrays com objectos sempre nos menores �ndices, shift nas remo��es

	String nome;

	Livro[] livros = new Livro[2000];
	int nLivros = 0;

	Pessoa[] utentes = new Pessoa[1000];
	int nUtentes = 0;

	Requisicao[] requisicoes = new Requisicao[10000];
	int nRequisicoes = 0;

	Ocorrencia[] ocorrencias = new Ocorrencia[3000];
	int nOcorrencias = 0;

	/*
	 * constructor
	 */
	public Biblioteca(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	/**
	 * S� se pode adicionar o livro se n�o existir um outro livro com o mesmo
	 * titulo
	 */
	public boolean addLivro(Livro l) {
		// verificar se h� espa�o
		if (nLivros == livros.length)
			return false;

		// verificar se � repetido
		if (getLivroPorTitulo(l.getTitulo()) >= 0)
			return false;

		// inserir
		livros[nLivros] = l;
		nLivros++;
		return true;
	}

	public boolean addPessoa(Pessoa p) {
		// verificar se h� espa�o
		if (nUtentes == utentes.length)
			return false;

		// inserir
		utentes[nUtentes++] = p;
		return true;
	}

	public boolean addRequisicao(String titulo, String nomeUtente) {
		// verificar se h� espa�o
		if (nRequisicoes == requisicoes.length)
			return false;

		int idxLivro = getLivroPorTitulo(titulo);
		if (idxLivro == -1)
			return false;
		Livro livro = livros[idxLivro];

		int idxUtente = getUtentePorNome(nomeUtente);
		if (idxUtente == -1)
			return false;
		Pessoa utente = utentes[idxUtente];

		// construir a requisicao
		Requisicao req = new Requisicao("2015/04/14", 30, livro, utente);
		if (!utente.addRequisicao(req))
			return false;

		// adicionar a requisicao ao array da biblioteca
		requisicoes[nRequisicoes++] = req;
		return true;
	}

	public Livro remLivro(String titulo) {
		int idx = getLivroPorTitulo(titulo);
		if (idx == -1)
			return null;

		// livro encontrado, remov�-lo
		Livro l = livros[idx];

		for (int i = idx; i < nLivros - 1; i++) {
			livros[i] = livros[i + 1];
		}
		livros[nLivros - 1] = null;
		nLivros--;
		return l;
	}

	/**
	 * Procura pela exist�ncia de um livro com o mesmo nome, devolve o �ndice do
	 * livro se o encontrar, ou -1 se n�o o encontrar
	 */
	private int getLivroPorTitulo(String titulo) {
		for (int i = 0; i < nLivros; i++) {
			if (livros[i].getTitulo().equalsIgnoreCase(titulo))
				return i;
		}
		return -1;
	}

	private int getUtentePorNome(String nome) {
		for (int i = 0; i < nUtentes; i++) {
			if (utentes[i].getNome().equalsIgnoreCase(nome))
				return i;
		}
		return -1;
	}

	public String toString() {
		return getNome() + ", n�mero de livros " + nLivros;
	}

	/**
	 * Listagem com um livro por linha
	 */
	public void mostrarLivros() {
		System.out.println("Livros existentes na biblioteca: " + getNome());
		for (int i = 0; i < nLivros; i++) {
			System.out.println(" " + livros[i]);
		}
		System.out.println();
	}

	public void mostrarUtentes() {
		System.out.println("Utentes registados na biblioteca: " + getNome());
		for (int i = 0; i < nUtentes; i++) {
			System.out.println(" " + utentes[i]);
		}
		System.out.println();
	}

	void init() {

		// inser��o de livros
		Livro l = new Livro("Viagem ao sol", "2010/02/03", new String[] {
				"Jos� Sara", "Lobo Ant" }, 100, "PortoEdi��es");
		addLivro(l);

		// esta inser��o vai dar erro
		l = new Livro("Viagem ao sol", "2010/02/03", new String[] {
				"Jos� Sara", "Lobo Ant" }, 100, "PortoEdi��es");
		addLivro(l);

		l = new Livro("Viagem � lua", "2013/06/23", "Sofia Melo", 300);
		addLivro(l);

		l = new Livro("Viagem a Marte", "2013/06/23", "Sofia Melo", 300);
		addLivro(l);

		// inserir utentes

		Pessoa p = new Pessoa("Manuel Jos�", 233333333, "Lisboa");
		addPessoa(p);

		p = new Pessoa("Ana Maria", 234234234, "Porto");
		addPessoa(p);

	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		Biblioteca bibLisboa = new Biblioteca("Biblioteca de Lisboa");

		bibLisboa.init();

		bibLisboa.mostrarLivros();

		bibLisboa.remLivro("Viagem ao Sol");

		bibLisboa.mostrarLivros();

		bibLisboa.mostrarUtentes();

		// mostrar utentes

		// menu de opera��o: inserir requisicao, inserir entrega de livro,
		// listar requisicoes em atraso. Ver exemplo de Menu em
		// classcode.p06ClassesAndObjects.C05BAnco

	}
}