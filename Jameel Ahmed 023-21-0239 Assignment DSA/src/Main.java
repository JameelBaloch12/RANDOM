// Main.java
public class Main {
    public static void main(String[] args) {
        ECommerceSystem sys = new ECommerceSystem();

        sys.addProduct("P1", "Laptop", "Slim laptop", 1200, 5);
        sys.addProduct("P2", "Phone", "Android phone", 800, 10);
        sys.addProduct("P3", "Books", "10th Standard", 200, 100);
        System.out.println("Find Product P1: " + sys.findProduct("P1"));

        boolean order1 = sys.createOrder("Jameel Baloch", new String[]{"P1"});
        boolean order2 = sys.createOrder("Shoaib", new String[]{"P2"});
        boolean order3 = sys.createOrder("Ahmed", new String[]{"P3"});

        System.out.println("Order placed? " + order1);

        sys.listPendingOrders();
        sys.shipNextOrder();
        sys.listPendingOrders();
    }
}
