public class Lesson2 {

    public static void main(String[] args) {

        int b = 12, c = 25;
        System.out.printf("\nTask 1:\nInput data: %d, %d\nOutput data: %d\n",b, c, executeTask1(b, c));

        int twoDigitNum = 68;
        System.out.printf("\nTask 2:\nInput data: %d\nOutput data: %d\n",twoDigitNum, executeTask2Or3(twoDigitNum));

        int threeDigitNum = 159;
        System.out.printf("\nTask 3:\nInput data: %d\nOutput data: %d\n",threeDigitNum, executeTask2Or3(threeDigitNum));

        double n = -5.97;
        System.out.printf("\nTask 4:\nInput data: %f\nOutput data: %d\n", n, executeTask4(n));

        System.out.println("\nTask 5:");
        executeTask5(b, c);

        System.out.println("\nTask 6.v.1.0:");
        executeTask6(b, c);

        System.out.println("\nTask 6.v.1.1:");
        executeUpgradeTask6(b, c);

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


    //Round number
    //  return (n * 10) % 10 >= 5 ? (long)++n : (long)n;
    public static long executeTask4(double n) {

        long bits = Double.doubleToLongBits(n);
        long e = ((bits << 1) >>> 53) - 1023;
        long m =  ((bits << 12) >>>12) | (1L << 52);

        m += (1L << (52 - e - 1));

        long integer = (e >= 0 && e < 52)
                ? (m) >> (52-e)
                : (long) n;

        return bits > 0 ? integer : -integer;

    }


    // Print division result and remainder of q divided by w
    public static void executeTask5(int q, int w) {
        System.out.printf("%d / %d = %d и %d в остатке\n", q, w,q/w, q% w);
    }

    // Swap values of a and b using a temporary variable
    public static void executeTask6(int a, int b) {
        System.out.printf("Input data: a = %d; b = %d\n", a, b);
        int temp = a;
        a = b;
        b = temp;
        System.out.printf("Output data: a = %d; b = %d\n", a, b);
    }

    // Swap values of a and b without using a temporary variable
    public static void executeUpgradeTask6(int a, int b) {

        System.out.printf("Input data: a = %d; b = %d\n", a, b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.printf("Output data: a = %d; b = %d\n", a, b);
    }

}