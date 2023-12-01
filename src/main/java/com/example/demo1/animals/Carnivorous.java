package com.example.demo1.animals;

import com.example.demo1.tablero.Cell;
import com.example.demo1.tablero.Direction;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Carnivorous extends Animal {
    public Carnivorous(int peso, double alimentoNecesario) {
        super(peso, alimentoNecesario);
    }

    public void comer(Animal animal) {
        alimentoSuministrado += animal.getPeso();
        if (alimentoSuministrado > alimentoNecesario) {
            alimentoSuministrado = alimentoNecesario;
        }
    }

    public Optional<Direction> act(Cell cell) {

        Set<Class<? extends Animal>> animalsToEat = animalsToEat(); //template method

        if (alimentoSuministrado < alimentoNecesario) {

            Optional<Animal> animal = cell.getAnyOf(animalsToEat, this);

            if (animal.isPresent()) {
                comer(animal.get());

                return Optional.empty();
            } else {
                return getDirection();
            }

        }

        if (cell.getAnimalsCount(this.getClass()) > 0) {
            cell.add(reproduce());

            return Optional.empty();
        }

        return getDirection();
    }

    private static Optional<Direction> getDirection() {
        return switch (ThreadLocalRandom.current().nextInt(4)) {
            case 0 -> Optional.of(Direction.UP);
            case 1 -> Optional.of(Direction.DOWN);
            case 2 -> Optional.of(Direction.RIGHT);
            default -> Optional.of(Direction.LEFT);
        };
    }
}
