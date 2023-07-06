import java.util.Scanner;

class Stack {
    String[] stack;
    int size, top;

    Stack(int size) {
        this.size = size;
        stack = new String[this.size];
        top = -1;
    }

    public void push(String n) {
        if (top == size - 1) {
            System.out.println("Stack Overflow.");
        } else {
            top++;
            stack[top] = n;
            System.out.println("Pushed " + n + " onto the stack.");
        }
    }

    public String pop() {
        if (top <= -1) {
            System.out.println("Stack Underflow.");
            return " ";
        } else {
            System.out.println("Popped " + stack[top] + " from stack.");
            return stack[top--];
        }
    }

    public String peek() {
        if (top <= -1) {
            System.out.println("Stack Underflow.");
            return " ";
        } else {
            return stack[top];
        }
    }
}

class Recognize {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your string with a space attached at the end : ");
        String s = input.nextLine();
        Stack st = new Stack(s.length() + 1);

        // Algorithm starts here :

        if (Character.toString(s.charAt(s.length() - 1)).equals(" ")) {
            // Step 1 :
            st.push("c");

            // Step 2 :
            int i = 1;
            String next = Character.toString(s.charAt(0));
            while (!next.equals("c")) {
                if (next.equals(" ")) {
                    System.out.println("Invalid String.");
                    System.exit(0);
                } else {
                    st.push(next);
                    next = Character.toString(s.charAt(i));
                    i++;
                }
            }

            // Step 3 :
            while (!st.peek().equals("c")) {
                next = Character.toString(s.charAt(i));
                i++;
                String x = st.pop();
                if (!next.equals(x)) {
                    System.out.println("Invalid String.");
                    System.exit(0);
                }
            }

            // Step 4 :
            next = Character.toString(s.charAt(i));
            if (next.equals(" ")) {
                System.out.println("It is a valid string.");
            } else {
                System.out.println("Invalid String.");
            }
        } else {
            System.out.println("Invalid String.");
        }
    }
}