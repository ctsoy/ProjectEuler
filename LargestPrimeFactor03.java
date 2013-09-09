import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

public class LargestPrimeFactor03 {
	static BigInteger limit;
	BigInteger largePrime = BigInteger.ONE;
	
	private boolean isPrime(BigInteger n){
		BigInteger i = new BigInteger("2");
		BigInteger h = n.divide(new BigInteger("2"));
		while (i.compareTo(h)<=0){
			if (n.mod(i).equals(BigInteger.ZERO)){
				return false;
			}
			i = i.add(BigInteger.ONE);
		}
		return true;
	}

	private BigInteger findFactor(){
		BigInteger sq = BigInteger.ONE.add(BigInteger.ONE);
		while(!limit.mod(sq).equals(BigInteger.ZERO) && (sq.compareTo(limit)<=0)){
				sq = sq.add(BigInteger.ONE);
			
		}
		System.out.println("Found 1st factor "+sq);
		if (sq.compareTo(limit)>0)
			return sq;
		BigInteger lq = limit.divide(sq);
		while (lq.compareTo(sq) >= 0){
			if (isPrime(lq)){
				return lq;
			}
			if (isPrime(sq)){
				largePrime = sq;
			}
			sq = sq.add(BigInteger.ONE);
			while(!limit.mod(sq).equals(BigInteger.ZERO) && (sq.compareTo(lq)<=0)){
				sq = sq.add(BigInteger.ONE);
			}
			lq = limit.divide(sq);
		}
		
		//if it reaches here, it means it's a prime number itself.
		if (largePrime.compareTo(BigInteger.ONE)>0 )
			return largePrime;
		else
			return limit; 
	}

	public static void main(String[] args){
		if (args.length > 1){
			System.out.println("Only 1 argument is needed.");
			System.exit(0);
		}
		try {
			limit = new BigInteger(args[0]);
		} catch (NullPointerException e){
			System.out.println("I need a number");
			System.exit(0);
		} finally {
			System.out.println("The largest prime factor of "+limit+" is "+ new LargestPrimeFactor03().findFactor().toString());
		}
	}

}