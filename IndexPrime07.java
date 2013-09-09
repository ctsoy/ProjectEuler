import java.math.*;

public class IndexPrime07 {
	
	private boolean isPrime(BigInteger n){
		BigInteger d = new BigInteger("2");
		BigInteger lm = n.divide(d);
		while (d.compareTo(lm)<0){
			if (n.mod(d).compareTo(BigInteger.ZERO) ==0){
				return false;
			}
			d = d.add(BigInteger.ONE);
		}
		return true;
	}

	private String findPrime(String l){
		int limit = Integer.parseInt(l);
		BigInteger count = BigInteger.ONE;
		while (limit >= 0){
			count = count.add(BigInteger.ONE);
			if (isPrime(count))
				limit--;
		}
		return count.toString();
	}

	public static void main(String[] args){
		System.out.println("The "+args[0]+" prime number is "+ new IndexPrime07().findPrime(args[0]));
	}

}