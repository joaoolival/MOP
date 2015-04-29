package classcode.p06ClassesAndObjects;

import java.util.Arrays;


/**
 * 
 */
public class Livro {
	private String titulo;
	private String dataEdicao = "2015/05/13";
	private String[] autores;
	private int numPaginas;
	private String editora;

	private Requisicao requisicao = null;

	public Livro(String newTitulo, String dataEdicao, String[] autores,
			int numPaginas, String editora) {

		if (!isTituloValid(newTitulo))
			throw new IllegalArgumentException("Titulo inválido -> " + titulo);

		if (!isAutoresValid(autores))
			throw new IllegalArgumentException("Autores inválidos -> "
					+ Arrays.toString(autores));

		if (!isNumPaginasValid(numPaginas))
			throw new IllegalArgumentException(
					"O número de páginas não pode ser negativo -> "
							+ numPaginas);

		if (!isPersonNameValid(editora))
			throw new IllegalArgumentException("Editora inválida -> " + editora);

		// validar os autores

		titulo = newTitulo;
		this.dataEdicao = dataEdicao;
		this.autores = autores;
		this.numPaginas = numPaginas;
		this.editora = editora;

	}

	public Livro(String newTitulo, String dataEdicao, String autor,
			int numPaginas) {
		this(newTitulo, dataEdicao, new String[] { autor }, numPaginas,
				"desconhecido");
	}

	public Requisicao getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDataEdicao() {
		return dataEdicao;
	}

	public String[] getAutores() {
		return autores;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public String getEditora() {
		return editora;
	}

	private boolean isAutoresValid(String[] autores) {
		if (autores == null || autores.length == 0)
			return false;

		for (int i = 0; i < autores.length; i++) {
			if (!isPersonNameValid(autores[i]))
				return false;
		}
		return true;
	}

	private boolean isNumPaginasValid(int numPaginas) {
		return numPaginas > 0;
	}

	private boolean isPersonNameValid(String name) {
		if (name == null || name.length() == 0)
			return false;

		// valido: letras, espaços
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i)) && name.charAt(i) != ' ')
				return false;
		}
		return true;
	}

	private boolean isTituloValid(String titulo) {
		if (titulo == null || titulo.length() == 0)
			return false;

		// valido: letras, digitos, :, -, espaços
		for (int i = 0; i < titulo.length(); i++) {
			if (!Character.isLetter(titulo.charAt(i))
					&& !Character.isDigit(titulo.charAt(i))
					&& titulo.charAt(i) != ':' && titulo.charAt(i) != '-'
					&& titulo.charAt(i) != ' ')
				return false;
		}
		return true;
	}

	public String toString() {
		return titulo + ", data de edição " + dataEdicao + ", páginas "
				+ numPaginas + ", autores " + Arrays.toString(autores)
				+ (editora != null ? ", editora " + editora : "");
	}

	public String toSimpleString() {
		return titulo;
	}

	public static void main(String[] args) {

		// Livro l1 = new Livro();
		// l1.titulo = "Viagem ao sol";
		// l1.dataEdicao = "2010/02/03";
		// l1.editora = "PortoEdições";
		//
		// Livro l2 = new Livro();
		// l2.titulo = "Viagem à lua";
		// l2.dataEdicao = "2013/06/23";
		//
		// System.out.println("Livro 1 -> " + l1);
		// System.out.println("Livro 2 -> " + l2);

		Livro l3 = new Livro("Viagem ao sol", "2010/02/03", new String[] {
				"José Sara", "Lobo Ant" }, 100, "PortoEdições");

		Livro l4 = new Livro("Viagem à lua", "2013/06/23", "Sofia Melo", 300);

		System.out.println("Livro 3 -> " + l3.toSimpleString());
		System.out.println("Livro 4 -> " + l4);

	}

}
