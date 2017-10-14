/**
 * Created by del on 2017/9/14.
 */

/*第7题
        【描述】
        你的程序要读入一行文本，其中以空格分隔为若干个单词，以‘.’结束。你要输出这行文本中每个单词的长度。这里的单词与语言无关，可以包括各种符号，比如“it's”算一个单词，长度为4。注意，行中可能出现连续的空格。
        【输入】
        输入在一行中给出一行文本，以‘.’结束，结尾的句号不能计算在最后一个单词的长度内。
        【输出】
        在一行中输出这行文本对应的单词的长度，每个长度之间以空格隔开，行末没有最后的空格。*/

import java.util.Scanner;
import java.util.StringTokenizer;
public class Two_Serven {
    public static void main(String[] args) {
        String text,part;
        Scanner keyboard = new Scanner(System.in);
        text = keyboard.nextLine();

        StringTokenizer strTokenizer = new StringTokenizer(text);
        while(strTokenizer.hasMoreTokens()){
            part = strTokenizer.nextToken();
            if(part.endsWith(".")){
                System.out.print(part.length() - 1);
            }
            else{
                System.out.print(part.length() + " ");
            }

        }

    }
}