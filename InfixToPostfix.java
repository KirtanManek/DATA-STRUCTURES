import java.util.Scanner;

public class InfixToPostfix {
    static InfixToPostfix obj = new InfixToPostfix();
    static int top = -1;
    char[] ch = new char[100];

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String infix;
        System.out.print("Enter the infix expression you want to convert to postfix : ");
        infix = input.nextLine();
        System.out.println("Postfix expression for the given infix expression is : " + obj.toPostfix(infix));
    }

    public void push(char c) {
        if (top >= 100) {
            System.out.println("Overflow");
        } else {
            top++;
            ch[top] = c;
        }
    }

    public char peek() {
        if (top <= -1) {
            System.out.println("UnderFlow");
            return 0;
        } else {
            return ch[top];
        }

    }

    public char pop() {
        if (top == -1) {
            System.out.println("Underflow");
            return 0;
        }
        return ch[top--];
    }

    public String toPostfix(String infix) {
        char symbol;
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); ++i) {
            symbol = infix.charAt(i);

            if (Character.isLetter(symbol))
                postfix.append(symbol);
            else if (symbol == '(') {
                obj.push(symbol);
            } else if (symbol == ')') {
                while (obj.peek() != '(') {
                    postfix.append(pop());
                }
                obj.pop();
            } else {
                while (top != -1 && !(obj.peek() == '(') && precedent(symbol) <= precedent(obj.peek()))
                    postfix.append(obj.pop());
                obj.push(symbol);
            }
        }

        while (top != -1)
            postfix.append(obj.pop());
        return postfix.toString();
    }

    public int precedent(char chr) {
        return switch (chr) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> chr;
        };
    }

}
