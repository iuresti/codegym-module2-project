package com.example.demo1.animals;

import com.example.demo1.Restriction;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


@Restriction(maxPerCell = 30)
public class Lobo extends Animal {

    private static final Map<Class<? extends Animal>, Integer> probabilityMap = new HashMap<>();

    static {
        probabilityMap.put(Conejo.class, 60);
        probabilityMap.put(Caballo.class, 10);
    }

    public Lobo() {
        super(50, 8);
    }


    public boolean seTeAntoja(Animal animal) {
        int probabilidad = probabilityMap.getOrDefault(animal.getClass(), 0);
        ThreadLocalRandom random = ThreadLocalRandom.current();

        return random.nextInt(100) < probabilidad;
    }

    @Override
    public void actuar() {

    }
}
