package com.study.java8;

import com.study.java8.model.Car;
import com.study.java8.model.VolkswagenCar;
import com.study.java8.utils.MockGenerator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Operations {
    private static List<Car> cars;
    private static List<VolkswagenCar> volkswagenCars;

    public static void main(String... args) {
        resetArray();
        orderByCarIdWithCollectionsAnonymousFunction(true);
        resetArray();
        orderByCarIdWithCollectionsLambda(true);
        resetArray();
        orderByCarIdWithStream(true);
        resetArray();
        orderByCarModelWithCollections(true);
        resetArray();
        orderByCarModelWithStream(true);
        resetArray();
        filterByCarSpeedHigherThan130WithStreamAndLambda();
        resetArray();
        filterByCarSpeedHigherThan130WithStream();
        resetArray();
        filterByCarSpeedHigherThan130WithStream();
        resetArray();
        filterByBrandWithStreamAndLambda("Volkswagen");
        resetArray();
        filterByBrandVolkswagenAndMapWithStreamAndLambda();
        resetArray();
        filterByBrandVolkswagenAndMapWithStreamAndFunctionRef();
    }

    private static void resetArray() {
        cars = MockGenerator.generateCars(100000);
    }

    private static void printAll() {
        System.out.print("Printing all cars");
        cars.forEach(car -> System.out.println(car.getId() +
                " - " + car.brand() + " " + car.model() + ","));
        System.out.println("Printed: " + cars.size() + " elements");
    }

    /**
     * Ordering an array of complex objects using Collections.sort
     * and anonymous function for comparator.
     * Type of comps: int (primitive)
     */
    private static void orderByCarIdWithCollectionsAnonymousFunction(boolean desc) {
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return desc
                        ? o2.getId() - o1.getId()
                        : o1.getId() - o2.getId();
            }
        });
    }

    /**
     * Ordering an array of complex objects using Collections.sort
     * and lambda for comparator.
     * With one line command we can perform a sort.
     * Type of comps: int (primitive)
     */
    private static void orderByCarIdWithCollectionsLambda(boolean desc) {
            Collections.sort(cars, (Car car0, Car car1) -> desc
                    ? car0.getId() - car1.getId()
                    : car1.getId() - car0.getId());
    }

    /**
     * Ordering an array of complex objects using Stream API
     * Type of comps: int (primitive)
     */
    private static void orderByCarIdWithStream(boolean desc) {
        if (desc)
            cars = cars
                    .stream()
                    .sorted(Comparator.comparingInt(Car::getId))
                    .collect(Collectors.toList());
        else
            cars = cars
                    .stream()
                    .sorted(Comparator.comparingInt(Car::getId).reversed())
                    .collect(Collectors.toList());
    }

    /**
     * Ordering an array of complex objects using Collections.sort
     * and lambda for comparator.
     * Type of comps: String (non-primitive)
     */
    private static void orderByCarModelWithCollections(boolean desc) {
        Collections.sort(cars, (Car o1, Car o2) -> desc
                            ? o2.model().compareToIgnoreCase(o1.model())
                            : o1.model().compareToIgnoreCase(o2.model()));
    }

    /**
     * Ordering an array of complex objects using Stream API
     * Type of comps: String (non-primitive)
     */
    private static void orderByCarModelWithStream(boolean desc) {
            cars =  desc
                    ? cars
                    .stream()
                    .sorted(Comparator.comparing(Car::model, String.CASE_INSENSITIVE_ORDER))
                    .collect(Collectors.toList())
                    : cars
                    .stream()
                    .sorted(Comparator.comparing(Car::model, String.CASE_INSENSITIVE_ORDER).reversed())
                    .collect(Collectors.toList());
    }

    /**
     * Filtering an array of complex objects using Stream API
     * and anonymous function for predicate
     * Type of comps: int (primitive)
     */
    private static void filterByCarSpeedHigherThan130WithStream() {
        cars = cars
                .stream()
                .filter(new Predicate<Car>() {
                    @Override
                    public boolean test(Car car) {
                        return car.maxSpeed() > 130;
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * Filtering an array of complex objects using Stream API
     * and lambda for predicate
     * Type of comps: int (primitive)
     */
    private static void filterByCarSpeedHigherThan130WithStreamAndLambda() {
        cars = cars
                .stream()
                .filter(car -> car.maxSpeed() > 130)
                .collect(Collectors.toList());
    }

    /**
     * Filtering an array of complex objects using Stream API
     * and lambda for predicate
     * Type of comps: String (non-primitive)
     */
    private static void filterByBrandWithStreamAndLambda(String brand) {
        cars = cars
                .stream()
                .filter(car -> car.brand().contains(brand))
                .collect(Collectors.toList());
    }

    /**
     * Filtering an array of complex objects using Stream API
     * and lambda for predicate and mapping it to a
     * different type complex objects array
     * Type of comps: String (non-primitive)
     */
    private static void filterByBrandVolkswagenAndMapWithStreamAndLambda() {
        volkswagenCars = cars
                .stream()
                .filter(car -> car.brand().equals("Volkswagen"))
                .map(car -> new VolkswagenCar(car))
                .collect(Collectors.toList());
    }

    /**
     * Filtering an array of complex objects using Stream API,
     * lambda for predicate and Function Reference for mapper
     * and mapping it to a different type complex objects array
     * Type of comps: String (non-primitive)
     */
    private static void filterByBrandVolkswagenAndMapWithStreamAndFunctionRef() {
        volkswagenCars = cars
                .stream()
                .filter(car -> car.brand().equals("Volkswagen"))
                .map(VolkswagenCar::new)
                .collect(Collectors.toList());
    }
}
