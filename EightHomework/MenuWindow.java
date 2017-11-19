package EightHomework;

/**
 * Created by del on 2017/11/16.
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuWindow extends Application {
    final int WINDOW_WIDTH = 500;
    final int WINDOW_HEIGHT = 200;

    private MenuBar menuBar;
    private Menu fileMenu, textMenu;
    private MenuItem exitItem;
    private MenuItem blackItem, redItem, blueItem;

    @Override
    public void start(Stage stage) throws Exception {
        VBox mainPane = new VBox();

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
        mainPane.getChildren().add(menuBar);

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

        // set the font of the fileMenu
        //fileMenu.setStyle("-fx-font-size:14pt");

        // create exit menu item
        exitItem = new MenuItem("exit");

        // set the font of the exit menu item
        //exitItem.setStyle("-fx-font-size:12pt");

        // add the exit menu item to the file menu
        fileMenu.getItems().add(exitItem);

    }

    public void buildTextMenu() {
        // create text menu with the title "Text"
        textMenu = new Menu("Text");
        //textMenu.setStyle("-fx-font-size:14pt");

        // create the black, red, and blue menu items
        blackItem = new MenuItem("black");
        //blackItem.setStyle("-fx-font-size:12pt");
        redItem = new MenuItem("red");
        //redItem.setStyle("-fx-font-size:12pt");
        blueItem = new MenuItem("blue");
        //blueItem.setStyle("-fx-font-size:12pt");

        // put the menu items in the text menu
        textMenu.getItems().addAll(blackItem, redItem, blueItem);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
