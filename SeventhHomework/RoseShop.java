package SeventhHomework;

/**
 * Created by del on 2017/11/19.
 */
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

public class RoseShop extends Application{
    TextField num1=new TextField();
    TextField num2=new TextField();
    TextField num3=new TextField();
    TextField sum1=new TextField();
    TextField sum2=new TextField();
    TextField sum3=new TextField();
    TextField total=new TextField();
    CheckBox rose=new CheckBox("11朵玫瑰");
    CheckBox box=new CheckBox("精美包装盒");
    CheckBox card=new CheckBox("贺卡");
    Button calculate = new Button("计算");
    Button restart = new Button("重置");
    double s1=0,s2=0,s3=0,t=0;
    @Override
    public void start(Stage primaryStage) {
        GridPane pane=new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(12, 12, 22, 12));
        pane.setHgap(20);
        pane.setVgap(20);

        sum1.setEditable(false);
        sum2.setEditable(false);
        sum3.setEditable(false);
        total.setEditable(false);

        Label type=new Label("商品类型");
        Label price=new Label("商品单价");
        Label cnt=new Label("数量");
        Label ss=new Label("单价");
        Label tt=new Label("总计");

        CalClass handler1=new CalClass();
        ReClass handler2=new ReClass();

        calculate.setOnAction(handler1);
        restart.setOnAction(handler2);

        pane.add(type, 0, 0);
        GridPane.setHalignment(type, HPos.CENTER);
        pane.add(price, 1, 0);
        GridPane.setHalignment(price, HPos.CENTER);
        pane.add(cnt, 2, 0);
        GridPane.setHalignment(cnt, HPos.CENTER);
        pane.add(ss, 3, 0);
        GridPane.setHalignment(ss, HPos.CENTER);
        pane.add(rose, 0, 1);
        pane.add(new Label("108"), 1, 1);
        pane.add(num1, 2, 1);
        num1.setPrefWidth(80);
        pane.add(sum1, 3, 1);
        sum1.setPrefWidth(80);
        pane.add(box, 0, 2);
        pane.add(new Label("28"), 1, 2);
        pane.add(num2, 2, 2);
        num2.setPrefWidth(80);
        pane.add(sum2, 3, 2);
        sum2.setPrefWidth(80);
        pane.add(card, 0, 3);


        EventHandler<ActionEvent> handler = e -> {
            //****判断复选框是否选中
            if (rose.isSelected()&&num1.getText().length()>=1) {
                s1=108*Double.valueOf(num1.getText());
            }
            if(!rose.isSelected()) {
                s1=0;
            }
            if (box.isSelected()&&num2.getText().length()>=1) {
                s2=28*Double.valueOf(num2.getText());
            }
            if (!box.isSelected()) {
                s2=0;
            }
            if (card.isSelected()&&num3.getText().length()>=1) {
                s3=8*Double.valueOf(num3.getText());
            }
            if (!card.isSelected()) {
                s3=0;
            }
            t=s1+s2+s3;
        };

        //****多对一
        rose.setOnAction(handler);
        box.setOnAction(handler);
        card.setOnAction(handler);

        pane.add(new Label("8"), 1, 3);
        pane.add(num3, 2, 3);
        num3.setPrefWidth(80);
        pane.add(sum3, 3, 3);
        sum3.setPrefWidth(80);
        pane.add(tt, 3, 4);
        GridPane.setHalignment(tt, HPos.CENTER);
        pane.add(total, 3, 5);
        total.setPrefWidth(80);
        pane.add(calculate, 1, 6);
        GridPane.setHalignment(calculate,HPos.RIGHT);
        pane.add(restart, 2, 6);
        GridPane.setHalignment(restart, HPos.CENTER);
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Rose Shop");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    class CalClass implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent arg0) {
            total.setText(t+"");
            if(s1!=0)
                sum1.setText(s1+"");
            if(s1==0)
                sum1.setText("");
            if(s2!=0)
                sum2.setText(s2+"");
            if(s2==0)
                sum2.setText("");
            if(s3!=0)
                sum3.setText(s3+"");
            if(s3==0)
                sum3.setText("");
        }

    }
    class ReClass implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent arg0) {
            s1=0;
            s2=0;
            s3=0;
            t=0;
            rose.setSelected(false);
            box.setSelected(false);
            card.setSelected(false);
            sum1.clear();
            sum2.clear();
            sum3.clear();
            total.clear();
            num1.clear();
            num2.clear();
            num3.clear();
        }

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
