package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 20)
public class Ciervo extends Herbivorous {
    public Ciervo() {
        super(300, 50);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
