import java.io.*;
import java.lang.*;

public class EvenFibonacci02 {
	
	int firstTerm = 1;
	int secondTerm = 2;
	int current = 0;
	private int resultSum = 2;
	private static final int LIMIT = 4000000;
	
	private int getCurrentTerm(){
		return (firstTerm + secondTerm);
	}
	
	private void moveTerms(){
		firstTerm = secondTerm;
		secondTerm = current;
		current = getCurrentTerm();
	}
	
	private boolean isEven(int c){
		if ((c % 2) == 0)
			return true;
		else
			return false;
	}
	
	private int getResultSum(){
		current = getCurrentTerm();
		while (current<LIMIT){
			if (isEven(current))
				resultSum += current;
			moveTerms();
		}
		
		return resultSum;
	}
	
	public static void main(String[] args){
		System.out.println("The sum for even Fibonacci terms under 4 million is "+new EvenFibonacci02().getResultSum());
	}
}