package FifthLab;

/**
 * Created by del on 2017/10/14.
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
/*����һ����ΪTriangle��������չGeometricObject�ࡣ���������

        ������Ϊside1��side2��side3��double����˽�������򣬱�ʾ�����ε������ߣ����ǵ�Ĭ��ֵ��Ϊ1.0��
        �޲ι��췽����������������������ΪĬ��ֵ
        �вι��췽����������������������Ϊ�����Ĳ�����
        ʵ�ֳ��󷽷�getArea�����������ε������
        ʵ�ֳ��󷽷�getPerimeter�����������ε��ܳ���
        ��дtoString���������������ε��ַ���������*/
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