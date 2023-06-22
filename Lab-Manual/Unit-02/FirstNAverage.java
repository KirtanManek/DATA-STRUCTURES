// 11. Write a program to calculate average of first n numbers.

import java.util.Scanner;

class FirstNAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter till where you want to find average : ");
        int n = input.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        double avg = (double) sum / n;
        System.out.println("The average of first " + n + " numbers is : " + avg);
    }
}