package FifthHomework;
import java.util.Scanner;
/**
 * Created by del on 2017/10/21.
 */
/*��1��Employee�����˽��������name��������String���ͣ���
        �вι��췽������name����Ϊ�����Ĳ�����
        ����������getName�����г��󷽷�earnings��
        earning��������ÿ��������ʵ�֣���Ϊÿ��������㹤�ʵķ�����ͬ��*/
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
/*��2��Boss���й̶����ܹ����Ҳ��ƹ���ʱ�䡣
        Boss�����˽��������weeklySalary���ܹ��ʣ�double���ͣ���
        �вι��췽������name��weeklySalary����Ϊ�����Ĳ�����
        ����������setWeeklySalary��
        earnings������
        ��дtoString����������Boss���ַ���������*/
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
/*��3��CommissionWorker���й��ʼ���������ɡ�
        CommissionWorker�����˽��������salary�����ʣ�double���ͣ���
        commission��Ӷ��double���ͣ���quantity������������int���ͣ���
        �вι��췽������name��salary��commission��quantity����Ϊ�����Ĳ�����
        ����������setSalary��setCommission��setQuantity��
        earnings������
        ��дtoString����������CommissionWorker���ַ���������*/
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
/*��4��PieceWorker��Ĺ��ʸ����������Ĳ�Ʒ����������
        PieceWorker�����˽��������wagePerPiece��ÿ����Ʒ���ʣ�double���ͣ���
        quantity������������int���ͣ���
        �вι��췽������name��wagePerPiece��quantity����Ϊ�����Ĳ�����
        ����������setWage��setQuantity��show��
        earnings������
        ��дtoString����������PieceWorker���ַ���������*/
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
/*��6��HourlyWorker��Ĺ��ʸ���Сʱ���㲢�мӰ๤�ʡ�
        HourlyWorker�����˽��������wage��Сʱ���ʣ�double���ͣ���hours������ʱ����double���ͣ���
        �вι��췽������name��wage��hours����Ϊ�����Ĳ�����
        ����������setWage��setHours��earnings������
        ��дtoString����������HourlyWorker���ַ���������*/
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