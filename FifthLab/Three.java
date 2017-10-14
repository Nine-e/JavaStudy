package FifthLab;

/**
 * Created by del on 2017/10/14.
 */
import java.util.Scanner;
/*GeometricObject类包括：

        String类型的私有数据域color，用于保存几何对象的颜色，默认值为white。
        boolean类型的私有数据域filled，用于表明几何对象是否填充颜色，默认值为false。
        有参构造方法，将颜色、是否填充颜色设置为给定的参数。
        访问器方法getColor、isFilled，分别用于访问颜色、是否填充颜色。
        更改器方法setColor、setFilled，分别用于更改颜色、是否填充颜色。
        重写成员方法toString，返回几何对象的字符串描述。
        抽象方法getArea，返回几何对象的面积。
        抽象方法getPerimeter，返回几何对象的周长*/
abstract class GeometricObject{
    String color = "white";
    boolean filled = false;
    public GeometricObject(){
        color = "white";
        filled = false;
    }
    public GeometricObject(String c,boolean b){
        color = c;
        filled = b;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return ("Color:"+ color + " and filled:"+ filled);
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}
/*定义一个名为Circle的类来扩展GeometricObject类。该类包括：

        名为radius的double类型私有数据域，表示圆的半径，默认值为1.0。
        无参构造方法，将圆的半径设置为默认值
        有参构造方法，将圆的半径设置为给定的参数。
        实现抽象方法getArea，返回圆的面积。
        实现抽象方法getPerimeter，返回圆的周长。
        重写toString方法，返回圆的字符串描述。*/
class Circle extends GeometricObject{
    private double radius = 1.0;
    public Circle(){
        super();
        radius = 1.0;
    }
    public Circle(String c,boolean f,double r){
        super(c,f);
        radius = r;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public String toString() {
        return ("Circle:\n"+
                "radius = "+ radius + "\n" +
                "Color:"+ color + " and filled:"+ filled);
    }
}
/*定义一个名为Triangle的类来扩展GeometricObject类。该类包括：

        三个名为side1、side2、side3的double类型私有数据域，表示三角形的三条边，它们的默认值均为1.0。
        无参构造方法，将三角形三条边设置为默认值
        有参构造方法，将三角形三条边设置为给定的参数。
        实现抽象方法getArea，返回三角形的面积。
        实现抽象方法getPerimeter，返回三角形的周长。
        重写toString方法，返回三角形的字符串描述。*/
class Triangle extends GeometricObject{
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    public Triangle(){
        super();
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }
    public Triangle(String c,boolean f,double s1,double s2,double s3){
        super(c,f);
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    @Override
    public double getArea() {
        double p = (side1+side2+side3)/2;
        return Math.sqrt(p * (p - side1)*(p - side2)*(p-side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    @Override
    public String toString() {
        return ("Triangle:\n"+
                "side1 = "+ side1 + " side2 = "+ side2 +" side3 = "+ side3 +"\n" +
                "Color:"+ color + " and filled:"+ filled);
    }
}
public class Three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double radius = in.nextDouble();
        String color = in.next();
        boolean filled = in.nextBoolean();
        Circle circle = new Circle(color, filled, radius);
        displayObject(circle);
        double side1 = in.nextDouble();
        double side2 = in.nextDouble();
        double side3 = in.nextDouble();
        color = in.next();
        filled = in.nextBoolean();
        Triangle triangle = new Triangle(color, filled, side1, side2, side3);
        displayObject(triangle);
        in.close();
    }
    public static void displayObject(GeometricObject obj) {
        System.out.println(obj);
        System.out.printf("The area is %.2f\n", obj.getArea());
        System.out.printf("The perimeter is %.2f\n", obj.getPerimeter());
    }
}