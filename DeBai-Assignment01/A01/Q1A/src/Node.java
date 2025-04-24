// Node.java
class Node {
    Student info;
    Node next;
    
    Node() {}
    
    Node(Student x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    
    Node(Student x) {
        this(x, null);
    }
}

// Student.java
class Student {
    String name;
    String major;
    double gpa;
    
    Student() {}
    
    Student(String n, String m, double g) {
        this.name = n;
        this.major = m;
        this.gpa = g;
    }
}