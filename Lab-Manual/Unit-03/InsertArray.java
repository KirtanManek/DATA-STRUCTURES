// Write a program to insert a number at a given location in an array

import java.util.Scanner;

class InsertArray {
    public static void main(String[] args) {
        int n, pos, x;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements you want in array : ");
        n = sc.nextInt();

        // Scanning the array
        int[] a = new int[n + 1];
        System.out.println("Enter all the elements : ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Scanning element to be inserted and its position
        System.out.print("Enter the position where you want to insert element : ");
        pos = sc.nextInt();
        System.out.print("Enter the element you want to insert : ");
        x = sc.nextInt();

        // Inserting the element at given position
        for (int i = (n - 1); i >= (pos - 1); i--) {
            a[i + 1] = a[i];
        }
        a[pos - 1] = x;

        // Printing the array after inserting
        System.out.print("After inserting : ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[n]);
    }
}