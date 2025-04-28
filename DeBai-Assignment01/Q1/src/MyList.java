
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

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(b[i]);

            addLast(a[i], p);
        }
    }

    // Luu y: doc ky dieu kien trong de bai
    void addLast(String n, float p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Phone newPhone = new Phone(n, p);
        Node newNode = new Node(newPhone);

        if (p > 0) {
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
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
        ftraverse(f);
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
        Phone t = new Phone("FPT_Phone", 100);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        // Initialize pointers  
        Node cuNode = head;
        Node maxNode = head;

        // Edge case: List is empty  
        if (cuNode == null) {
            head = new Node(t); // If the list is empty, just add the new node  
            size++;
            ftraverse(f);
            f.close();
            return;
        }

        while (cuNode != null) {
            if (maxNode == null || cuNode.info.price > maxNode.info.price) {
                maxNode = cuNode; // Update maxNode to the current cuNode if it has a greater price  
            }
            cuNode = cuNode.next; // Move to the next node  
        }
        Node newNode = new Node(t);

        if (maxNode == null) {
            head = newNode;
        } else {
            newNode.next = maxNode.next; // Link newNode to the next node of maxNode  
            maxNode.next = newNode; // Set maxNode's next to the newNode  
        }

        size++;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        float avg_S = 0;
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node current = head;
        float sum = 0;
        int count = 0;
        while (current != null) {
            if (current.info.name.equalsIgnoreCase("S")) {
                sum += current.info.price;
                count++;
            }
            current = current.next;
        }
        if (count != 0) {
            avg_S = sum / count;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        f.writeBytes(avg_S + "\n"); // write data
        ftraverse(f);
        f.close();

    }

    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        head = head.next.next.next;
        size -= 3;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
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
            ftraverse(f);
            f.close();
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
        ftraverse(f);
        f.close();
    }

}
