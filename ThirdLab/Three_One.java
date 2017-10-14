/**
 * Created by del on 2017/9/21.
 */

import java.util.Scanner;
public class Three_One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String name = line.split(",")[0];
        int age = Integer.parseInt(line.split(",")[1]);
        String id = line.split(",")[2];
        int a1 = Integer.parseInt(line.split(",")[3]);
        int a2 = Integer.parseInt(line.split(",")[4]);
        int a3 = Integer.parseInt(line.split(",")[5]);
        int a4 = Integer.parseInt(line.split(",")[6]);
        Student student = new Student(name, age, id, a1, a2, a3, a4);
        System.out.println(student.getName() + "," + student.getAge() + "," + student.getID()+ "," + student.getAverage());
        in.close();
    }
}
/*【输入】
        姓名，年龄，学号，第一学年平均成绩，第二学年平均成绩，第三学年平均成绩，第四学年平均成绩。
        其中姓名、学号为字符串，不含空格和逗号；年龄为正整数；成绩为非负整数。
        各部分内容之间均用单个英文逗号“,”隔开，无多余空格。
        【输出】
        一行，按顺序输出：姓名，年龄，学号，四年平均成绩（向下取整）。
        各部分内容之间均用单个英文逗号“,”隔开，无多余空格。*/
class Student{
    String name;
    int age;
    String id;
    int a1,a2,a3,a4;
    public Student (String name,int age,String id,int a1,int a2,int a3,int a4){
        this.name = name;
        this.age = age;
        this.id = id;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
    }
    public String getName (){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getID(){
        return id;
    }
    public int getAverage(){
        return (int)(a1+a2+a3+a4)/4;
    }

}