import java.math.*;
import java.lang.*;
import java.util.*;

public class SumSquareDiff06 {
	private static final BigInteger ONE = BigInteger.ONE;

	private BigInteger getSumSquare(String limit){
		BigInteger l = new BigInteger(limit);
		BigInteger sum = BigInteger.ZERO;
		for(BigInteger i = ONE; i.compareTo(l)<=0; i=i.add(ONE)){
			sum = sum.add(i.pow(2));
		}
		return sum;
	}
	
	private BigInteger getSquareSum(String limit){
		BigInteger l = new BigInteger(limit);
		BigInteger sum = BigInteger.ZERO;
		for(BigInteger i = ONE; i.compareTo(l)<=0; i=i.add(ONE)){
			sum = sum.add(i);
		}
		return sum.pow(2);
	}
	
	private String getDiff(String l){
		return getSumSquare(l).subtract(getSquareSum(l)).abs().toString();
	}

	public static void main(String[] args){
		System.out.println("The difference between the sum of the squares and the square of the sum is "
			+ new SumSquareDiff06().getDiff(args[0]));
	}

}