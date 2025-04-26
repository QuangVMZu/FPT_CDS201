class Node {

    Fruit info;
    Node next;

    Node(Fruit x, Node p) {
        info = x;
        next = p;
    }

    Node(Fruit x) {
        this(x, null);
    }
}
