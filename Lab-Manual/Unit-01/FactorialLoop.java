// 4. Write a program to find factorial of a number. (Using Loop)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FactorialLoop {
    public static void main(String[] args) throws Exception {
        int factorial = 1;
        System.out.print("Enter a number : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println(n + "! = " + factorial);
    }
}