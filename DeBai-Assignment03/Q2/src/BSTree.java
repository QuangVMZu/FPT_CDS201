/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        //System.out.println(p);
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    private Node insertRec(Node p, User user) {
        // If the current position is null, this is where we insert the new node  
        if (p == null) {
            return new Node(user);
        }

        // Compare IDs to decide where to insert the new node  
        if (p.info.getId() > user.getId()) {
            // Recur down the left subtree  
            p.left = insertRec(p.left, user);
        } else if (p.info.getId() < user.getId()) {
            // Recur down the right subtree  
            p.right = insertRec(p.right, user);
        } else {
            // If the ID already exists, we can do nothing or handle duplicates (return)  
            // For instance, you might want to throw an error or update the existing node depending on your requirement.  
        }
        return p; // Return the unchanged node pointer  
    }

    void insert(String xName, int xAge, int xId) {
        //You should insert here statements to complete this function
        if (xAge > 0) {
            User user = new User(xName, xAge, xId);
            root = insertRec(root, user);
        }
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    private void postOrderWithAgeFilter(Node node, RandomAccessFile f, int ageLimit) throws Exception {
        if (node == null) {
            return;
        }

        postOrderWithAgeFilter(node.left, f, ageLimit);

        postOrderWithAgeFilter(node.right, f, ageLimit);

        if (node.info.getAge() < ageLimit) {
            fvisit(node, f);
        }
    }

    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        postOrderWithAgeFilter(root, f, 25);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    // f.writeBytes(" k = " + k + "\r\n");
    //=============================================================

    private void updateAgesWithOneChild(Node node) {
        if (node == null) {
            return;
        }

        boolean hasLeftChild = (node.left != null);
        boolean hasRightChild = (node.right != null);

        if ((hasLeftChild && !hasRightChild) || (!hasLeftChild && hasRightChild)) {

            User user = node.info;
            user.setAge(user.getAge() + 3);
        }

        updateAgesWithOneChild(node.left);
        updateAgesWithOneChild(node.right);
    }

    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        updateAgesWithOneChild(root);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    private int height(Node p) {
        if (p == null) {
            return 0;
        }
        int leftHeight = height(p.left);
        int rightHeight = height(p.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    Node lastPostOrder = null;

    private void findLastPostOrder(Node p) {
        if (p == null) {
            return;
        }
        findLastPostOrder(p.left);
        findLastPostOrder(p.right);
        lastPostOrder = p;
    }

    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        int h = 0;//Height of the last node
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        lastPostOrder = null;
        findLastPostOrder(root);
        if (lastPostOrder != null) {
            h = height(lastPostOrder);
        }
        //------------------------------------------------------------------------------------
        f.writeBytes(h + "");
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================    
    void resetAgeLeftBranch() {
        if (root == null) {
            return;
        }
        resetAge(root.left);
    }

    void resetAge(Node p) {
        if (p == null) {
            return;
        }
        p.info.age = 0;
        resetAge(p.left);
        resetAge(p.right);
    }

    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        resetAgeLeftBranch();
        //------------------------------------------------------------------------------------
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    Node findRightMost(Node p) {
        if (p == null) {
            return null;
        }

        while (p.right != null) {
            p = p.right;
        }

        return p;
    }
//=============================================================

    void f6() throws Exception {
        clear();
        loadData(21);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        Node right_most = null;//right_most node
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        right_most = findRightMost(root);
        //------------------------------------------------------------------------------------
        fvisit(right_most, f);
        f.writeBytes("\r\n");
        f.close();
    }
}
