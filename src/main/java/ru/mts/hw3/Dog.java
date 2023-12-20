package ru.mts.hw3;

import java.math.BigDecimal;

public class Dog extends Pet{
    public Dog(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
    }
}
