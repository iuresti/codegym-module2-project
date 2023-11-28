package com.example.demo1.tablero;

import com.example.demo1.Planta;
import com.example.demo1.Restriction;
import com.example.demo1.animals.*;

import java.util.concurrent.ThreadLocalRandom;

public class BoardMaker {

    private final BoardSettings boardSettings;

    public BoardMaker(BoardSettings boardSettings) {
        this.boardSettings = boardSettings;
    }

    public SimulationBoard createWorld() {
        SimulationBoard simulationBoard = new SimulationBoard(100, 20);

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                poblarPlantas(simulationBoard.get(i, j));
                poblarAnimales(simulationBoard.get(i, j));
            }
        }
        return simulationBoard;
    }

    private void poblarAnimales(Cell cell) {

        //TODO: Read all animals from package com.exmple.demo1.animals and replace line by line with a loop

        populateAnimal(cell, Bear.class);
        populateAnimal(cell, Boa.class);
        populateAnimal(cell, Bufalo.class);
        populateAnimal(cell, Cabra.class);
        populateAnimal(cell, Ciervo.class);
        populateAnimal(cell, Duck.class);
        populateAnimal(cell, Eagle.class);
        populateAnimal(cell, Fox.class);
        populateAnimal(cell, Horse.class);
        populateAnimal(cell, Jabali.class);
        populateAnimal(cell, Mouse.class);
        populateAnimal(cell, Oruga.class);
        populateAnimal(cell, Oveja.class);
        populateAnimal(cell, Rabbit.class);
        populateAnimal(cell, Wolf.class);
    }

    private static void populateAnimal(Cell celda, Class<? extends Animal> classAnimal) {
        Restriction restriction = classAnimal.getAnnotation(Restriction.class);

        int maxPerCell = restriction != null ? restriction.maxPerCell() : 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int realCount = random.nextInt(maxPerCell);

        for (int i = 0; i < realCount; i++) {
            try {
                Animal animal = classAnimal.getConstructor().newInstance();

                celda.add(animal);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void poblarPlantas(Cell cell) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        int plantsPerCell = random.nextInt(Planta.MAX_PER_CELL);

        cell.setPlantsCount(plantsPerCell);

    }
}
