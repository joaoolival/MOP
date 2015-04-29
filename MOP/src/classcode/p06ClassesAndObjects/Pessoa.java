package classcode.p06ClassesAndObjects;

/**
 * 
 */
class Pessoa {
	String nome;
	int numTelefone;
	String morada;
	Requisicao[] requisicoes = new Requisicao[1000];
	int nRequisicoes = 0;
	Ocorrencia[] ocorrencias = new Ocorrencia[1000];
	int nOcorrencias = 0;

	public Pessoa(String nome, int numTelefone, String morada) {
		this.nome = nome;
		this.numTelefone = numTelefone;
		this.morada = morada;
	}

	public int getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(int numTelefone) {
		this.numTelefone = numTelefone;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public String getNome() {
		return nome;
	}

	public Requisicao[] getRequisicoes() {
		return requisicoes;
	}

	public Ocorrencia[] getOcorrencias() {
		return ocorrencias;
	}

	public boolean addRequisicao(Requisicao r) {
		// verificar se há espaço
		if (nRequisicoes == requisicoes.length)
			return false;

		// inserir
		requisicoes[nRequisicoes++] = r;
		return true;
	}

	public String toString() {
		return getNome() + ", telefone " + getNumTelefone() + ", morada "
				+ getMorada();
	}

}