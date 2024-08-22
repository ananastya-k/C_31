public class ATM {

    private  Banknote[] banknotes ;

    public ATM(int amountBanknote20, int amountBanknote50, int amountBanknote100) {
        banknotes = new Banknote[3];
        banknotes[0] = new Banknote(100, amountBanknote100);
        banknotes[1] = new Banknote(50, amountBanknote50);
        banknotes[2] = new Banknote(20, amountBanknote20);

    }


    public void depositCash(int sum) {
        if (isValidAmount(sum) && sum > 0) {
            for (int i = 0; i < banknotes.length; i++ ) {
                int numOfBanknotes = getNumOfBanknotes(sum, i);

                if (numOfBanknotes > 0) {
                    banknotes[i].increaseAmount(numOfBanknotes);
                    sum -= numOfBanknotes * banknotes[i].getDenomination();
                    System.out.println(banknotes[i].getDenomination() + " : " + banknotes[i].getAmount());
                }
            }
        }
    }
    public void withdrawalCash(int sum) {
        if (!isValidAmount(sum) || sum > this.getAllATMCash()) {
            System.out.println("Unable to dispense the exact amount. Try a different sum.");
            return;
        }

        for (int i = 0; i < banknotes.length; i++ ) {
            int numOfBanknotes = getNumOfBanknotes(sum, i);

            if (numOfBanknotes > 0) {
                banknotes[i].decreaseAmount(numOfBanknotes);
                sum -= numOfBanknotes * banknotes[i].getDenomination();
                System.out.println(banknotes[i].getDenomination() + " : " + numOfBanknotes);
            }
        }
        if (sum > 0) {
            System.out.println("Unable to dispense the exact amount. Try a different sum.");
        }
    }

    private int getNumOfBanknotes(int sum, int i) {
        int denomination = banknotes[i].getDenomination();
        int numOfBanknotes = Math.min(sum / denomination, banknotes[i].getAmount());

        if (i < banknotes.length - 1) {
            int remainingSum = sum - numOfBanknotes * denomination;
            boolean isLastDenominationCheck = (i == banknotes.length - 2
                    && remainingSum % banknotes[banknotes.length - 1].getDenomination() != 0);
            boolean isNotDivisibleByNextDenomination = remainingSum != 0
                    && remainingSum < banknotes[i + 1].getDenomination();

            if (isLastDenominationCheck || isNotDivisibleByNextDenomination) {
                numOfBanknotes--;
            }
        }
        return numOfBanknotes;
    }


    public int getAllATMCash() {
        int totalSum = 0;
        for (Banknote banknote : banknotes) {
            totalSum += banknote.getAmount() * banknote.getDenomination();
        }
        return totalSum;
    }

    private boolean isValidAmount(int sum) {
        return sum % 10 == 0 && (sum >= 50 || sum % 20 == 0);
    }
}
