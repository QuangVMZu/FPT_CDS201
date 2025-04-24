class Node{
    Patient info;
    Node next;
    Node () {}
    Node (Patient x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    Node (Patient x) {
        this(x,null);
    }
 }

class Patient{
    String name;
    float eLevel;
    Patient () {}
    Patient (String n, float p) {
        this.name = n; // data stored inside the node
        this.eLevel = p; // link to the next node
    }
 }

