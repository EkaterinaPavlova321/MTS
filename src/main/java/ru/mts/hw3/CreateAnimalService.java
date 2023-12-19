package ru.mts.hw3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public interface CreateAnimalService {
    default Set<Animal> createUniqueAnimals() {
        Set<Animal> uniqueAnimals = new HashSet<>();

        int count = 0;
        while (count < 10) {
            Animal animal;
            if (count % 4 == 0) {
                animal = new Dog("Labrador", "Dog" + count, BigDecimal.valueOf(200).setScale(2, RoundingMode.HALF_UP), "Friendly");
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
        }

        return uniqueAnimals;
    }
}


