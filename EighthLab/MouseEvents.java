package EighthLab;

/**
 * Created by del on 2017/11/16.
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * This application shows the mouse events as they occur.
 */

public class MouseEvents extends Application {
    private final int WINDOW_WIDTH = 500; // the width of a window
    private final int WINDOW_HEIGHT = 200; // the height of a window
    private FlowPane mainPane;
    private Label[] mouseStates;
    private String[] text = { "Pressed", "Clicked", "Released", "Entered",
            "Exited", "Dragged", "X:", "Y:" };

    @Override
    public void start(Stage stage) throws Exception {
        mainPane = new FlowPane();
        mainPane.setHgap(10);
        mainPane.setVgap(5);
        mainPane.setAlignment(Pos.CENTER);

        // Create the array of text fields.
        mouseStates = new Label[8];
        for (int i = 0; i < mouseStates.length; i++) {
            mouseStates[i] = new Label(text[i]);
            mouseStates[i].setPrefSize(180, 40);
            mouseStates[i].setAlignment(Pos.CENTER);
            mouseStates[i].setStyle("-fx-border-color: Blue");
            mainPane.getChildren().add(mouseStates[i]);
        }

        mainPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                clearTextFields();
                mouseStates[0].setStyle("-fx-background-color: Yellow");
            }
        });

        mainPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                clearTextFields();
                mouseStates[1].setStyle("-fx-background-color: Yellow");
            }

        });

        mainPane.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                clearTextFields();
                mouseStates[2].setStyle("-fx-background-color: Yellow");

            }
        });

        mainPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                clearTextFields();
                mouseStates[3].setStyle("-fx-background-color: Yellow");
            }
        });

        mainPane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                clearTextFields();
                mouseStates[4].setStyle("-fx-background-color: Yellow");
            }
        });

        mainPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                clearTextFields();
                mouseStates[5].setStyle("-fx-background-color: Yellow");
            }
        });

        mainPane.setOnMouseMoved(e -> {
            mouseStates[6].setText("X: " + String.valueOf(e.getX()));
            mouseStates[7].setText("Y: " + String.valueOf(e.getY()));
        });

        // set title
        stage.setTitle("Mouse Events");

        // set the size of the window
        Scene scene = new Scene(mainPane, WINDOW_WIDTH, WINDOW_HEIGHT);

        // set scene for the stage
        stage.setScene(scene);

        // show the window
        stage.show();

    }

    /**
     * The clearTextFields method sets all of the text backgrounds to light
     * gray.
     */
    public void clearTextFields() {
        for (int i = 0; i < 6; i++) {
            mouseStates[i]
                    .setStyle("-fx-background-color: White; -fx-border-color: Blue");
            ;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
