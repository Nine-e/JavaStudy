/**
 * Created by del on 2017/9/24.
 */

import java.util.Scanner;
public class TwoHomework_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double y = in.nextDouble();
        double radius = in.nextDouble();
        Circle2D c1 = new Circle2D(x, y, radius);
        x = in.nextDouble();
        y = in.nextDouble();
        radius = in.nextDouble();
        Circle2D c2 = new Circle2D(x, y, radius);
        System.out.printf("%.2f %.2f\n", c1.getArea(), c1.getPerimeter());
        System.out.printf("%.2f %.2f\n", c2.getArea(), c2.getPerimeter());
        System.out.println(c1.contains(x, y));
        System.out.println(c1.contains(c2));
        System.out.println(c1.overlaps(c2));
        in.close();
    }
}
/*【描述】
        设计一个Circle2D类，表示圆。Circle2D类包括：

        double类型的私有数据域x、y，表示圆心。
        double类型的私有数据域radius，表示半径。
        无参构造方法，将圆心设置为原点，半径设置为1。
        有参构造方法，将圆心和半径设置为给定的参数。
        x、y和radius的访问器方法。
        成员方法getArea，返回圆面积。
        成员方法getPerimeter，返回圆周长。
        成员方法contains，判断给定的点是否在这个圆内，如果在，返回true，否则返回false。
        成员方法contains，判断给定的圆是否在这个圆内，如果在，返回true，否则返回false。
        成员方法overlaps，判断给定的圆是否和这个圆相交，如果相交，返回true，否则返回false。*/
class Circle2D{
    private double x;
    private double y;
    private double radius;
    public Circle2D (){
        x = 0;
        y = 0;
        radius = 1;
    }
    public Circle2D (double x, double y,double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    public boolean contains(double X,double Y){
        return (X-x)*(X-x)+(Y-y)*(Y-y)<= radius*radius;
    }
    public boolean contains(Circle2D c){
        return Math.sqrt((c.x - x)*(c.x - x)+(c.y-y)*(c.y-y)) + c.radius<= radius;
    }
    public boolean overlaps(Circle2D c){
        return (radius < Math.sqrt((c.x - x)*(c.x - x)+(c.y-y)*(c.y-y))+c.radius)&&
                (Math.sqrt((c.x - x)*(c.x - x)+(c.y-y)*(c.y-y))< radius+c.radius);
    }
}
