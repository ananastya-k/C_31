public class Banknote {
    private final int denomination;
    private int amount;

    public Banknote(int denomination, int amount) {
        this.denomination = denomination;
        this.amount = amount;
    }
    public int getDenomination() {
        return denomination;
    }
    public int getAmount() {
        return amount;
    }
    public void increaseAmount(int amount) {
        this.amount += amount;
    }
    public void decreaseAmount(int amount) {
        this.amount -= amount;
    }


}
