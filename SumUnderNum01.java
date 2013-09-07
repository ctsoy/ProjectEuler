import java.io.*;
import java.lang.*;

public class SumUnderNum01 {
    
    static int resultSum = 0;
    static int limit;
    
    private static void CheckAndAdd(int toplimit){
        for (int i=3; i< toplimit; i++){
            if ((i % 3) == 0){
                resultSum += i;
                continue;
            }
            if ((i % 5) == 0){
                resultSum += i;
                continue;
            }
        }
    }
    
    public static void main(String[] args){
        if (args.length > 1){
            System.out.println ("Too many arguments! I'm leaving!");
            System.exit(0);
        } else {
            try{
                limit = Integer.parseInt(args[0]);
            } catch (NumberFormatException e){
                System.out.println ("I need a natural number! What are you giving me?");
                System.exit(0);
            } finally {
                System.out.println ("... calculating ...");
                CheckAndAdd(limit);

            }
        }
        
        System.out.println ("The sum of all the multiples of 3 and 5 under "+limit+" is "+resultSum+".");
    }

}

// static method needs static methods and variables inside