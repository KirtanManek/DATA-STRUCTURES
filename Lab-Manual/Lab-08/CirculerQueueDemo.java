import java.util.Scanner;

public class CirculerQueueDemo {

    int[] queue;
    int front = -1;
    int rear = -1;

    CirculerQueueDemo(int size) {
        queue = new int[size];
    }

    public void enqueue(int x) {
        int temp = (rear + 1) % queue.length;
        if (temp == front) {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1)
            front = 0;
        rear = temp;

        queue[rear] = x;
    }

    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int temp = queue[front];
        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % queue.length;
        return temp;
    }

    public void display() {
        if (front <= -1) {
            System.out.println("Queue Underflow");
        } else {

            System.out.print("Items : ");

            if (front <= rear) {
                for (int i = front; i <= rear; i++) {
                    System.out.print("[" + queue[i] + "] ");
                }
            } else {
                for (int i = front; i < queue.length; i++)
                    System.out.print("[" + queue[i] + "] ");

                for (int i = 0; i <= rear; i++)
                    System.out.print("[" + queue[i] + "] ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue ");
        int n = sc.nextInt();

        CirculerQueueDemo queue = new CirculerQueueDemo(n);

        String str = "Enter Your Choice\nPress 1 to enqueue \nPress 2 to dequeue\nPress 3 to display\nPress 4 to exit";
        System.out.println(str);
        int choice = sc.nextInt();
        while (true) {

            if (choice == 1) {
                System.out.println("Enter Element");
                queue.enqueue(sc.nextInt());
                System.out.println(str);
                choice = sc.nextInt();
            } else if (choice == 2) {
                System.out.println("Dequed Element [" + queue.dequeue() + "]");
                System.out.println(str);
                choice = sc.nextInt();
            } else if (choice == 3) {
                queue.display();
                System.out.println(str);
                choice = sc.nextInt();
            } else {
                break;
            }
        }
        sc.close();
    }
}