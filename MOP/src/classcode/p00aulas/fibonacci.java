package classcode.p00aulas;

public class fibonacci {

	public static void main(String[] args) {
		//fibonacci(10);
		fibonacciR(10);

	}

	/*public static int fibonacci(int val) {
		int aux = 0;
		int current = 1;
		int actual = 0;
		for (int i = 0; i < val - 2; i++) {
			if (i == 0) {
				System.out.println(0);
			}
			if (i == 1) {
				System.out.println(1);
			}
			actual = aux + current;
			aux = current;
			current = actual;
			System.out.println(actual);
		}
		return current;
	}*/
	
	public static int fibonacciR(int val){
		if(val == 0) return 0;
		if(val == 1) return 1;
		return fibonacciR(fibonacciR(val-1) + fibonacciR(val-2));
	}

}
