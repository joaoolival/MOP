package classcode.p06ClassesAndObjects;

/**
 * 
 */
class Ocorrencia {
	String data;
	String tipo;
	Requisicao requisicao;

	public Ocorrencia(String data, String tipo, Requisicao requisicao) {
		this.data = data;
		this.tipo = tipo;
		this.requisicao = requisicao;
	}

	public String getData() {
		return data;
	}

	public String getTipo() {
		return tipo;
	}

	public Requisicao getRequisicao() {
		return requisicao;
	}

}