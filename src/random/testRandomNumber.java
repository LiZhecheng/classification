package random;

import java.util.Arrays;

public class testRandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomNumber rn = new RandomNumber();
		int[] randomNumber = new int[1000];
		randomNumber = rn.unrepeatRandomNumber( 20, 30, 50);
		
		for(int i = 0; i < randomNumber.length; i++) {
			System.out.print(randomNumber[i] + " ");
		}
		Arrays.sort(randomNumber);
		System.out.println();
		for(int i = 0; i < randomNumber.length; i++) {
			System.out.print(randomNumber[i] + " ");
		}
	}

}
