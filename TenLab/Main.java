package TenLab;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by del on 2017/11/30.
 */
public class Main extends Application {

    private final int WINDOW_WIDTH = 150;
    private final int WINDOW_LENGTH = 400;

    private Label labelA;
    private Label labelB;
    private Label labelC;

    private TextField TFA;
    private TextField TFB;
    private TextField TFC;

    private Button button;

    private GridPane gridPane;

    private boolean isRunning = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //创建标签
        labelA = new Label("线程一");
        GridPane.setHalignment(labelA, HPos.CENTER);
        labelA.setStyle("-fx-font-size: 16px;-fx-font-weight: bold");
        labelB = new Label("线程二");
        GridPane.setHalignment(labelB, HPos.CENTER);
        labelB.setStyle("-fx-font-size: 16px;-fx-font-weight: bold");
        labelC = new Label("线程三");
        GridPane.setHalignment(labelC, HPos.CENTER);
        labelC.setStyle("-fx-font-size: 16px;-fx-font-weight: bold");
        //创建文本域
        TFA = new TextField();
        TFA.setStyle("-fx-font-size: 16px");
        TFA.setPrefSize(110,30);
        TFB = new TextField();
        TFB.setStyle("-fx-font-size: 16px");
        TFB.setPrefSize(110,30);
        TFC = new TextField();
        TFC.setStyle("-fx-font-size: 16px");
        TFC.setPrefSize(110,30);
        //创建按钮
        button = new Button("开始");
        button.setStyle("-fx-font-size: 16px");
        button.setPrefSize(110,30);
        //为按钮编写监听事件
        button.setOnAction(e->{
            if(!isRunning){
                isRunning = true;
                button.setText("停止");
                Thread threadA = new Thread(new MyRunnable(TFA));
                threadA.start();
                Thread threadB = new Thread(new MyRunnable(TFB));
                threadB.start();
                Thread threadC = new Thread(new MyRunnable(TFC));
                threadC.start();
            }else {
                isRunning = false;
                button.setText("开始");
            }

        });
        //创建面板
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(15);

        gridPane.add(labelA,0,0);
        gridPane.add(labelB,1,0);
        gridPane.add(labelC,2,0);

        gridPane.add(TFA,0,1);
        gridPane.add(TFB,1,1);
        gridPane.add(TFC,2,1);

        gridPane.add(button,1,2);

        //******************创建舞台和场景***************
        //创建场景
        Scene scene = new Scene(gridPane,this.WINDOW_LENGTH,this.WINDOW_WIDTH);
        //把创建的场景放入舞台
        primaryStage.setScene(scene);
        //设置舞台标题
        primaryStage.setTitle("线程控制");
        //显示舞台
        primaryStage.show();
    }

    private class MyRunnable implements Runnable{
        private TextField TF;
        public MyRunnable(TextField TF){
            this.TF = TF;
        }
        @Override
        public void run() {
            while(isRunning){
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                //非应用程序线程中的代码不能更新应用程序线程中的GUI，所以需要下面的语句
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        TF.setText(""+ (char)(65+ Math.random()*26));
                    }
                });
            }
        }
    }

   public static void main(String[] args){
       launch(args);
    }
}
