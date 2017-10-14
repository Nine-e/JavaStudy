package FourthLab;

/**
 * Created by del on 2017/9/29.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        double[][] a = new double[m][n];
        for(int i = 0; i < m; ++i)
            for(int j = 0; j < n; ++j)
                a[i][j] = in.nextDouble();
        Location loc = locateLargest(a);
        System.out.println(loc.maxValue + " " + loc.row + " " + loc.column);
        in.close();
    }
    public Main(){
        Location l = new Location();
    }
    class Location{
        public int row;
        public int column;
        public double maxValue;
        public Location(int r,int c,double m){
            row = r;
            column = c;
            maxValue = m;
        }
        public Location(){
            row = 0;
            column = 0;
            maxValue = 0;
        }
    }
    public static Location locateLargest(double[][] a){
        Main m = new Main();
        Main.Location l = m.new Location();
        int maxi = 0;
        int maxj = 0;
        double max = a[0][0];
        for (int i =0 ;i<a.length;i++){
            for (int j =0 ;j<a[0].length;j++){
                if(a[i][j]>max){
                    max = a[i][j];
                    maxi = i;
                    maxj = j;
                }
            }
        }
        l.row = maxi;
        l.column = maxj;
        l.maxValue = max;
        return l;

    }
}
/*
设计一个名为Location的内部类，定位二维数组中的最大值及其位置。这个类包括公共数据域row、column和maxValue，二维数组中的最大值及其下标用double类型的maxValue以及int类型的row、column存储。
        定义静态方法：public static Location locateLargest(double[][] a)，返回一个Location对象。
        编写一个main方法，输入二维数组行列大小及其值，调用locationLargest方法，显示这个数组中的最大值及其下标。*/
