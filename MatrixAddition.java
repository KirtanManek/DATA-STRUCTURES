import java.util.Scanner;
class Matrix {
    int rows, columns;
    Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
    }
    public void AddMatrix() {
        Scanner input = new Scanner(System.in);
        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];
        int[][] sumMatrix = new int[rows][columns];

        // Scanning 1st Matrix ==>
        System.out.println("\n\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter Matrix_1[" + (i + 1) + "][" + (j + 1) + "] : ");
                matrix1[i][j] = input.nextInt();
            }
        }

        // Scanning 2nd Matrix ==>
        System.out.println("\n\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter Matrix_2[" + (i + 1) + "][" + (j + 1) + "] : ");
                matrix2[i][j] = input.nextInt();
            }
        }

        System.out.println("\n\n");
        System.out.println("Sum of both Matrices is : ");
        // Performing and Printing Sum ==>
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(sumMatrix[i][j] + "  ");
            }
            System.out.println("\n");
        }
        input.close();
    }

}

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Kindly input square Matrix only.");

        System.out.print("Enter number of rows of Matrix_1 : ");
        int rows = input.nextInt();

        System.out.print("Enter number of columns of Matrix_2 : ");
        int columns = input.nextInt();

        Matrix am1 = new Matrix(rows, columns);
        am1.AddMatrix();
        input.close();
    }
}
