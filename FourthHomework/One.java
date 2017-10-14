package FourthHomework;

/**
 * Created by del on 2017/9/30.
 */
import java.util.Scanner;
class Stock{
    private String symbol;
    private int totalShares;
    private double totalCost;
    public Stock(){}
    public Stock(String s){
        symbol = s;
        totalShares = 0;
        totalCost = 0;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getTotalShares() {
        return totalShares;
    }

    public double getTotalCost() {
        return totalCost;
    }
    public void purchase(int a,double b){
        totalShares += a;
        totalCost += a * b;
    }
    public double getProfit(double nowPrice){
        return totalShares * nowPrice - totalCost;
    }
}
class dividendStock extends Stock {
    private double dividends;
    public dividendStock( String s){
        super(s);
        dividends = 0;
    }
    public void payDividend(double count ){
        dividends = count * getTotalShares();
    }

    @Override
    public double getProfit(double nowPrice) {
        return super.getProfit(nowPrice) + dividends;
    }
}
public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String symbol = in.next();
        dividendStock currentStock = new dividendStock(symbol);
        int numPurchases = in.nextInt();
        for(int i = 1; i <= numPurchases; ++i) {
            int numShares = in.nextInt();
            double pricePerShare = in.nextDouble();
            currentStock.purchase(numShares, pricePerShare);
        }
        double currentPrice = in.nextDouble();
        double amountPerShare = in.nextDouble();
        currentStock.payDividend(amountPerShare);
        double profit = currentStock.getProfit(currentPrice);
        System.out.println("Net profit/loss: " + profit);
        in.close();
    }
}
/*
定义一个表示股票信息的类Stock，可以保存股票代码、保存投资者股票交易的累计信息、记录单笔交易信息、计算股票的盈亏状况。Stock类包括：

        String类型的私有数据域symbol，用于保存股票代码。
        int类型的私有数据域totalShares，用于保存股票的总股数。
        double类型的私有数据域totalCost，用于保存股票的总成本。
        有参构造方法，将股票代码设置为给定的参数，股票的总股数、股票的总成本设置为0。
        访问器方法getSymbol、getTotalShares、getTotalCost，分别用于访问股票代码、股票的总股数、股票的总成本。
        成员方法purchase，记录单笔交易信息（总股数、总成本），有两个参数：表示股数的int类型变量和表示股票单价的double类型变量，无返回值。
        成员方法getProfit，计算股票的盈亏状况（总股数乘以股票当前价格，然后减去总成本），有一个参数：表示股票当前价格的double类型变量，返回盈亏金额。
*/

/*
增加double类型私有数据域dividends，用于记录分红。
        有参构造方法，将股票代码设置为给定的参数，分红设置为0。
        成员方法payDividend()，它的参数是每股分红的数量，它的功能是计算出分红的数量（每股分红的数量乘以总股数），并将其加到dividends中。
        红利是股东利润的一部分，一个DividendStock对象的利润应该等于总股数乘以股票当前价格，然后减去总成本，再加上分红。
        因此对于一个DividendStock对象来说，计算利润的方法与Stock有所不同，在定义DividendStock时要重写getProfit方法。*/
