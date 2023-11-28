package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 140)
public class Cabra extends Herbivorous {
    public Cabra() {
        super(60, 10);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
