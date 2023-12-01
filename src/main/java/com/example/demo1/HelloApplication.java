package com.example.demo1;

import com.example.demo1.tablero.BoardMaker;
import com.example.demo1.tablero.BoardSettings;
import com.example.demo1.tablero.SimulationBoard;
import com.google.gson.Gson;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HelloApplication /*extends Application*/ {

    private final TableView table = new TableView();

    //@Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        //launch();

        Gson gson = new Gson();

        try (InputStream inputStream = HelloApplication.class.getResourceAsStream("/settings.json");
             InputStreamReader reader = new InputStreamReader(inputStream)) {

            BoardSettings boardSettings = gson.fromJson(reader, BoardSettings.class);

            BoardMaker boardMaker = new BoardMaker(boardSettings);

            SimulationBoard simulationBoard = boardMaker.createWorld();
            SimulationBoardStatistics simulationBoardStatistics = new SimulationBoardStatistics(simulationBoard);

            simulationBoard.start();
            simulationBoardStatistics.start();
        }

    }
}
