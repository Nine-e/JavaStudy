/**
 * Created by del on 2017/9/14.
 */

/*
第1题
        【描述】
        输入一个字符串，统计并输出该字符串中26个英文字母（不区分大小写）出现的次数。
        【输入】
        输入一个字符串。
        【输出】
        分行输出26个英文字母（不区分大小写）出现的次数。
*/
import java.util.Scanner;
public class Two_One {
    public static void main(String[] args) {
        String S , s;
        int num;
        int[] count = new int[26];
        Scanner keyboard = new Scanner(System.in);
        S = keyboard.nextLine();
        s = S.toLowerCase();
        for(int i = 0 ;i<s.length();i++){
            if(s.charAt(i)> 96 && s.charAt(i)<123){
                num = (int)s.charAt(i) - 97 ;
                count[num]++;
            }
        }
        for(int i = 0 ;i < 26 ; i++){
            if(count[i] != 0 ){
                System.out.println((char)(i+97) + ":" + count[i] );
            }
        }

    }

}
