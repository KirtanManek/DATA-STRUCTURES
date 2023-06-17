// 6. Write a program to find power of a number using loop.

import java.util.Scanner;

class PowerLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base : ");
        int base = input.nextInt();
        System.out.print("Enter Power : ");
        int power = input.nextInt();
        int ans = 1;
        for (int i = 0; i < power; i++){
            ans *= base;
        }
        System.out.println("Answer is " + ans);
    }
}