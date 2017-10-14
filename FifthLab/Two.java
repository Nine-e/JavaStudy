package FifthLab;

/**
 * Created by del on 2017/10/14.
 */
import java.util.Scanner;
/*Series�ӿ��������������󷽷���
        int getNext();                   //�õ������е���һ������
        void reset();                     //�����е�ǰֵ����Ϊ��ʼֵ
        void setStart(int start);    //���������µ���ʼֵ*/
interface Series {
    abstract int getNext();
    abstract void reset();
    abstract void setStart(int start);
}
/*����һ����ΪByTwos���࣬ʵ��Series�ӿڡ�
        ByTwos������һ�����У�����ÿ�����ֶ���ǰһ�����ִ�2.
        ����������int���͵�˽��������start��
        ���������ʼֵ��Ĭ��ֵΪ0��value��������е�ǰֵ��Ĭ��ֵΪ0��*/
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