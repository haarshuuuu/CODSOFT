import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame  {
    private static final int MAX_ATTEMPTS = 10;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100. Try to guess it!");

            while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                    score += (MAX_ATTEMPTS - attempts + 1); // Higher score for fewer attempts
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all " + MAX_ATTEMPTS + " attempts. The number was " + numberToGuess + ".");
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
