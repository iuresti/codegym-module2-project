package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 150, feedingFactorDecrease = 80)
public class Rabbit extends Herbivorous {
    public Rabbit() {
        super(2, 0.45);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
