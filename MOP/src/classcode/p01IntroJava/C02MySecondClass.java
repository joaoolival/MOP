package classcode.p01IntroJava;
import java.util.Scanner;

public class C02MySecondClass {
	public static void main(String[] args) {
		Scanner keyboard = new java.util.Scanner(System.in);
		
		System.out.println("inteiro -> ");
		
		int val = keyboard.nextInt();
		
		System.out.println("o inteiro lido foi " + val);
		
		keyboard.close();

	}

}
