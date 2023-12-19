package ru.mts.hw3;

import java.math.BigDecimal;

public abstract class AbstractAnimal implements Animal{
    protected String breed;
    protected String name;
    protected BigDecimal cost;
    protected String character;

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }
}
