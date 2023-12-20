package ru.mts.hw3;

import java.math.BigDecimal;

public class Shark extends Predator{

    public Shark(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
    }
}
