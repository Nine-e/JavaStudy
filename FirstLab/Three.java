/**
 * Created by del on 2017/9/7.
 */
/*【描述】
   给定一个字符串a和字符串b，1≤a的长度≤100, 1≤b的长度≤a的长度。求b在a中的出现次数。
  【输入】
   有两行。
   第一行给出字符串a。
   第二行给出字符串b。
   【输出】
    一个整数，表示b在a中的出现次数。*/
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        String a,b;
        int position ,count = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("input strings");
        a = keyboard.nextLine();
        b = keyboard.nextLine();

        // 找到b在第一次出现在a中的位置
        position = a.indexOf(b);

        while(position!=-1){
            count++;
            // 继续往下找
            position = a.indexOf(b, position+1);
        }
        System.out.println(count);
    }}
