// 2. Write a program to find whether a number is odd or even.

import java.util.Scanner;

class OddEven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = input.nextInt();
        if (number % 2 == 0) {
            System.out.println(number + " is Even");
        }
        else {
            System.out.println(number + " is Odd");
        }
    }
}