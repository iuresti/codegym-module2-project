package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 20)
public class Horse extends Herbivorous {
    public Horse() {
        super(400, 60);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
