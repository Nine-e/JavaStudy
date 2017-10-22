package FifthHomework;
import java.util.Scanner;
/**
 * Created by del on 2017/10/21.
 */
/*（1）Employee类包括私有数据域name（姓名，String类型）；
        有参构造方法，将name设置为给定的参数；
        访问器方法getName；还有抽象方法earnings。
        earning方法将在每个子类中实现，因为每个子类计算工资的方法不同。*/
abstract class Employee {
    private String name;
    public Employee(){};
    public Employee(String n){
        name = n;
    }

    public String getName() {
        return name;
    }
    abstract double earnings();
}
/*（2）Boss类有固定的周工资且不计工作时间。
        Boss类包括私有数据域weeklySalary（周工资，double类型）；
        有参构造方法，将name、weeklySalary设置为给定的参数；
        更改器方法setWeeklySalary；
        earnings方法；
        重写toString方法，返回Boss的字符串描述。*/
class Boss extends Employee {
    private double weeklySalary;
    public Boss (String n ,double s){
        super(n);
        weeklySalary = s;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public double earnings(){
        return weeklySalary;
    }

    @Override
    public String toString() {
        return ("Boss: " + getName());
    }
}
/*（3）CommissionWorker类有工资加上销售提成。
        CommissionWorker类包括私有数据域salary（工资，double类型）、
        commission（佣金，double类型）和quantity（销售数量，int类型）；
        有参构造方法，将name、salary、commission、quantity设置为给定的参数；
        更改器方法setSalary、setCommission和setQuantity；
        earnings方法；
        重写toString方法，返回CommissionWorker的字符串描述。*/
class CommissionWorker extends Employee{
    private double salary;
    private double commission;
    private int quantity;
    public CommissionWorker(String n,double s,double c, int q){
        super(n);
        salary = s;
        commission = c;
        quantity = q;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double earnings(){
        return salary + commission*quantity;
    }

    @Override
    public String toString() {
        return ("Commission Worker: " +  getName());
    }
}
/*（4）PieceWorker类的工资根据其生产的产品数量而定。
        PieceWorker类包括私有数据域wagePerPiece（每件产品工资，double类型）、
        quantity（生产数量，int类型）；
        有参构造方法，将name、wagePerPiece、quantity设置为给定的参数；
        更改器方法setWage、setQuantity；show；
        earnings方法；
        重写toString方法，返回PieceWorker的字符串描述。*/
class PieceWorker extends Employee {
    private double wagePerPiece;
    private int quantity;
    public PieceWorker(String n,double w, int q){
        super(n);
        wagePerPiece = w;
        quantity = q;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWagePerPiece(double wagePerPiece) {
        this.wagePerPiece = wagePerPiece;
    }
    public double earnings(){
        return wagePerPiece * quantity;
    }

    @Override
    public String toString() {
        return ("Piece Worker: " +  getName());
    }
}
/*（6）HourlyWorker类的工资根据小时计算并有加班工资。
        HourlyWorker类包括私有数据域wage（小时工资，double类型）、hours（工作时数，double类型）；
        有参构造方法，将name、wage、hours设置为给定的参数；
        更改器方法setWage、setHours；earnings方法；
        重写toString方法，返回HourlyWorker的字符串描述。*/
class HourlyWorker extends Employee {
    private double wage;
    private double hours;
    public HourlyWorker(String n,double w,double h){
        super(n);
        wage = w;
        hours = h;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
    public double earnings(){
        return wage * hours;
    }
    @Override
    public String toString() {
        return ("Hourly Worker: " +  getName());
    }
}
public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = in.next();
        double weeklySalary = in.nextDouble();
        Boss b = new Boss(name, weeklySalary);
        displayObject(b);

        name = in.next();
        double salary = in.nextDouble();
        double commission = in.nextDouble();
        int quantity = in.nextInt();
        CommissionWorker c = new CommissionWorker(name, salary, commission, quantity);
        displayObject(c);

        name = in.next();
        double wagePerPiece = in.nextDouble();
        quantity = in.nextInt();
        PieceWorker p = new PieceWorker(name, wagePerPiece, quantity);
        displayObject(p);

        name = in.next();
        double wage = in.nextDouble();
        double hours = in.nextDouble();
        HourlyWorker h = new HourlyWorker(name, wage, hours);
        displayObject(h);
        in.close();
    }
    public static void displayObject(Employee e) {
        System.out.println(e);
        System.out.println("Earned: $" + e.earnings());
    }
}