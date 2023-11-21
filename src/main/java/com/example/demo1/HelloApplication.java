package com.example.demo1;

import com.example.demo1.tablero.HacedorDeLuz;
import com.example.demo1.tablero.TableroDeSimulacion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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

        TableroDeSimulacion tableroDeSimulacion;

        HacedorDeLuz hacedorDeLuz = new HacedorDeLuz();

        tableroDeSimulacion = hacedorDeLuz.hagaseLaLuz();

    }
}
