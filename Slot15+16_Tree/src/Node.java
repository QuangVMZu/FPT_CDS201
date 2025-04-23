/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Node {

    int info;
    Node right, left;

    public Node() {
        right = left = null;
    }

    public Node(int info, Node right, Node left) {
        this.info = info;
        this.right = right;
        this.left = left;
    }

    public Node(int info) {
        this(info, null, null);
    }
}
