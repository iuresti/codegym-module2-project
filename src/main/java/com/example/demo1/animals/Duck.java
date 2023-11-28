package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 200)
public class Duck extends Herbivorous{
    public Duck() {
        super(1, 0.15);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
