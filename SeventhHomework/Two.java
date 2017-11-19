package SeventhHomework;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Created by del on 2017/11/18.
 */
public class Two extends Application{
    private final int WINDOW_LENGTH = 550;
    private final int WINDOW_HEIGHT = 300;

    private Label textLabel_1;
    private Label textLabel_2;
    private Label textLabel_3;
    private Label textLabel_4;

    private Label numLabel_1;
    private Label numLabel_2;
    private Label numLabel_3;
    private Label countLabel;

    private CheckBox roseChk;
    private CheckBox caseChk;
    private CheckBox cardChk;

    private TextField numTF_1;
    private TextField numTF_2;
    private TextField numTF_3;
    private TextField countTF_1;
    private TextField countTF_2;
    private TextField countTF_3;
    private TextField countTF;

    private Button countBtn;
    private Button resetBtn;

    private BorderPane bPane;
    private GridPane gPane;
    private HBox hBox;

    double s1=0,s2=0,s3=0,t=0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //创建标签
        textLabel_1 = new Label("商品类型");
        textLabel_1.setStyle("-fx-font-weight: bold");
        textLabel_2 = new Label("商品单价");
        textLabel_2.setStyle("-fx-font-weight: bold");
        textLabel_3 = new Label("数量");
        textLabel_3.setStyle("-fx-font-weight: bold");
        GridPane.setHalignment(textLabel_3, HPos.CENTER);
        textLabel_4 = new Label("小计");
        textLabel_4.setStyle("-fx-font-weight: bold");
        GridPane.setHalignment(textLabel_4, HPos.CENTER);

        numLabel_1 = new Label("108");
        numLabel_2 = new Label("28");
        numLabel_3 = new Label("8");
        countLabel = new Label("总计");
        GridPane.setHalignment(countLabel, HPos.CENTER);

        //创建文本域
        numTF_1 = new TextField();
        numTF_1.setPrefColumnCount(6);
        numTF_2 = new TextField();
        numTF_2.setPrefColumnCount(6);
        numTF_3 = new TextField();
        numTF_3.setPrefColumnCount(6);
        countTF_1 = new TextField();
        countTF_1.setPrefColumnCount(6);
        countTF_1.setEditable(false);//将文本框设置为不可被用户编辑
        countTF_2 = new TextField();
        countTF_2.setPrefColumnCount(6);
        countTF_2.setEditable(false);
        countTF_3 = new TextField();
        countTF_3.setPrefColumnCount(6);
        countTF_3.setEditable(false);
        countTF = new TextField();
        countTF.setPrefColumnCount(6);
        countTF.setEditable(false);

        //创建复选框
        roseChk = new CheckBox("11朵玫瑰");
        caseChk = new CheckBox("精美包装盒");
        cardChk = new CheckBox("贺卡");

        // *****把处理器对象的地址赋值给handler
        EventHandler<ActionEvent> handler = e ->{
            //***判断复选框是否选中
            if(roseChk.isSelected()&&numTF_1.getText().equals("")){
                numTF_1.setText("1");
            }
            if(!roseChk.isSelected()) {
                numTF_1.setText("");
                countTF_1.setText("");
            }
            if(caseChk.isSelected()&&numTF_2.getText().equals("")){
                numTF_2.setText("1");
            }
            if(!caseChk.isSelected()) {
                numTF_2.setText("");
                countTF_2.setText("");
            }
            if (cardChk.isSelected()&&numTF_3.getText().equals("")){
                numTF_3.setText("1");
            }
            if(!cardChk.isSelected()) {
                numTF_3.setText("");
                countTF_3.setText("");
            }
        };
        roseChk.setOnAction(handler);
        caseChk.setOnAction(handler);
        cardChk.setOnAction(handler);

        //创建按钮
        countBtn = new Button("计算");
        resetBtn = new Button("重置");

        //为按钮添加点击事件
        Count count = new Count();
        Reset reset = new Reset();
        countBtn.setOnAction(count);
        resetBtn.setOnAction(reset);

        //********************网格布局面板的创建**************
        //创建一个GridPane并设置它的属性
        gPane = new GridPane();

        gPane.setAlignment(Pos.CENTER);//垂直水平居中
        gPane.setPadding(new Insets(12,12,12,12));//设置内边距
        gPane.setHgap(20);//设置节点之间的水平间隔
        gPane.setVgap(10);//设置节点之间的垂直间隔

        //把节点放入网格布局面板指定单元格中——（对象，列，行）
        gPane.add(textLabel_1,0,0);
        gPane.add(roseChk,0,1);
        gPane.add(caseChk,0,2);
        gPane.add(cardChk,0,3);

        gPane.add(textLabel_2,1,0);
        gPane.add(numLabel_1 ,1,1);
        gPane.add(numLabel_2,1,2);
        gPane.add(numLabel_3,1,3);

        gPane.add(textLabel_3,2,0);
        gPane.add(numTF_1,2,1);
        gPane.add(numTF_2,2,2);
        gPane.add(numTF_3,2,3);

        gPane.add(textLabel_4,3,0);
        gPane.add(countTF_1,3,1);
        gPane.add(countTF_2,3,2);
        gPane.add(countTF_3,3,3);
        gPane.add(countLabel,3,4);
        gPane.add(countTF,3,5);

        //****************HBox的创建****************
        //创建HBox
        hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER); // 垂直水平居中
        hBox.setPadding(new Insets(0, 0, 20, 0));  // 设置下边距
        //把按钮添加到hBox中
        hBox.getChildren().addAll(this.countBtn,this.resetBtn);

        //**************边界布局面板的创建****************
        //创建边界布局面板
        bPane = new BorderPane();
        //设置该面板的字体大小
        bPane.setStyle("-fx-font-size: 15");
        //把GridPane面板放入边界布局面板的Top区域
        bPane.setTop(gPane);
        //把HBox面板放入边界布局面板Bottom的区域
        bPane.setBottom(hBox);

        //*************场景和舞台的创建*********************
        //创建场景
        Scene scene = new Scene(bPane,this.WINDOW_LENGTH,this.WINDOW_HEIGHT);
        //把创建的场景放入舞台
        primaryStage.setScene(scene);
        //设置舞台标题
        primaryStage.setTitle("Rose Shop");
        //显示舞台
        primaryStage.show();



    }
    class Count implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {

            //***判断复选框是否选中
            if(roseChk.isSelected()){
                double num1 = Double.valueOf(numTF_1.getText());
                s1 = 108 * num1;
                countTF_1.setText(s1+"");
            }
            else {
                s1=0;
                countTF_1.setText("");
            }
            if(caseChk.isSelected()){
                s2 = 28 * Double.valueOf(numTF_2.getText());
                countTF_2.setText(s2+"");
            }
            else{
                s2=0;
                countTF_2.setText("");
            }
            if (cardChk.isSelected()){
                s3 = 8 * Double.valueOf(numTF_3.getText());
                countTF_3.setText(s3+"");
            }
            else{
                s3=0;
                countTF_3.setText("");
            }
            t = s1 + s2 + s3;
            if(roseChk.isSelected()|| caseChk.isSelected()||cardChk.isSelected()){
                countTF.setText(t+"");
            }
            else {
                countTF.setText("");
            }

        }
    }
    class Reset implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            s1 = 0;
            s2 = 0;
            s3 = 0;
            t = 0;
            roseChk.setSelected(false);
            caseChk.setSelected(false);
            cardChk.setSelected(false);
            numTF_1.clear();
            numTF_2.clear();
            numTF_3.clear();
            countTF_1.clear();
            countTF_2.clear();
            countTF_3.clear();
            countTF.clear();

        }
    }
    public static void main(String[] args) {
        launch(args);  // 运行Java FX应用程序
    }
}
