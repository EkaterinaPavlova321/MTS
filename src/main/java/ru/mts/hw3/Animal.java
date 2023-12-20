package ru.mts.hw3;

import java.math.BigDecimal;

public interface Animal {

    /**
     *Метод для получения поля Breed
     */
    String getBreed();

    /**
     *Метод для получения поля Name
     */
    String getName();

    /**
     *Метод для получения поля Cost
     */
    BigDecimal getCost();

    /**
     *Метод для получения поля Character
     */
    String getCharacter();

}