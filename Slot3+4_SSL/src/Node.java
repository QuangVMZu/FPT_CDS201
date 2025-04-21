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
    Node next;

//    Default constructor (no paramenter)
    public Node() {
    }

//    Constructor for a typical node
    public Node(int info, Node next) {
        this.info = info; // data stored inside the node
        this.next = next; // link to the next node
    }

//    Copy a Constructor
    public Node(int info) {
        this.info = info;
    }
    
}
