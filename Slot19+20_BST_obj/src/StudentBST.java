/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class StudentBST {

    Node root;

    public StudentBST() {
        this.root = null;

    }

    public void insert(int id, String name, double gpa) {
        root = insertRec(root, id, name, gpa);
    }

    public void load() {
        insert(20, "Alice", 3.8);
        insert(10, "Bob", 3.5);
        insert(30, "Charlie", 3.9);
        insert(5, "David", 3.2);
        insert(15, "Eva", 3.7);
        insert(25, "Frank", 3.6);
        insert(35, "Grace", 4.0);
        insert(100, "Henry", 3.4);
    }

    private Node insertRec(Node p, int id, String name, double gpa) {
        Student st = new Student(id, name, gpa);
        if (p == null) {
            p = new Node(st);
        } else if (st.compareTo(p.info) < 0) {
            p.left = insertRec(p.left, id, name, gpa);
        } else if (st.compareTo(p.info) > 0) {
            p.right = insertRec(p.right, id, name, gpa);
        }
        return p;
    }

    public void visit(Node p) {
        System.out.println(p.info + " ");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        } else { // root -- left -- right
            visit(p);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        } else { // left -- root -- right
            inOrder(p.left);
            visit(p);
            inOrder(p.right);
        }
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        } else { // left -- right -- root
            postOrder(p.left);
            postOrder(p.right);
            visit(p);
        }
    }

    public Student findstudentById(Node p, int id) {
        if (p == null) {
            return null;
        }
        if (p.info.getId() == id) {
            return p.info;
        }
        if (id < p.info.getId()) {
            return findstudentById(p.left, id);
        } else {
            return findstudentById(p.right, id);
        }
    }

    private double sumNode(Node p) {
        if (p == null) {
            return 0;
        }
        return (p.info.getGpa() + sumNode(p.left) + sumNode(p.right));
    }

    private int countNodes(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + countNodes(p.left) + countNodes(p.right);
    }

    public double getAverageGPA() {
        int count = countNodes(root);
        return (count > 0) ? (sumNode(root) / count) : 0;
    }

    // f1 - test insert
    public void f1() {
        System.out.println("Students after insertion:");
        inOrder(root);
    }

    // f2 - count students/nodes
    public int f2() {
        return countNodes(root);
    }

    // f3 - sum of GPAs
    public double f3() {
        return getAverageGPA();
    }

    // f4 - pre-order traversal
    public void f4() {
        preOrder(root);
    }

    // f5 - in-order traversal
    public void f5() {
        inOrder(root);
    }

    // f6 - post-order traversal
    public void f6() {
        postOrder(root);
    }

    // f7 - find student by ID
    public Student f7(int id) {
        return findstudentById(root, id);
    }
}
