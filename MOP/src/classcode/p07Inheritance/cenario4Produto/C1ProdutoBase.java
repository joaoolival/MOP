package classcode.p07Inheritance.cenario4Produto;

/*
 * Classe base do cen�rio.
 * Exemplo formado pelas classes: ProdutoBase, ProdutoSimples e ProdutoComposto
 * 
 * Ver a documenta��o de cada m�todo, colocar o rato por cima do nome do m�todo
 *  
 */

public class C1ProdutoBase {

	/**
	 * Prefixo a ser utilizado aquando da identa��o de produtos dentro de um
	 * produtoComposto
	 */
	protected static String PREFIXBASE = "  ";

	/**
	 * Nome do produto
	 */
	private String name;

	//
	//
	// ### M�todos ### -------------------------------------------------

	/**
	 * M�todo constructor, deve guardar o nome recebido na vari�vel name
	 */
	public C1ProdutoBase(String name) {
		this.name = name;
	}

	/**
	 * Devolve o nome do produto
	 * 
	 * @return o nome do produto
	 */
	public String getName() {
		return name;
	}

	/**
	 * Devolve a descri��o do produto
	 * 
	 * @return a descri��o do produto
	 */
	public String getDescricao() {
		return null;
	}

	/**
	 * Devolve o pre�o do produto
	 * 
	 * @return o pre�o do produto
	 */
	public int getPreco() {
		return 0;
	}

	/**
	 * Devolve o stock deste do produto
	 * 
	 * @return o stock deste produto
	 */
	public int getStock() {
		return 0;
	}

	/**
	 * Devolve uma descri��o textual do produto
	 * 
	 * @return uma String com a descri��o sum�ria deste produto
	 */
	public String toString() {
		return getName() + ", " + getDescricao() + ", pre�o de " + getPreco()
				+ ", stock de " + getStock();
	}

	/**
	 * Mostra na consola a descri��o do produto, por omiss�o essa descri��o � o
	 * toString aqui declarado. A descri��o deve ser prefixada com o prefixo
	 * recebido.
	 * 
	 * @param prefix
	 *            O prefixo a colocar antes da descri��o do objecto
	 */
	public void print(String prefix) {
		// A coloca��o de this na string, vai implicar a chamada ao m�todo
		// toSTring do objecto.
		// � equivalente a System.out.println(prefix + toString());
		System.out.println(prefix + this);
	}

}
