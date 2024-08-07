import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nTask 1.\nInput number: ");
        System.out.println(executeTask1(sc.nextInt()));

    }

    // return true if num is Even, else - false
    public static boolean executeTask1(int n) {
        return n % 2 == 0;
    }

}