// 4. Write a program to find factorial of a number. (Using Loop)

import java.util.Scanner;

public class FactorialLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int factorial = 1;
        System.out.print("Enter a number : ");
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println(n + "! = " + factorial);
    }
}