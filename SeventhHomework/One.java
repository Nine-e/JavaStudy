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
        //***************������ǩ���ı��򡢰�ť�����**************
        // ������ǩ
        numLabel_1 = new Label("Number 1:");
        numLabel_2 = new Label("Number 2:");
        resultLabel= new Label("Result:");

        // �����ı���
        numTF_1 = new TextField();
        numTF_1.setPrefColumnCount(4);
        numTF_2 = new TextField();
        numTF_2.setPrefColumnCount(4);
        resultTF = new TextField();
        resultTF.setPrefColumnCount(4);
        resultTF.setEditable(false);//���ı�������Ϊ���ɱ��û��༭

        // ������ť
        addBtn = new Button("Add");
        subBtn = new Button("Subtract");
        mutBtn = new Button("Mutiplay");
        divBtn = new Button("Divide");

        // ***Ϊ��ťע���¼�
        addBtn.setOnAction(e->{
            double num1 = Double.valueOf(numTF_1.getText());
            double num2 = Double.valueOf(numTF_2.getText());
            double result = num1 + num2;
            resultTF.setText(Double.toString(result));// �����ʾ���ı�����
        });
        subBtn.setOnAction(e->{
            double num1 = Double.valueOf(numTF_1.getText());
            double num2 = Double.valueOf(numTF_2.getText());
            double result = num1 - num2;
            resultTF.setText(Double.toString(result));// �����ʾ���ı�����
        });
        mutBtn.setOnAction(e->{
            double num1 = Double.valueOf(numTF_1.getText());
            double num2 = Double.valueOf(numTF_2.getText());
            double result = num1 * num2;
            resultTF.setText(Double.toString(result));// �����ʾ���ı�����
        });
        divBtn.setOnAction(e->{
            double num1 = Double.valueOf(numTF_1.getText());
            double num2 = Double.valueOf(numTF_2.getText());
            double result = num1 / num2;
            resultTF.setText(Double.toString(result));// �����ʾ���ı�����
        });

        //*******************HBox�Ĵ���*******************
        // ����HBox, HBox�����֮���ˮƽ���Ϊ20
        hBox1 = new HBox(20);
        hBox1.setAlignment(Pos.CENTER); // ��ֱˮƽ����
        hBox1.setPadding(new Insets(20, 0, 0, 0));  // �����ϱ߾�
        hBox2 = new HBox(20);
        hBox2.setAlignment(Pos.CENTER); // ��ֱˮƽ����
        hBox2.setPadding(new Insets(10, 0, 0, 0));  // �����ϱ߾�

        // �ѱ�ǩ���ı�����ӵ�hBox1��
        hBox1.getChildren().addAll(this.numLabel_1, this.numTF_1);
        hBox1.getChildren().addAll(this.numLabel_2, this.numTF_2);
        hBox1.getChildren().addAll(this.resultLabel, this.resultTF);
        //�Ѱ�ť��ӵ�hBox2��
        hBox2.getChildren().addAll(this.addBtn,this.subBtn,this.mutBtn,this.divBtn);

        //***************�߽粼�����Ĵ���****************
        // �����߽粼�����
        bPane = new BorderPane();

        // ��hBox1������߽粼������Top����
        bPane.setTop(hBox1);
        // ��hBox2������߽粼������Center����
        bPane.setCenter(hBox2);

        //������������С
        bPane.setStyle("-fx-font-size: 15");


        //****************��������̨�Ĵ���***************
        // ��������
        Scene scene = new Scene(bPane,this.WINDOW_LENGTH,this.WINDOW_HEIGHT);

        //�Ѵ����ĳ���������̨
        primaryStage.setScene(scene);

        //������̨����
        primaryStage.setTitle("Calculator");

        //��ʾ��̨
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);//����JavaFX����
    }

}
