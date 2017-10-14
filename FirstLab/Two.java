/**
 * Created by del on 2017/9/7.
 */
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        int pos = 0 ;
        int neg = 0 ;
        int sum = 0 ;
        double count = 0 ;
        int num ;
        double avg ;
        Scanner keyboard = new Scanner(System.in);
        //输入若干个整数，如果输入0，输入即终止
        //System.out.println("please input num:");
        num = keyboard.nextInt();
        if ( num == 0 ) {
            System.out.println("No input");
        }
        //判定读入的整数中有多少个正整数、多少个负整数，
        // 并计算这些整数的总和和平均值（0不计算在内）。平均值结果保留2位小数。
        else {
            while ( num != 0 ){
                if ( num > 0 )
                    pos++;
                else
                    neg++;
                sum = sum + num ;
                count++;
                num = keyboard.nextInt();
            }
            avg = sum / (double)count ;
            String result = String.format("%.2f",avg);
            System.out.println(pos);
            System.out.println(neg);
            System.out.println(sum);
            System.out.println(result);
        }
    }
}
