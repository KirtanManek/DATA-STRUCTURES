/* 10. Implement a program for stack that performs following operations using array:
       PUSH, POP, PEEP, CHANGE & DISPLAY */

import java.util.Scanner;

class StackImplement {
    int top, size;
    int[] stack;

    public void initializeStack(int size) {
        stack = new int[size];
        this.size = size;
        top = -1;
    }

    public void push(int n) {
        if (top == size - 1) {
            System.out.println("Stack Overflow.");
        } else {
            top++;
            stack[top] = n;
            System.out.println("Pushed " + n + " onto the stack.");
        }
    }

    public int pop() {
        if (top <= -1) {
            System.out.println("Stack Underflow.");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public void peek() {
        if (top <= -1) {
            System.out.println("Stack Underflow.");
        } else {
            System.out.println("Top Element is : " + stack[top]);
        }
    }

    public void change(int position, int n) {
        if (top == -1) {
            System.out.println("Stack is empty");
        }
        else if (position < 0 || position > top) {
            System.out.println("Invalid position");
        }
        else {
            stack[top - position] = n;
            System.out.println("Changed position " + position + " to " + n);
        }
    }

    public void display() {
        System.out.println("Elements of stack are : ");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public void peep(int i) {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Element at index " + i + " is : " + stack[i]);
        }
    }
}

public class StackMethods {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of stack : ");
        int size = input.nextInt();
        StackImplement si = new StackImplement();
        si.initializeStack(size);
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
            switch (c) {
                case 1:
                    System.out.print("Which element you want to push : ");
                    si.push(input.nextInt());
                    break;

                case 2:
                    int n = si.pop();
                    System.out.println("Popped " + n + " from the stack.");
                    break;

                case 3:
                    si.peek();
                    break;

                case 4:
                    System.out.print("Enter index : ");
                    int index = input.nextInt();
                    si.peep(index);
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
                    break;

                default:
                    System.out.println("Invalid Input.");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }
}