// 13. Write a program to find whether the array contains a duplicate number or not.

import java.util.Scanner;

class Duplicates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter The Size Of Array You Want : ");
        int n = input.nextInt();

        // Read the array of size n
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = input.nextInt();
        }

        boolean flag = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println("The array entered by you contains duplicate elements.");
        }
        else {
            System.out.println("The array entered by you does not contains duplicate.");
        }
    }
}