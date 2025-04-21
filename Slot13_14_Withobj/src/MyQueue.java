/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class MyQueue {

    Node head, tail;

    public MyQueue() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void enqueue(String id, String name, int age, double gpa) {
        Student st = new Student(id, name, age, gpa);
        Node newNode = new Node(st);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Student dequeue() {
        if (!isEmpty()) {
            Student st = head.info;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return st;
        } else {
            return null;
        }
    }

    public Student front() {
        if (!isEmpty()) {
            Student st = head.info;
            if (head == null) {
                tail = null;
            }
            return st;
        } else {
            return null;
        }
    }

    public void display() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info + " ");
            p = p.next;
        }
    }

    public void hightGPA() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }

        Node p = head;
        Student maxStudent = head.info; // Start with the first student as the max  

        while (p != null) {
            if (p.info.getGpa() > maxStudent.getGpa()) {
                maxStudent = p.info; // Update maxStudent if a higher GPA is found  
            }
            p = p.next;
        }

        System.out.println("Student with highest GPA: " + maxStudent);
    }
}
