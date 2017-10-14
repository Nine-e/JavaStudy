package FourthLab;

/**
 * Created by del on 2017/9/28.
 */
import java.util.Scanner;
public class FourthLab_two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double y = in.nextDouble();
        double width = in.nextDouble();
        double height = in.nextDouble();
        Rectangle2D r1 = new Rectangle2D(x, y, width, height);
        x = in.nextDouble();
        y = in.nextDouble();
        width = in.nextDouble();
        height = in.nextDouble();
        Rectangle2D r2 = new Rectangle2D(x, y, width, height);
        System.out.printf("%.2f %.2f\n", r1.getArea(), r1.getPerimeter());
        System.out.printf("%.2f %.2f\n", r2.getArea(), r2.getPerimeter());
        System.out.println(r1.contains(x, y));
        System.out.println(r1.contains(r2));
        System.out.println(r1.overlaps(r2));
        in.close();
    }
}
/*
【描述】
        设计一个Rectangle2D类，表示矩形（假设矩形的边与x轴和y轴平行）。Rectangle2D类包括：

        double类型的私有数据域x、y，表示矩形的中心点。
        double类型的私有数据域width和height，表示矩形宽度和高度。
        无参构造方法，将中心点设置为原点，宽度和高度设置为1。
        有参构造方法，将中心点和宽度、高度设置为给定的参数。
        x、y和width、height的访问器和更改器方法。
        成员方法getArea，返回矩形面积。
        成员方法getPerimeter，返回矩形周长。
        成员方法contains，判断给定的点是否在这个矩形内，如果在，返回true，否则返回false。
        成员方法contains，判断给定的矩形是否在这个矩形内，如果在，返回true，否则返回false。
        成员方法overlaps，判断给定的矩形是否和这个矩形相交，如果相交，返回true，否则返回false。*/

class Rectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle2D() {
        x = 0;
        y = 0;
        width = 1;
        height = 1;
    }

    public Rectangle2D(double a, double b, double c, double d) {
        x = a;
        y = b;
        width = c;
        height = d;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setX(double a) {
        x = a;
    }

    public void setY(double a) {
        y = a;
    }

    public void setWidth(double a) {
        width = a;
    }

    public void setHeight(double a) {
        height = a;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double a, double b) {
        return (Math.abs(a - x) <= width / 2) && (Math.abs(b - y) <= height / 2);
    }

    public boolean contains(Rectangle2D r) {
        return ((r.x + r.width / 2) <= x + width / 2) && ((r.x - r.width / 2) >= x - width / 2)
                && ((r.y + r.height / 2) <= y + height / 2) && ((r.y - r.height / 2) >= y - height / 2);
    }
    public boolean  overlaps(Rectangle2D r){ /*相交即 既不相离也不包含*/
        return !(
                        ((r.x - r.width / 2) >= x + width / 2)|| ((r.x + r.width / 2) <= x - width / 2)
                ||((r.y + r.height / 2) <= y - height / 2) || ((r.y - r.height / 2) >= y + height / 2)
                )&&(contains(r)==false);
    }

}