package FifthLab;

/**
 * Created by del on 2017/10/14.
 */
import java.util.Scanner;
/*Series接口有如下三个抽象方法：
        int getNext();                   //得到数列中的下一个数字
        void reset();                     //将数列当前值重置为起始值
        void setStart(int start);    //设置数列新的起始值*/
interface Series {
    abstract int getNext();
    abstract void reset();
    abstract void setStart(int start);
}
/*定义一个名为ByTwos的类，实现Series接口。
        ByTwos类生成一个数列，其中每个数字都比前一个数字大2.
        它含有两个int类型的私有数据域：start，
        存放数列起始值，默认值为0；value，存放数列当前值，默认值为0。*/
class ByTwos implements Series{
    private int start = 0;
    private int value = 0;

    @Override
    public int getNext() {
        value += 2;
        return value ;
    }

    @Override
    public void reset() {
        start = value;
    }

    @Override
    public void setStart(int start) {
        this.start = start;
        value = this.start;
    }
}
public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start = in.nextInt();
        int n = in.nextInt();
        ByTwos two = new ByTwos();
        two.setStart(start);
        for(int i = 0; i < n - 1; ++i)
            System.out.printf("%d ", two.getNext());
        System.out.printf("%d\n", two.getNext());
        in.close();
    }
}