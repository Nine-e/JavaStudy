/**
 * Created by del on 2017/9/15.
 */

import java.util.Scanner;
import java.math.*;
public class HomeworkOne_One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] a = new double[10];
        for (int i = 0; i < a.length; ++i)
            a[i] = in.nextDouble();
        System.out.printf("%.2f\n", mean(a));
        System.out.printf("%.2f\n", deviation(a));
        in.close();
    }
    public static double mean( double[] a ){
        double sum = 0;
        for (int i = 0; i < a.length; ++i)
            sum += a[i];
        return  sum/a.length;
    }
    public static double deviation ( double[] a ){
        double deno = 0;
        double themean = mean(a);
        for (int i = 0; i < a.length; ++i)
            deno += (a[i] - themean)*(a[i] - themean);
        return Math.sqrt(deno / (a.length - 1) );
    }
}
