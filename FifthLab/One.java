package FifthLab;

/**
 * Created by del on 2017/10/14.
 */
import java.util.Scanner;
class A{
    int k;
    public A (int k){
        this.k = k;
    }
    public void print(){
        System.out.println("A "+ k);
    }
}
class B extends A{
    public B(int k){
        super(k);
    }
    public void print(){
        System.out.println("B "+ k);
    }
}
public class One {
    private static A a[] = new A[100];
    public static void printInfo(Object obj) {
        if(obj instanceof A)
            ((A)obj).print();
        else if(obj instanceof B)
            ((B)obj).print();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            for(int i = 0; i < n; ++i) {
                char c = in.next().charAt(0);
                int k = in.nextInt();
                if(c == 'A')
                    a[i] = new A(k);
                else
                    a[i] = new B(k);
            }
            System.out.println(n);
            for(int i = 0; i < n; ++i)
                printInfo(a[i]);
            System.out.println("****");
        }
        in.close();
    }
}