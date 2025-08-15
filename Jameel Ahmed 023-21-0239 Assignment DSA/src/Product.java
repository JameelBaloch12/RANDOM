// Product.java
public class Product {
    private final String id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;

    public Product(String id, String name, String description, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }
    public void addStock(int qty) { this.stockQuantity += qty; }

    public void reduceStock(int qty) {
        if (qty <= stockQuantity) {
            stockQuantity -= qty;
        }
    }

    @Override
    public String toString() {
        return "Product{id='" + id + "', name='" + name + "', price=" + price + ", stock=" + stockQuantity + "}";
    }
}
