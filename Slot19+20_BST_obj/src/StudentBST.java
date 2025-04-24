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
    
    public Student findstudentById(int id) {
        Node p = root;
        if (p == null) {
            return null;
        }
        if (p.info.getId() == id) {
            return p.info;
        }
        if (id < p.info.getId()) {
            return findstudentById(id);
        } else {
            return findstudentById(id);
        }
    }
    
    private double sumNode(Node p) {
        if(p == null) {
            return 0;
        }
        return (p.info.getGpa() + sumNode(p.left) + sumNode(p.right));
    }
    
    private int countNodes(Node p) {
        if(p == null) {
            return 0;
        }
        return 1 + countNodes(p.left) + countNodes(p.right);
    }
    
    public double getAverageGPA() {
        return sumNode(root) / countNodes(root);
    }
}
