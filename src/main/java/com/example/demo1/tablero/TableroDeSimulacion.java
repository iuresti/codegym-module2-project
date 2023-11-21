package com.example.demo1.tablero;

public class TableroDeSimulacion {
    private final Celda[][] matriz;

    public TableroDeSimulacion(int rows, int columns) {
        matriz = new Celda[rows][columns];
    }

    public Celda get(int row, int col) {
        return matriz[row][col];
    }
}
