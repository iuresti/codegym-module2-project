package com.example.demo1.tablero;

import com.example.demo1.Planta;
import com.example.demo1.animals.Animal;
import com.example.demo1.animals.Herbivorous;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cell {
    private List<Animal> animales;
    private int plantsCount;

    public Cell() {
        animales = new ArrayList<>();
    }

    public void add(Animal animal) {
    }

    public void setPlantsCount(int plantsPerCell) {
        this.plantsCount = plantsPerCell;
    }

    public int getPlantsCount() {
        return plantsCount;
    }

    public int getAnimalsCount(Class<? extends Animal> animalClass) {
        return 0;
    }

    public Optional<Animal> getAnyOf(List<Animal> animalsToEat) {

        return Optional.empty();
    }

    public void remove(Animal animal) {

    }
}
