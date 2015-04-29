package tps.tp2.pack2Percursos;
import java.util.Arrays;
public class testClass {
	
	public static void main(String[] args) {
		String[] src  = new String[]{"a","a","a","a","a"};
		String[] dest = new String[10];
		
		System.arraycopy( src, 0, dest, 0, src.length );
		
		System.out.println(Arrays.toString(dest));
	}

}
