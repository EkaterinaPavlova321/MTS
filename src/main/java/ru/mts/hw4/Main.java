package ru.mts.hw4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl serviceImpl = new CreateAnimalServiceImpl();
        serviceImpl.createAnimals(5);
        serviceImpl.createUniqueAnimals();


        Dog dog1 = new Dog("Labrador", "Tom", BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(2000,4,7));
        Cat cat1 = new Cat("Siamskay", "Milan", BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(2003,4,7));
        Wolf wolf1 = new Wolf("Gray", "Sam", BigDecimal.valueOf(352).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(1996,4,7));
        Dog dog2 = new Dog("Labrador", "Tom", BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(2000,4,7));
        Dog dog3 = new Dog("Labrador", "Tom", BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(2000,4,7));


        Animal[] animals = {dog1, cat1, wolf1,dog2, dog3};

        SearchServiceImpl searchService = new SearchServiceImpl();

        System.out.println("Список имен животных, рожденных в високосный год:");
        searchService.findLeapYearNames(animals);

        System.out.println("Года рождения животноных, которые старше возраста на входе");
        searchService.findOlderAnimal(animals, 24);

        searchService.findDuplicate(animals);


    }
}