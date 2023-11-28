package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 50)
public class Jabali extends Herbivorous {
    public Jabali() {
        super(400, 50);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
