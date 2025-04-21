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

    public void enqueue(int key) {
        Node newNode = new Node(key);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int dequeue() { // xoá thằng đầu tiên
        if (!isEmpty()) {
            int value = head.info;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return value;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int front() { // lấy giá trị đầu tiên
        if (!isEmpty()) {
            int value = head.info;
            if (head == null) {
                tail = null;
            }
            return value;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public void display() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info + " ");
            p = p.next;
        }
    }
}
