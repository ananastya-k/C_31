import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nTask 1.\nInput number: ");
        System.out.println(executeTask1(sc.nextInt()));

        System.out.print("\nTask 2.\nInput temperature: ");
        System.out.println(executeTask2(sc.nextInt()));

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

}