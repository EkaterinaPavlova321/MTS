package ru.mts.hw4;

import java.util.*;

public class SearchServiceImpl implements SearchService{

    /**
     * Метод, который находит всех животных, рожденных
     * в високосный год
     */
    @Override
    public String[] findLeapYearNames(Animal[] animals) {
        List<Animal> trueAnimals = new ArrayList<Animal>(); //список с животными, у которых день рождение в високосный год
        for (int i =0; i < animals.length; i++){
            if (animals[i].getBirthDate().getYear() % 4 == 0){
                trueAnimals.add(animals[i]);
            }
        }
        int lenght = trueAnimals.size();
        String[] animalsName = new String[lenght];//Массив, в котором имена тех животных, у которых дни рождения в високосный год
        for (int i = 0; i < lenght; i++){
            animalsName[i] = trueAnimals.get(i).getName();
        }

        for (int i = 0; i < lenght; i++){
            System.out.println(animalsName[i]);
        }
        return animalsName;
    }


    /**
     * Метод, который ныходит животных, которые старше
     * возраста, поступающего на вход
     */
    @Override
    public Animal[] findOlderAnimal(Animal[] animals, int n) {
        List<Animal> trueAnimals = new ArrayList<Animal>();

        for (int i = 0; i < animals.length; i++){
            if((2023 - animals[i].getBirthDate().getYear()) > n){
                trueAnimals.add(animals[i]);
            }
        }

        Animal[] olderAnimals = new Animal[trueAnimals.size()];
        for (int i = 0; i < trueAnimals.size(); i++){
            olderAnimals[i] = trueAnimals.get(i);
        }

        for ( int i = 0; i < olderAnimals.length; i++){
            System.out.println(olderAnimals[i].getBirthDate().getYear());
        }
        return olderAnimals;
    }

    /**
     * Метод, которй выводит на экран дубликаты животных
     */
    @Override
    public void findDuplicate(Animal[] animals) {
        Map<Animal, Integer> animalCount = new HashMap<>();

        // Подсчитываем количество каждого животного
        for (Animal animal : animals) {
            animalCount.put(animal, animalCount.getOrDefault(animal, 0) + 1);
        }

        // Выводим дубликаты (если их количество больше 1)
        boolean foundDuplicates = false;
        for (Map.Entry<Animal, Integer> entry : animalCount.entrySet()) {
            if (entry.getValue() > 1) {
                foundDuplicates = true;
                System.out.println("Дубликат: " + entry.getKey() + ", количество: " + entry.getValue());
            }
        }

        if (!foundDuplicates) {
            System.out.println("Дубликаты животных не найдены");
        }
    }

}
