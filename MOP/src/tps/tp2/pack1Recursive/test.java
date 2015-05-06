package tps.tp2.pack1Recursive;
import java.util.Arrays;
public class test {
	
	public static int sumDigits(int n, int sum) {    
	    // Basic Case to stop the recursion
	if (n== 0)  {
	        return sum;
	    } else {
	        sum = sum + n % 10;  //recursive variable to keep the digits sum
	        n= n/10;
	        return sumDigits(n, sum); //returning sum to print it.
	    }
	}
	public static void main(String[] args) {
		System.out.println(sumDigits(121212, 0));
	}


}
