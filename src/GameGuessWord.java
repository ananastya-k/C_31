import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GameGuessWord {

    private String word;
    private char[] wordChars;
    private char[] hiddenWord;
    private final Scanner sc = new Scanner(System.in);

    public void startGame() {

        System.out.print("Enter the word :");
        word = sc.nextLine().toLowerCase();

        if (!isValidWord(word)) {
            System.out.println("Incorrect input.");
            return;
        }
        wordChars = word.toCharArray();
        hiddenWord = new char[word.length()];
        Arrays.fill(hiddenWord, '*');

        playGame();
    }

    public void playGame() {
        while (!String.valueOf(hiddenWord).equals(word)) {

            System.out.print("Enter the letter: ");
            String guessWord = sc.nextLine().toLowerCase();

            if (guessWord.length() > 1) {
                if (word.equals(guessWord)) break;
                System.out.println("Try again.");
                continue;
            }

            char letter = guessWord.charAt(0);
            if (!isValidLetter(letter))  System.out.println("Incorrect input.");

            System.out.println(updateHiddenWord(letter) ? "Good!" : "Try again.");
            System.out.println("Word: " + String.valueOf(hiddenWord));

        }
        System.out.println("Congratulations! You guessed the word: " + word);
    }

    public boolean updateHiddenWord(char letter) {
        boolean found = false;

        for (int i = 0; i < wordChars.length; i++) {
            if (wordChars[i] == letter) {
                hiddenWord[i] = letter;
                wordChars[i] = '*';
                found = true;
            }
        }
        return found;
    }

    public boolean isValidLetter(char symbol) {
        return symbol >='a' && symbol <= 'z';
    }

    public boolean isValidWord(String word) {
        return word.split(" ").length == 1 && Pattern.matches("[a-z]+",word);
    }
}
