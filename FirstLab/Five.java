/**
 * Created by del on 2017/9/7.
 */

/*      【描述】
        "distance"和"disinfection"的共有前缀是"dis"。
        定义方法：publicstatic String prefix(String s1,  Strings2)，检查两个字符串是否有共有前缀，如果有，返回该共有前缀；否则返回null。
        编写一个main方法，输入两个字符串，调用prefix方法，显示共有前缀或"No common prefix"。
        【输入】
        有两行，分别对应两个字符串。
        【输出】
        若两个字符串有共有前缀，输出该共有前缀，否则输出"No common prefix"。*/

import java.util.Scanner;
public class Five {
    public static void main(String[] args){
        String s1,s2;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("input:");
        s1 = keyboard.nextLine();
        s2 = keyboard.nextLine();
        String theSame = prefix(s1,s2);
        System.out.println(theSame);
    }
    public static String prefix(String s1, String s2){
        int i = 0;
        String thePrefix="";
        while (s1.charAt(i) == s2.charAt(i)){
            thePrefix += s1.charAt(i);
            i++;
        }
        if (i == 0)
            thePrefix = "No common prefix";
        return thePrefix;
    }
}
    /*public static void main(String[] args) {
        System.out.println("Hello World!");
    }*/