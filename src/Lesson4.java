import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    public static void main(String[] args) {

        int length = promptArrayLength();
        int[] array = new int[length];
        handleArrayInput(array);

        System.out.println("Task 1:");
        printArray(array);
        reversePrintArray(array);

        System.out.printf("Task 2: \nMin element: %d\nMax element: %d\n",
                array[findMin(array)], array[findMax(array)]);

        System.out.printf("Task 3: \nIndex min element: %d\nIndex max element: %d\n",
                findMin(array), findMax(array));

        System.out.printf("Task 4: \nNum of zero: %d\n", countElement(array,0));

        System.out.println("Task 5:");
        printArray(array);
        reverseArray(array);
        printArray(array);

        System.out.println("Task 6:\n" + isSorted(array));

        System.out.println("Task 7: ");
        printArray(array);
        printArray(incrementArray(array));
    }

    public static int promptArrayLength() {
        Scanner sc = new Scanner(System.in);
        int length;

        while (true) {
            System.out.println("Enter array length: ");
            if (sc.hasNextInt()) {
                length = sc.nextInt();
                if (length >= 0) break;
                else{
                    System.out.println("Invalid input. Length must be a positive integer.");
                    sc.next();
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next();
            }
        }
        return length;
    }

    public static void handleArrayInput(int[] array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to manually input the array? (y/n)");
        char answer = sc.next().trim().toLowerCase().charAt(0);


        switch (answer) {
            case 'y':
                manualArrayInput(array);
                break;
            case 'n':
                randomArrayFill(array);
                break;
            default:
                System.out.println("Invalid input.");
                handleArrayInput(array);
        }

    }

    public static void manualArrayInput(int[] array) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter %d elements: ", array.length);
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        sc.close();
    }

    public static void randomArrayFill(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0,10);
        }
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) return false;
        }
        return true;
    }

    public static void reverseArray(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            swap(array, i++, j--);
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static int[] incrementArray(int[] array) {
        if (array[array.length - 1] < 9) {
            array[array.length - 1]++;
            return array;
        }

        StringBuilder number = new StringBuilder();
        for(int i : array){
            number.append(i);
        }
        int num = Integer.parseInt(String.valueOf(number));
        num++;
        String temp = Integer.toString(num);
        int[] newArray = new int[temp.length()];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = temp.charAt(i) - '0';
        }

        return newArray;
    }

    public static void reversePrintArray(int [] array) {
        System.out.print("[");
        for(int i = array.length - 1; i > 0; i--) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[0] + "]");
    }

    public static int findMin(int [] array) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++) {
            min = array[i] < min ? i : min;
        }

        return min;
    }

    public static int findMax(int [] array) {
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            min = array[i] > min ? i : min;
        }

        return min;
    }

    public static int countElement(int [] array, int val) {
        int cnt = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] == val) cnt++;
        }

        return cnt;
    }
}