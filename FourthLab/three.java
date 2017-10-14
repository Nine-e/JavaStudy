package FourthLab;

/**
 * Created by del on 2017/9/29.
 */
import java.util.Scanner;
public class three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int passengers = in.nextInt();
        int fuelcap = in.nextInt();
        int mpg = in.nextInt();
        int cargocap = in.nextInt();
        Truck t = new Truck(passengers, fuelcap, mpg, cargocap);
        int dist = in.nextInt();
        double gallons = t.fuelneeded(dist);
        System.out.println("Truck can carry " + t.getCargo() + " pounds.");
        System.out.println("To go " + dist + " miles truck needs " + gallons + " gallons of fuel.");
        in.close();
    }
}

/*
（1）声明并实现一个名为Vehicle的类，表示汽车。Vehicle类包括：

        int类型的私有数据域passengers，表示载客数量。
        int类型的私有数据域fuelcap，表示油箱容量（单位：加仑）。
        int类型的私有数据域mpg，表示油耗均值（每加仑燃油可以跑多少英里，miles per gallon）。
        有参构造方法，将载客数量、油箱容量、油耗均值设置为给定的参数。
        访问器方法getPassengers、getFuelCap、getMPG，分别用于访问载客数量、油箱容量、油耗均值。
        更改器方法setPassengers、setFuelCap、setMPG，分别用于更改载客数量、油箱容量、油耗均值。
        成员方法range，显示汽车行驶的英里数。
        成员方法fuelneeded，根据汽车要行驶的英里数，返回所需汽油的加仑数。
        （2）卡车是汽车的一种，卡车的一个重要属性就是它的运载能力。从Vehicle类派生出Truck类，表示卡车。Truck类新增int类型的私有数据域cargocap（单位：磅）以及有参构造方法，将载客数量、油箱容量、油耗均值、运载能力设置为给定的参数；访问器/更改器方法getCargo和setCargo。
*/
class Vehicle{
    private int passengers;
    private int fuelcap;
    private int mpg;
    public Vehicle(){
        passengers =0 ;
        fuelcap = 0;
        mpg = 0;
    }
    public Vehicle(int p,int f,int m){
        passengers = p;
        fuelcap = f;
        mpg = m;
    }
    public int  getPassengers(){
        return passengers;
    }
    public int getFuelcap(){
        return fuelcap;
    }
    public int getMpg(){
        return mpg;
    }
    public void setPassengers(int p){
        passengers = p;
    }
    public void setFuelcap(int f){
        fuelcap = f;
    }
    public void setMpg(int m){
        mpg = m;
    }
    public double range(){
        return fuelcap*1.0/mpg;
    }
    public double fuelneeded(int dist){
        return dist * 1.0 / mpg ;
    }
}
class Truck extends Vehicle{
    private int cargocap;
    public Truck(int p,int f,int m,int c){
        setPassengers(p);
        setFuelcap(f);
        setMpg(m);
        cargocap = c;
    }
    public int getCargo(){
        return cargocap;
    }
    public void setCargo(int c){
        cargocap = c;
    }
}
