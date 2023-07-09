// 5. Write a program to find factorial of a number. (Using Recursion)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Factorial {

    public int findFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        else
        {
            return (n * findFactorial(n - 1));
        }
    }
}


class FactorialRecursion {
    public static void main(String[] args) throws IOException {
        Factorial fact = new Factorial();
        System.out.print("Enter a number : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read below code carefully ==>
        // Dont get confused.
        // I used readLine() method to read user input and applied anonymity.
        System.out.println("Factorial of entered number is : " + fact.findFactorial(Integer.parseInt(br.readLine())));
    }
}