import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (!isExitRequested(sc)) {
            GameGuessWord ggw = new GameGuessWord();
            ggw.startGame();
        }
        System.out.println("Goodbye! See you next time.");
    }

    public static boolean isExitRequested(Scanner sc) {
        System.out.println("If you want to exit, enter '-1'. Otherwise, let's play the game.");
        return sc.nextLine().equals("-1");
    }
}
