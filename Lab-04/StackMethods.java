/* 10. Implement a program for stack that performs following operations using array:
       PUSH, POP, PEEP, CHANGE & DISPLAY */

/* This is manually created stack. */

import java.util.Scanner;

class StackImplement {
    int top = -1;
    int[] a = new int[100];

    public void push(int n) {
        if (top >= 100) {
            System.out.println("Stack Overflow.");
        } else {
            top++;
            a[top] = n;
        }
    }

    public int pop() {
        if (top <= -1) {
            return -1;
        } else {
            return a[top--];
        }
    }

    public int peek() {
        if (top <= -1) {
            System.out.println("Stack Underflow.");
            return -1;
        } else {
            return a[top];
        }
    }

    public void change(int i, int n) {
        if (top - i + 1 <= 0) {
            System.out.println("Stack Underflow.");
        } else {
            a[i] = n;
        }
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.print(a[i] + "   ");
        }
    }

    public int peep(int i) {
        if (top - i + 1 <= 0) {
            System.out.println("Stack Underflow.");
            return -1;
        } else {
            return a[i];
        }
    }
}

public class StackMethods {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StackImplement si = new StackImplement();
        System.out.println();


        while (true) {

            System.out.println("To push press \"1\"");
            System.out.println("To pop press \"2\"");
            System.out.println("To peek press \"3\"");
            System.out.println("To peep press \"4\"");
            System.out.println("To change press \"5\"");
            System.out.println("To display press \"6\"");
            System.out.println("To exit press \"0\"");
            System.out.print("Enter your choice : ");
            int c = input.nextInt();
            repeat:

            switch (c) {
                case 1:
                    System.out.print("Which element you want to push : ");
                    si.push(input.nextInt());
                    break;

                case 2:
                    int Pop = si.pop();
                    System.out.println(Pop);
                    break;

                case 3:
                    int Peek = si.peek();
                    System.out.println(Peek);
                    break;

                case 4:
                    System.out.print("Which element you want to change : ");
                    si.peep(input.nextInt());
                    break;

                case 5:
                    System.out.print("Which index : ");
                    int changeIndex = input.nextInt();
                    System.out.println();
                    System.out.println("New element : ");
                    int newElement = input.nextInt();
                    si.change(changeIndex, newElement);
                    break;

                case 6:
                    si.display();
                    break;

                case 0:
                    break repeat;

                default:
                    System.out.println("Invalid Input.");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }
}
