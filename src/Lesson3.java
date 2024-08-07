import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nTask 1.\nInput number: ");
        System.out.println(executeTask1(sc.nextInt()));

        System.out.print("\nTask 2.\nInput temperature: ");
        System.out.println(executeTask2(sc.nextInt()));

        System.out.println("\nTask 3:");
        executeTask3();

        System.out.println("\nTask 4:");
        executeTask4();

        System.out.print("\nTask 5. \nInput number: ");
        int nextInt;
        if(sc.hasNextInt() && (nextInt=sc.nextInt()) > 0){
            System.out.println(executeTask5(nextInt));
        } else {
            System.out.println("Incorrect input");
        }

    }

    // return true if num is Even, else - false
    public static boolean executeTask1(int n) {
        return n % 2 == 0;
    }


    // Returns "Warm" if n > -5, "Normal" if n > -20, otherwise "Cold"
    public static String executeTask2(int n) {
        return n > -5
                ? "Warm" : n >-20
                ? "Normal" : "Cold";
    }

    // Prints the squares of integers from 10 to 20
    public static void executeTask3() {
        for (int i = 10; i <= 20; i++){
            System.out.print(i * i + " ");
        }
        System.out.println();
    }

    // Prints multiples of 7 from 7 to 98
    public static void executeTask4() {
        for (int i = 7; i < 100; i += 7){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Calculates the sum of integers from 1 to n
    public static int executeTask5(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i ++){
            sum += i;
        }
        return sum;
    }

}