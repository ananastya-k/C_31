import java.util.Random;

public class Main {
    public static void main(String[] args) {

        executeTask1();
        executeTask2();
    }

    public static void executeTask1() {

        CreditCard[] cards = new CreditCard[3];

        Random random = new Random();
        for (int i = 0; i < cards.length; i++){
            cards[i] = new CreditCard(random.nextInt(1000),10 + random.nextInt(100));
        }

        printCards(cards);

        cards[0].depositCash(120);
        cards[1].depositCash(200);
        cards[2].withdrawalCash(10);

        printCards(cards);
    }

    public static void executeTask2() {

        ATM a = new ATM(10,10,10);
        a.withdrawalCash(1610);
    }
    public static void printCards(CreditCard[] cards) {
        for (CreditCard card : cards){
            card.printInfo();
        }
        System.out.println();
    }
}
