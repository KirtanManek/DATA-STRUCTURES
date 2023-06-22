// 8. Write a program to check whether a number is prime or not.

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number = ");
        int no = input.nextInt();
        int flag = 0;

        for (int i = 2; i <= Math.sqrt(no); i++) {
            if (no % i == 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println(no + " is Prime");
        } else {
            System.out.println(no + " is not Prime");
        }
    }
}
