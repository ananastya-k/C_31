import java.util.Random;

public class CreditCard {
    private long creditCardNumber;
    private double balance;

    public CreditCard() {
        this.creditCardNumber = generateRandomCardNumber();
        this.balance = 0;
    }

    public CreditCard(long number, double balance) {
        this.creditCardNumber = number;
        this.balance = balance;
    }

    public boolean withdrawalCash(int sum) {
        if (sum <= 0) {
            System.out.println("Incorrect withdrawal amount.");
            return false;
        }
        if (balance < sum) {
            System.out.printf("Insufficient funds. Your balance: %.2f. Requested sum: %d.\n", this.balance, sum);
            return false;
        } else {
            balance -= sum;
            return true;
        }
    }

    public boolean depositCash(int sum) {
        if (sum <= 0) {
            System.out.println("Incorrect deposit amount.");
            return false;
        } else {
            balance += sum;
            return true;
        }
    }

    public void printInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format("CreditCard:\nCredit Card Number: %d\nBalance: %.2f", creditCardNumber, balance);
    }

    private long generateRandomCardNumber() {
        Random random = new Random();
        return Math.abs(random.nextLong());
    }
}
