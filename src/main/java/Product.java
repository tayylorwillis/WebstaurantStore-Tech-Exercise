import java.math.BigDecimal; // using over float or double for the currency

public class Product {

    private String name;
    private int id;
    private BigDecimal price;
    private int quantity;

    public Product(String name, int id, BigDecimal price, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    // --------getters--------
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // --------setters--------
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // needed for displaying inventory
    @Override
    public String toString() {
        return "Product Name: " + name + ", ID: " + id + ", Price: $" + price + ", Quantity: " + quantity;
    }

}
