package NinthLab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import static java.lang.Integer.valueOf;


/**
 * Created by del on 2017/11/23.
 */
public class Main extends Application {
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_LENGTH = 700;

    private Label mainLabel;
    private Label subLabel;

    private Button button_1;
    private Button button_2;

    private Rectangle bigArea;

    private Slider rSlider;
    private Slider gSlider;
    private Slider bSlider;

    private BorderPane bPane;
    private VBox leftPane;
    private GridPane gridPane;
    private VBox rslidePane;
    private VBox gslidePane;
    private VBox bslidePane;
    private HBox slidePane;
    private VBox vslidePane;
    private HBox buttonPane;

    private int R = 255;
    private int G = 255;
    private int B = 255;
    private int count = 0;

    private Rectangle[] rectArray = new Rectangle[12];

    @Override
    public void start(Stage primaryStage) throws Exception {
        //******������ǩ�����Ρ�����������ť��ʵ��*****
        //������ǩ
        mainLabel = new Label("���������ɫ");
        mainLabel.setStyle("-fx-font-size: 20;-fx-font-weight: bold");
        mainLabel.setPadding(new Insets(40,0,0,0));
        BorderPane.setAlignment(mainLabel,Pos.CENTER);

        subLabel = new Label("���ѡ��");
        subLabel.setStyle("-fx-font-size: 12;-fx-font-weight: bold;-fx-background-color: pink");
        subLabel.setPrefSize(190,20);
        subLabel.setAlignment(Pos.CENTER);

        //����С����
        for(int i=0;i<12;i++){
            rectArray[i] = new Rectangle(90,41);
            rectArray[i].setStroke(Color.BLACK);
            rectArray[i].setFill(Color.WHITE);
        }

        //���������
        bigArea = new Rectangle(300,300);
        bigArea.setStroke(Color.BLACK);
        bigArea.setFill(Color.WHITE);
        BorderPane.setAlignment(bigArea,Pos.CENTER);

        //*******����������
        rSlider = new Slider(0,255,255);
        gSlider = new Slider(0,255,255);
        bSlider = new Slider(0,255,255);
        //���û������ķ���
        rSlider.setOrientation(Orientation.VERTICAL);
        gSlider.setOrientation(Orientation.VERTICAL);
        bSlider.setOrientation(Orientation.VERTICAL);

        //���û������Ĵ�С�Ϳ̶�
        rSlider.setPrefSize(50,280);
        rSlider.setMajorTickUnit(51);
        rSlider.setMinorTickCount(10);
        rSlider.setShowTickMarks(true);
        rSlider.setShowTickLabels(true);

        gSlider.setPrefSize(50,280);
        gSlider.setMajorTickUnit(51);
        gSlider.setMinorTickCount(10);
        gSlider.setShowTickMarks(true);
        gSlider.setShowTickLabels(true);

        bSlider.setPrefSize(50,280);
        bSlider.setMajorTickUnit(51);
        bSlider.setMinorTickCount(10);
        bSlider.setShowTickMarks(true);
        bSlider.setShowTickLabels(true);
        // Ϊ���������Դ��������¼�
        rSlider.valueProperty().addListener(e->{
            R = valueOf((int)rSlider.getValue());
            bigArea.setFill(Color.rgb(R,G,B));
        });
        gSlider.valueProperty().addListener(e->{
            G = valueOf((int)gSlider.getValue());
            bigArea.setFill(Color.rgb(R,G,B));
        });
        bSlider.valueProperty().addListener(e->{
            B = valueOf((int)bSlider.getValue());
            bigArea.setFill(Color.rgb(R,G,B));
        });

        //������ť
        button_1 = new Button("��ѡ����");
        button_2 = new Button("��    ��");
        //��Ӱ�ť����¼�
        button_1.setOnAction(e->{
            rectArray[count%12].setFill(Color.rgb(R,G,B));
            count++;
        });
        button_2.setOnAction(e->{
            R = 255;
            G = 255;
            B = 255;
            count = 0;
            rSlider.setValue(255);
            gSlider.setValue(255);
            bSlider.setValue(255);
            bigArea.setFill(Color.WHITE);
            for(int i=0;i<12;i++){
                rectArray[i].setFill(Color.WHITE);
            }

        });

        //****�������**********

        //******������Ż�������HBox
        vslidePane = new VBox();
        vslidePane.setPrefSize(180,300);
        vslidePane.setAlignment(Pos.CENTER);

        slidePane = new HBox();
        slidePane.setPrefSize(180,300);
        slidePane.setAlignment(Pos.CENTER);
        slidePane.setStyle("-fx-border-width: 5;-fx-border-color: pink");


        //�ѻ������������

        slidePane.getChildren().addAll(rSlider,gSlider,bSlider);
        vslidePane.getChildren().add(slidePane);

        //********�����������
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(2, 12, 0, 12));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(rectArray[0],0,0);
        gridPane.add(rectArray[1],1,0);
        gridPane.add(rectArray[2],0,1);
        gridPane.add(rectArray[3],1,1);
        gridPane.add(rectArray[4],0,2);
        gridPane.add(rectArray[5],1,2);
        gridPane.add(rectArray[6],0,3);
        gridPane.add(rectArray[7],1,3);
        gridPane.add(rectArray[8],0,4);
        gridPane.add(rectArray[9],1,4);
        gridPane.add(rectArray[10],0,5);
        gridPane.add(rectArray[11],1,5);

        //��������leftPane
        leftPane = new VBox();
        leftPane.setAlignment(Pos.CENTER);
        leftPane.getChildren().addAll(subLabel,gridPane);

        //******������Ű�ť��HBox
        buttonPane = new HBox();
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setPadding(new Insets(0,0,30,0));
        buttonPane.setSpacing(20);
        //�Ѱ�ť�������
        buttonPane.getChildren().addAll(button_1,button_2);


        //*******����BorderPane
        bPane = new BorderPane();
        bPane.setTop(mainLabel);
        bPane.setLeft(leftPane);
        bPane.setCenter(bigArea);
        bPane.setRight(vslidePane);
        bPane.setBottom(buttonPane);

        //******************������̨�ͳ���***************
        //��������
        Scene scene = new Scene(bPane,this.WINDOW_LENGTH,this.WINDOW_WIDTH);
        //�Ѵ����ĳ���������̨
        primaryStage.setScene(scene);
        //������̨����
        primaryStage.setTitle("Color the Panel");
        //��ʾ��̨
        primaryStage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}
