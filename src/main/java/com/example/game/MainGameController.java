package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainGameController {

    @FXML
    private ComboBox<Integer> gridSizeBox;

    @FXML
    private TextField playerNameField;
    Client client;

    GameWindowController gameWindow;

    @FXML
    void startBtnClicked(ActionEvent event) throws IOException, ClassNotFoundException {
        Stage gameStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("gameWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        gameWindow = (GameWindowController)fxmlLoader.getController();
        gameWindow.initParams(gridSizeBox.getSelectionModel().getSelectedItem(), playerNameField.getText());
        gameWindow.waitForGame();

        gameStage.setScene(scene);
        gameStage.show();
    }

    @FXML
    public void initialize(){
        gridSizeBox.getItems().addAll(IntStream.rangeClosed(3,15).boxed().collect(Collectors.toList()));
        gridSizeBox.getSelectionModel().select(0);
    }
}
