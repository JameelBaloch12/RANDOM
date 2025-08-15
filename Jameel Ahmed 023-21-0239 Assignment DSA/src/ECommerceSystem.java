
public class ECommerceSystem {
    private final ProductHashTable catalog = new ProductHashTable();
    private final OrderQueue orders = new OrderQueue();

    public void addProduct(String id, String name, String desc, double price, int stock) {
        Product existing = catalog.get(id);
        if (existing == null) {
            Product p = new Product(id, name, desc, price, stock);
            catalog.put(p);
        } else {
            existing.setName(name);
            existing.setDescription(desc);
            existing.setPrice(price);
            existing.addStock(stock);
        }
    }

    public Product findProduct(String id) {
        return catalog.get(id);
    }

    public boolean createOrder(String customerName, String[] productIDs) {
        if (customerName == null || productIDs == null || productIDs.length == 0) return false;

        // Check stock
        for (String pid : productIDs) {
            Product p = catalog.get(pid);
            if (p == null || p.getStockQuantity() < 1) {
                return false;
            }
        }
        // Reduce stock
        for (String pid : productIDs) {
            catalog.get(pid).reduceStock(1);
        }
        // Add order
        String oid = IdGenerator.nextOrderId();
        Order order = new Order(oid, customerName, productIDs);
        orders.enqueue(order);
        return true;
    }

    public void shipNextOrder() {
        Order next = orders.dequeue();
        if (next == null) {
            System.out.println("No pending orders to ship.");
            return;
        }
        next.setStatus(Order.Status.SHIPPED);
        System.out.println("Shipped Order: " + next);
    }

    public void restockProduct(String id, int quantity) {
        Product p = catalog.get(id);
        if (p != null) {
            p.addStock(quantity);
        }
    }

    public void listPendingOrders() {
        orders.forEachPending(o -> {
            if (o.getStatus() == Order.Status.PENDING) {
                System.out.println(o);
            }
        });
    }
}
