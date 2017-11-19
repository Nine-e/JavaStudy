package EightHomework;

/**
 * Created by del on 2017/11/16.
 */


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MenuWindow2 extends Application {
    final int WINDOW_WIDTH = 500;
    final int WINDOW_HEIGHT = 200;

    private MenuBar menuBar;
    private Menu fileMenu, textMenu, colorMenu;
    private MenuItem exitItem;
    private RadioMenuItem blackItem, redItem, blueItem;
    private CheckMenuItem visibleItem;
    private SeparatorMenuItem spa;
    private Label textLabel;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();

        // create a menu bar
        menuBar = new MenuBar();

        // create a File menu
        buildFileMenu();

        // create a Text menu
        buildTextMenu();

        // add the file menu and text menu to the menu bar
        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(textMenu);

        // add the menu bar to the window
        mainPane.setTop(menuBar);

        // 创建标签
        textLabel = new Label("Give you color see see.");
        textLabel.setAlignment(Pos.CENTER);
        textLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,
                FontPosture.ITALIC, 36));
        // textLabel.setTextFill(Color.BLUE);

        mainPane.setCenter(textLabel);

        // set title for the window
        stage.setTitle("Menu Window");

        // set the size of the window
        Scene scene = new Scene(mainPane, this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public void buildFileMenu() {
        // create file menu with the title "File"
        fileMenu = new Menu("File");

        // create exit menu item
        exitItem = new MenuItem("exit");
        exitItem.setOnAction(e->System.exit(0));

        // add the exit menu item to the file menu
        fileMenu.getItems().add(exitItem);
    }

    public void buildTextMenu() {
        // create text menu with the title "Text"
        textMenu = new Menu("Text");

        // ************创建color子菜单
        colorMenu = new Menu("color");

        // create the black, red, and blue menu items
        blackItem = new RadioMenuItem("black");
        blackItem.setSelected(true);
        blackItem.setOnAction(e -> textLabel.setTextFill(Color.BLACK));

        redItem = new RadioMenuItem("red");
        redItem.setOnAction(e -> textLabel.setTextFill(Color.RED));

        blueItem = new RadioMenuItem("blue");
        blueItem.setOnAction(e -> textLabel.setTextFill(Color.BLUE));

        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(blackItem, redItem, blueItem);

        colorMenu.getItems().addAll(blackItem, redItem, blueItem);

        // **********创建分割线
        spa = new SeparatorMenuItem();

        // **********创建visible菜单项
        visibleItem = new CheckMenuItem("visible");
        visibleItem.setSelected(true);
        visibleItem.setOnAction(e -> {
            if (visibleItem.isSelected()) {
                textLabel.setVisible(true);
            } else {
                textLabel.setVisible(false);
            }
        });

        // put the menu items in the text menu
        textMenu.getItems().addAll(colorMenu, spa, visibleItem);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
