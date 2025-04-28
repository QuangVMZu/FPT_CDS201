
class Node {

    Product info;
    Node next;

    Node(Product x, Node p) {
        info = x;
        next = p;
    }

    Node(Product x) {
        this(x, null);
    }
}
