package com.example.demo1.animals;

import java.util.concurrent.TimeUnit;

public abstract class Animal implements Runnable {
    private final int peso;

    private final double alimentoNecesario;
    private double alimentoSuministrado;

    private boolean comido;

    public Animal(int peso, double alimentoNecesario) {
        this.peso = peso;
        this.alimentoNecesario = alimentoNecesario;
    }

    public abstract boolean seTeAntoja(Animal animal);

    public abstract void actuar();

    public int getPeso() {
        return peso;
    }

    public void comer(Animal animal) {
        if (seTeAntoja(animal)) {
            alimentoSuministrado += animal.getPeso();
            if (alimentoSuministrado > alimentoNecesario) {
                alimentoSuministrado = alimentoNecesario;
            }
        }
    }

    public void run() {
        while (alimentoSuministrado > 0 && !Thread.currentThread().isInterrupted() && !comido) {
            actuar();
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void fuisteComido() {
        comido = true;
    }
}
