[1mdiff --git a/.idea/misc.xml b/.idea/misc.xml[m
[1mindex 9793229..605816e 100644[m
[1m--- a/.idea/misc.xml[m
[1m+++ b/.idea/misc.xml[m
[36m@@ -1,5 +1,15 @@[m
 <?xml version="1.0" encoding="UTF-8"?>[m
 <project version="4">[m
[32m+[m[32m  <component name="EclipseCodeFormatter">[m
[32m+[m[32m    <option name="defaultSettings" value="true" />[m
[32m+[m[32m    <option name="formatOtherFileTypesWithIntelliJ" value="false" />[m
[32m+[m[32m    <option name="formatSeletedTextInAllFileTypes" value="false" />[m
[32m+[m[32m    <option name="formatter" value="ECLIPSE" />[m
[32m+[m[32m    <option name="id" value="1477487201913" />[m
[32m+[m[32m    <option name="name" value="default" />[m
[32m+[m[32m    <option name="pathToConfigFileJava" value="$USER_HOME$/workspace/pagseguro/conf/dev/uol-formatter.xml" />[m
[32m+[m[32m    <option name="selectedJavaProfile" value="UOL - Java Conventions" />[m
[32m+[m[32m  </component>[m
   <component name="EntryPointsManager">[m
     <entry_points version="2.0" />[m
   </component>[m
[1mdiff --git a/src/main/java/com/study/java8/CarOperationUtils.java b/src/main/java/com/study/java8/CarOperationUtils.java[m
[1mdeleted file mode 100644[m
[1mindex 55b808e..0000000[m
[1m--- a/src/main/java/com/study/java8/CarOperationUtils.java[m
[1m+++ /dev/null[m
[36m@@ -1,210 +0,0 @@[m
[31m-package com.study.java8;[m
[31m-[m
[31m-import com.study.java8.enums.Color;[m
[31m-import com.study.java8.model.Car;[m
[31m-import com.study.java8.model.VolkswagenCar;[m
[31m-[m
[31m-import java.util.*;[m
[31m-import java.util.function.Predicate;[m
[31m-import java.util.stream.Collectors;[m
[31m-[m
[31m-public class CarOperationUtils {[m
[31m-[m
[31m-    /**[m
[31m-     * Order an array of Cars using Collections.sort[m
[31m-     * and anonymous function for comparator.[m
[31m-     * Type of comps: int (primitive)[m
[31m-     *[m
[31m-     * @param cars list of cars.[m
[31m-     * @param desc boolean if descending or not.[m
[31m-     *[m
[31m-     * @return List of cars ordered by Id[m
[31m-     */[m
[31m-    public List<Car> orderByCarIdWithCollectionsAnonymousFunction(List<Car> cars, boolean desc) {[m
[31m-        List<Car> orderedCars = new ArrayList<>(cars);[m
[31m-        Collections.sort(orderedCars, new Comparator<Car>() {[m
[31m-            @Override[m
[31m-            public int compare(Car o1, Car o2) {[m
[31m-                return desc[m
[31m-                        ? o2.getId() - o1.getId()[m
[31m-                        : o1.getId() - o2.getId();[m
[31m-            }[m
[31m-        });[m
[31m-        return orderedCars;[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Ordering an array of complex objects using Collections.sort[m
[31m-     * and lambda for comparator.[m
[31m-     * With one line command we can perform a sort.[m
[31m-     * Type of comps: int (primitive)[m
[31m-     */[m
[31m-    public List<Car> orderByCarIdWithCollectionsLambda(List<Car> cars, boolean desc) {[m
[31m-            Collections.sort(cars, (Car car0, Car car1) -> desc[m
[31m-                    ? car0.getId() - car1.getId()[m
[31m-                    : car1.getId() - car0.getId());[m
[31m-        return cars;[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Ordering an array of complex objects using Stream API[m
[31m-     * Type of comps: int (primitive)[m
[31m-     */[m
[31m-    public List<Car> orderByCarIdWithStream(List<Car> cars, boolean desc) {[m
[31m-        if (desc)[m
[31m-            return cars[m
[31m-                    .stream()[m
[31m-                    .sorted(Comparator.comparingInt(Car::getId))[m
[31m-                    .collect(Collectors.toList());[m
[31m-        else[m
[31m-            return cars[m
[31m-                    .stream()[m
[31m-                    .sorted(Comparator.comparingInt(Car::getId).reversed())[m
[31m-                    .collect(Collectors.toList());[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Ordering an array of complex objects using Collections.sort[m
[31m-     * and lambda for comparator.[m
[31m-     * Type of comps: String (non-primitive)[m
[31m-     */[m
[31m-    public List<Car> orderByCarModelWithCollections(List<Car> cars, boolean desc) {[m
[31m-        Collections.sort(cars, (Car o1, Car o2) -> desc[m
[31m-                            ? o2.model().compareToIgnoreCase(o1.model())[m
[31m-                            : o1.model().compareToIgnoreCase(o2.model()));[m
[31m-        return cars;[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Ordering an array of complex objects using Stream API[m
[31m-     * Type of comps: String (non-primitive)[m
[31m-     */[m
[31m-    public List<Car> orderByCarModelWithStream(List<Car> cars, boolean desc) {[m
[31m-            return desc[m
[31m-                    ? cars[m
[31m-                    .stream()[m
[31m-                    .sorted(Comparator.comparing(Car::model, String.CASE_INSENSITIVE_ORDER))[m
[31m-                    .collect(Collectors.toList())[m
[31m-                    : cars[m
[31m-                    .stream()[m
[31m-                    .sorted(Comparator.comparing(Car::model, String.CASE_INSENSITIVE_ORDER).reversed())[m
[31m-                    .collect(Collectors.toList());[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Filtering an array of complex objects using Stream API[m
[31m-     * and anonymous function for predicate[m
[31m-     * Type of comps: int (primitive)[m
[31m-     */[m
[31m-    public List<Car> filterByCarSpeedHigherThan130WithStream(List<Car> cars) {[m
[31m-        return cars[m
[31m-                .stream()[m
[31m-                .filter(new Predicate<Car>() {[m
[31m-                    @Override[m
[31m-                    public boolean test(Car car) {[m
[31m-                        return car.maxSpeed() > 130;[m
[31m-                    }[m
[31m-                })[m
[31m-                .collect(Collectors.toList());[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Filtering an array of complex objects using Stream API[m
[31m-     * and lambda for predicate[m
[31m-     * Type of comps: int (primitive)[m
[31m-     */[m
[31m-    public List<Car> filterByCarSpeedHigherThan130WithStreamAndLambda(List<Car> cars) {[m
[31m-        return cars[m
[31m-                .stream()[m
[31m-                .filter(car -> car.maxSpeed() > 130)[m
[31m-                .collect(Collectors.toList());[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Filtering an array of complex objects using Stream API[m
[31m-     * and lambda for predicate[m
[31m-     * Type of comps: String (non-primitive)[m
[31m-     */[m
[31m-    public List<Car> filterByBrandWithStreamAndLambda(List<Car> cars, String brand) {[m
[31m-        return cars[m
[31m-                .stream()[m
[31m-                .filter(car -> car.brand().contains(brand))[m
[31m-                .collect(Collectors.toList());[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Filtering an array of complex objects using Stream API[m
[31m-     * and lambda for predicate and mapping it to a[m
[31m-     * different type complex objects array[m
[31m-     * Type of comps: String (non-primitive)[m
[31m-     */[m
[31m-    public List<VolkswagenCar> filterByBrandVolkswagenAndMapWithStreamAndLambda(List<Car> cars) {[m
[31m-        return cars[m
[31m-                .stream()[m
[31m-                .filter(car -> car.brand().equals("Volkswagen"))[m
[31m-                .map(car -> new VolkswagenCar(car))[m
[31m-                .collect(Collectors.toList());[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Filtering an array of complex objects using Stream API,[m
[31m-     * lambda for predicate and Function Reference for mapper[m
[31m-     * and mapping it to a different type complex objects array[m
[31m-     * Type of comps: String (non-primitive)[m
[31m-     */[m
[31m-    public List<VolkswagenCar> filterByBrandVolkswagenAndMapWithStreamAndFunctionRef(List<Car> cars) {[m
[31m-        return cars[m
[31m-                .stream()[m
[31m-                .filter(car -> car.brand().equals("Volkswagen"))[m
[31m-                .map(VolkswagenCar::new)[m
[31m-                .collect(Collectors.toList());[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Count the amount of complex objects in an array[m
[31m-     * using Stream API and lambda for predicate[m
[31m-     * Type of comps: String (non-primitive)[m
[31m-     */[m
[31m-    public long countBrandWithStreamAndFunctionRef(List<Car> cars) {[m
[31m-        return cars[m
[31m-                .stream()[m
[31m-                .filter(car -> car.brand().equals("Volkswagen"))[m
[31m-                .count();[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Group all elements in array by brand[m
[31m-     * using Stream API and method reference[m
[31m-     * Type of comps: String (non-primitive)[m
[31m-     */[m
[31m-    public Map<String, List<Car>> groupByBrandWithStreamAndFunctionRef(List<Car> cars) {[m
[31m-        return cars[m
[31m-                .stream()[m
[31m-                .collect(Collectors.groupingBy(Car::brand));[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Sort all elements in array by model, filter by[m
[31m-     * color YELLOW and print the ID using Stream API[m
[31m-     * Type of comps: String (non-primitive)[m
[31m-     */[m
[31m-    public void sortByModelAndFilerByColorAndPrintIdWithStream(List<Car> cars) {[m
[31m-        cars[m
[31m-                .stream()[m
[31m-                .sorted(Comparator.comparing(Car::model))[m
[31m-                .filter(car -> car.color().equals(Color.YELLOW))[m
[31m-                .forEach(car -> System.out.println(car.getId() + ", "));[m
[31m-    }[m
[31m-[m
[31m-    /**[m
[31m-     * Average of maxSpeed[m
[31m-     * Type of comps: int (primitive)[m
[31m-     */[m
[31m-    public double averageOfMaxSpeed(List<Car> cars) {[m
[31m-        return cars[m
[31m-                .stream()[m
[31m-                .mapToInt(Car::maxSpeed)[m
[31m-                .average()[m
[31m-                .getAsDouble();[m
[31m-    }[m
[31m-}[m
[1mdiff --git a/src/main/java/com/study/java8/enums/Color.java b/src/main/java/com/study/java8/enums/Color.java[m
[1mdeleted file mode 100644[m
[1mindex 52dccaa..0000000[m
[1m--- a/src/main/java/com/study/java8/enums/Color.java[m
[1m+++ /dev/null[m
[36m@@ -1,13 +0,0 @@[m
[31m-package com.study.java8.enums;[m
[31m-[m
[31m-public enum Color {[m
[31m-    YELLOW,[m
[31m-    BLUE,[m
[31m-    BROWN,[m
[31m-    PINK,[m
[31m-    GREEN;[m
[31m-[m
[31m-    public static int getTotalElements() {[m
[31m-        return values().length;[m
[31m-    }[m
[31m-}[m
[1mdiff --git a/src/main/java/com/study/java8/interfaces/Auto.java b/src/main/java/com/study/java8/interfaces/Auto.java[m
[1mdeleted file mode 100644[m
[1mindex 5cabda2..0000000[m
[1m--- a/src/main/java/com/study/java8/interfaces/Auto.java[m
[1m+++ /dev/null[m
[36m@@ -1,17 +0,0 @@[m
[31m-package com.study.java8.interfaces;[m
[31m-[m
[31m-import com.study.java8.enums.Color;[m
[31m-[m
[31m-public interface Auto {[m
[31m-    int maxSpeed();[m
[31m-    int amountWheels();[m
[31m-    Color color();[m
[31m-    int amountPlaces();[m
[31m-    double weight();[m
[31m-    String brand();[m
[31m-    String model();[m
[31m-    int warrantyYearsPeriod();[m
[31m-    default boolean fly() {[m
[31m-        return false;[m
[31m-    }[m
[31m-}[m
[1mdiff --git a/src/main/java/com/study/java8/model/Airplane.java b/src/main/java/com/study/java8/model/Airplane.java[m
[1mdeleted file mode 100644[m
[1mindex 227f866..0000000[m
[1m--- a/src/main/java/com/study/java8/model/Airplane.java[m
[1m+++ /dev/null[m
[36m@@ -1,92 +0,0 @@[m
[31m-package com.study.java8.model;[m
[31m-[m
[31m-import com.study.java8.interfaces.Auto;[m
[31m-import com.study.java8.enums.Color;[m
[31m-[m
[31m-public class Airplane implements Auto {[m
[31m-    private int maxSpeed;[m
[31m-    private int amountWheels;[m
[31m-    private double weight;[m
[31m-    private Color color;[m
[31m-    private String brand;[m
[31m-    private String model;[m
[31m-    private int places;[m
[31m-    private int warrantyYearsPeriod;[m
[31m-[m
[31m-    @Override[m
[31m-    public int maxSpeed() {[m
[31m-        return 0;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public int amountWheels() {[m
[31m-        return 0;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public Color color() {[m
[31m-        return null;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public int amountPlaces() {[m
[31m-        return 0;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public double weight() {[m
[31m-        return 0;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public String brand() {[m
[31m-        return null;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public String model() {[m
[31m-        return null;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public int warrantyYearsPeriod() {[m
[31m-        return warrantyYearsPeriod;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public boolean fly() {[m
[31m-        return true;[m
[31m-    }[m
[31m-[m
[31m-    public void setMaxSpeed(int maxSpeed) {[m
[31m-        this.maxSpeed = maxSpeed;[m
[31m-    }[m
[31m-[m
[31m-    public void setAmountWheels(int amountWheels) {[m
[31m-        this.amountWheels = amountWheels;[m
[31m-    }[m
[31m-[m
[31m-    public void setWeight(double weight) {[m
[31m-        this.weight = weight;[m
[31m-    }[m
[31m-[m
[31m-    public void setColor(Color color) {[m
[31m-        this.color = color;[m
[31m-    }[m
[31m-[m
[31m-    public void setBrand(String brand) {[m
[31m-        this.brand = brand;[m
[31m-    }[m
[31m-[m
[31m-    public void setModel(String model) {[m
[31m-        this.model = model;[m
[31m-    }[m
[31m-[m
[31m-    public void setPlaces(int places) {[m
[31m-        this.places = places;[m
[31m-    }[m
[31m-[m
[31m-    public void setWarrantyYearsPeriod(int warrantyYearsPeriod) {[m
[31m-        this.warrantyYearsPeriod = warrantyYearsPeriod;[m
[31m-    }[m
[31m-}[m
[1mdiff --git a/src/main/java/com/study/java8/model/Car.java b/src/main/java/com/study/java8/model/Car.java[m
[1mdeleted file mode 100644[m
[1mindex 2d27f85..0000000[m
[1m--- a/src/main/java/com/study/java8/model/Car.java[m
[1m+++ /dev/null[m
[36m@@ -1,73 +0,0 @@[m
[31m-package com.study.java8.model;[m
[31m-[m
[31m-import com.study.java8.interfaces.Auto;[m
[31m-import com.study.java8.enums.Color;[m
[31m-[m
[31m-public class Car implements Auto {[m
[31m-    private int id;[m
[31m-    private int maxSpeed;[m
[31m-    private double weight;[m
[31m-    private Color color;[m
[31m-    private String brand;[m
[31m-    private String model;[m
[31m-    private int warrantyYearsPeriod;[m
[31m-[m
[31m-    public Car(int id, int maxSpeed, double weight, Color color,[m
[31m-               String brand, String model, int warrantyYearsPeriod) {[m
[31m-        this.maxSpeed = maxSpeed;[m
[31m-        this.weight = weight;[m
[31m-        this.color = color;[m
[31m-        this.brand = brand;[m
[31m-        this.model = model;[m
[31m-        this.id = id;[m
[31m-        this.warrantyYearsPeriod = warrantyYearsPeriod;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public int maxSpeed() {[m
[31m-        return maxSpeed;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public int amountWheels() {[m
[31m-        return 4;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public Color color() {[m
[31m-        return color;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public int amountPlaces() {[m
[31m-        return 5;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public double weight() {[m
[31m-        return weight;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public String brand() {[m
[31m-        return brand;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public String model() {[m
[31m-        return model;[m
[31m-    }[m
[31m-[m
[31m-    @Override[m
[31m-    public int warrantyYearsPeriod() {[m
[31m-        return warrantyYearsPeriod;[m
[31m-    }[m
[31m-[m
[31m-    public int getId() {[m
[31m-        return id;[m
[31m-    }[m
[31m-[m
[31m-    public void changeColor(Color newColor) {[m
[31m-        color = newColor;[m
[31m-    }[m
[31m-}[m
[1mdiff --git a/src/main/java/com/study/java8/model/VolkswagenCar.java b/src/main/java/com/study/java8/model/VolkswagenCar.java[m
[1mdeleted file mode 100644[m
[1mindex 4b06b47..0000000[m
[1m--- a/src/main/java/com/study/java8/model/VolkswagenCar.java[m
[1m+++ /dev/null[m
[36m@@ -1,8 +0,0 @@[m
[31m-package com.study.java8.model;[m
[31m-[m
[31m-public class VolkswagenCar extends Car{[m
[31m-    public VolkswagenCar(Car car) {[m
[31m-        super(car.getId(), car.maxSpeed(), car.weight(),[m
[31m-                car.color(), car.brand(), car.model(), 15);[m
[31m-    }[m
[31m-}[m
[1mdiff --git a/src/main/java/com/study/java8/utils/MockGenerator.java b/src/main/java/com/study/java8/utils/MockGenerator.java[m
[1mdeleted file mode 100644[m
[1mindex 458eee5..0000000[m
[1m--- a/src/main/java/com/study/java8/utils/MockGenerator.java[m
[1m+++ /dev/null[m
[36m@@ -1,104 +0,0 @@[m
[31m-package com.study.java8.utils;[m
[31m-[m
[31m-import com.study.java8.enums.Color;[m
[31m-import com.study.java8.model.Car;[m
[31m-[m
[31m-import java.util.*;[m
[31m-[m
[31m-public class MockGenerator {[m
[31m-    private static final String[][] names = {{"Agrale", "Marruá"},[m
[31m-            {"Aston Martin", "DB9 Volante", "DBS Volante", "DBS Coupe", "Rapide", "V12 Vantage Coupe",[m
[31m-                    "V8 Vantage Coupe", "V8 Vantage Roadster", "Virage"},[m
[31m-            {"Audi", "A1", "A3", "A3 Sedan", "A4", "A4 Avant", "A5", "A7", "A8", "Q3", "Q5", "Q7", "R8",[m
[31m-                    "R8 GT", "RS 3 Sportback", "RS 5", "RS6 Avant", "TT Coupé", "TT Roadster"},[m
[31m-            {"Bentley", "Continental Flying Spur", "Continental Supersports Coupé"},[m
[31m-            {"BMW", "Série 1", "Série 1 Cabrio", "Série 1 Coupé", "Série 1 M", "Série 3 Cabrio",[m
[31m-                    "Série 3 M3 Coupé", "Série 3 M3 Sedã", "Série 3 Sedã", "Série 5 Gran Turismo",[m
[31m-                    "Série 5 Sedã", "Série 7 Sedã", "X1", "X3", "X4", "X5", "X6", "Z4 Roadster", "i3"},[m
[31m-            {"Changan", "Chana Cargo", "Chana Family", "Chana Utility"},[m
[31m-            {"Chery", "Celer Hatch", "Celer Sedan", "Cielo Hatch", "Cielo Sedan", "Face", "QQ",[m
[31m-                    "S-18", "Tiggo"},[m
[31m-            {"GM/Chevrolet", "Agile", "Astra Hatch", "Astra Sedan", "Blazer", "Camaro", "Captiva",[m
[31m-                    "Celta", "Classic", "Cobalt", "Corsa Hatch", "Corsa Sedã", "Cruze", "Cruze Sport6",[m
[31m-                    "Malibu", "Meriva", "Montana", "Omega", "Onix", "Prisma", "S10", "Sonic", "Spin",[m
[31m-                    "Tracker", "Trailblazer", "Vectra", "Vectra GT", "Zafira"},[m
[31m-            {"Chrysler", "300C", "Town & Country"},[m
[31m-            {"Citroën", "Aircross", "C3", "C3 Picasso", "C4", "C4 Lounge", "C4 Pallas", "C4 Picasso",[m
[31m-                    "C5", "C5 Tourer", "DS3", "DS5", "Jumper", "Xsara Picasso"},[m
[31m-            {"Dodge", "Durango", "Journey"},[m
[31m-            {"Effa", "Effa Hafei Furgão", "Effa Hafei Picape Baú", "Effa Hafei Picape Cabine Dupla",[m
[31m-                    "Effa Hafei Picape Cabine Simples", "Effa Hafei Van", "Effa M100"},[m
[31m-            {"Ferrari", "458", "California", "F599 GTO"},[m
[31m-            {"Fiat", "500", "500 Abarth", "Bravo", "Doblò", "Doblò Cargo", "Ducato", "Fiat Mobi",[m
[31m-                    "Fiat Toro", "Fiorino", "Freemont", "Grand Siena", "Idea", "Linea", "Mille",[m
[31m-                    "Palio", "Palio Adventure", "Palio Weekend", "Punto", "Siena EL", "Strada", "Uno"},[m
[31m-            {"Ford", "Courier", "EcoSport", "Edge", "F-250", "Fiesta Rocam Hatch", "Fiesta Rocam Sedan",[m
[31m-                    "Focus Fastback", "Focus Hatch", "Fusion", "Ka", "Ka+", "New Fiesta",[m
[31m-                    "New Fiesta Hatch", "Ranger", "Transit"},[m
[31m-            {"Geely", "EC7", "GC2"},[m
[31m-            {"Hafei", "Pick-up", "Towner Furgão", "Towner Jr", "Towner Passageiro"},[m
[31m-            {"Honda", "Accord", "CR-V", "City", "Civic", "Civic Si", "Fit", "HR-V"},[m
[31m-            {"Hyundai", "Azera", "Elantra", "Equus", "HB20", "HB20S", "HB20X", "HR", "Santa Fe",[m
[31m-                    "Sonata", "Tucson", "Veloster", "Veracruz", "i30", "i30 CW", "iX35"},[m
[31m-            {"Iveco", "Daily 35S14"},[m
[31m-            {"Jac Motors", "J2", "J3", "J3 Turin", "J5", "J6", "T5", "T6"},[m
[31m-            {"Jaguar", "F-Pace", "F-Type Coupé", "XE", "XF", "XJ Supersport", "XKR"},[m
[31m-            {"Jeep", "Cherokee", "Compass", "Grand Cherokee", "Jeep Renegade", "Wrangler"},[m
[31m-            {"Jinbei", "Topic Furgão", "Topic Passageiro"},[m
[31m-            {"Kia", "Bongo", "Cadenza", "Carens", "Carnival", "Cerato", "Mohave", "Optima",[m
[31m-                    "Picanto", "Sorento", "Soul", "Sportage"},[m
[31m-            {"Lamborghini", "Gallardo LP 560 - 4", "Gallardo LP 560 - 4 Spyder"},[m
[31m-            {"Land Rover", "Defender", "Discovery 4", "Discovery Sport", "Freelander 2",[m
[31m-                    "Range Rover Evoque", "Range Rover Sport", "Range Rover Vogue"},[m
[31m-            {"Lexus", "NX 200t"},[m
[31m-            {"Lifan", "320", "530", "620", "X60"},[m
[31m-            {"Mahindra", "Mahindra Picape", "Mahindra SUV"},[m
[31m-            {"Maserati", "Ghibli", "Gran Cabrio", "Gran Turismo", "Quattroporte"},[m
[31m-            {"Mercedes-Benz", "CLA", "Classe A", "Classe B", "Classe C", "Classe C 250 Turbo Sport",[m
[31m-                    "Classe C 63 AMG Touring", "Classe CL", "Classe CLS 63 AMG", "Classe E",[m
[31m-                    "Classe G", "Classe GL", "Classe GLK", "Classe M", "Classe S",[m
[31m-                    "Classe S 400 Hybrid", "Classe SLK", "Classe SLS AMG", "GLA", "GLC",[m
[31m-                    "GLC Coupé"},[m
[31m-            {"MG Motors", "MG 550", "MG 6"},[m
[31m-            {"Mini", "Cooper", "Cooper Cabrio", "Cooper Countryman", "Cooper S Clubman-Hampton",[m
[31m-                    "Mini Clubman", "Cooper S Clubman-Hampton", "One"},[m
[31m-            {"Mitsubishi", "ASX", "L200 Outdoor", "L200 Savana", "L200 Triton", "Lancer",[m
[31m-                    "Lancer Evolution X", "Outlander", "Pajero Dakar", "Pajero Full", "Pajero Sport",[m
[31m-                    "Pajero TR4"},[m
[31m-            {"Nissan", "Altima", "Frontier", "Grand Livina", "Kicks", "Livina", "March", "Sentra",[m
[31m-                    "Tiida Hatch", "Tiida Sedan", "Versa"},[m
[31m-            {"Peugeot", "2008", "207", "207 SW", "207 Sedan", "208", "3008", "307", "308", "308 CC",[m
[31m-                    "408", "508", "Boxer", "Hoggar", "Partner", "RCZ"},[m
[31m-            {"Porsche", "911", "Boxster", "Boxster S", "Cayenne", "Cayman", "Cayman S", "Macan",[m
[31m-                    "Panamera"},[m
[31m-            {"Ram", "2500"},[m
[31m-            {"Renault", "Alaskan", "Clio", "Duster", "Fluence", "Grand Tour", "Kangoo Express",[m
[31m-                    "Logan", "Master", "Oroch", "Sandero", "Sandero RS", "Sandero Stepway", "Symbol"},[m
[31m-            {"Smart", "Fortwo MHD", "Fortwo Passion Cabrio", "Fortwo Passion Coupé"},[m
[31m-            {"Ssangyong", "Actyon Sports", "Korando", "Kyron"},[m
[31m-            {"Subaru", "Forester", "Impreza Hatch", "Legacy", "Impreza Sedã", "Outback", "Tribeca"},[m
[31m-            {"Suzuki", "Grand Vitara", "Jimny", "S-Cross", "SX4"},[m
[31m-            {"Toyota", "Camry", "Corolla", "Etios Hatch", "Etios Hatch", "Etios Sedã", "Hilux",[m
[31m-                    "Prius", "RAV4", "SW4"},[m
[31m-            {"Troller", "T4"},[m
[31m-            {"Volkswagen", "Amarok", "Crossfox", "Fox", "Fusca", "Gol", "Gol" ,"Gol G4", "Golf",[m
[31m-                    "Golf Variant", "Jetta", "Jetta Variant", "Kombi", "Parati", "Passat",[m
[31m-                    "Passat Variant", "Polo", "Polo Sedan", "Saveiro", "Space Cross", "SpaceFox",[m
[31m-                    "Tiguan", "Touareg", "Up!", "Voyage"},[m
[31m-            {"Volvo", "C30", "S60", "V40", "XC60", "XC90"}};[m
[31m-[m
[31m-    public static List<Car> generateCars(int amount) {[m
[31m-        List<Car> cars = new ArrayList<>();[m
[31m-        Random r = new Random(1000);[m
[31m-        int id = 0;[m
[31m-        while (cars.size() < amount) {[m
[31m-            for (String[] brand: names) {[m
[31m-                for (int i = 1; i < brand.length; i ++) {[m
[31m-                    cars.add(new Car(id ++, r.nextInt(150) + 200, r.nextDouble(),[m
[31m-                            Color.values()[r.nextInt(Color.getTotalElements())], brand[0], brand[i], 5));[m
[31m-                }[m
[31m-            }[m
[31m-        }[m
[31m-        return cars;[m
[31m-    }[m
[31m-}[m
[1mdiff --git a/src/test/java/OperationsTest.java b/src/test/java/OperationsTest.java[m
[1mindex a11f180..0cfb68a 100644[m
[1m--- a/src/test/java/OperationsTest.java[m
[1m+++ b/src/test/java/OperationsTest.java[m
[36m@@ -1,6 +1,6 @@[m
[31m-import com.study.java8.CarOperationUtils;[m
[31m-import com.study.java8.model.Car;[m
[31m-import com.study.java8.utils.MockGenerator;[m
[32m+[m[32mimport com.study.java8.streams.CarOperationUtils;[m
[32m+[m[32mimport com.study.java8.streams.model.Car;[m
[32m+[m[32mimport com.study.java8.streams.utils.MockGenerator;[m
 import org.junit.BeforeClass;[m
 import org.junit.Test;[m
 [m
