/**
 * Created by del on 2017/9/14.
 */

/*【描述】
        输入一个字符串和一个非负整数N，要求将字符串循环右移N次。
        【输入】
        第一行中给出一个字符串，以'#'表示结束，'#'不是字符串的一部分，字符串的长度未知，但至少有一个字符。
        第二行中给出非负整数N。
        【输出】
        在一行中输出循环右移N次后的字符串。*/

import java.util.Scanner;

public class Tow_Four {
    public static void main(String[] args) {
        String s1,s2 = "",s3 = "";
        int s1_length , s2_length;
        int N , n;
        Scanner keyboard = new Scanner(System.in);
        /*System.out.println("input the string:");*/
        s1 = keyboard.nextLine();
        /*System.out.println("input the N:");*/
        N = keyboard.nextInt();

        s1_length = s1.length();
        s2_length = s1_length - 1;
        n = N % s2_length ;

        s2 = s1.substring(0,s2_length);

        for (int i= 0 ; i < s2_length ; i++){
            if ( i < n ) {
                s3 += s2.charAt(s2_length - n + i);
            }
            else {
                s3 += s2.charAt( i - n );
            }
        }
        System.out.println(s3);

    }
}
