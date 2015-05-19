package classcode.p07Inheritance.cenario4Produto;

public class C2ProdutoSimples extends C1ProdutoBase {

	// pre�o do produto
	private int preco;

	// stock do produto
	private int stock = 0;

	//
	//
	// ### M�todos ### -------------------------------------------------

	/**
	 * constructor
	 */
	public C2ProdutoSimples(String name, int preco, int initialStock) {
		super(name);
		this.preco = preco;
		stock = initialStock;
	}

	/**
	 * Devolve a descri��o do produto
	 * 
	 * @return a descri��o do produto
	 */
	public String getDescricao() {
		return "produto simples";
	}

	/**
	 * Devolve o pre�o do produto
	 * 
	 * @return o pre�o do produto
	 */
	public int getPreco() {
		return preco;
	}

	/**
	 * Devolve o stock deste do produto
	 * 
	 * @return o stock deste produto
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		// um produto simples
		C2ProdutoSimples p1 = new C2ProdutoSimples(
				"Sapatilhas Mike Air Blue Mountain", 60, 100);
		p1.print("p1 -> ");
		System.out.println(p1);
	}

}
