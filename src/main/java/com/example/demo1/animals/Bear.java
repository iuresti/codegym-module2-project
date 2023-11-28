package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 5, feedingFactorDecrease = 10)
public class Bear extends Carnivorous {

    public Bear() {

        super(500, 80);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
