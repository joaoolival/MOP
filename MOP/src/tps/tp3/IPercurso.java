package tps.tp3;

public interface IPercurso {

	/**
	 * Devolve o nome do percurso
	 */
	public abstract String getNome();

	/**
	 * Devolve o local de in�cio do percurso
	 */
	public abstract String getInicio();

	/**
	 * ... M�todos abstactos - colocar aqui
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
	 * ToString, deve devolver uma String tal como:
	 * "A2 de Lisboa para Faro, com 278000 metros e com 0 de declive"
	 */
	public abstract String toString();

	/**
	 * Print, deve imprimir na consola o prefixo seguido da informa��o que se
	 * obt�m com o toString
	 * 
	 * @param prefix
	 *            Prefixo a colocar antes da informa��o do toString
	 */
	public abstract void print(String prefix);

}