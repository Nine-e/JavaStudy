/**
 * Created by del on 2017/9/23.
 */

/*import java.util.Scanner;
public class Three_Three{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        System.out.printf("%.2f\n", p1.distance(p2));
        System.out.printf("%.2f\n", Point.distance(p1, p2));
        in.close();
    }
}*/
/*
【描述】
        设计一个Point类，表示直角坐标系中的一个点。Point类包括：

        double类型的私有数据域x和y，表示坐标。
        无参构造方法，将坐标设置为原点。
        有参构造方法，将坐标设置为给定的参数。
        访问器方法getX和getY，分别用于访问点的x坐标和y坐标。
        一个名为distance的方法，返回Point类型的两个点之间的距离。
        一个名为distance的静态方法，返回指定Point类型的两个点之间的距离。
*/
/*class Point{
    double x , y ;
    public Point (){
        x = 0 ;
        y = 0 ;
    }
    public Point (double x,double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double distance(Point p){
        return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
    }
    public static double distance(Point p1,Point p2){
        return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x)+(p1.y - p2.y)*(p1.y - p2.y));
    }
}*/
