package SixthLab;

/**
 * Created by del on 2017/11/2.
 */
import java.util.Scanner;
public class One {
    public static double getArea(double a, double b, double c){
        if(a==b || a==c || b==c ){
            double p = (a + b + c)/ 2;
            return Math.sqrt(p * (p - a) * (p - b)* (p - c));
        }
        else {
            throw new IllegalArgumentException("The input is illegal");
        }

    }
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double area;

        try{
            area = getArea(a,b,c);
            System.out.println(String.format("%.2f",area));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
