package week1;

import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        // create array
        // display array
        // prompt for number
        // search for that number in array, show index, -1 if missing
        /*
         * 5, 3, 5, 6, 2, 1
         * Enter number: 5
         * Index: 0
         * 
         * Enter number: 2
         * Index:4
         * 
         * Exter number: 100
         * Index: -1
         */

        int[] numbers = { 3, 6, 5, 4, 3, 2, 3, 4, 5, 7 };
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        // promp
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == n) {
                index = i;
                break;
            }
        }

        System.out.println("Index of " + n + " is " + index);
    }
}