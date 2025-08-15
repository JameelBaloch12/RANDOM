// OrderQueue.java
public class OrderQueue {
    private static class Node {
        Order value;
        Node next;
        Node(Order value) { this.value = value; }
    }

    private Node head;
    private Node tail;
    private int size;

    public void enqueue(Order order) {
        Node n = new Node(order);
        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public Order dequeue() {
        if (head == null) return null;
        Order v = head.value;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return v;
    }

    public boolean isEmpty() { return size == 0; }

    public void forEachPending(java.util.function.Consumer<Order> consumer) {
        for (Node n = head; n != null; n = n.next) {
            consumer.accept(n.value);
        }
    }
}
