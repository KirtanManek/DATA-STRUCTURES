// 8. Write a program to check whether a number is prime or not.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prime {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter Number = ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int no = Integer.parseInt(br.readLine());
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
