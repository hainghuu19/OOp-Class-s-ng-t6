package hust.soict.globalict.javafx;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {

    private boolean isErase = true;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Rectangle clipArea = new Rectangle(0, 0, drawingAreaPane.getWidth(), drawingAreaPane.getHeight());
        drawingAreaPane.setClip(clipArea);
        if (!isErase) {
            drawingAreaPane.getChildren().add(new Circle(event.getX(), event.getY(), 4, Color.BLACK));
        } else {
            drawingAreaPane.getChildren().add(new Circle(event.getX(), event.getY(), 4, Color.WHITE));
        }
    }
    @FXML
    void penButton(ActionEvent event) {
        isErase = false;
    }
    @FXML
    void eraserButton(ActionEvent event) {
        isErase = true;
    }

}