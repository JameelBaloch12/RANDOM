// Order.java
import java.time.LocalDateTime;
import java.util.Arrays;

public class Order {
    public enum Status { PENDING, SHIPPED }

    private final String orderId;
    private final String customerName;
    private final String[] productIds;
    private Status status;
    private final LocalDateTime createdAt;

    public Order(String orderId, String customerName, String[] productIds) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productIds = productIds;
        this.status = Status.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String[] getProductIds() { return productIds; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "Order{id='" + orderId + "', customer='" + customerName + "', items=" +
                Arrays.toString(productIds) + ", status=" + status + ", createdAt=" + createdAt + "}";
    }
}
