package FourthHomework;

/**
 * Created by del on 2017/9/30.
 */
import FourthLab.Main;

/*import java.util.Scanner;
public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double side1 = in.nextDouble();
        double side2 = in.nextDouble();
        double side3 = in.nextDouble();
        Triangle triangle = new Triangle(side1, side2, side3);
        String color = in.next();
        triangle.setColor(color);
        boolean filled = in.nextBoolean();
        triangle.setFilled(filled);
        System.out.println(triangle);
        System.out.println("The area is " + triangle.getArea());
        System.out.println("The perimeter is " + triangle.getPerimeter());
        in.close();
    }
}*/
/*
GeometricObject类，用来建模所有的几何对象。GeometricObject类包括：

        String类型的私有数据域color，用于保存几何对象的颜色，默认值为white。
        boolean类型的私有数据域filled，用于表明几何对象是否填充颜色，默认值为false。
        有参构造方法，将颜色、是否填充颜色设置为给定的参数。
        访问器方法getColor、isFilled，分别用于访问颜色、是否填充颜色。
        更改器方法setColor、setFilled，分别用于更改颜色、是否填充颜色。
        重写成员方法toString，返回几何对象的字符串描述。*/
/*class GeometricObject{
    private String color = "white";
    private boolean filled = false;
    public GeometricObject(){}
    public GeometricObject(String c,boolean f){
        color = c;
        filled =f;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public String toString(){
        return ("Color:"+ color + "and filled:" + filled);

    }
}*/


    /*定义一个名为Triangle的类来扩展GeometricObject类。该类包括：

            三个名为side1、side2、side3的double类型私有数据域，表示三角形的三条边，它们的默认值均为1.0。
            无参构造方法，将三角形三条边设置为默认值
            有参构造方法，将三角形三条边设置为给定的参数。
            成员方法getArea，返回三角形的面积。
            成员方法getPerimeter，返回三角形的周长。
            重写toString方法，返回三角形的字符串描述。*/
   /* class Triangle extends GeometricObject {
        private double side1 ;
        private double side2 ;
        private double side3 ;
        public Triangle(){
            side1 = 1.0;
            side2 = 1.0;
            side3 = 1.0;
        }
        public Triangle (double s1,double s2,double s3){
            side1 = s1;
            side2 = s2;
            side3 = s3;
        }
        public double getArea(){
            double p = (side1 + side2 +side3)/2;
             return   Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));

        }
        public double getPerimeter(){
            return side1 + side2 + side3;
        }
        public String  toString(){
            return ("Triangle:\n"+
                    "side1 = "+ side1 + " side2 = " + side2 + " side3 = " + side3 + "\n" +
                    "Color: " + getColor() + " and filled: " + isFilled());
        }
        *//*Triangle:
        side1 = 3.0 side2 = 4.0 side3 = 5.0
        Color: red and filled: false*//*

    }*/
     /*public String toString(){
        String x = String.format("%.1f",a);
        String y = String.format("%.1f",b);
        if(b>=0){
            return ("("+ x + "+" + y + "i"+")");
        }
        else
            return ("("+ x + y + "i"+")");
    }*/
