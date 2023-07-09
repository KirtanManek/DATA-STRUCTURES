// Write a program to delete a number from a given location in an array

import java.util.Scanner;

public class DeleteArray {
    public static void main(String[] args) {
        int flag = 0, loc = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements you want in array:");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter all the elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print("Enter the element you want to delete:");
        int x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                flag = 1;
                loc = i;
                break;
            }
        }
        if (flag == 1) {
            for (int i = loc + 1; i < n; i++) {
                a[i - 1] = a[i];
            }
            System.out.print("After Deleting:");
            for (int i = 0; i < n - 2; i++) {
                System.out.print(a[i] + ",");
            }
            System.out.print(a[n - 2]);
        } else {
            System.out.println("Element not found");
        }
    }
}