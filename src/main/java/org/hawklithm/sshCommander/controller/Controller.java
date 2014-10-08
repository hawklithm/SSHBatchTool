package org.hawklithm.sshCommander.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Controller {
    @FXML private TextArea textArea;
    @FXML private GridPane gridPane;
    @FXML private Button button;
    int count=0;
    @FXML protected void handleAddButtonClickAction(MouseEvent event){
        System.out.println(event.toString());
        if (MouseEvent.MOUSE_CLICKED.equals(event.getEventType())){
            System.out.println("mouse click");
            gridPane.add(new TextArea(),++count,0);
        }
    }
}
