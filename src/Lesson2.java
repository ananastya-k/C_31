public class Lesson2 {

    public static void main(String[] args) {

        int b = 12, c = 25;
        System.out.printf("\nTask 1:\nInput data: %d, %d\nOutput data: %d\n",b, c, executeTask1(b, c));

        int twoDigitNum = 68;
        System.out.printf("\nTask 2:\nInput data: %d\nOutput data: %d\n",twoDigitNum, executeTask2Or3(twoDigitNum));

        int threeDigitNum = 159;
        System.out.printf("\nTask 3:\nInput data: %d\nOutput data: %d\n",threeDigitNum, executeTask2Or3(threeDigitNum));

    }

    // Calculate the result of the formula: a = 4 * (b + c - 1) / 2
    public static int executeTask1(int b, int c) {
        return 4 * (b + c - 1) / 2;
    }

    // Calculate the sum of the digits of n
    public static int executeTask2Or3(int n) {
        int sum = 0;
        for(; n >= 1; n /= 10){
            sum += n % 10;
        }
        return sum;
    }

}