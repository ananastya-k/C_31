import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    public static void main(String[] args) {

        int length = promptArrayLength();
        int[] array = new int[length];
        handleArrayInput(array);

        executeTask1(array);
        executeTask2(array);
        executeTask3(array);
        executeTask4(array);
        executeTask5(array);
        executeTask6(array);
        executeTask7(array);
    }

    /**
     * Task 1:
     * - Print the array in both normal and reverse order.
     *
     * @param array The array to be processed
     */
    public static void executeTask1(int[] array) {
        System.out.println("\nTask 1:");

        System.out.println("Array in normal order:");
        printArray(array);

        System.out.println("Array in reverse order:");
        reversePrintArray(array);
    }

    // Prints the array in a standard format.
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    // Prints the array in reverse order.
    public static void reversePrintArray(int [] array) {
        System.out.print("[");
        for(int i = array.length - 1; i > 0; i--) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[0] + "]");
    }

    /**
     * Task 2:
     * - Print the minimum and maximum elements in the array.
     *
     * @param array The array to be processed
     */
    public static void executeTask2(int[] array){
        System.out.printf("\nTask 2: \nMinimum element: %d\nMaximum element: %d\n",
                array[findMin(array)], array[findMax(array)]);
    }

    // Finds the index of the minimum element in the array.
    public static int findMin(int [] array) {
        int min = 0;
        for(int i = 0; i < array.length; i++) {
            min = array[i] < array[min] ? i : min;
        }
        return min;
    }

    // Finds the index of the maximum element in the array
    public static int findMax(int [] array) {
        int max = 0;
        for(int i = 0; i < array.length; i++) {
            max = array[i] > array[max] ? i : max;
        }
        return max;
    }

    /**
     * Task 3:
     * - Find and print the indices of the minimum and maximum elements in the array.
     *
     * @param array The array to be processed
     */
    public static void executeTask3(int[] array){
        System.out.printf("\nTask 3: \nIndex of minimum element: %d\nIndex of maximum element: %d\n",
                findMin(array), findMax(array));
    }

    /**
     * Task 4:
     * - Count and print the number of zero elements in the array.
     *
     * @param array The array to be processed
     */
    public static void executeTask4(int[] array) {
        int zeroCount = countElement(array, 0);

        if (zeroCount == 0) {
            System.out.println("\nTask 4:\nNo zeros in the array.");
        } else {
            System.out.println("\nTask 4:\nNumber of zeros: " + zeroCount);
        }
    }

    // Counts the occurrences of a specific value in the array.
    public static int countElement(int [] array, int val) {
        int cnt = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * Task 5:
     * - Reverse the array in place and print it before and after reversing.
     *
     * @param array The array to be processed
     */
    public static void executeTask5(int[] array) {
        System.out.println("\nTask 5:");
        System.out.println("Original array:");
        printArray(array);

        reverseArray(array);

        System.out.println("Reversed array:");
        printArray(array);
    }

    // Reverses the array in place.
    public static void reverseArray(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            swap(array, i++, j--);
        }
    }

    // Swaps two elements in the array.
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * Task 6:
     * - Check if the array is sorted in non-decreasing order and print the result.
     *
     * @param array The array to be checked
     */
    public static void executeTask6(int[] array) {
        System.out.println("\nTask 6:\n" + isSorted(array));
    }

    // Checks if the array is sorted in non-decreasing order.
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) return false;
        }
        return true;
    }

    /**
     * Task 7:
     * - Increments the array as if it represents a large number and print the result.
     *
     * @param array The array to be processed
     */
    public static void executeTask7(int[] array) {
        System.out.println("\nTask 7: ");
        printArray(array);
        printArray(incrementArray(array));
    }

    // Increments the array as if it represents a large number.
    public static int[] incrementArray(int[] array) {
        if (array[array.length - 1] < 9) {
            array[array.length - 1]++;
            return array;
        }

        StringBuilder number = new StringBuilder();
        for(int i : array){
            number.append(i);
        }

        int incrementedNum = Integer.parseInt(number.toString()) + 1;
        String incrementedStr = Integer.toString(incrementedNum);

        int[] newArray = new int[incrementedStr.length()];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = incrementedStr.charAt(i) - '0';
        }

        return newArray;
    }

    /**
     * Functions for create array
     */


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
}