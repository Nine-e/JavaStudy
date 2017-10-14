/**
 * Created by del on 2017/9/24.
 */

import java.util.Scanner;
public class Three_Four {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Line line = new Line(p1, p2);
        System.out.printf("%.2f\n", line.slope());
        in.close();
    }
}

class Point{
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
    /*public double distance(Point p){
        return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
    }
    public static double distance(Point p1,Point p2){
        return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x)+(p1.y - p2.y)*(p1.y - p2.y));
    }*/
}
/*
【描述】
        设计一个Line类，表示线段。Line类包括：

        Point类的私有对象数据域start和end，表示线段的两个端点。
        有参构造方法，将线段端点设置为给定的参数。
        成员方法slope，计算线段的斜率。*/

class Line{
    private Point start;
    private Point end;

    public Line (Point p1,Point p2){
        start = p1;
        end = p2;
    }
    public double slope(){
        return (end.y - start.y)/(end.x - start.x);
    }
}