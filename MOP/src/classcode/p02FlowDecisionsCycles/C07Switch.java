package classcode.p02FlowDecisionsCycles;

/**
 * Switch com inteiros (bytes) - com m�ltiplas entradas para o mesmo c�digo
 * 
 * 
 * @author ateofilo
 * 
 */
public class C07Switch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// n�mero do m�s no ano
		byte month = 1;

		System.out.println("M�s -> " + month);

		// nome da respectiva esta��o - esta��o em maioria nesse m�s
		String seasonName;

		switch (month) {
		case 1:
		case 2:
		case 3:
			seasonName = "Inverno";
			break;
		case 4:
		case 5:
		case 6:
			seasonName = "Primavera";
			break;
		case 7:
		case 8:
		case 9:
			seasonName = "Ver�o";
			break;
		case 10:
		case 11:
		case 12:
			seasonName = "Outono";
			break;
		default:
			seasonName = "m�s inv�lido";
		}

		System.out.println("Nome da esta��o -> " + seasonName);
	}
}
