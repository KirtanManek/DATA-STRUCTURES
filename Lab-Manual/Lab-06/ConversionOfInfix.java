import java.util.Scanner;
import java.util.Stack;

class ConversionOfInfix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the infix expression you want to convert : ");
        String infix = input.nextLine();
        while (true) {
            System.out.println("1. To convert to postfix.");
            System.out.println("2. To convert to prefix.");
            System.out.println("3. To change infix string.");
            System.out.println("0. To exit");
            System.out.print("Enter choice : ");
            int c = input.nextInt();
            switch (c) {
                case 1 ->
                        System.out.println("Postfix expression for the given infix expression is : " + toPostfix(infix));
                case 2 ->
                        System.out.println("Prefix expression for the given infix expression is : " + toPrefix(infix));
                case 3 -> {
                    System.out.print("Enter new infix string : ");
                    infix = input.next();
                }
                case 0 -> System.exit(0);
                default -> {
                    System.out.println("Invalid input.");
                    System.exit(0);
                }
            }
        }
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

        // Step 3:
        next = infix.charAt(i);
        i++;

        //Step 4:
        while (next != ' ') {

            // Step 5:
            while (stackPrecedence(stack.peek()) > inputPrecedence(next)) {
                String temp = stack.pop().toString();
                POLISH = POLISH + temp;
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
        return POLISH;
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
            if (polish.charAt(i) == '(') {
                prefix = prefix + ')';
            } else if (polish.charAt(i) == ')') {
                prefix = prefix + '(';
            } else {
                prefix = prefix + polish.charAt(i);
            }
        }
        return prefix;
    }

    public static int inputPrecedence(char chr) {
        return switch (chr) {
            case '+', '-' -> 1;
            case '*', '/' -> 3;
            case '^' -> 6;
            case '(' -> 9;
            case ')' -> 0;
            default -> 7;
        };
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