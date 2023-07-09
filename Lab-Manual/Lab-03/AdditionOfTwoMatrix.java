import java.util.Scanner;

public class AdditionOfTwoMatrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Of Rows For First Matrix : ");
        int row = sc.nextInt();
        System.out.println("Enter Number Of Columns For First Matrix : ");
        int column = sc.nextInt();

        int[][] matrix_1 = new int[row][column];
        int[][] matrix_2 = new int[row][column];
        int[][] sum = new int[row][column];

        System.out.println("Enter Elements Of First Matrix : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix_1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Number Of Rows For Second Matrix: ");
        row = sc.nextInt();
        System.out.println("Enter Number Of Columns For Second Matrix : ");
        column = sc.nextInt();

        System.out.println("Enter Elements Of Second Matrix : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix_2[i][j] = sc.nextInt();
            }

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sum[i][j] = matrix_1[i][j] + matrix_2[i][j];
            }
        }
        System.out.println("Sum Of Matrix ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(sum[i][j] + "\t");
            }
            System.out.println();
        }
    }
}