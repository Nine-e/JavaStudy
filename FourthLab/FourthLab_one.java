
package FourthLab;

/**
 * Created by del on 2017/9/28.
 */


import java.util.Scanner;
public class FourthLab_one {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a1 = in.nextDouble();
        double b1 = in.nextDouble();
        double a2 = in.nextDouble();
        double b2 = in.nextDouble();
        Complex a = new Complex(a1, b1);
        Complex b = new Complex(a2, b2);
        Complex c = new Complex();
        System.out.print(a + " + " + b + " = ");
        c = a.add(b);
        c.print();
        System.out.print(a + " - " + b + " = ");
        c = a.sub(b);
        c.print();
        System.out.print(a + " * " + b + " = ");
        c = a.mul(b);
        c.print();
        System.out.print(a + " / " + b + " = ");
        c = a.div(b);
        c.print();
        in.close();
    }
}

/*【描述】
        编写程序，计算2个复数的和、差、积、商。*/

 class Complex{
     double a;
     double b;
     public Complex(){
         a = 0;
         b = 0;
     }
     public Complex(double a1,double b1){
         a = a1;
         b = b1;
     }
     public Complex add(Complex x){
         Complex c = new Complex();
         c.a = a + x.a;
         c.b = b + x.b;
         return  c;
     }
     public Complex sub(Complex x){
         Complex c = new Complex();
         c.a = a - x.a;
         c.b = b - x.b;
         return c;
     }
     public Complex mul(Complex x){
         Complex c = new Complex();
         c.a = a * x.a - b * x.b;
         c.b = a * x.b + b * x.a;
         return c;
     }
     public Complex div(Complex x){
         Complex c = new Complex();
         c.a = (a * x.a + b * x.b)/(x.a * x.a + x.b * x.b);
         c.b = (b * x.a - a * x.b)/(x.a * x.a + x.b * x.b);
         return  c;
     }
     public String toString(){
         String x = String.format("%.1f",a);
         String y = String.format("%.1f",b);
         if(b>=0){
                return ("("+ x + "+" + y + "i"+")");
         }
         else
             return ("("+ x + y + "i"+")");
     }
     public void print(){
         String x = String.format("%.1f",a);
         String y = String.format("%.1f",b);
         String str = "";
         if(a == 0 && b!=0){
             System.out.println( y + "i");
         }
         else if(a!=0 && b==0){
             System.out.println(x );
         }
         else if(a==0 && b==0){
             System.out.println("0.0");
         }
         else if(b>0){
             System.out.println(x + "+" + y + "i");
         }
         else
             System.out.println(x + y + "i");

     }
 }
