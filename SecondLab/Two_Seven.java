/**
 * Created by del on 2017/9/14.
 */

/*第7题
        【描述】
        输入一个4×4的整数矩阵，求该矩阵的外围元素之和，主对角线元素之和以及副对角线元素之和。
        【输入】
        输入一个4×4的整数矩阵。
        分4行，每行4个整数，整数之间以空格间隔。
        【输出】
        分行输出矩阵的外围元素之和，主对角线元素之和以及副对角线元素之和。
        【提示】
        求三类元素的和，可以定义三个不同的和变量，在遍历数组元素的循环中通过三次条件判断分别进行三类元素的求和。设行下标为i ，列下标为j，考察三类元素的下标特征，外围元素要么行下标i==0或者i==n-1（这里n为4），要么列下标j==0或者j==n-1；主对角线上的元素行下标和列下标相等（i==j）；副对角线上的元素行下标和列下标之和等于n-1（i+j==n-1）。
        需使用 Main 作为主类名。*/

import java.util.Scanner;
public class Two_Seven {
    public static void main (String[] args){
        int[][] scores = new int[4][4];
        int sumOne = 0 ,sumTwo = 0 , sumThree = 0 ;
        Scanner keyboard = new Scanner(System.in);
        for(int i=0 ; i<4;i++){
            for(int j = 0 ; j<4;j++){
                scores[i][j] = keyboard.nextInt();
                if(i == 0 || i==3 || j==0 || j==3){
                    sumOne += scores[i][j];
                }
                if (i == j){
                    sumTwo += scores[i][j];
                }
                if( i+j==3 ){
                    sumThree += scores[i][j];
                }
            }
        }
        System.out.println(sumOne);
        System.out.println(sumTwo);
        System.out.println(sumThree);
    }

}
