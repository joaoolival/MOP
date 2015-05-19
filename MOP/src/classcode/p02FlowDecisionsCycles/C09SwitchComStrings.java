package classcode.p02FlowDecisionsCycles;

/**
 * Switch com Strings - o compilador tem de estar com Compiler Compliance Level
 * de 1.7. Ir a Project->Properties->Java Compiler.
 * 
 * @author ateofilo
 * 
 */
public class C09SwitchComStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// the initial season
		String estacao = "Inverno";

		// show it
		System.out.println("Esta��o corrente -> " + estacao);

		// set the next season
		switch (estacao) {
		case "Inverno":
			estacao = "Primavera";
			break;
		case "Primavera":
			estacao = "Ver�o";
			break;
		case "Ver�o":
			estacao = "Outono";
			break;
		case "Outono":
			estacao = "Inverno";
		default:
			System.out
					.println("O nome inicial n�o corresponde a uma esta��o do ano");
			System.out.println("O programa vai terminar!!!");
			System.exit(1);
		}

		System.out.println("Pr�xima esta��o -> " + estacao);

	}

}
