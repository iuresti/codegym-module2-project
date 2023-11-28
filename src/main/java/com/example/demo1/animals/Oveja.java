package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 140, feedingFactorDecrease = 70)
public class Oveja extends Herbivorous {
    public Oveja() {
        super(70, 15);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
