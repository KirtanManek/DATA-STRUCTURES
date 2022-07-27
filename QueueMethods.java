import java.util.Scanner;

class QueueImplement {

    int front = -1, rear = -1;
    int[] a = new int[100];

    public void enque(int n) {
        if (rear > 99) {
            System.out.println("Queue Overflow.");
        } else {
            if(rear==-1){
                front=0;
            }
            rear++;
            a[rear] = n;
        }
    }

    public void deque() {
        if (rear <= -1) {
            System.out.println("Queue underflow");
        } else {
            System.out.println(a[front]);
            front++;
        }
    }

    public void displayAll() {
        if (front==-1) {
            System.out.println("Queue Empty");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.print(a[i] + "   ");
            }
            System.out.println();
        }
    }
}

public class QueueMethods {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        QueueImplement q = new QueueImplement();

        while (true) {
            System.out.println("To enque press \"1\"");
            System.out.println("To deque press \"2\"");
            System.out.println("To displayAll press \"3\"");
            System.out.println("To exit press \"0\"");
            System.out.print("Enter your choice : ");
            int c = input.nextInt();

            switch (c) {
                case 1:
                    System.out.print("Which integer to enque : ");
                    q.enque(input.nextInt());
                    break;

                case 2:
                    q.deque();
                    break;

                case 3:
                    q.displayAll();
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter valid input.");
            }
            System.out.println();
            System.out.println();
        }
    }
}
