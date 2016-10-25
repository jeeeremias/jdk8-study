package com.study.java8;

import com.study.java8.enums.Color;
import com.study.java8.model.Car;
import com.study.java8.model.VolkswagenCar;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarOperationUtils {

    /**
     * Order an array of Cars using Collections.sort
     * and anonymous function for comparator.
     * Type of comps: int (primitive)
     *
     * @param cars list of cars.
     * @param desc boolean if descending or not.
     *
     * @return List of cars ordered by Id
     */
    public List<Car> orderByCarIdWithCollectionsAnonymousFunction(List<Car> cars, boolean desc) {
        List<Car> orderedCars = new ArrayList<>(cars);
        Collections.sort(orderedCars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return desc
                        ? o2.getId() - o1.getId()
                        : o1.getId() - o2.getId();
            }
        });
        return orderedCars;
    }

    /**
     * Ordering an array of complex objects using Collections.sort
     * and lambda for comparator.
     * With one line command we can perform a sort.
     * Type of comps: int (primitive)
     */
    public List<Car> orderByCarIdWithCollectionsLambda(List<Car> cars, boolean desc) {
            Collections.sort(cars, (Car car0, Car car1) -> desc
                    ? car0.getId() - car1.getId()
                    : car1.getId() - car0.getId());
        return cars;
    }

    /**
     * Ordering an array of complex objects using Stream API
     * Type of comps: int (primitive)
     */
    public List<Car> orderByCarIdWithStream(List<Car> cars, boolean desc) {
        if (desc)
            return cars
                    .stream()
                    .sorted(Comparator.comparingInt(Car::getId))
                    .collect(Collectors.toList());
        else
            return cars
                    .stream()
                    .sorted(Comparator.comparingInt(Car::getId).reversed())
                    .collect(Collectors.toList());
    }

    /**
     * Ordering an array of complex objects using Collections.sort
     * and lambda for comparator.
     * Type of comps: String (non-primitive)
     */
    public List<Car> orderByCarModelWithCollections(List<Car> cars, boolean desc) {
        Collections.sort(cars, (Car o1, Car o2) -> desc
                            ? o2.model().compareToIgnoreCase(o1.model())
                            : o1.model().compareToIgnoreCase(o2.model()));
        return cars;
    }

    /**
     * Ordering an array of complex objects using Stream API
     * Type of comps: String (non-primitive)
     */
    public List<Car> orderByCarModelWithStream(List<Car> cars, boolean desc) {
            return desc
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
    public List<Car> filterByCarSpeedHigherThan130WithStream(List<Car> cars) {
        return cars
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
    public List<Car> filterByCarSpeedHigherThan130WithStreamAndLambda(List<Car> cars) {
        return cars
                .stream()
                .filter(car -> car.maxSpeed() > 130)
                .collect(Collectors.toList());
    }

    /**
     * Filtering an array of complex objects using Stream API
     * and lambda for predicate
     * Type of comps: String (non-primitive)
     */
    public List<Car> filterByBrandWithStreamAndLambda(List<Car> cars, String brand) {
        return cars
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
    public List<VolkswagenCar> filterByBrandVolkswagenAndMapWithStreamAndLambda(List<Car> cars) {
        return cars
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
    public List<VolkswagenCar> filterByBrandVolkswagenAndMapWithStreamAndFunctionRef(List<Car> cars) {
        return cars
                .stream()
                .filter(car -> car.brand().equals("Volkswagen"))
                .map(VolkswagenCar::new)
                .collect(Collectors.toList());
    }

    /**
     * Count the amount of complex objects in an array
     * using Stream API and lambda for predicate
     * Type of comps: String (non-primitive)
     */
    public long countBrandWithStreamAndFunctionRef(List<Car> cars) {
        return cars
                .stream()
                .filter(car -> car.brand().equals("Volkswagen"))
                .count();
    }

    /**
     * Group all elements in array by brand
     * using Stream API and method reference
     * Type of comps: String (non-primitive)
     */
    public Map<String, List<Car>> groupByBrandWithStreamAndFunctionRef(List<Car> cars) {
        return cars
                .stream()
                .collect(Collectors.groupingBy(Car::brand));
    }

    /**
     * Sort all elements in array by model, filter by
     * color YELLOW and print the ID using Stream API
     * Type of comps: String (non-primitive)
     */
    public void sortByModelAndFilerByColorAndPrintIdWithStream(List<Car> cars) {
        cars
                .stream()
                .sorted(Comparator.comparing(Car::model))
                .filter(car -> car.color().equals(Color.YELLOW))
                .forEach(car -> System.out.println(car.getId() + ", "));
    }

    /**
     * Average of maxSpeed
     * Type of comps: int (primitive)
     */
    public double averageOfMaxSpeed(List<Car> cars) {
        return cars
                .stream()
                .mapToInt(Car::maxSpeed)
                .average()
                .getAsDouble();
    }
}
