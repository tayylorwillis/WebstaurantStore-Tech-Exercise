import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;


public class StoreInventory {
    private List<Product> inventory;

    public StoreInventory() {
        this.inventory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println("Product added successfully.");
    }

    public void removeProduct(int id) {
        boolean removed = inventory.removeIf(product -> product.getId() == id);

        if (removed) {
            System.out.println("Product with ID " + id + " was removed.");
        }
        else {
            System.out.println("No product with ID " + id + " found.");
        }
    }

    public void updateQuantity(int id, int newQuantity) {
        for (Product product : inventory) {
            if (product.getId() == id) {
                product.setQuantity(newQuantity);
                System.out.println("Updated quantity of product with ID " + id);
                return;
            }
        }
        System.out.println("No product with ID " + id + " found.");
    }

    public List<Product> viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        }
        else {
            for (Product product : inventory) {
                System.out.println(product);
                System.out.println("\n");
            }
        }
        return inventory;
    }

    public BigDecimal displayTotalValue() {
        BigDecimal value = BigDecimal.ZERO; // constant

        for (Product product : inventory) {
            BigDecimal price = product.getPrice();
            BigDecimal quantity = new BigDecimal(product.getQuantity());

            value = value.add(price.multiply(quantity));
        }

        System.out.println("Total inventory value: $" + value);
        return value;
    }
}
