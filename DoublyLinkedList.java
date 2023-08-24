import java.util.Scanner;

public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LL ll = new LL();
        while (true) {
            System.out.println(
                    "Menu:\n1 for insert at first\n2 for insert at last\n3 for delete\n4 for display\n0 for exit");
            System.out.print("Enter choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter number that you want to insert at first :");
                    int data1 = sc.nextInt();
                    ll.insertAtFirst(data1);
                }
                case 2 -> {
                    System.out.print("Enter number that you want to insert at last :");
                    int data2 = sc.nextInt();
                    ll.insertAtLast(data2);
                }
                case 3 -> {
                    System.out.print("Enter number that you want to delete :");
                    int x = sc.nextInt();
                    ll.deleteNode(x);
                }
                case 4 -> ll.displayLL();
                case 0 -> {
                    System.exit(0);
                    sc.close();
                }
            }
            System.out.println();
        }
    }
}

class Node {
    int info;
    Node next;
    Node prev;

    Node(int info) {
        this.info = info;
        this.next = null;
        this.prev = null;
    }
}

class LL {
    Node head;

    void insertAtFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node save = head;
            while (save.next != null) {
                save = save.next;
            }
            newNode.prev = save;
            save.next = newNode;
        }
    }

    void deleteNode(int x) {
        Node save = head;
        while (save != null) {
            if (save.info == x) {
                if (save.prev == null) {
                    head = save.next;
                } else {
                    save.prev.next = save.next;
                }
                if (save.next != null) {
                    save.next.prev = save.prev;
                }
                save = null;
            } else {
                save = save.next;
            }
        }
    }

    void displayLL() {
        Node save = head;
        System.out.println();
        while (save != null) {
            System.out.print(save.info + " ");
            save = save.next;
        }
        System.out.println();
        System.out.println();
    }
}