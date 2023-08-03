import java.util.Scanner;

public class SimpleQueueDemo {

    int[] queue;
    int front = -1;
    int rear = -1;

    SimpleQueueDemo(int size) {
        queue = new int[size];
    }

    public void enqueue(int x) {
        if (rear == queue.length - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        if (front == -1)
            front++;
        rear++;
        queue[rear] = x;
    }

    public int dequeue() {
        if (front == -1) { // front=rear
            System.out.println("Queue Underflow");
            return -1;
        }
        int temp = queue[front];
        if(front == rear)
            front = rear = -1;
        else
            front++;
        return temp;
    }

    public void display() {
        for (int i = front; i <= rear; i++) {
            System.out.print("[" + queue[i] + "] ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue ");
        int n = sc.nextInt();

        SimpleQueueDemo queue = new SimpleQueueDemo(n);

        System.out.println("Enter Your Choice ");
        System.out.println("Press 1 to enqueue ");
        System.out.println("Press 2 to dequeue ");
        System.out.println("Press 3 to display  ");
        System.out.println("Press 4 to exit  ");
        int choice = sc.nextInt();
        while (true) {
            if (choice == 1) {
                System.out.println("Enter Element");
                queue.enqueue(sc.nextInt());
                System.out.println("Enter your choice");
                choice = sc.nextInt();
            } else if (choice == 2) {
                System.out.println("[" + queue.dequeue() + "]");
                System.out.println("Enter your choice");
                choice = sc.nextInt();
            } else if (choice == 3) {
                queue.display();
                System.out.println("Enter your choice");
                choice = sc.nextInt();
            } else {
                break;
            }
        }
        sc.close();
    }
}