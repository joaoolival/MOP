package classcode.p06ClassesAndObjects;

/**
 * 
 */
class Requisicao {
	private String data;
	private int nDias;
	private Livro livro;
	private String dataEntrega; // null, significa que o livro não está entregue
	private Pessoa utente;

	public Requisicao(String data, int nDias, Livro livro, Pessoa utente) {
		this.data = data;
		this.nDias = nDias;
		this.livro = livro;
		this.utente = utente;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getData() {
		return data;
	}

	public int getnDias() {
		return nDias;
	}

	public Livro getLivro() {
		return livro;
	}

	public Pessoa getUtente() {
		return utente;
	}

}