import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.math.BigDecimal;


public class UnitTests {

    private StoreInventory store;

    @BeforeEach
    public void setUp() {
        store = new StoreInventory();
    }

    @Test
    @DisplayName("Adding 'Laptop' to the inventory")
    public void testAddProduct() {
        Product product = new Product("Laptop", 101, new BigDecimal("999.99"), 5);
        store.addProduct(product);
        List<Product> inventory = store.viewInventory();

        assertEquals(1, inventory.size());
        assertEquals("Laptop", inventory.get(0).getName());
        assertEquals(101, inventory.get(0).getId());
    }

    @Test
    @DisplayName("Removing 'Laptop'")
    public void testRemoveProduct() {
        Product product1 = new Product("Laptop", 101, new BigDecimal("999.99"), 5);
        Product product2 = new Product("Smartphone", 102, new BigDecimal("499.99"), 10);
        store.addProduct(product1);
        store.addProduct(product2);
        store.removeProduct(101);
        List<Product> inventory = store.viewInventory();

        assertEquals(1, inventory.size());
        assertEquals(102, inventory.get(0).getId());
    }

    @Test
    @DisplayName("Updating 'Laptop' quantity")
    public void testUpdateQuantity() {
        Product product = new Product("Laptop", 101, new BigDecimal("999.99"), 5);
        store.addProduct(product);
        store.updateQuantity(101, 3);
        List<Product> inventory = store.viewInventory();

        assertEquals(3, inventory.get(0).getQuantity());
    }

    @Test
    @DisplayName("Viewing inventory")
    public void testViewInventory() {
        Product product1 = new Product("Laptop", 101, new BigDecimal("999.99"), 5);
        Product product2 = new Product("Smartphone", 102, new BigDecimal("499.99"), 10);
        store.addProduct(product1);
        store.addProduct(product2);
        List<Product> inventory = store.viewInventory();

        assertEquals(2, inventory.size());
        assertEquals("Laptop", inventory.get(0).getName());
        assertEquals("Smartphone", inventory.get(1).getName());
    }

    @Test
    @DisplayName("Displaying total value of inventory")
    public void testDisplayTotalValue() {
        Product product1 = new Product("Laptop", 101, new BigDecimal("999.99"), 5);
        Product product2 = new Product("Smartphone", 102, new BigDecimal("499.99"), 10);
        store.addProduct(product1);
        store.addProduct(product2);
        BigDecimal value = store.displayTotalValue();
        BigDecimal expectedValue = new BigDecimal("999.99").multiply(new BigDecimal(5))
                .add(new BigDecimal("499.99").multiply(new BigDecimal(10)));

        assertEquals(expectedValue, value);
    }
}
