package com.example.demo1.animals;

public class Conejo extends Animal{
    public Conejo() {
        super(2, 0.45);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
