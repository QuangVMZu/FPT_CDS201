/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slot2_list;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Slot2_List {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(5);
        list1.add(10);
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(list1.get(i));
//        }

        for (Integer inter : list1) {
            System.out.println(inter);
        }

        //getFirst
        System.out.println(list1.get(0));

        //getLast
        System.out.println(list1.get(list1.size() - 1));
        
        //getNext cách 1
        System.out.println("Enter index: ");
        int index;
        Scanner sc = new Scanner(System.in);
        index = sc.nextInt();
        System.out.println(list1.get(index + 1));
        
        System.out.println(list1.indexOf(0));
        //getNext cách 2
        System.out.println("Enter index: ");
        int index1;
        index1 = sc.nextInt();
        
//        System.out.println(list1.get(list1.indexOf(index1)));
    }

}
