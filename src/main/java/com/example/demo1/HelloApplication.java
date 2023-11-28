package com.example.demo1;

import com.example.demo1.tablero.BoardMaker;
import com.example.demo1.tablero.BoardSettings;
import com.example.demo1.tablero.SimulationBoard;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import com.google.gson.*;

import java.io.IOException;

public class HelloApplication extends Application {

    private final TableView table = new TableView();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();


        // ToDo: Read BoardSettings from json file
        BoardSettings boardSettings = new BoardSettings();

        boardSettings.setBoard(new BoardSettings.Board());
        boardSettings.setSimulation(new BoardSettings.Simulation());

        boardSettings.getBoard().setRows(20);
        boardSettings.getBoard().setColumns(100);

        boardSettings.getSimulation().setDuration(300);
        boardSettings.getSimulation().setStatisticsRefreshInterval(5);

        // -----------------------------

        BoardMaker boardMaker = new BoardMaker(boardSettings);

        SimulationBoard simulationBoard = boardMaker.createWorld();

    }
}
