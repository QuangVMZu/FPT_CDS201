/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        MyQueue mq = new MyQueue();

        mq.enqueue("001", "Quang", 20, 10);
        mq.enqueue("002", "Vy", 22, 9.5);
        mq.enqueue("003", "Thinh", 24, 5);
        mq.enqueue("004", "Thu", 26, 2.4);

        mq.display();
    }
}
