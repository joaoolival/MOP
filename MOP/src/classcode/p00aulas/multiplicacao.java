package classcode.p00aulas;

public class multiplicacao {

	public static void main(String[] args) {
		System.out.println(mult(20088888880l,700l));
	}
	public static long mult(long a, long b){
		if(a==0|| b==0) return 0;
		if(b>0) return a + mult(a, b-1);
		return -(a + mult(a , -b-1));
	}

}
