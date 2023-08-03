import java.util.Scanner;

class LinkedListMethods {
    static Node head;

    public void insert(int var) {
        Node node = new Node(var);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void displayAll() {
        //Node current will point to head
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while (current != null) {
            //Prints each node by incrementing pointer
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void sort() {
        Node current = head;
        Node sortNode;
        int temp;
        if (head == null) {
            System.out.println("List is empty.");
        } else {
            while (current.next != null) {
                sortNode = current.next;

                while (sortNode != null) {
                    if (current.data > sortNode.data) {
                        temp = current.data;
                        current.data = sortNode.data;
                        sortNode.data = temp;
                    }
                    sortNode = sortNode.next;
                }
                current = current.next;
            }
        }
    }
//for (Node current = head; current != null; current = current.next){}
    static class Node {
        int data;
        Node next;

        Node(int a) {
            this.data = a;
            this.next = null;
        }
    }
}

public class LinkedListImplements {
    public static void main(String[] args) {
        LinkedListMethods li = new LinkedListMethods();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("To insert press \"1\"");
            System.out.println("To displayAll press \"2\"");
            System.out.println("To sort the list press \"3\"");
            System.out.println("To exit press \"0\"");
            System.out.print("Enter your choice : ");
            int c = input.nextInt();

            switch (c) {
                case 1 -> {
                    System.out.print("Enter Number to insert : ");
                    li.insert(input.nextInt());
                }
                case 2 -> li.displayAll();
                case 3 -> li.sort();
                case 0 -> System.exit(0);
                default -> System.out.println("Enter valid input.");
            }
            System.out.println();
            System.out.println();
        }
    }
}