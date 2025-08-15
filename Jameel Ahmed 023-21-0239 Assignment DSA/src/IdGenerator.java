// IdGenerator.java
public class IdGenerator {
    private static long counter = 0;

    public static synchronized String nextOrderId() {
        counter++;
        return "ORD-" + System.currentTimeMillis() + "-" + counter;
    }
}
