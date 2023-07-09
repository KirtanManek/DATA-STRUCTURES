// 9. Write a program to read and display n numbers using an array.

import java.util.Scanner;

public class InputPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The Size Of Array U Want : ");
        int n = scanner.nextInt();

        // Read the array of size n
        int[] array = new int[n];
        System.out.print("Enter " + n + " values to the array : ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println();
        System.out.println();

        // Display the array
        System.out.println("Entered Arrays values : \r");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
    }
}