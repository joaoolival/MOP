package classcode.p07Inheritance.cenario4Produto;

/**
 * Exemplo de heran�a com um array com possibilidade de ter elementos a null
 * entre posi��es ocupadas. Exemplo do uso de instanceof e casts de classes.
 * 
 */
public class C3ProdutoComposto extends C1ProdutoBase {

	// Suporte aos produtos que este produto composto pode conter - os produtos
	// existentes poder�o estar em quaiquer �ndexes, o que significa que pode
	// haver posi��es a null em qualquer posi��o e que n�o se deve alterar a
	// posi��o dos produtos uma vez colocados.

	// Os produtos nele contido podem ser produtosSimples ou ProdutosCompostos
	private C1ProdutoBase[] produtos = new C1ProdutoBase[40];

	// Conter� o n�mero de produtos existentes
	private int nProdutos = 0;

	//
	//
	// ### M�todos ### -------------------------------------------------

	/**
	 * constructor
	 */
	public C3ProdutoComposto(String name) {
		super(name);
	}

	/**
	 * Adicionar um produto a este produto composto, caso o argumento recebido
	 * seja null ou caso n�o haja espa�o.
	 * 
	 * @param produto
	 *            o produto a inserir, pode ser um produto simples ou produto
	 *            composto
	 * @return true se a inser��o tiver sido realizada, false caso contr�rio
	 */
	public boolean addProduto(C1ProdutoBase produto) {
		if (produto == null || nProdutos == produtos.length)
			return false;

		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] == null) {
				produtos[i] = produto;
				nProdutos++;
				return true;
			}
		}

		// nunca deve ocorrer
		return false;
	}

	/**
	 * Remove o primeiro produto encontrado que tiver o mesmo nome que o nome
	 * recebido. Para j� s� se deve procurar nos produtos directos deste
	 * produtoComposto
	 * 
	 * @param name
	 *            O nome do produto a remover
	 * @return O produto removido ou null se n�o encontrar um produto com esse
	 *         nome
	 */
	public C1ProdutoBase remProduto(String name) {
		// Percorrer todos os produtos do produtoComposto
		// O for s� deve continuar at� atingirmos os nProdutos consultados
		for (int i = 0, nprods = 0; i < produtos.length && nprods < nProdutos; i++) {
			// verificar se a posi��o i cont�m um produto
			if (produtos[i] != null) {
				// verificar se o produto na posi��o i � o produto pretendido
				if (produtos[i].getName().equalsIgnoreCase(name)) {
					// remover e devolver o produto
					C1ProdutoBase prod = produtos[i];
					produtos[i] = null;
					nProdutos--;
					return prod;
				}
				// incrementar o n�mero de produtos consultados
				nprods++;
			}
		}

		// significa que n�o encontrou nenhum produto com o nome recebido
		return null;
	}

	/**
	 * Devolve a descri��o do produto
	 * 
	 * @return a descri��o do produto
	 */
	public String getDescricao() {
		return "produto composto com " + nProdutos + " produtos";
	}

	/**
	 * Devolve o pre�o total dos v�rios produtos dentro dele. Deve-se considerar
	 * o pre�o de uma unidade de cada produto.
	 * 
	 * @return o pre�o total do produto composto
	 */
	public int getPreco() {
		int preco = 0;
		// percorrer o array at� se ter consultado nProdutos produtos
		for (int i = 0, nprods = 0; i < produtos.length && nprods < nProdutos; i++) {
			if (produtos[i] != null) {
				preco += produtos[i].getPreco();
				nprods++;
			}
		}
		return preco;
	}

	/**
	 * Devolve o stock deste do produto composto. O valor a devolver ser� o
	 * n�mero de vendas que se poder�o realizar deste produto. Considera-se que
	 * o produto composto, para efeitos de venda e stock, � composto por uma
	 * unidade de cada produto nele contido.
	 * 
	 * @return o stock deste produto
	 */
	public int getStock() {

		// sem produtos o stock � zero
		if (nProdutos == 0)
			return 0;

		// para conter o valor m�nimo dos stocks de todos os produtos
		int minStock = 0;

		// inicializar o minStock com o stock do primeiro produto
		int i = 0;
		for (; i < produtos.length; i++) {
			if (produtos[i] != null) {
				minStock = produtos[i].getStock();
				i++;
				break;
			}
		}

		// percorrer o array at� se ter consultado os nProdutos produtos
		for (int nprods = 1; i < produtos.length && nprods < nProdutos; i++) {
			if (produtos[i] != null) {
				// se este produto tiver um stock inferior ao m�nimo, coloc�-lo
				// como m�nimo
				if (produtos[i].getStock() < minStock)
					minStock = produtos[i].getStock();
			}
		}
		return minStock;
	}

	/**
	 * Devolve o n�mero de produtos compostos dentro destre produto composto
	 */
	public int getNumProdutosCompostos() {
		int total = 0;
		for (int i = 0, nprods = 0; i < produtos.length && nprods < nProdutos; i++) {
			if (produtos[i] != null) {

				if (produtos[i] instanceof C3ProdutoComposto) {
					// fazer o cast para produto composto
					C3ProdutoComposto pc = (C3ProdutoComposto) produtos[i];
					// obter o n�mero de produtos compostos dentro desse produto
					// composto, contar com ele mesmo
					total += 1 + pc.getNumProdutosCompostos();
				}

			}
		}
		return total;
	}

	/**
	 * Devolve uma descri��o textual do produto
	 * 
	 * @return uma String com a descri��o textual deste produto
	 */
	public String toString() {
		String s = super.toString() + " : [ ";
		for (int i = 0; i < nProdutos; i++) {
			s += produtos[i];
			if (i < nProdutos - 1)
				s += "; ";
		}
		return s + " ]";
	}

	/**
	 * Mostra na consola a descri��o do produto. A descri��o deve ser prefixada
	 * com o prefixo recebido. Os seus produtos devem ser ainda ser prefixado
	 * previamente com o prefixo por omiss�o que � o ProdutoBase.PREFIXBASE
	 * 
	 * @param prefix
	 *            O prefixo a colocar antes da descri��o do objecto
	 */
	public void print(String prefix) {

		// header do produto
		System.out.println(prefix + super.toString());

		// percorrer todos os seus produtos
		for (int i = 0, nprods = 0; i < produtos.length && nprods < nProdutos; i++) {
			if (produtos[i] != null) {
				produtos[i].print(PREFIXBASE + prefix);
			}
		}
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// um produto composto
		C3ProdutoComposto pcOutDoor = new C3ProdutoComposto("PackOutdoor");
		pcOutDoor.addProduto(new C2ProdutoSimples(
				"Sapatilhas Mike Air Blue Mountain", 60, 100));
		pcOutDoor.addProduto(new C2ProdutoSimples(
				"Cal�as desportivas Axics Jungle treck", 25, 200));

		// um produto composto com um artigo composto dentro
		C3ProdutoComposto pc1 = new C3ProdutoComposto("PackPrimavera");
		pc1.addProduto(new C2ProdutoSimples(
				"Mochila The South Face Sunny Walk", 40, 300));
		pc1.addProduto(new C2ProdutoSimples("Bin�culos Laica Bright View", 80,
				50));
		pc1.addProduto(pcOutDoor);
		pc1.addProduto(new C2ProdutoSimples("T-Shirt Domyous Spring Forest", 6,
				500));
		pc1.addProduto(new C2ProdutoSimples("Kayak Melo Amazonas 500", 740, 30));

		// chamada ao toString e print de um produto composto
		System.out.println("pc1 -> " + pc1);
		System.out.println();

		pc1.print("");
		System.out.println();

		int n = pc1.getNumProdutosCompostos();
		System.out.println("pc1.getNumProdutosCompostos() -> " + n);
		System.out.println();

		// remover um produto simples
		C1ProdutoBase result = pc1.remProduto("Bin�culos Laica Bright View");
		System.out
				.println("pc1.remProduto(\"Bin�culos Laica Bright View\") -> "
						+ result);
		pc1.print("");
		System.out.println();

		// remover um produto composto
		result = pc1.remProduto("PackOutdoor");
		System.out.println("pc1.remProduto(\"PackOutdoor\") -> " + result);
		pc1.print("");
		System.out.println();

		// remover um produto simples
		result = pc1.remProduto("Kayak Melo Amazonas 500");
		System.out.println("pc1.remProduto(\"Kayak Melo Amazonas 500\") -> "
				+ result);
		pc1.print("");
		System.out.println();

		// remover um produto simples inexistente
		result = pc1.remProduto("Kayak Melo Amazonas 500");
		System.out.println("pc1.remProduto(\"Kayak Melo Amazonas 500\") -> "
				+ result);
		pc1.print("");
		System.out.println();

	}
}
