package SixthLab;

/**
 * Created by del on 2017/11/2.
 */
import java.util.Scanner;

class NegativeNumberException extends Exception{
    public NegativeNumberException (){
        System.out.println("Invalid");
    }
    public NegativeNumberException (String s){
        System.out.println(s);
    }

}
public class Two {

    public static double squareRoot(double x) throws NegativeNumberException{
        if(x < 0){
            throw new NegativeNumberException();
        }
        else {
            return Math.sqrt(x);
        }
    }
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        try {
            System.out.println(String.format("%.2f",squareRoot(x)));
        }catch (NegativeNumberException ex){}
    }
}
