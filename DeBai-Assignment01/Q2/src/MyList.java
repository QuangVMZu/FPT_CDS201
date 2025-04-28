
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void ftraverseFW(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.ID + "-" + p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void ftraverseBW(RandomAccessFile f) throws Exception {
        Node p = tail;
        while (p != null) {
            f.writeBytes(p.info.ID + "-" + p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.pre;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        String[] c = Lib.readLineToStrArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(a[i]);
            int y = Integer.parseInt(c[i]);
            addLast(x, b[i], y);
        }
    }

    void addLast(int id, String name, int price) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Phone newPhone = new Phone(id, name, price);
        Node newNode = new Node(newPhone);

        if (price > 0) {
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                tail = tail.next;
            }
            size++;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    void f1() throws Exception {
        clear();
        loadData(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (head != null && head.next != null) {
            Node secondNode = head.next;
            head = secondNode.next;

            if (head != null) {
                head.pre = null;
            } else {
                tail = null;
            }

            secondNode.next = null;
            size -= 2;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f3: remove the all Phone 'I'
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        MyList tmp = new MyList();
        Node current = head;
        while (current != null) {
            if (!current.info.name.equalsIgnoreCase("I")) {
                tmp.addLast(current.info.ID, current.info.name, current.info.price);
            }
            current = current.next;
        }
        this.head = tmp.head;
        this.tail = tmp.tail;
        this.size = tmp.size;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f4: add a new Phone to the possition "after the head node"
    // (only add if the list does not contain the ID of the new Phone).
    // This also means that: 
    // (1) you should check the ID of the new Phone exist in the list or not; 
    // (2) if it does not exist, you write your code to add it to the list.
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        Phone t = new Phone(999, "FPT", 25);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node current = head;
        boolean idExists = false;

        // Check if the ID exists in the list  
        while (current != null) {
            if (current.info.ID == t.ID) {
                idExists = true;
                break;
            }
            current = current.next;
        }

        // If the ID does not exist, add the new phone after the head  
        if (!idExists) {
            Node newNode = new Node(t);

            if (head != null) { // If the list is not empty  
                newNode.next = head.next; // Point new node to the second node  
                newNode.pre = head; // Point new node back to head  
                if (head.next != null) { // If there's a second node, point it back to the new node  
                    head.next.pre = newNode; // Adjust the previous pointer of the second node  
                }
                head.next = newNode; // Link head's next to the new node  
            } else { // If the list is empty, establish the head  
                head = newNode;
                tail = newNode; // The tail will also point to the new node  
            }
            size++;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f5: swap min and max 
    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node prevMax = null, prevMin = null;
        Node maxNode = head, minNode = head;
        Node prev = null, curr = head;

        while (curr != null) {
            if (curr.info.price > maxNode.info.price) {
                prevMax = prev;
                maxNode = curr;
            }
            if (curr.info.price < minNode.info.price) {
                prevMin = prev;
                minNode = curr;
            }
            prev = curr;
            curr = curr.next;
        }

        if (maxNode == minNode) {
            // No need to swap if they're the same
            return;
        }

        // Handle prev pointers
        if (prevMax != null) {
            prevMax.next = minNode;
        } else {
            head = minNode;
        }

        if (prevMin != null) {
            prevMin.next = maxNode;
        } else {
            head = maxNode;
        }

        // Swap next pointers
        Node temp = maxNode.next;
        maxNode.next = minNode.next;
        minNode.next = temp;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }
}
