import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String infix;
        System.out.print("Enter the infix expression you want to convert to postfix : ");
        infix = input.nextLine();
        System.out.println("Postfix expression for the given infix expression is : " + toPostfix(infix));
    }

    public static String toPostfix(String infix) {
        StackIP obj = new StackIP(infix.length());
        char symbol;
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            symbol = infix.charAt(i);

            if (Character.isLetter(symbol))
                postfix.append(symbol);
            else if (symbol == '(') {
                obj.push(symbol);
            } else if (symbol == ')') {
                while (obj.peek() != '(') {
                    postfix.append(obj.pop());
                }
                obj.pop();
            } else {
                while (obj.isEmpty() && !(obj.peek() == '(') && precedent(symbol) <= precedent(obj.peek()))
                    postfix.append(obj.pop());
                obj.push(symbol);
            }
        }

        while (obj.isEmpty())
            postfix.append(obj.pop());
        return postfix.toString();
    }

    public static int precedent(char chr) {
        return switch (chr) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> chr;
        };
    }

}
class StackIP{
    int top, size;
    char[] stack;

    StackIP(int size) {
        stack = new char[size];
        this.size = size;
        top = -1;
    }

    public void push(char n) {
        if (top == size - 1) {
            System.out.println("Stack Overflow.");
        } else {
            top++;
            stack[top] = n;
        }
    }

    public char pop() {
        if (top <= -1) {
            System.out.println("Stack Underflow.");
            return ' ';
        } else {
            return stack[top--];
        }
    }

    public char peek() {
        if (top <= -1) {
            System.out.println("Stack Underflow.");
            return ' ';
        } else {
            return stack[top];
        }
    }

    public boolean isEmpty(){
        return top > -1;
    }
}