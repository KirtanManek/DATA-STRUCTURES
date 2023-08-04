import java.util.Scanner;

class LinkedListMethods {
    static class Node {
        int data;
        Node next;

        Node(int a) {
            this.data = a;
            this.next = null;
        }
    }
    static Node head;

    void insertEnd(int var) {
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

    void insertFront(int var) {
        Node node = new Node(var);
        if(head != null){
            node.next = head;
        }
        head = node;
    }

    void insertPosition(int x, int pos){
        Node node = new Node(x);
        if(head == null && pos == 1){
            head = node;
        }
        else if(pos > countNodes()){
            System.out.println("Invalid Position");
        }
        else{
            int count1 = 1;
            Node current = head;
            while(count1 + 1 != pos){
                current = current.next;
                count1++;
            }
            node.next = current.next;
            current.next = node;
        }
    }

    int deleteEnd(){
        if(head == null){
            System.out.println("List Empty");
            return -1;
        }
        else{
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            int tempData = temp.next.data;
            temp.next = null;
            return tempData;
        }
    }

    int deleteFront(){
        if(head == null){
            System.out.println("List Empty");
            return -1;
        }
        else{
            int tempData = head.data;
            head = head.next;
            return tempData;
        }
    }

    int deletePosition(int pos){
        if(head == null){
            System.out.println("List Empty");
            return -1;
        }
        else if(pos > countNodes()){
            System.out.println("Invalid Position");
            return -1;
        }
        else{
            int count1 = 1;
            Node save = head;
            Node pred = head;
            while(count1 != pos){
                pred = save;
                save = save.next;
                count1++;
            }
            int tempData = save.data;
            pred.next = save.next;
            return tempData;
        }
    }

    void displayAll() {
        //Node current will point to head
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while (current.next != null) {
            //Prints each node by incrementing pointer
            System.out.print("[" + current.data + "]" + "-->");
            current = current.next;
        }
        System.out.print("[" + current.data + "]");
        System.out.println();
    }

    void sort() {
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

    int countNodes(){
        if(head == null){
            return 0;
        }
        else{
            int count = 0;
            Node temp = head;
            while(temp != null){
                temp = temp.next;
                count++;
            }
            return count;
        }
    }
}

public class LinkedListImplements {
    public static void main(String[] args) {
        LinkedListMethods li = new LinkedListMethods();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("To insert at end press \"1\"");
            System.out.println("To insert at front press \"2\"");
            System.out.println("To insert at specific position press \"3\"");
            System.out.println("To delete from end press \"4\"");
            System.out.println("To delete from front press \"5\"");
            System.out.println("To delete from specific position press \"6\"");
            System.out.println("To displayAll press \"7\"");
            System.out.println("To sort the list press \"8\"");
            System.out.println("To exit press \"0\"");
            System.out.print("Enter your choice : ");
            int c = input.nextInt();

            switch (c) {
                case 1 -> {
                    System.out.print("Enter Number to insert : ");
                    li.insertEnd(input.nextInt());
                }
                case 2 -> {
                    System.out.print("Enter Number to insert : ");
                    li.insertFront(input.nextInt());
                }
                case 3 -> {
                    System.out.print("Enter Number to insert : ");
                    int x = input.nextInt();
                    System.out.print("Enter Position : ");
                    int pos = input.nextInt();
                    li.insertPosition(x,pos);
                }
                case 4 -> System.out.println("Deleted : [" + li.deleteEnd() + "]");
                case 5 -> System.out.println("Deleted : [" + li.deleteFront() + "]");
                case 6 -> {
                    System.out.print("Enter position : ");
                    int position = input.nextInt();
                    System.out.println("Deleted : [" + li.deletePosition(position)+ "]");
                }
                case 7 -> li.displayAll();
                case 8 -> li.sort();
                case 0 -> System.exit(0);
                default -> System.out.println("Enter valid input.");
            }
            System.out.println();
        }
    }
}