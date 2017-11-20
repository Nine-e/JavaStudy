package SeventhHomework;

/*import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;*/
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * Created by del on 2017/11/12.
 */
public class One extends Application{
    private final int WINDOW_LENGTH = 600;
    private final int WINDOW_HEIGHT = 120;

    private Label numLabel_1;
    private Label numLabel_2;
    private Label resultLabel;

    private TextField numTF_1;
    private TextField numTF_2;
    private TextField resultTF;

    private Button addBtn;
    private Button subBtn;
    private Button mutBtn;
    private Button divBtn;

    private BorderPane bPane;
    private HBox hBox1;
    private HBox hBox2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //***************创建标签、文本框、按钮等组件**************
        // 创建标签
        numLabel_1 = new Label("Number 1:");
        numLabel_2 = new Label("Number 2:");
        resultLabel= new Label("Result:");

        // 创建文本框
        numTF_1 = new TextField();
        numTF_1.setPrefColumnCount(4);
        numTF_2 = new TextField();
        numTF_2.setPrefColumnCount(4);
        resultTF = new TextField();
        resultTF.setPrefColumnCount(4);
        resultTF.setEditable(false);//将文本框设置为不可被用户编辑

        // 创建按钮
        addBtn = new Button("Add");
        subBtn = new Button("Subtract");
        mutBtn = new Button("Mutiplay");
        divBtn = new Button("Divide");

        // ***为按钮注册事件
        addBtn.setOnAction(e->{
            double num1 = Double.valueOf(numTF_1.getText());
            double num2 = Double.valueOf(numTF_2.getText());
            double result = num1 + num2;
            resultTF.setText(Double.toString(result));// 结果显示在文本框内
        });
        subBtn.setOnAction(e->{
            double num1 = Double.valueOf(numTF_1.getText());
            double num2 = Double.valueOf(numTF_2.getText());
            double result = num1 - num2;
            resultTF.setText(Double.toString(result));// 结果显示在文本框内
        });
        mutBtn.setOnAction(e->{
            double num1 = Double.valueOf(numTF_1.getText());
            double num2 = Double.valueOf(numTF_2.getText());
            double result = num1 * num2;
            resultTF.setText(Double.toString(result));// 结果显示在文本框内
        });
        divBtn.setOnAction(e->{
            double num1 = Double.valueOf(numTF_1.getText());
            double num2 = Double.valueOf(numTF_2.getText());
            double result = num1 / num2;
            resultTF.setText(Double.toString(result));// 结果显示在文本框内
        });

        //*******************HBox的创建*******************
        // 创建HBox, HBox中组件之间的水平间距为20
        hBox1 = new HBox(20);
        hBox1.setAlignment(Pos.CENTER); // 垂直水平居中
        hBox1.setPadding(new Insets(20, 0, 0, 0));  // 设置上边距
        hBox2 = new HBox(20);
        hBox2.setAlignment(Pos.CENTER); // 垂直水平居中
        hBox2.setPadding(new Insets(10, 0, 0, 0));  // 设置上边距

        // 把标签和文本框添加到hBox1中
        hBox1.getChildren().addAll(this.numLabel_1, this.numTF_1);
        hBox1.getChildren().addAll(this.numLabel_2, this.numTF_2);
        hBox1.getChildren().addAll(this.resultLabel, this.resultTF);
        //把按钮添加到hBox2中
        hBox2.getChildren().addAll(this.addBtn,this.subBtn,this.mutBtn,this.divBtn);

        //***************边界布局面板的创建****************
        // 创建边界布局面板
        bPane = new BorderPane();

        // 把hBox1面板放入边界布局面板的Top区域
        bPane.setTop(hBox1);
        // 把hBox2面板放入边界布局面板的Center区域
        bPane.setCenter(hBox2);

        //设置面板字体大小
        bPane.setStyle("-fx-font-size: 15");


        //****************场景和舞台的创建***************
        // 创建场景
        Scene scene = new Scene(bPane,this.WINDOW_LENGTH,this.WINDOW_HEIGHT);

        //把创建的场景放入舞台
        primaryStage.setScene(scene);

        //设置舞台标题
        primaryStage.setTitle("Calculator");

        //显示舞台
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);//运行JavaFX程序
    }

}
