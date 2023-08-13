import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("*****Number Guessing Game*****");
            System.out.println("The number is generated between " + minRange + " and " + maxRange + ".");
            System.out.println("The max attemps to guess the number are " + maxAttempts);

            int attempts = 0;
            boolean guessedCorrectly = false;
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter the guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("*****It is the correct guess*****");
                    System.out.println("Number of attempts: " + attempts);
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low");
                } else {
                    System.out.println("Too high");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("No more attemps left...");
                System.out.println("The number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (y/n): ");
            String playAgainResponse = sc.next().toLowerCase();
            playAgain = playAgainResponse.equals("y");
        }

        System.out.println("Your score: " + score);
        System.out.println("Thank you for playing the Number Guessing Game!");
        sc.close();
    }

}