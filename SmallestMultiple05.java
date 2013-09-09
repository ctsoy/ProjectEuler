import java.util.*;
import java.lang.*;
import java.math.*;

public class SmallestMultiple05 {
	
	private boolean isDivisible(int l, BigInteger q){
		BigInteger count = new BigInteger("2");
		for (int i = 2; i<=l; i++){
			if (q.mod(count).compareTo(BigInteger.ZERO) != 0){
				return false;
			}
			count = count.add(BigInteger.ONE);
		}
		return true;
	}

	private String findSmallProduct(String limit){
		int l = Integer.parseInt(limit);
		BigInteger exactP = BigInteger.ONE;
		BigInteger count = BigInteger.ONE;
		for (int i = 1; i<=l; i++){
			exactP = exactP.multiply(count);
			count = count.add(BigInteger.ONE);
		}
		BigInteger smallP = new BigInteger(limit);
		while (smallP.compareTo(exactP) < 0){
			if (isDivisible(l, smallP)){
				if (smallP.compareTo(exactP) < 0)
					return smallP.toString();
			} else 
				smallP = smallP.add(BigInteger.ONE);
		}
		return exactP.toString();
	}

	public static void main(String[] args){
		System.out.println("The smallest positive number that is evenly divisible by all of the numbers from 1 to "
			+args[0]+" is "+new SmallestMultiple05().findSmallProduct(args[0]));
	}
}