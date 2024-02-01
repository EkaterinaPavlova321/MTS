package ru.mts.hw5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
//import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class TestMain {
    @Nested
    class AbstractAnimalTest {
        private final Cat cat1 = new Cat("Bengal", "Vasa", BigDecimal.valueOf(6000), "Friendly", LocalDate.of(2024, 7, 17));
        private final Cat cat2 = new Cat("Bengal", "Vasa", BigDecimal.valueOf(6000), "Friendly", LocalDate.of(2024, 7, 17));
        private final Cat cat3 = new Cat("Siamese", "Chipa", BigDecimal.valueOf(5000), "Kind", LocalDate.of(2010, 3, 10));


        @org.junit.jupiter.api.Test
        @DisplayName("Тест на проверку метода equals")
        void testEquals() {


            assertTrue(cat1.equals(cat2));

            assertFalse(cat1.equals(cat3));
        }

        @Test
        @DisplayName("Тест на рефлексивность метода equals")
        public void testEqualsReflexive() {

            // Проверяем рефлексивность (объект должен быть равен самому себе)
            assertTrue(cat1.equals(cat1));
        }

        @Test
        @DisplayName("Тест на симметричность метода equals")
        public void testEqualsSymmetric() {

            // Проверяем симметричность (если A равно B, то B должно быть равно A)
            assertTrue(cat1.equals(cat2));
            assertTrue(cat2.equals(cat1));
        }

        @Test
        @DisplayName("Тест на транзитивность метода equals")
        public void testEqualsTransitive() {
            Cat cat4 = new Cat("Bengal", "Vasa", BigDecimal.valueOf(6000), "Friendly", LocalDate.of(2024, 7, 17));
            Cat cat5 = new Cat("Bengal", "Vasa", BigDecimal.valueOf(6000), "Friendly", LocalDate.of(2024, 7, 17));
            Cat cat6 = new Cat("Bengal", "Vasa", BigDecimal.valueOf(6000), "Friendly", LocalDate.of(2024, 7, 17));

            // Проверяем транзитивность (если A равно B и B равно C, то A должно быть равно C)
            assertTrue(cat4.equals(cat5));
            assertTrue(cat5.equals(cat6));
            assertTrue(cat4.equals(cat6));
        }


        @Test
        @DisplayName("Тест на консистентность метода equals")
        public void testEqualsConsistent() {

            // Проверяем консистентность (повторный вызов должен давать тот же результат)
            assertTrue(cat1.equals(cat2));
            assertTrue(cat1.equals(cat2));
            assertTrue(cat1.equals(cat2));
        }

        @Test
        @DisplayName("Тест на непустой объект метода equals")
        public void testEqualsWithNull() {

            // Проверяем, что объект не равен null
            assertFalse(cat1.equals(null));
        }

    }

    @Nested
    class SearchServiceImplTest {

        @Test
        @DisplayName("Тест метода findLeapYearNames в классе SearchServicesImpl")
        void testFindLeapYearNames() {
            SearchServiceImpl searchService = new SearchServiceImpl();
            Cat cat1 = new Cat("Bengal", "Vasa", BigDecimal.valueOf(2000), "Friendly", LocalDate.of(2000, 7, 17));
            Wolf wolf = new Wolf("White", "Bob", BigDecimal.valueOf(6000), "Angry", LocalDate.of(2001, 7, 17));
            Dog dog1 = new Dog("German", "Tom", BigDecimal.valueOf(3000), "Kind", LocalDate.of(2003, 9, 6));
            Dog dog2 = new Dog("Bksdv", "Sam", BigDecimal.valueOf(3000), "Lazy", LocalDate.of(2004, 5, 11));

            Animal[] animals = {cat1, wolf, dog1, dog2};

            String[] leapYearNames = searchService.findLeapYearNames(animals);
            assertArrayEquals(new String[]{"Vasa", "Sam"}, leapYearNames);
        }

        @Test
        @ParameterizedTest
        @ValueSource(ints = {24, 30})
        @DisplayName("Тест метода findOlderAnimal в классе SearchServicesImpl")
        void testFindOlderAnimal(int age) {
            SearchServiceImpl searchService = new SearchServiceImpl();
            Dog dog1 = new Dog("Labrador", "Tom", BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(2000, 4, 7));
            Cat cat1 = new Cat("Siamskay", "Milan", BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(2003, 4, 7));
            Wolf wolf1 = new Wolf("Gray", "Sam", BigDecimal.valueOf(352).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(1996, 4, 7));
            Dog dog2 = new Dog("Labrador", "Tom", BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(1981, 4, 7));
            Dog dog3 = new Dog("Labrador", "Tom", BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(2000, 4, 7));
            Animal[] animals = {dog1, cat1, wolf1, dog2, dog3};

            Animal[] result = searchService.findOlderAnimal(animals, age);


            for (int i = 0; i < result.length; i++) {
                assertTrue((LocalDate.now().getYear() - animals[i].getBirthDate().getYear()) > age);
            }

        }

        @Test
        @DisplayName("Тест метода findDuplicate в классе SearchServicesImpl")
        void testFindDuplicate() {
            Dog dog1 = new Dog("Labrador", "Tom", BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(2000, 4, 7));
            Cat cat1 = new Cat("Siamskay", "Milan", BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(2003, 4, 7));
            Wolf wolf1 = new Wolf("Gray", "Sam", BigDecimal.valueOf(352).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(1996, 4, 7));
            Dog dog3 = new Dog("Labrador", "Tom", BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(2000, 4, 7));
            Animal[] animals = {dog1, cat1, wolf1, dog3};

            Map<Animal, Integer> expectedCount = new HashMap<>();
            expectedCount.put(new Dog("Labrador", "Tom", BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(2000, 4, 7)), 2);
            expectedCount.put(new Cat("Siamskay", "Milan", BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(2003, 4, 7)), 1);
            expectedCount.put(new Wolf("Gray", "Sam", BigDecimal.valueOf(352).setScale(2, RoundingMode.HALF_UP), "kind", LocalDate.of(1996, 4, 7)), 1);

            SearchServiceImpl animalServiceImpl = new SearchServiceImpl();

            Map<Animal, Integer> result = animalServiceImpl.findDuplicate(animals);

            assertEquals(expectedCount, result);
        }

    }
}
