package com.example.demo1.tablero;

public class SimulationBoard {
    private final Cell[][] board;

    public SimulationBoard(int rows, int columns) {
        board = new Cell[rows][columns];
    }

    public Cell get(int row, int col) {
        return board[row][col];
    }
}
