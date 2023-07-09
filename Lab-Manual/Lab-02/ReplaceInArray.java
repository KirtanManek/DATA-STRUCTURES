// 14. Read n numbers in an array then read two different numbers, replace 1st
//     number with 2nd number in an array and print its index and final array.

import java.util.Scanner;

public class ReplaceInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Read Array
        System.out.print("Enter size of array : ");
        int n = input.nextInt();

		System.out.println("\n");

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter array["+ i +"] : ");
            array[i] = input.nextInt();
        }

        System.out.print("Enter number present in array : ");
        int present = input.nextInt();

        System.out.print("Enter new number : ");
        int afterReplace = input.nextInt();

        System.out.println("\n\n");

        boolean temp = true;
		int index = -1;

        for (int i = 0; i < n; i++) {
            if (array[i] == present) {
				array[i] = afterReplace;
				index = i;
                temp = false;
            }
        }
        if (temp)
            System.out.print("Number entered by you is not found.");

        else {
			System.out.print("New Array : ");
            for (int i = 0; i < n; i++) {
				System.out.print(array[i] + " ");
            }
			System.out.print("\n");
			System.out.println("Change happened at index : " + index);
        }

    }
}