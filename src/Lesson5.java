import java.util.Random;
import java.util.Scanner;

public class Lesson5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nTask 1:");
        executeTask1(sc);

        System.out.println("\nTask 2:");
        executeTask2();

        System.out.println("\nTask 3:");
        executeTask3(sc);
    }

    /**
     * Task 1:
     * - Creates a 2x3 matrix.
     * - Fills the matrix with random numbers.
     * - Adds a user-provided number to each element.
     * - Prints the matrix before and after modification and calculates the sum of all elements.
     *
     * @param sc Scanner for user input
     */
    public static void executeTask1(Scanner sc) {
        int[][] matrix = new int[2][3];
        generateRandomMatrix(matrix);

        System.out.println("Matrix before modification:");
        printMatrix(matrix);

        System.out.println("Input number to add to each element:");

        int num;

        if (sc.hasNextInt()) {
            num = sc.nextInt();
        } else {
            System.out.println("Incorrect input.");
            sc.next();
            return;
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += num;
            }
        }

        System.out.println("Matrix after modification:");
        printMatrix(matrix);
        System.out.println("Sum of elements: " + calculateSumMatrix(matrix));
    }

    /**
     * Calculates the sum of all elements in the given matrix.
     *
     * @param matrix The matrix to sum elements of
     * @return The sum of all elements
     */
    public static int calculateSumMatrix(int[][] matrix) {
        int sum = 0;
        for(int[] row : matrix) {
            for(int el : row) {
                sum += el;
            }
        }
        return sum;
    }

    /**
     * Task 2:
     * - Creates and prints a chessboard-like matrix.
     * - 'W' represents white squares and 'B' represents black squares.
     */
    public static void executeTask2() {
        String[][] board = new String[8][8];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = (i + j) % 2 == 0 ? "W" : "B";
            }
        }

        printMatrix(board);
    }

    /**
     * Task 3:
     * - Creates a matrix with user-defined dimensions.
     * - Fills the matrix in a snake-like pattern.
     *
     * @param sc Scanner for user input
     */
    public static void executeTask3(Scanner sc) {
        System.out.println("Input matrix height: ");
        int height = sc.hasNextInt() ? sc.nextInt() : -1;

        System.out.println("Input matrix width: ");
        int width =  sc.hasNextInt() ? sc.nextInt() : -1;

        if (height < 1 || width < 1){
            System.out.println("Incorrect input.");
            return;
        }
        int[][] matrix = new int[height][width];
        fillMatrixSnakePattern(matrix);

        printMatrix(matrix);
    }

    /**
     * Fills a matrix in a snake-like pattern.
     *
     * @param matrix The matrix to be filled
     */
    public static void fillMatrixSnakePattern(int[][] matrix) {
        int num = 0;
        int direction = 1;

        for (int i = 0, j = 0; i < matrix.length;) {
            matrix[i][j] = num++;
            j += direction;

            if (j == matrix[i].length || j == -1) {
                direction *= -1;
                j += direction;
                i++;
            }
        }
    }

    /**
     * Fills the provided matrix with random integers between 1 and 99.
     *
     * @param matrix The matrix to be filled
     */
    public static void generateRandomMatrix(int[][] matrix) {
        Random random = new Random();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(1, 100);
            }
        }
    }

    /**
     * Prints the provided matrix of integers.
     *
     * @param matrix The matrix to be printed
     */
    public static void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            for(int el : row) {
                System.out.printf("%-3d", el);
            }
            System.out.println();
        }
    }

    /**
     * Prints the provided matrix of strings.
     *
     * @param matrix The matrix to be printed
     */
    public static void printMatrix(String[][] matrix) {
        for(String[] row : matrix) {
            for(String el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
