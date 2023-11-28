package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 20)
public class Eagle extends Carnivorous {
    public Eagle() {
        super(6, 1);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
