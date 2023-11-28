package com.example.demo1.animals;

import com.example.demo1.Restriction;
import com.example.demo1.tablero.Cell;
import com.example.demo1.tablero.Direction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Carnivorous extends Animal{
    public Carnivorous(int peso, double alimentoNecesario) {
        super(peso, alimentoNecesario);
    }

    public void comer(Animal animal) {
        alimentoSuministrado += animal.getPeso();
        if (alimentoSuministrado > alimentoNecesario) {
            alimentoSuministrado = alimentoNecesario;
        }
    }

    public Optional<Direction> mover(Cell cell) {

        List<Animal> animalsToEat = new LinkedList<>();

        if (alimentoSuministrado < alimentoNecesario ) {

            cell.getAnyOf(animalsToEat).ifPresent(animal -> {
                comer(animal);
                cell.remove(animal);
            });

            return Optional.empty();
        }

        if (cell.getAnimalsCount(this.getClass()) > 0) {
            cell.add(reproduce());

            return Optional.empty();
        }

        return switch (ThreadLocalRandom.current().nextInt(4)) {
            case 0 -> Optional.of(Direction.UP);
            case 1 -> Optional.of(Direction.DOWN);
            case 2 -> Optional.of(Direction.RIGHT);
            default -> Optional.of(Direction.LEFT);
        };
    }
}
