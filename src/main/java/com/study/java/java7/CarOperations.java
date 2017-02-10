package com.study.java.java7;

import com.study.java.utils.enums.Color;
import com.study.java.models.Car;
import com.study.java.models.VolkswagenCar;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarOperations {

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
}
