package ru.mts.hw3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    // Перегруженный метод для создания N животных с использованием цикла for
    public Set<Animal> createAnimals(int numberOfAnimals) {
        Set<Animal> animals = new HashSet<>();
        for (int i = 0; i < numberOfAnimals; i++) {
            Animal animal = new Dog("Labrador", "Dog" + i, BigDecimal.valueOf(200).setScale(2,RoundingMode.HALF_UP), "Friendly");
            animals.add(animal);
            System.out.println("Created: " + animal.getBreed() + " - " + animal.getName() + " cost = " + animal.getCost());
        }
        return animals;
    }
    // Переопределенный метод для создания 10 уникальных животных с использованием цикла do-while
    @Override
    public Set<Animal> createUniqueAnimals() {
        Set<Animal> uniqueAnimals = new HashSet<>();
        int count = 0;
        do {
            Animal animal;
            if (count % 4 == 0) {
                animal = new Dog("Labrador", "Dog" + count, BigDecimal.valueOf(200).setScale(2,RoundingMode.HALF_UP), "Friendly");
            } else if (count % 4 == 1) {
                animal = new Cat("Siamese", "Cat" + count, BigDecimal.valueOf(150).setScale(2,RoundingMode.HALF_UP), "Playful");
            } else if (count % 4 == 2) {
                animal = new Wolf("Gray Wolf", "Wolf" + count, BigDecimal.valueOf(100).setScale(2,RoundingMode.HALF_UP), "Fierce");
            } else {
                animal = new Shark("Great White Shark", "Shark" + count, BigDecimal.valueOf(500).setScale(2,RoundingMode.HALF_UP), "Aggressive");
            }

            uniqueAnimals.add(animal);
            System.out.println("Created: " + animal.getBreed() + " - " + animal.getName() + " cost = " + animal.getCost());
            count++;
        } while (count < 10);

        return uniqueAnimals;
    }
}
