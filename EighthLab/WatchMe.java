package EighthLab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * Created by del on 2017/11/16.
 */
public class WatchMe extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        //创建椭圆对象
        Ellipse e1 = new Ellipse(200,250,40,90);
        e1.setFill(Color.WHITE);
        e1.setStroke(Color.BLACK);
        pane.getChildren().add(e1);

        Ellipse e2 = new Ellipse(300,250,40,90);
        e2.setStroke(Color.BLACK);
        e2.setFill(Color.WHITE);
        pane.getChildren().add(e2);

        //创建圆形对象
        Circle c1 = new Circle(200,250,10);
        c1.setFill(Color.BLACK);
        c1.setStroke(Color.BLACK);
        pane.getChildren().add(c1);

        Circle c2 = new Circle(300,250,10);
        c2.setFill(Color.BLACK);
        c2.setStroke(Color.BLACK);
        pane.getChildren().add(c2);

        //设置鼠标事件
        //鼠标移动事件
        pane.setOnMouseMoved(event -> {
            double x = event.getX();
            double y = event.getY();
            if(x>160 && x<340 && y<160){//移动到图形正上方时
                c1.setCenterX(200);
                c2.setCenterX(300);
                c1.setCenterY(170);
                c2.setCenterY(170);
            }else if(x>160 && x<340 && y>340 ){//移动到图形正下方时
                c1.setCenterX(200);
                c2.setCenterX(300);
                c1.setCenterY(330);
                c2.setCenterY(330);
            }else if(x<160 && y>160 && y<340){//移动到图形正左方时
                c1.setCenterX(170);
                c2.setCenterX(270);
                c1.setCenterY(250);
                c2.setCenterY(250);
            }else if(x>340 && y>160 && y<340){//移动到图形正右方时
                c1.setCenterX(230);
                c2.setCenterX(330);
                c1.setCenterY(250);
                c2.setCenterY(250);
            }else {//移动到其他位置时
                c1.setCenterX(200);
                c1.setCenterY(250);
                c2.setCenterX(300);
                c2.setCenterY(250);
            }
        });
        //鼠标移出事件
        pane.setOnMouseExited(e->{
            c1.setCenterX(200);
            c1.setCenterY(250);
            c2.setCenterX(300);
            c2.setCenterY(250);
        });


        //创建场景
        Scene scene = new Scene(pane,500,500);
        primaryStage.setResizable(false);//设置舞台大小不可改变
        primaryStage.setTitle("Watch Me");//设置舞台标题
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

}
