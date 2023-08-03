// Java program to evaluate the value of a prefix expression.
// This method is limited to only a single digit evaluation.

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaluation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter prefix string : ");
        String exp = sc.next();

        // Function call
        System.out.println("prefix evaluation: " + evaluatePostfix(exp));
    }

    // Method to evaluate value of a prefix expression
    static int evaluatePostfix(String exp) {
        // Create a stack
        Stack<Integer> stack = new Stack<>();

        // Scan all characters one by one in reverse order
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);

            // If the character is a digit, then push it into stack by converting it from character to int.
            if (Character.isDigit(c)) {
                // Here character c is converted from char to int.
                stack.push(Integer.parseInt(String.valueOf(c)));
            }

            //  If the scanned character is an operator, pop two elements from the stack, apply the operator and push it into stack.
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                // if the operator is '+' then add both values.
                if (c == '+') {
                    int ans = val2 + val1;
                    stack.push(ans);
                }

                // if the operator is '-' then subtract both values.
                else if (c == '-') {
                    int ans = val2 - val1;
                    stack.push(ans);
                }

                // if the operator is '*' then multiply both values.
                else if (c == '*') {
                    int ans = val2 * val1;
                    stack.push(ans);
                }

                // if the operator is '/' then divide both values.
                else if (c == '/') {
                    int ans = val2 / val1;
                    stack.push(ans);
                }

                // if the operator is '^' then apply val2 to the power of val1.
                else if (c == '^') {
                    // Here Math.pow() method return double
                    double ans = Math.pow(val1, val2);
                    // So we have to convert double to int and then push it into stack
                    stack.push((int)ans);
                }
            }
        }

        // after the whole process is completed, there will be only one element remaining in the stack which is the answer.
        return stack.pop();
    }
}