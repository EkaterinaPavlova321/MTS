package ru.mts.hw3;

import java.math.BigDecimal;

public class Cat extends Pet{
    public Cat(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
    }
}