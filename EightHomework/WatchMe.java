package EightHomework;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;


/**
 * Created by del on 2017/11/16.
 */
public class WatchMe extends Application {
    final int WINDOW_WIDTH = 500;
    final int WINDOW_HEIGHT = 400;

    private MenuBar menuBar;
    private Menu fileMenu,shapesMenu,modeMenu;
    private MenuItem exitItem;
    private MenuItem rectangleItem,polygonItem;
    private SeparatorMenuItem spa;
    private RadioMenuItem fillItem,unfillItem;

    private Rectangle rectangle;
    private Polygon polygon;
    private BorderPane mainPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainPane = new BorderPane();

        //定义矩形
        rectangle = new Rectangle(200,100);
        rectangle.setStroke(Color.BLACK);

        //定义六边形
        double centerX = WINDOW_WIDTH / 2, centerY = WINDOW_HEIGHT / 2;
        double radius =160 / Math.sqrt(3);
        polygon = new Polygon();
        polygon.setStroke(Color.BLACK);
        //get list
        ObservableList<Double> list = polygon.getPoints();

        //add points to the polygon list
        for(int i=0;i<6;++i) {
            list.add(centerX + radius * Math.cos(i * Math.PI / 3));
            list.add(centerY - radius * Math.sin(i * Math.PI / 3));
        }
       // mainPane.setCenter(polygon);

        menuBar = new MenuBar();
        buildFileMenu();
        buildShapesMenu();
        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(shapesMenu);

        mainPane.setTop(menuBar);

        primaryStage.setTitle("Watch Me");
        Scene scene = new Scene(mainPane, this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void buildFileMenu() {
        fileMenu = new Menu("File");

        exitItem = new MenuItem("exit");
        exitItem.setOnAction(e->System.exit(0));

        fileMenu.getItems().add(exitItem);
    }
    public void buildShapesMenu() {
        shapesMenu = new Menu("Shapes");

        rectangleItem = new MenuItem("rectangle");
        rectangleItem.setOnAction(e->{
          mainPane.setCenter(rectangle);
        });

        polygonItem = new MenuItem("polygon");
        polygonItem.setOnAction(e->{
           mainPane.setCenter(polygon);
        });

        modeMenu = new Menu("Drawing Mode");
        fillItem = new RadioMenuItem("fill");
        fillItem.setSelected(true);
        fillItem.setOnAction(e->{
            rectangle.setFill(Color.BLACK);
            polygon.setFill(Color.BLACK);
        });

        unfillItem = new RadioMenuItem("unfill");
        unfillItem.setOnAction(e->{
            rectangle.setFill(Color.WHITE);
            polygon.setFill(Color.WHITE);
        });

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(fillItem,unfillItem);

        modeMenu.getItems().addAll(fillItem,unfillItem);

        // **********创建分割线
        spa = new SeparatorMenuItem();

        shapesMenu.getItems().addAll(rectangleItem,polygonItem,spa,modeMenu);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
