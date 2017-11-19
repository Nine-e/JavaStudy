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

        //������ǩ
        textLabel_1 = new Label("��Ʒ����");
        textLabel_1.setStyle("-fx-font-weight: bold");
        textLabel_2 = new Label("��Ʒ����");
        textLabel_2.setStyle("-fx-font-weight: bold");
        textLabel_3 = new Label("����");
        textLabel_3.setStyle("-fx-font-weight: bold");
        GridPane.setHalignment(textLabel_3, HPos.CENTER);
        textLabel_4 = new Label("С��");
        textLabel_4.setStyle("-fx-font-weight: bold");
        GridPane.setHalignment(textLabel_4, HPos.CENTER);

        numLabel_1 = new Label("108");
        numLabel_2 = new Label("28");
        numLabel_3 = new Label("8");
        countLabel = new Label("�ܼ�");
        GridPane.setHalignment(countLabel, HPos.CENTER);

        //�����ı���
        numTF_1 = new TextField();
        numTF_1.setPrefColumnCount(6);
        numTF_2 = new TextField();
        numTF_2.setPrefColumnCount(6);
        numTF_3 = new TextField();
        numTF_3.setPrefColumnCount(6);
        countTF_1 = new TextField();
        countTF_1.setPrefColumnCount(6);
        countTF_1.setEditable(false);//���ı�������Ϊ���ɱ��û��༭
        countTF_2 = new TextField();
        countTF_2.setPrefColumnCount(6);
        countTF_2.setEditable(false);
        countTF_3 = new TextField();
        countTF_3.setPrefColumnCount(6);
        countTF_3.setEditable(false);
        countTF = new TextField();
        countTF.setPrefColumnCount(6);
        countTF.setEditable(false);

        //������ѡ��
        roseChk = new CheckBox("11��õ��");
        caseChk = new CheckBox("������װ��");
        cardChk = new CheckBox("�ؿ�");

        // *****�Ѵ���������ĵ�ַ��ֵ��handler
        EventHandler<ActionEvent> handler = e ->{
            //***�жϸ�ѡ���Ƿ�ѡ��
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

        //������ť
        countBtn = new Button("����");
        resetBtn = new Button("����");

        //Ϊ��ť��ӵ���¼�
        Count count = new Count();
        Reset reset = new Reset();
        countBtn.setOnAction(count);
        resetBtn.setOnAction(reset);

        //********************���񲼾����Ĵ���**************
        //����һ��GridPane��������������
        gPane = new GridPane();

        gPane.setAlignment(Pos.CENTER);//��ֱˮƽ����
        gPane.setPadding(new Insets(12,12,12,12));//�����ڱ߾�
        gPane.setHgap(20);//���ýڵ�֮���ˮƽ���
        gPane.setVgap(10);//���ýڵ�֮��Ĵ�ֱ���

        //�ѽڵ�������񲼾����ָ����Ԫ���С����������У��У�
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

        //****************HBox�Ĵ���****************
        //����HBox
        hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER); // ��ֱˮƽ����
        hBox.setPadding(new Insets(0, 0, 20, 0));  // �����±߾�
        //�Ѱ�ť��ӵ�hBox��
        hBox.getChildren().addAll(this.countBtn,this.resetBtn);

        //**************�߽粼�����Ĵ���****************
        //�����߽粼�����
        bPane = new BorderPane();
        //���ø����������С
        bPane.setStyle("-fx-font-size: 15");
        //��GridPane������߽粼������Top����
        bPane.setTop(gPane);
        //��HBox������߽粼�����Bottom������
        bPane.setBottom(hBox);

        //*************��������̨�Ĵ���*********************
        //��������
        Scene scene = new Scene(bPane,this.WINDOW_LENGTH,this.WINDOW_HEIGHT);
        //�Ѵ����ĳ���������̨
        primaryStage.setScene(scene);
        //������̨����
        primaryStage.setTitle("Rose Shop");
        //��ʾ��̨
        primaryStage.show();



    }
    class Count implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {

            //***�жϸ�ѡ���Ƿ�ѡ��
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
        launch(args);  // ����Java FXӦ�ó���
    }
}
