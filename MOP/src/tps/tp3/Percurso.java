package tps.tp3;

public abstract class Percurso {

	/**
	 * nome do percurso, deve conter só letras, digitos e espaços, deve começar
	 * por uma letra e ter pelo menos mais uma letra ou dígito
	 */
	private String nome;

	public Percurso(String nome) {
		if(!validarNomeDeLocal(nome)){
			throw new IllegalArgumentException("Nome inválido -> " + nome);
		}
		this.nome = nome;
	}

	/**
	 * Devolve o nome do percurso
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Devolve o local de início do percurso
	 */
	public abstract String getInicio();

	/**
	 * ... Métodos abstactos - colocar aqui
	 */
	/**
	 * Devolve o local de fim do percurso
	 */
	public abstract String getFim();
	/**
	 * Devolve a distancia do percurso
	 */
	public abstract int getDistancia();
	
	/**
	 * Devolve o declive do percurso
	 */
	public abstract int getDeclive();
	
	/**
	 * Devolve a descricao do percurso
	 */
	public abstract String[] getLocalidades();
	
	/**
	 * Devolve a descricao do percurso
	 */
	public abstract String getDescricao();
	
	

	/**
	 * Deve validar se contém só letras, digitos e espaços, deve começar por uma
	 * letra e ter pelo menos mais uma letra ou dígito
	 * 
	 * @param local
	 *            Nome a validar
	 */
	protected static boolean validarNomeDeLocal(String local) {
		// se tiver menos que dois char
				if (local.length() < 2)
					return false;
				// se o primeiro char nao for uma letra
				if (!(Character.isLetter(local.charAt(0))))
					return false;
				// se os restantes chars nao forem letras, digitos, espacos ou
				// underscore
				for (int i = 1; i < local.length(); i++) {
					if (!(Character.isLetter(local.charAt(i))
							|| Character.isDigit(local.charAt(i))
							|| local.charAt(i) == ' ')) {
						return false;
					}
				}
				return true;
	}

	/**
	 * ToString, deve devolver uma String tal como:
	 * "A2 de Lisboa para Faro, com 278000 metros e com 0 de declive"
	 */
	public String toString() {
		return "percurso " + getDescricao() + " " + getNome() + " de "
				+ getInicio() + " para " + getFim() + ", com " + getDistancia()
				+ " metros e com " + getDeclive() + " de declive";
	}


	/**
	 * Print, deve imprimir na consola o prefixo seguido da informação que se
	 * obtém com o toString
	 * 
	 * @param prefix
	 *            Prefixo a colocar antes da informação do toString
	 */
	public void print(String prefix) {
		System.out.println(prefix + this);
	}

}