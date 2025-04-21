
import java.io.File;
import java.io.RandomAccessFile;
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
public class StudentStack {

    Node top;

    public StudentStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void clear() {
        this.top = null;
    }

    void ftraverseFW(RandomAccessFile f) throws Exception {
        Node p = top;
        while (p != null) {
            f.writeBytes(p.info.getId() + "-" + p.info.getName() + "-" + p.info.getAge() + "-" + p.info.getGpa() + "     "); // write data in the node p to the file f
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        String[] c = Lib.readLineToStrArray("data.txt", k + 2);
        String[] d = Lib.readLineToStrArray("data.txt", k + 3);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int age = Integer.parseInt(c[i]);
            double gpa = Double.parseDouble(d[i]);
            push(a[i], b[i], age, gpa);
        }
    }

    public void push(String id, String name, int age, double gpa) {
        Student newStudent = new Student(id, name, age, gpa);
        Node newNode = new Node(newStudent);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public Student pop() {
        if (!isEmpty()) {
            Student st = top.info;
            top = top.next;
            return st;
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    public Student peek() {
        if (!isEmpty()) {
            return top.info;
        } else {
            System.out.println("Stack is empty");
            return null;
        }
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
        f.close();
    }

    // f2: Add a new student from console input
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

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id: ");
        String id = sc.nextLine();
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter age: ");
        int age = sc.nextInt();
        System.out.println("Enter Gpa: ");
        double gpa = sc.nextDouble();

        push(id, name, age, gpa);

        ftraverseFW(f);
        f.close();
    }

    // f3: Calculate average GPA of all students
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

        double sum = 0;
        int count = 0;
        Node p = top;

        while (p != null) {
            sum += p.info.getGpa();
            p = p.next;
            count++;
        }

        double aver = count > 0 ? sum / count : 0; // Prevent division by zero  
        String average = String.format("%.1f", aver); // Format to 2 decimal places 

        f.writeBytes("Avergare of GPA for all students: " + average + "\r\n");
        f.close();
    }
}
