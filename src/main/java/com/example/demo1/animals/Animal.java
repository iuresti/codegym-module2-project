package com.example.demo1.animals;

import com.example.demo1.tablero.Cell;
import com.example.demo1.tablero.Direction;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public abstract class Animal {
    private final double peso;

    protected final double alimentoNecesario;
    protected double alimentoSuministrado;

    private boolean comido;

    public Animal(double peso, double alimentoNecesario) {
        this.peso = peso;
        this.alimentoNecesario = alimentoNecesario;
    }

    public abstract boolean seTeAntoja(Animal animal);

    public abstract void actuar();

    public Set<Class<? extends Animal>> animalsToEat(){
        return Collections.emptySet();
    }

    public double getPeso() {
        return peso;
    }

    public abstract Optional<Direction> act(Cell cell);

    protected Animal reproduce() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
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

    protected boolean seTeAntoja(Animal animal, Map<Class<? extends Animal>, Integer> probabilityMap) {
        int probabilidad = probabilityMap.getOrDefault(animal.getClass(), 0);
        ThreadLocalRandom random = ThreadLocalRandom.current();

        return random.nextInt(100) < probabilidad;
    }

    public double getAlimentoSuministrado() {
        return alimentoSuministrado;
    }

    public void setAlimentoSuministrado(double alimentoSuministrado) {
        this.alimentoSuministrado = alimentoSuministrado;
    }
}
