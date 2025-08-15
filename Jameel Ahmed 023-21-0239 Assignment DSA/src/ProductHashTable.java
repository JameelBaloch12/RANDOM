// ProductHashTable.java
public class ProductHashTable {
    private static class ProductNode {
        Product value;
        ProductNode next;
        ProductNode(Product value, ProductNode next) {
            this.value = value;
            this.next = next;
        }
    }

    private ProductNode[] buckets;
    private int size;
    private static final double LOAD_FACTOR = 0.75;

    public ProductHashTable() {
        this(16);
    }

    public ProductHashTable(int capacity) {
        if (capacity < 1) capacity = 16;
        buckets = new ProductNode[capacity];
        size = 0;
    }

    private int hash(String key) {
        long h = 0;
        for (int i = 0; i < key.length(); i++) {
            h = 31 * h + key.charAt(i);
        }
        return (int)(Math.abs(h) % buckets.length);
    }

    private void rehashIfNeeded() {
        if (size >= buckets.length * LOAD_FACTOR) {
            ProductNode[] old = buckets;
            buckets = new ProductNode[old.length * 2];
            size = 0;
            for (ProductNode head : old) {
                for (ProductNode n = head; n != null; n = n.next) {
                    put(n.value);
                }
            }
        }
    }

    public void put(Product product) {
        if (product == null) return;
        rehashIfNeeded();
        int idx = hash(product.getId());
        ProductNode head = buckets[idx];
        for (ProductNode n = head; n != null; n = n.next) {
            if (n.value.getId().equals(product.getId())) {
                n.value = product;
                return;
            }
        }
        buckets[idx] = new ProductNode(product, head);
        size++;
    }

    public Product get(String id) {
        int idx = hash(id);
        for (ProductNode n = buckets[idx]; n != null; n = n.next) {
            if (n.value.getId().equals(id)) {
                return n.value;
            }
        }
        return null;
    }
}
