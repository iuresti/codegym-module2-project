package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 10)
public class Bufalo extends Herbivorous {
    public Bufalo() {
        super(700, 100);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
