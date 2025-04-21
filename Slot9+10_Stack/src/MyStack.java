/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class MyStack {

    Node top;

    public MyStack() {
    }

    public MyStack(Node top) {
        this.top = top;
    }

    // add a element at the top position
    public void push(int x) {
        Node newNode = new Node(x);
        // make the new node point to the current top
        newNode.next = top;
        // update top to poin to new node
        top = newNode;
    }

    public void load() {
        this.push(10);
        this.push(14);
        this.push(7);
        this.push(7);
        this.push(3);
        this.push(2);
        this.push(15);
        this.push(9);
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (!isEmpty()) {
            return top.info;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }
    
    public int pop() {
        if (!isEmpty()) {
            int value = top.info;
            top = top.next;
            return value;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }
    
    public void display() {
        if(!isEmpty()) {
            Node current = top;
            System.out.print("Strack: ");
            while(current != null) {
                System.out.print(current.info + " ");
                current = current.next;
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty");
        }
    }
}
