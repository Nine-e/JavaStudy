package SixHomework;

/**
 * Created by del on 2017/11/4.
 */
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Two {
    public static void main(String[] args)throws Exception{
        File file = new File("hours.txt");
        FileReader inFile = new FileReader(file);
        int ch = inFile.read();
        //初始化数组，保存工作时间
        int[][] a = new int[20][7];
        for(int i=0;i<20;i++){
            for(int j=0;j<7;j++){
                a[i][j]=0;
            }
        }
        //读取文件，将时间信息导入数组
        int x=0;
        int y=0;
        while (ch!=-1){
            //System.out.println();
           if(ch!=32 && ch!=13 && ch!=10){
               a[x][y]=ch-48;
               y++;
           }
           else if(ch == 13){
               x++;
               y=0;
           }
            ch = inFile.read();
        }
        inFile.close();
        /*for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }*/
        int sum1 = 0;
        int[] sum2 = new int[7];
        Arrays.fill(sum2,0);
        int sum3 = 0;
        for(int i=0;i<x+1;i++) {
            for (int j = 0; j < 7; j++) {
                sum1 += a[i][j];
                sum2[j]+= a[i][j];
            }
            System.out.println("Total hours = " + sum1);
            sum3 += sum1;
            sum1 = 0;
        }
        System.out.println();
        System.out.println("Mon hours = " + sum2[0]);
        System.out.println("Tue hours = " + sum2[1]);
        System.out.println("Wed hours = " + sum2[2]);
        System.out.println("Thu hours = " + sum2[3]);
        System.out.println("Fri hours = " + sum2[4]);
        System.out.println("Sat hours = " + sum2[5]);
        System.out.println("Sun hours = " + sum2[6]);
        System.out.println("Total hours = " + sum3);


    }
}
