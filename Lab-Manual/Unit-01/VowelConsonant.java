// 3. Write a program to determine whether the entered character is vowel or not.

import java.util.Scanner;

class VowelConsonant {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String vowels = "aeiouAEIOU";
        System.out.print("Enter a Character : ");
        char c = input.next().charAt(0);
        if (vowels.indexOf(c) != -1) {
            System.out.println("Entered character is a Vowel");
        }
        else {
            System.out.println("Entered character is not a Vowel");
        }
    }
}