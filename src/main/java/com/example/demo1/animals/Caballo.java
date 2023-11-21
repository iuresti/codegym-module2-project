package com.example.demo1.animals;

import com.example.demo1.Restriction;

@Restriction(maxPerCell = 20)
public class Caballo extends Animal {
    public Caballo() {
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
