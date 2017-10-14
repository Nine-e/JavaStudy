/**
 * Created by del on 2017/9/15.
 */

/*【描述】
        编写程序，输入一个浮点数和输出格式要求，按照格式要求将该浮点数输出。给定非负整数m和n，表示输出的浮点数小数点前的宽度为m，若宽度不够则在前面补0，小数点后的宽度为n，若宽度不够则在后面补0。当n=0时，只需输出整数部分，当m、n都为0时，则输出0。
        【输入】
        每个测试用例共2行，第一行为两个整数m,n(n≥0,m≥0)，第二行为一个浮点数。
        【输出】
        对每个测试用例输出的浮点数占一行，其小数点前宽度为m，小数点后宽度为n，不足时补零。*/

import java.util.Scanner;
public class HomeworkOne_Two {
    public static void main(String[] args) {
        int m, n;
        int intLength = 0, doubleLength = 0;
        String str;
        Scanner keyboard = new Scanner(System.in);
        m = keyboard.nextInt();
        n = keyboard.nextInt();
        str = keyboard.next();
        String[] split = str.split("\\.");
        /*for (int i=0 ; i<split.length;i++)
        System.out.println(split[i]);*/

        intLength = split[0].length();
        doubleLength = split[1].length();
        /*System.out.println(intLength);
        System.out.println(doubleLength);*/
        if (m == 0 || n==0){
            System.out.println("0");
        }
        else if( m >= intLength ){
           for(int i=0 ; i<m-intLength;i++)
               System.out.print("0");
           if (n <= doubleLength) {
               String subStr = str.substring(0, intLength + n + 1);
               System.out.print(subStr);
           }
           else {
               String subStr = str.substring(0, intLength + doubleLength + 1);
               System.out.print(subStr);
               for(int i=0;i<n-doubleLength;i++){
                   System.out.print("0");
               }
           }
        }
        else{
            System.out.print("error input!");
        }


    }
}