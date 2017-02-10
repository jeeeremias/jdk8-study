package com.study.java.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.study.java.utils.enums.Color;
import com.study.java.models.Car;
import com.study.java.models.VolkswagenCar;

public class CarOperations {

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
    public List<VolkswagenCar> filterByBrandAndMapWithStreamAndLambda(List<Car> cars, String brand) {
        return cars
                .stream()
                .filter(car -> car.brand().equals(brand))
                .map(car -> new VolkswagenCar(car))
                .collect(Collectors.toList());
    }

    /**
     * Filtering an array of complex objects using Stream API,
     * lambda for predicate and Function Reference for mapper
     * and mapping it to a different type complex objects array
     * Type of comps: String (non-primitive)
     */
    public List<VolkswagenCar> filterByBrandAndMapWithStreamAndFunctionRef(List<Car> cars, String brand) {
        return cars
                .stream()
                .filter(car -> car.brand().equals(brand))
                .map(VolkswagenCar::new)
                .collect(Collectors.toList());
    }

    /**
     * Count the amount of complex objects in an array
     * using Stream API and lambda for predicate
     * Type of comps: String (non-primitive)
     */
    public long countBrandWithStreamAndFunctionRef(List<Car> cars, String brand) {
        return cars
                .stream()
                .filter(car -> car.brand().equals(brand))
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
     * Sort all elements in array by models, filter by
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
