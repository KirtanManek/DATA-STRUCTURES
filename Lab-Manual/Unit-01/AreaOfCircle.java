// 1. Write a program to calculate area of a Circle.

import java.util.Scanner;

class AreaOfCircle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter radius : ");
        int radius = input.nextInt();
        System.out.println("Area of circle with radius " + radius + " is : " + (Math.PI * radius * radius));
    }
}