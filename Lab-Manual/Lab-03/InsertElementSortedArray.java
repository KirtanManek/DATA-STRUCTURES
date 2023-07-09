import java.util.Scanner;

class InsertElementSortedArray {
    public static void main(String[] args) {
        int n, x, loc = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements you want in array : ");
        n = sc.nextInt();
        int[] a = new int[n + 1];

        // Scanning the elements of array
        System.out.println("Enter all the elements in ascending order only : ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Printing before inserting the element
        System.out.print("Before Inserting : ");
        for (int i = 0; i < (n - 1); i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[n - 1]);

        // Scanning the element to be inserted
        System.out.print("Enter the element you want to insert : ");
        x = sc.nextInt();

        // Find where to insert the element
        for (int i = 0; i < a.length; i++) {
            if (a[i] > x) {
                loc = i;
                break;
            }
        }

        // Inserting the element
        for (int i = (n - 1); i >= loc; i--) {
            a[i + 1] = a[i];
        }
        a[loc] = x;

        // Printing the array
        System.out.print("After Inserting : ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[n]);
    }
}