package SixthLab;

/**
 * Created by del on 2017/11/2.
 */
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class Three {
    public static void main (String[] args)throws Exception{
        Scanner in = new Scanner(System.in);
        // 创建PrintWriter对象
        FileWriter fw = new FileWriter("example.txt");
        PrintWriter outputFile = new PrintWriter(fw);
        int[] a = new int[10];
        for (int i = 0;i< 10;i++){
            a[i] = in.nextInt();
        }
        for (int i = 0;i<10;i++){
            if((i+1)%5 == 0){
                outputFile.println(a[i]);
            }else{
                outputFile.print(a[i] + " ");
            }
        }
        outputFile.close();

    }
}
