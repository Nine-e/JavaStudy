package SeventhLab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Random;


/**
 * Created by del on 2017/11/9.
 */
public class Main  extends Application {
    private final int WINDOW_LENGTH = 550;
    private final int WINDOW_HEIGTH = 130;

    private Label msgLabel;
    private TextField sexTf;
    private Button forBtn;
    private Button backBtn;

    private BorderPane bPane;
    private HBox hBox1;
    private HBox hBox2;
    private HBox hBox3;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //创建标签
        msgLabel = new Label("Click \"Forward\" to run a word,click \"Backward\" to reverse");
        msgLabel.setStyle("-fx-font-size: 16");

        //创建文本框
        sexTf = new TextField();
        sexTf.setPrefWidth(500);

        //创建按钮
        forBtn = new Button("Forward");
        forBtn.setStyle("-fx-font-size: 14");
        backBtn = new Button("Backward");
        backBtn.setStyle("-fx-font-size: 14");

        //为按钮注册事件
        forBtn.setOnAction(e->{
            String[] sex = {"male","female"};
            int sexIndex = 0;
            StringBuffer content = new StringBuffer(sexTf.getText().toString());
            Random random = new Random();
            sexIndex = random.nextInt(2);
            sexTf.setText(content + sex[sexIndex]);
        });

        backBtn.setOnAction(e -> {
            String content = sexTf.getText().toString();
            StringBuffer s = new StringBuffer(content);
            if(content.endsWith("female")){
                s.delete(s.length()-6,s.length());
            }else {
                s.delete(s.length()-4,s.length());
            }
            sexTf.setText(s.toString());
        });

        //创建HBox
        hBox1 = new HBox();
        hBox2 = new HBox();
        hBox3 = new HBox(30);


        //把按钮添加到HBox中
        hBox1.getChildren().add(this.msgLabel);
        hBox2.getChildren().add(this.sexTf);
        hBox3.getChildren().addAll(this.forBtn, this.backBtn);

        //设置HBox的属性
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setPadding(new Insets(15,0,0,0));
        hBox2.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setPadding(new Insets(0,0,15,0));


        //创建边界布局面版
        bPane = new BorderPane();

        bPane.setTop(hBox1);
        bPane.setCenter(hBox2);
        bPane.setBottom(hBox3);

        //创建场景和舞台
        Scene scene = new Scene(bPane,this.WINDOW_LENGTH,this.WINDOW_HEIGTH);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Control Window");
        primaryStage.show();

    }
    public static void main (String[] args){
        launch(args);
    }
}
