/**
 * Created by del on 2017/9/24.
 */
import java.util.Scanner;
public class TwoHomework_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5,6)).print();
        a.print();
        b.print();
        in.close();
    }
}
/*
这个类的构造函数是：
        // 构造一个a/b的分数
        Fraction(int a, int b);

        这个类要提供以下的功能：
        // 将分数转换为double
        double toDouble();

// 将自己的分数和r的分数相加，产生一个新的Fraction的对象
        Fraction plus(Fraction r);

// 将自己的分数和r的分数相乘，产生一个新的Fraction的对象
        Fraction multiply(Fraction r);

// 将自己以“分子/分母”的形式输出到标准输出，并带有回车换行
// 如果分数是1/1，应该输出1。当分子大于分母时，不需要提出整数部分，即31/30是一个正确的输出
        void print();

        在创建和做完运算后应该化简分数为最简形式。如2/4应该被化简为1/2。
*/
class Fraction{
    int a, b ;
    public Fraction(int a,int b){
        this.a = a;
        this.b = b;
    }
    public double toDouble(){
        return a*1.0/b;
    }

    public Fraction  plus(Fraction r){
        Fraction f = new Fraction(1,1);
        f.a =  a * r.b + r.a * b;
        f.b = b * r.b;
        return f;
    }
    public Fraction  multiply(Fraction r){
        Fraction f = new Fraction(1,1);
        f.a = r.a * a;
        f.b = r.b * b;
        return f;
    }
    public void print(){
        int c = 1;
        int min;
        if(a == b){
            c =a;
        }
        else {
            if (a>b){
                min = b;
            }
            else{
                min = a;
            }
            for(int i=1;i<=min;i++ ){
                if((a % i == 0 )&& (b%i == 0)){
                    c = i;
                }
            }
        }
        if((a/c)==1&&(b/c)==1){
            System.out.println("1");
        }
        else
            System.out.println(a/c+"/"+b/c);

    }
}
