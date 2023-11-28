package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 1000)
public class Oruga extends Herbivorous {
    public Oruga() {
        super(0.01, 0);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
