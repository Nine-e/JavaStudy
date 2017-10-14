/**
 * Created by del on 2017/9/21.
 */
import java.util.Scanner;
public class Three_Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int hour = Integer.parseInt(line.split(":")[0]);
        int minute = Integer.parseInt(line.split(":")[1]);
        int second = Integer.parseInt(line.split(":")[2]);
        Time t1 = new Time(hour, minute, second);
        t1.printTime24();
        t1.printTime12();
        t1.tick();
        t1.printTime24();
        t1.printTime12();
        Time t2 = new Time();
        t2.printTime24();
        t2.printTime12();
        in.close();
    }
}
/*
【描述】
        设计一个Time类，表示时间。Time类包括：
        int类型的私有数据域hour、minute、second，表示时、分、秒，默认值都为0。
        无参构造方法。
        有参构造方法，将时、分、秒设置为给定的参数。
        hour、minute、second的更改器和访问器方法。
        成员方法setTime，用于同时更改时、分、秒。
        成员方法printTime24，以24小时制格式输出时间，格式为时:分:秒。
        成员方法printTime12，以12小时制格式输出时间，格式为时:分:秒 AM或时:分:秒 PM。
        成员方法tick，将时间递增1秒。要考虑增加1秒后，时间增加到下一分钟、下一小时、下一天的情况。

        注意，Time类的定义应该这样开始：
class Time {
    也就是说，Time类的class前面不要有public。
            【输入】
    一行中给出时、分、秒的值，其间以“:”分隔。*/
class Time{
    private int hour = 0;
    private int minute = 0;
    private int second = 0;
    public Time (){}
    public Time (int hour,int minute,int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public void setHour (int hour){
        this.hour = hour;
    }
    public void setMinute (int minute){
        this.minute = minute;
    }
    public void setSecond ( int second){
        this.second = second;
    }
    public int getHour (){
        return hour;
    }
    public int getMinute(){
        return minute;
    }
    public int getSecond(){
        return second;
    }
    public void setTime(int hour,int minute,int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public void printTime24(){
        if(hour < 10)
            System.out.print("0");
        System.out.print(hour + ":");
        if(minute < 10)
            System.out.print("0");
        System.out.print(minute + ":");
        if(second < 10)
            System.out.print("0");
        System.out.println(second);
    }
    public void printTime12(){

        int printHour = hour;
        String s;
        if(printHour < 12)
            s = " AM";
        else {
            s = " PM";
            printHour = printHour % 12;
        }
        if(printHour < 10)
            System.out.print("0");
        System.out.print(printHour + ":");
        if(minute < 10)
            System.out.print("0");
        System.out.print(minute + ":");
        if(second < 10)
            System.out.print("0");
        System.out.println(second + s);

    }
    public void tick(){
        second++;
        if (second >= 60){
            minute++;
            second = second % 60 ;
        }
        if (minute >= 60){
            hour++;
            minute = minute % 60;
        }
        if (hour >= 24){
            hour = hour % 24;
        }

    }

}

/*13:59:59
        01:59:59 PM
        14:00:00
        02:00:00 PM
        00:00:00
        00:00:00 AM*/






