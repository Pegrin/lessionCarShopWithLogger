package CarShop;

import models.Car;
import models.Order;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sa on 13.02.17.
 */
class StoreTest {
    static Store store;

    @BeforeAll
    public static void InitStore(){
        store = new Store();
        assertNotNull(store);
    }

    @org.junit.jupiter.api.Test
    void createCar() {
        //Car car = new Car(100, "Lada", "ABC");
        Store store = new Store();
        store.createCar(100, "Lada", "ABC");

        assertNotNull(store.getFreeCars());
        assertTrue(store.getFreeCars().size() > 0);

        store.getFreeCars().stream().forEach((car1) -> {
            assertEquals(car1.getPrice(), 100);
            assertEquals(car1.getModel(), "Lada");
            assertEquals(car1.getRegNum(), "ABC");
        }
        );
    }

    @org.junit.jupiter.api.Test
    void save() {

    }

    @org.junit.jupiter.api.Test
    void recover() {

    }

    @org.junit.jupiter.api.Test
    void getFirstOrder() {
        Store store = new Store();
        assertNotNull(store);
    }

    @org.junit.jupiter.api.Test
    void sellCar() throws CarNotFoundException {
        Store store = new Store();

        assertThrows(CarNotFoundException.class, () -> store.sellCar("2","2",
                "2","2"));

        store.createCar(100, "Lada", "ABC");
        store.sellCar("Lada", "Ivan", "vasa", "1215");

        assertTrue(store.getFreeCars().size() == 0);

        assertTrue(store.getOrders().stream().filter((order) -> order.getCar()
                .getModel
                ().equals("Lada") && (order.getCar().getPrice() == 100)
        && (order.getCar().getRegNum().equals("ABC"))).count() > 0);
        assertTrue(store.getContractList().size() == 1);
        assertTrue(store.getContractList().values().stream().filter(
                (client) -> client.getFirstName().equals("Ivan") &&
        client.getLastName().equals("vasa") && client.getPhoneNumber().equals
                        ("1215")).count() == 1);
    }

    @org.junit.jupiter.api.Test
    void getContractList(){
        Store store = new Store();
        assertNotNull(store.getContractList());
        assertTrue(store.getContractList().size() == 0);
    }

    @org.junit.jupiter.api.Test
    void getOrders() {

    }

    @org.junit.jupiter.api.Test
    void getFreeCars() {

    }

}