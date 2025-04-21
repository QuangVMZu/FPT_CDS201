/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 3;
        int[] array = new int[n];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            try {
                System.out.println("Input a[" + i + "]=");
                array[i] = sc.nextInt();
            } catch (Exception e) {
            }
        }

        System.out.println(array);

        for (int i : array) {
            System.out.print(i);
        }
        System.out.println("");
        System.out.println(array.length);
    }

}
