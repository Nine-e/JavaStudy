package FifthHomework;

/**
 * Created by del on 2017/10/21.
 */
import java.util.Scanner;
/*GeometricObject�������

        String���͵�˽��������color�����ڱ��漸�ζ������ɫ��Ĭ��ֵΪwhite��
        boolean���͵�˽��������filled�����ڱ������ζ����Ƿ������ɫ��Ĭ��ֵΪfalse��
        �вι��췽��������ɫ���Ƿ������ɫ����Ϊ�����Ĳ�����
        ����������getColor��isFilled���ֱ����ڷ�����ɫ���Ƿ������ɫ��
        ����������setColor��setFilled���ֱ����ڸ�����ɫ���Ƿ������ɫ��
        ��д��Ա����toString�����ؼ��ζ�����ַ���������
        ���󷽷�getArea�����ؼ��ζ���������
        ���󷽷�getPerimeter�����ؼ��ζ�����ܳ�*/
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
/*����һ����ΪCircle��������չGeometricObject�ࡣ���������

        ��Ϊradius��double����˽�������򣬱�ʾԲ�İ뾶��Ĭ��ֵΪ1.0��
        �޲ι��췽������Բ�İ뾶����ΪĬ��ֵ
        �вι��췽������Բ�İ뾶����Ϊ�����Ĳ�����
        ʵ�ֳ��󷽷�getArea������Բ�������
        ʵ�ֳ��󷽷�getPerimeter������Բ���ܳ���
        ��дtoString����������Բ���ַ���������*/
class Circle extends GeometricObject  implements Comparable<Circle> {
    private double radius = 1.0;
    public Circle(){
        super();
        radius = 1.0;
    }
    public Circle(String c,boolean f,double r){
        super(c,f);
        radius = r;
    }

    public double getRadius() {
        return radius;
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

    @Override
    public boolean equals(Object obj) {
       if (obj instanceof Circle)
           return ((Circle) obj).getRadius()==radius;
       else
           return false;
    }
    public int compareTo(Circle c) {
        if (c.getRadius() == radius)
            return 0;
        else if(c.getRadius() < radius)
            return 1;
        else
            return -1;
    }
}


public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double radius = in.nextDouble();
        String color = in.next();
        boolean filled = in.nextBoolean();
        Circle circle1 = new Circle(color, filled, radius);
        radius = in.nextDouble();
        color = in.next();
        filled = in.nextBoolean();
        Circle circle2 = new Circle(color, filled, radius);
        System.out.println(circle1.equals(circle2));
        System.out.println(circle1.compareTo(circle2));
        in.close();
    }
}