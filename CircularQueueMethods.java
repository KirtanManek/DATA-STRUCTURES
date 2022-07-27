import java.util.Scanner;

class CircularQueueImplement{
    int front = -1, rear = -1, size = 3;
    int[] array = new int[size];

    public void enqueue(int n){

        if(front == (rear + 1) % size){
            System.out.println("\n\"Circular Queue is full.\"");
        }
        else {
            if(front == -1 && rear == -1){
                front = 0;
                rear = 0;
                array[rear] = n;
            }
            else {
                rear = (rear + 1) % size;
                array[rear] = n;
            }
        }
    }

    public void deque() {
        if (rear == -1 && front == -1) {
            System.out.println("Circular Queue underflow");
        }
        else if(front == rear){
            System.out.println("Circular Queue is Empty");
            front = -1;
            rear = -1;
        }
        else {
            System.out.println(array[front]);
            front = (front + 1) % size;
        }
    }

    public void display(){
        int i = front;
        if (front == -1 && rear == -1) {
            System.out.println("Circular Queue is empty.");
        } else if (front == rear) {
            System.out.println("Circular Queue overflow.");
        }
        else {
            while(i != rear) {
                System.out.print(array[i] + "   ");
                i = (i + 1) % size;
            }
            System.out.print(array[i]);
        }
    }
}

public class CircularQueueMethods {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        CircularQueueImplement q = new CircularQueueImplement();

        while (true) {
            System.out.println("To enqueue press \"1\"");
            System.out.println("To deque press \"2\"");
            System.out.println("To displayAll press \"3\"");
            System.out.println("To exit press \"0\"");
            System.out.print("Enter your choice : ");
            int c = input.nextInt();

            switch (c) {
                case 1 -> {
                    System.out.print("Which integer to enqueue : ");
                    q.enqueue(input.nextInt());
                }
                case 2 -> q.deque();
                case 3 -> q.display();
                case 0 -> System.exit(0);
                default -> System.out.println("Enter valid input.");
            }
            System.out.println("\n");
        }
    }
}
