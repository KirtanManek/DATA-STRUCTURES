import java.util.Scanner;

public class  MatrixMultiplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of rows of 1st matrix : ");
        int rows1 = input.nextInt();

        System.out.print("Enter number of columns of 1st matrix : ");
        int columns1 = input.nextInt();

        System.out.println("\n");

        System.out.print("Enter number of rows of 2nd matrix : ");
        int rows2 = input.nextInt();

        System.out.print("Enter number of columns of 2nd matrix : ");
        int columns2 = input.nextInt();

        System.out.println("\n");

        int[][] matrix1 = new int[rows1][columns1];
        int[][] matrix2 = new int[rows2][columns2];
        int[][] productMatrix = new int[rows1][columns2];

        // Scan 1st Matrix ==>
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {
                System.out.print("Enter Matrix_1[" + (i + 1) + "][" + (j + 1) + "] : ");
				matrix1[i][j] = input.nextInt();
            }
        }
        // Scan 2nd Matrix ==>
        System.out.println("\n\n");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < columns2; j++) {
                System.out.print("Enter Matrix_2[" + (i + 1) + "][" + (j + 1) + "] : ");
				matrix2[i][j] = input.nextInt();
            }
        }
        // Matrix Multiplication ==>
        System.out.println("\n\n");
        if (columns1 == rows2) {
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns2; j++) {
                    for (int k = 0; k < rows2; k++) {
                        productMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }

            // Printing ==>
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns2; j++) {
                    System.out.print(productMatrix[i][j] + "  ");
                }
                System.out.println("\n");
            }
        }
        else {
            System.out.println("Entered Matrices are invalid.");
            System.exit(0);
        }
    }
}
