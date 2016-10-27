import com.study.java8.streams.CarOperationUtils;
import com.study.java8.streams.model.Car;
import com.study.java8.streams.utils.MockGenerator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class OperationsTest {
    private List<Car> carsTemp;
    private static List<Car> cars;
    private static final int size = 100000;
    private static CarOperationUtils carUtils;

    @BeforeClass
    public static void init() {
        cars = MockGenerator.generateCars(size);
        assertNotNull(cars);
        assertTrue("Size should be equals or higher than " + size, cars.size() >= size);
        carUtils = new CarOperationUtils();
    }

    @Test
    public void orderByIdTest() {
        int prevId;

        carsTemp = carUtils.orderByCarIdWithCollectionsAnonymousFunction(cars, false);
        prevId = carsTemp.get(0).getId() - 1;
        for (Car car : carsTemp) {
            assertTrue(car.getId() > prevId);
        }

        carsTemp = carUtils.orderByCarIdWithCollectionsAnonymousFunction(cars, true);
        prevId = carsTemp.get(0).getId() + 1;
        for (Car car : carsTemp) {
            assertTrue(car.getId() < prevId);
        }
    }
}
