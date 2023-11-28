package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 500)
public class Mouse extends Herbivorous{

    public Mouse() {
        super(0.05, 0.01);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
