// 12. Write a program to find position of the smallest number from given n numbers.

import java.util.Scanner;

class SmallestIndex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter The Size Of Array You Want : ");
        int n = input.nextInt();

        // Read the array of n size
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = input.nextInt();
        }

        // Find the smallest value from the array.
        int small = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < small) {
                small = array[i];
                index = i;
            }
        }

        System.out.println("The smallest element in the array is " + small + " and it is present at " + index + ".");
    }
}