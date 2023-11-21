package com.example.demo1.tablero;

import com.example.demo1.Planta;
import com.example.demo1.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class Celda {
    private List<Animal> animales;
    private List<Planta> plantas;

    public Celda() {
        animales = new ArrayList<>();
        plantas = new ArrayList<>();
    }

    public void add(Animal animal) {
    }
}
