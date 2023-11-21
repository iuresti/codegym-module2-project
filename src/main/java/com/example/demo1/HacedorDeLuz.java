package com.example.demo1;

import com.example.demo1.animals.*;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class HacedorDeLuz {
    public void hagaseLaLuz() {
        TableroDeSimulacion tableroDeSimulacion = new TableroDeSimulacion(100, 20);

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                poblarAnimales(tableroDeSimulacion.get(i, j));
                poblarPlantas(tableroDeSimulacion.get(i, j));
            }
        }

    }

    private void poblarAnimales(Celda celda) {




        ThreadGroup threadGroup = new ThreadGroup("Animales");


        populateAnimal(celda, threadGroup, Lobo.class);
        populateAnimal(celda, threadGroup, Conejo.class);
        populateAnimal(celda, threadGroup, Caballo.class);

    }

    private static void populateAnimal(Celda celda, ThreadGroup threadGroup, Class<? extends Animal> classAnimal) {
        Restriction restriction = classAnimal.getAnnotation(Restriction.class);

        int maxPerCell = restriction.maxPerCell();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int realCount = random.nextInt(maxPerCell);

        for(int i = 0; i< realCount; i++) {
            try {
                Animal animal = classAnimal.getConstructor().newInstance();
                new Thread(threadGroup, animal);

                celda.add(animal);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
