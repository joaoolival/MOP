package tps.tp2.pack2Percursos;
import java.util.Arrays;
public class testClass {
	
	public static void main(String[] args) {
		int nPercursos = 7;
		String[] src  = new String[]{"a","b","c","d","e","f","g"};
		int aux = 0;
		for (int i = 0; i < nPercursos; i++) {
			if(src[i] == "a"){
				aux=i;
				break;
			}
		}
		System.out.println(aux);
		aux+=1;
		String[] removePart = Arrays.copyOfRange(src,aux,nPercursos);
		
		int length = nPercursos;
		for (;aux < length; aux++) {
			src[aux]=null;
			nPercursos--;
		}
		
		System.out.println(Arrays.toString(removePart));
		//System.out.println(i);
	}

}
