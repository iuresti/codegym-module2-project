package com.example.demo1;

import com.example.demo1.animals.Animal;
import com.example.demo1.animals.Boa;
import com.example.demo1.animals.Horse;
import com.example.demo1.animals.Wolf;
import com.example.demo1.tablero.Cell;
import com.example.demo1.tablero.SimulationBoard;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class SimulationBoardStatistics extends Thread {

    private final SimulationBoard simulationBoard;

    private boolean finished;

    public SimulationBoardStatistics(SimulationBoard simulationBoard) {

        this.simulationBoard = simulationBoard;

    }

    public void run(){
        int rows = simulationBoard.getTotalRows();
        int columns = simulationBoard.getTotalColumns();

        while(!finished) {
            Map<Class<? extends Animal>, Integer> countByAnimal = new HashMap<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    Cell cell = simulationBoard.get(i, j);

                    cell.count(countByAnimal);
                }
            }

            Set<Map.Entry<Class<? extends Animal>, Integer>> countEntries = countByAnimal.entrySet();

            for(Map.Entry<Class<? extends Animal>, Integer> entry: countEntries){
                print(entry);
            }

            System.out.println("========================================================");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void print(Map.Entry<Class<? extends Animal>, Integer> entry) {
        if(entry.getKey().equals(Wolf.class)){
            System.out.println("🐺: "+ entry.getValue());
        }else if(entry.getKey().equals(Boa.class)){
            System.out.println("🐍: "+ entry.getValue());
        }else {
            System.out.println(entry.getKey().getName() + ": "+ entry.getValue());
        }
    }
}
