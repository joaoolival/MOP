package tps.tp3;

public abstract class Percurso implements IPercurso {

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

	/* (non-Javadoc)
	 * @see tps.tp3.IPercurso#getNome()
	 */
	@Override
	public String getNome() {
		return nome;
	}

	/* (non-Javadoc)
	 * @see tps.tp3.IPercurso#getInicio()
	 */
	//@Override
	//public abstract String getInicio();

	/**
	 * ... Métodos abstactos - colocar aqui
	 */
	/* (non-Javadoc)
	 * @see tps.tp3.IPercurso#getFim()
	 */
	//@Override
	//public abstract String getFim();
	/* (non-Javadoc)
	 * @see tps.tp3.IPercurso#getDistancia()
	 */
	//@Override
	//public abstract int getDistancia();
	
	/* (non-Javadoc)
	 * @see tps.tp3.IPercurso#getDeclive()
	 */
	//@Override
	//public abstract int getDeclive();
	
	/* (non-Javadoc)
	 * @see tps.tp3.IPercurso#getLocalidades()
	 */
	//@Override
	//public abstract String[] getLocalidades();
	
	/* (non-Javadoc)
	 * @see tps.tp3.IPercurso#getDescricao()
	 */
	//@Override
	//public abstract String getDescricao();
	
	

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

	/* (non-Javadoc)
	 * @see tps.tp3.IPercurso#toString()
	 */
	@Override
	public String toString() {
		return "percurso " + getDescricao() + " " + getNome() + " de "
				+ getInicio() + " para " + getFim() + ", com " + getDistancia()
				+ " metros e com " + getDeclive() + " de declive";
	}


	/* (non-Javadoc)
	 * @see tps.tp3.IPercurso#print(java.lang.String)
	 */
	@Override
	public void print(String prefix) {
		System.out.println(prefix + this);
	}

}