
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class MyList {

    Node head;

    public MyList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void clear() {
        this.head = null;
    }

    public void traverse() {
        try {
            Node p = head;
            while (p != null) {
                System.out.print(p.info);
                System.out.print(" ");
                p = p.next;
            }
        } catch (Exception e) {
        }

    }

    void loadData(int k) {
        Random generator = new Random();
        for (int i = 0; i < k; i++) {
            int number = generator.nextInt(1000) + 1;
            // add into list
            addFirst(number);
//            addLast(number);

        }
    }

    public void addFirst(int n) {
        Node newNode = new Node(n);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int n) {
        Node newNode = new Node(n);
//      addLast
        if (head == null) {
            head = newNode;
            return;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }

    void f1() {
        System.out.print("Linked list: ");
        this.traverse();
    }

    void f2() {
        System.out.print("\nBefore: ");
        this.traverse();
        System.out.println();
        try {
            System.out.print("Enter: ");
            Scanner sc = new Scanner(System.in);
            int s = sc.nextInt();
            addLast(s);
        } catch (Exception e) {
        }

        System.out.print("After: ");
        this.traverse();
    }

    void f3() {
        System.out.print("\nBefore: ");
        this.traverse();
        System.out.println();
        try {
            System.out.print("Enter: ");
            Scanner sc = new Scanner(System.in);
            int s = sc.nextInt();
            System.out.print("Enter k: ");
            int k = sc.nextInt();

            if (k == 0) {
                addFirst(s);
            } else {
                Node t = head;
                int count = 0;
                while (count < k - 1 && t != null) {
                    t = t.next;
                    count++;
                }
                // muc dich cua vong while:
                // tim node dung o vi tri (k-1)

                Node newNode = new Node(s);
                newNode.next = t.next;
                t.next = newNode;
            }
        } catch (Exception e) {
        }

        System.out.print("After: ");
        this.traverse();
    }

    // Remove first
    void f4() {
        System.out.print("\nBefore: ");
        this.traverse();
        System.out.println();

        try {
            if (head != null) {
                head = head.next;
            }
        } catch (Exception e) {
        }

        System.out.print("After: ");
        this.traverse();
    }

    // Remove last
    void f5() {
        System.out.print("\nBefore: ");
        this.traverse();
        System.out.println();

        try {
            if ((head == null) || (head.next == null)) {
                head = null;
            }
            Node x = head;
            while (x.next.next != null) {
                x = x.next;
            }
            x.next = null;
        } catch (Exception e) {
//            e.printStackTrace();
        }

        System.out.print("After: ");
        this.traverse();
    }
}
