package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 30)
public class Fox extends Carnivorous {
    public Fox() {
        super(8, 2);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
