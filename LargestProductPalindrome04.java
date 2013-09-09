import java.util.*;
import java.lang.*;

//Since 999*999 is 998,001 which is within the int range, I can use int instead of BigInteger.

public class LargestProductPalindrome04 {

	private boolean isPalindrome(int n){
		char[] p = Integer.toString(n).toCharArray();
		for (int i=0; i<=p.length/2; i++){
			if(p[i] != p[p.length-1-i])
				return false;
		}
		return true;
	}
	
	private int findProductPalindrome() {
		int largestP = 0;
		for (int i = 100; i < 1000; i++){
			for (int j = 100; j < 1000; j++){
				if (isPalindrome(i*j) && i*j>largestP)
					largestP = i*j;
			}
		}
		return largestP;
	}

	public static void main(String[] args){
		System.out.println("The largest palindrome made from the product of two 3-digit numbers is "+ new LargestProductPalindrome04().findProductPalindrome());
	}

}