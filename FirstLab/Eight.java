/**
 * Created by del on 2017/9/8.
 */
/*
        【输入】
        一行中给出一个整数，表示BJT的时和分。整数的个位和十位表示分，百位和千位表示小时。
        如果小时小于10，则没有千位部分；如果小时是0，则没有百位部分；如果分小于10分，需要保留十位上的0。
        【输出】
        一行中输出一个整数，表示UTC的时和分。整数的个位和十位表示分，百位和千位表示小时。
        如果小时小于10，则没有千位部分；如果小时是0，则没有百位部分；如果分小于10分，需要保留十位上的0。
*/
import java.util.Scanner;
public class Eight {
    public static void main(String[] args){
        int bjt,utc;
        int bjtHour,bjtMinute;
        int utcHour,utcMinute;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("input:");
        bjt = keyboard.nextInt();
        bjtHour = bjt/100;
        bjtMinute = bjt%100;
        utcMinute = bjtMinute;
        if (bjtHour < 8){
            utcHour = 24 + bjtHour - 8 ;
        }
        else {
            utcHour = bjtHour - 8 ;
        }
        utc = utcHour * 100 + utcMinute ;
        System.out.println(utc);
    }
}
