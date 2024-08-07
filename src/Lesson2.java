public class Lesson2 {

    public static void main(String[] args) {

        int b = 12, c = 25;
        System.out.printf("\nTask 1:\nInput data: %d, %d\nOutput data: %d\n",b, c, executeTask1(b, c));

    }

    // Calculate the result of the formula: a = 4 * (b + c - 1) / 2
    public static int executeTask1(int b, int c) {
        return 4 * (b + c - 1) / 2;
    }

}