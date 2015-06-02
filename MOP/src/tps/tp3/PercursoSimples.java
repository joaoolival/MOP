package tps.tp3;


/**
 * Classe que suporta um percurso simples
 *
 */
public class PercursoSimples extends Percurso {

	/**
	 * Nome do ponto de início do percurso
	 */
	private String inicio;

	/**
	 * Nome do ponto de fim do percurso
	 */
	private String fim;

	/**
	 * Distância em metros do percurso
	 */
	private int distancia;

	/**
	 * Declive em metros, positivo, se fim mais alto que início
	 */
	private int declive;

	/**
	 * Constructor. Deve validar o nome, inicio e fim com o método de validação
	 * validarNomeDelocal. A distância tem de ser positiva (>0)
	 * 
	 * @param nome
	 *            Nome do percurso
	 * @param inicio
	 *            Local do início do percurso
	 * @param fim
	 *            Local de im do percurso
	 * @param distancia
	 *            Distancia do percurso
	 * @param declive
	 *            Declive do percurso
	 */
	public PercursoSimples(String nome, String inicio, String fim,
			int distancia, int declive) {
		super(nome);
		if (!validarNomeDeLocal(inicio))
			throw new IllegalArgumentException("Nome de inicio inválido -> "
					+ inicio);
		if (!validarNomeDeLocal(fim))
			throw new IllegalArgumentException("Nome de inicio inválido -> "
					+ fim);
		if(distancia <0)
			throw new IllegalArgumentException("Distancia menor ou igual a zero -> "
					+ distancia);
		
		this.inicio=inicio;
		this.fim = fim;
		this.distancia= distancia;
		this.declive=declive;
	}

	/**
	 * Construtor de cópia, deve chamar o constructor acima
	 * 
	 * @param p
	 *            O percurso a copiar
	 */
	public PercursoSimples(PercursoSimples p) {
		this(p.getNome(), p.getInicio(), p.getFim(), p.getDistancia(), p
				.getDeclive());
	}

	/**
	 * Deve criar uma cópia do percurso recebido
	 */
	public PercursoSimples clone() {
		return new PercursoSimples(this.getNome(), this.getInicio(),
				this.getFim(), this.getDistancia(), this.getDeclive());
	}

	/**
	 * Devolve o início do percurso
	 */
	public String getInicio() {
		return inicio;
	}

	/**
	 * Devolve o fim do percurso
	 */
	public String getFim() {
		return fim;
	}

	/**
	 * Devolve a distância do percurso
	 */
	public int getDistancia() {
		return distancia;
	}

	/**
	 * Devolve o declive do percurso
	 */
	public int getDeclive() {
		return declive;
	}

	/**
	 * Equals, deve devolver true se o percurso é do tipo PercursoSimples, se
	 * tem o mesmo nome, o mesmo início e o mesmo fim.
	 * 
	 * @param percurso
	 *            Percurso a comparar
	 */
	public boolean equals(Object percurso) {
		boolean condition = false;
		if((percurso != null)&&(percurso instanceof PercursoSimples)){
			PercursoSimples auxPercurso = (PercursoSimples) percurso;
			if(getNome().equals(auxPercurso.getNome()) && getInicio().equals(auxPercurso.getInicio()) && getFim().equals(auxPercurso.getFim())){
				condition = true; 
			}
		}
		return condition;
	}

	/**
	 * Main, para realizar testes aos métodos
	 */
	public static void main(String[] args) {
		PercursoSimples ps1 = new PercursoSimples("A2", "Lisboa", "Faro",
				278_000, 0);
		ps1.print("ps1 -> ");

		PercursoSimples ps2 = new PercursoSimples("A1", "Lisboa", "Porto",
				317_000, 0);
		ps2.print("ps2 -> ");

		boolean ps1ps2 = ps1.equals(ps2);
		System.out.println("ps1.equals(ps2) -> " + ps1ps2);

		System.out.println("ps1 toString -> " + ps1);
	}

	@Override
	public String[] getLocalidades() {
		return new String[] { getInicio(), getFim() };
	}

	public String getDescricao() {
		return "simples";
	}

}
