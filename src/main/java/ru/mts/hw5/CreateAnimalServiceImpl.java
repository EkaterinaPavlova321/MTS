package ru.mts.hw5;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    // Перегруженный метод для создания N животных с использованием цикла for
    public Animal[] createAnimals(int numberOfAnimals){
        Animal[] animals = new Animal[10];


        for (int i = 0; i < numberOfAnimals; i++){
            int breedIndex = random.nextInt(3);
            int nameIndex = random.nextInt(10);
            int charactersIndex = random.nextInt(5);
            int animalIndex = random.nextInt(4);


            Animal animal;

            switch (AnimalType.values()[animalIndex]) {

                case DOG:
                    animals[i] = new Dog(dogBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(200).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;
                case CAT:
                    animals[i] = new Cat(catBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;
                case WOLF:
                    animals[i] = new Wolf(wolfBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;
                case SHARK:
                    animals[i] = new Shark(sharkBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(3000).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;

            }
            System.out.println("Created: " + animals[i].getBreed() + " - " + animals[i].getName() + ", cost = " + animals[i].getCost() + ", dateBith: " + animals[i].getBirthDate());
        }

        return animals;
    }
    // Переопределенный метод для создания 10 уникальных животных с использованием цикла do-while
    @Override
    public Animal[] createUniqueAnimals() {
        Animal[] animals = new Animal[10];
        int count = 0;
        do {

            int breedIndex = random.nextInt(3);
            int nameIndex = random.nextInt(10);
            int charactersIndex = random.nextInt(5);
            int animalIndex = random.nextInt(4);


            Animal animal;

            switch (AnimalType.values()[animalIndex]) {

                case DOG:
                    animals[count] = new Dog(dogBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(200).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;
                case CAT:
                    animals[count] = new Cat(catBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;
                case WOLF:
                    animals[count] = new Wolf(wolfBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;
                case SHARK:
                    animals[count] = new Shark(sharkBreeds[breedIndex], names[nameIndex], BigDecimal.valueOf(3000).setScale(2, RoundingMode.HALF_UP), characters[charactersIndex], RandomDate.dateGenerator());
                    break;

            }
            System.out.println("Created: " + animals[count].getBreed() + " - " + animals[count].getName() + " cost = " + animals[count].getCost() + ", dateBith: " + animals[count].getBirthDate());
            count++;
        } while (count < 10);
        return animals;
    }
}
