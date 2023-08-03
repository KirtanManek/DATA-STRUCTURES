import java.util.Scanner;
import java.util.Stack;

class ConversionOfInfix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the infix expression you want to convert : ");
        String infix = input.nextLine();
        System.out.println("Postfix expression for the given infix expression is : " + toPostfix(infix));
        System.out.println("Prefix expression for the given infix expression is : " + toPrefix(infix));
    }

    public static String toPostfix(String infix) {
        infix = "(" + infix + ")" + " ";
        Stack<Character> stack = new Stack<>();
        int i = 0;

        // Step 1:
        stack.push('(');

        // Step 2:
        char next;
        String POLISH = "";
        int rank = 0;

        // Step 3:
        next = infix.charAt(i);
        i++;

        //Step 4:
        while (next != ' ') {

            // Step 5:
            while (stackPrecedence(stack.peek()) > inputPrecedence(next)) {
                char temp = stack.pop();
                POLISH += temp;
                rank += calculateRank(temp);
                if (rank < 1) {
                    System.out.println("Invalid.");
                    System.exit(0);
                }
            }

            // Step 6:
            if (stackPrecedence(stack.peek()) != inputPrecedence(next)) {
                stack.push(next);
            } else {
                stack.pop();
            }

            // Step 7:
            next = infix.charAt(i);
            i++;
        }

        // Step 8:
        if (rank != 1) {
            System.out.println("Invalid.");
            System.exit(0);
            return "";
        } else {
            System.out.println("Valid.");
            return POLISH;
        }
    }

    public static String toPrefix(String infix) {
        String reversed = "", prefix = "";

        // Reversing before converting to postfix
        for (int i = infix.length() - 1; i >= 0; i--) {
            if (infix.charAt(i) == '(') {
                reversed = reversed + ')';
            } else if (infix.charAt(i) == ')') {
                reversed = reversed + '(';
            } else {
                reversed = reversed + infix.charAt(i);
            }
        }

        String polish = toPostfix(reversed);

        // reversing postfix string to prefix
        for (int i = polish.length() - 1; i >= 0; i--) {
            prefix = prefix + polish.charAt(i);
        }
        return prefix;
    }

    public static int calculateRank(char chr) {
        if (Character.isLetter(chr)) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int inputPrecedence(char chr) {
        if (chr == '+' || chr == '-') {
            return 1;
        } else if (chr == '*' || chr == '/') {
            return 3;
        } else if (chr == '^') {
            return 6;
        } else if (Character.isLetter(chr)) {
            return 7;
        } else if (chr == '(') {
            return 9;
        } else if (chr == ')') {
            return 0;
        } else {
            System.out.println("Invalid character in infix expression.");
            System.exit(0);
            return -1;
        }
    }

    public static int stackPrecedence(char chr) {
        if (chr == '+' || chr == '-') {
            return 2;
        } else if (chr == '*' || chr == '/') {
            return 4;
        } else if (chr == '^') {
            return 5;
        } else if (Character.isLetter(chr)) {
            return 8;
        } else if (chr == '(') {
            return 0;
        } else {
            System.out.println("Invalid character in infix expression.");
            System.exit(0);
            return -1;
        }
    }
}