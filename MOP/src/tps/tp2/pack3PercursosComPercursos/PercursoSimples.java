package tps.tp2.pack3PercursosComPercursos;

/**
 * Classe que suporta um percurso simples
 *
 */
public class PercursoSimples {

	/**
	 * nome do percurso, deve conter s� letras, digitos e espa�os, deve come�ar
	 * por uma letra e ter pelo menos mais uma letra ou d�gito
	 */
	private String nome;

	/**
	 * Nome do ponto de in�cio do percurso
	 */
	private String inicio;

	/**
	 * Nome do ponto de fim do percurso
	 */
	private String fim;

	/**
	 * Dist�ncia em metros do percurso
	 */
	private int distancia;

	/**
	 * Declive em metros, positivo, se fim mais alto que in�cio
	 */
	private int declive;

	/**
	 * Deve validar o nome, inicio e fim com o m�todo de valida��o
	 * validarNomeDelocal. A dist�ncia tem de ser positiva (maior que 0). Em
	 * caso de argumentos inv�lidos deve ser lan�ada a excep��o
	 * IllegalArgumentException com uma mensagem a indicar o erro ocorrido e o
	 * argumento inv�lido.
	 * 
	 * @param nome
	 *            Nome do percurso
	 * @param inicio
	 *            Local do in�cio do percurso
	 * @param fim
	 *            Local de im do percurso
	 * @param distancia
	 *            Distancia do percurso
	 * @param declive
	 *            Declive do percurso
	 */
	public PercursoSimples(String nome, String inicio, String fim,
			int distancia, int declive) {
		if (!validarNomeDeLocal(nome))
			throw new IllegalArgumentException("Nome inv�lido -> " + nome);

		if (!validarNomeDeLocal(inicio))
			throw new IllegalArgumentException("Nome de Inicio inv�lido -> "
					+ inicio);

		if (!validarNomeDeLocal(fim))
			throw new IllegalArgumentException("Nome de Fim inv�lido -> " + fim);

		if (distancia <= 0)
			throw new IllegalArgumentException("Distania inv�lida -> "
					+ distancia);

		this.nome = nome;
		this.inicio = inicio;
		this.fim = fim;
		this.distancia = distancia;
		this.declive = declive;
	}

	/**
	 * Construtor de c�pia, deve copiar os valores do percurso recebido para o
	 * novo percurso.
	 * 
	 * @param p
	 *            O percurso a copiar
	 */
	public PercursoSimples(PercursoSimples p) {
		this(p.getNome(), p.getInicio(), p.getFim(), p.getDistancia(), p
				.getDeclive());
	}

	/**
	 * Deve criar uma c�pia do percurso recebido
	 * 
	 * @return O novo percurso id�ntico ao corrente
	 */
	public PercursoSimples clone() {
		return new PercursoSimples(this.getNome(), this.getInicio(),
				this.getFim(), this.getDistancia(), this.getDeclive());
	}

	/**
	 * Deve validar se cont�m s� letras, digitos e espa�os, deve come�ar por uma
	 * letra e ter pelo menos mais uma letra ou d�gito
	 * 
	 * @param nome
	 *            Nome a validar
	 * @return True se o nome for v�lido
	 */
	public static boolean validarNomeDeLocal(String nome) {
		// se tiver menos que dois char
		if (nome.length() < 2)
			return false;
		// se o primeiro char nao for uma letra
		if (!(Character.isLetter(nome.charAt(0))))
			return false;
		// se os restantes chars nao forem letras, digitos, espacos ou
		// underscore
		for (int i = 1; i < nome.length(); i++) {
			if (!(Character.isLetter(nome.charAt(i))
					|| Character.isDigit(nome.charAt(i))
					|| nome.charAt(i) == ' ' || nome.charAt(i) == '_')) {
				return false;
			}
		}
		return true;
	}

	public String getNome() {
		return nome;
	}

	public String getInicio() {
		return inicio;
	}

	public String getFim() {
		return fim;
	}

	public int getDistancia() {
		return distancia;
	}

	public int getDeclive() {
		return declive;
	}

	/**
	 * ToString, deve devolver uma String tal como:
	 * "A2 de Lisboa para Faro, com 278000 metros e com 0 de declive"
	 * 
	 * @return A string que descreve o percurso
	 */
	public String toString() {
		return nome + " de " + inicio + " para " + fim + ", com " + distancia
				+ " metros e com " + declive + " de declive ";
	}

	/**
	 * Equals, deve devolver true se o percurso recebido tem o mesmo nome, o
	 * mesmo in�cio e o mesmo fim.
	 * 
	 * @param percurso
	 *            Percurso a comparar
	 * @return True se o percurso corrente for igual, por nome, in�cio e fim com
	 *         o percurso recebido
	 */
	public boolean equals(PercursoSimples percurso) {
		if (this.nome.equals(percurso.nome)
				&& this.inicio.equals(percurso.inicio)
				&& this.fim.equals(percurso.fim)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Print, deve imprimir na consola o prefixo seguido da informa��o que se
	 * obt�m com o toString
	 * 
	 * @param prefix
	 *            Prefixo a colocar antes da informa��o do toString
	 */
	public void print(String prefix) {
		System.out.println(prefix + this.toString());
	}

	/**
	 * Main, para realizar testes aos m�todos
	 * 
	 * @param args
	 *            Argumentos do main
	 * 
	 */
	public static void main(String[] args) {
		PercursoSimples ps1 = new PercursoSimples("A2", "Lisboa", "Faro",
				278_000, 0);
		ps1.print("ps1 -> ");

		PercursoSimples ps2 = new PercursoSimples("A1", "Lisboa", "Porto",
				317_000, 0);
		ps2.print("ps2 -> ");

		boolean ps1ps2 = ps1.equals(ps2);
		System.out.println("ps1.equals(ps2) -> " + ps1ps2);

		System.out.println("ps1 toString -> " + ps1);

		System.out.println();
		System.out
				.println("-------------------------------------OUTROS TESTES---------------------------------------");
		System.out.println();

		// teste construtor de copia
		PercursoSimples ps3 = new PercursoSimples(ps1);
		ps3.print("ps3 -> ");

		// teste ao clone
		PercursoSimples ps4 = ps1.clone();
		ps4.print("ps4 -> ");

		// teste validar nome
		System.out.println("teste ao nome A2 -> " + validarNomeDeLocal("A2"));
		System.out.println("teste ao nome A -> " + validarNomeDeLocal("A"));
		System.out.println("teste ao nome A* -> " + validarNomeDeLocal("A*"));

		// teste ao equals
		boolean ps1ps1 = ps1.equals(ps1);
		System.out.println("ps1.equals(ps1) -> " + ps1ps1);
	}
}
