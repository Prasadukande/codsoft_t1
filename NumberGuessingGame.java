import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it. Good luck!");

            while (attemptsLeft > 0) {
                System.out.print("\nEnter your guess: ");
                
                try {
                    int guess = Integer.parseInt(scanner.nextLine());

                    if (guess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the correct number!");
                        totalScore += 10; 
                        guessedCorrectly = true;
                        break;
                    } else if (guess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }

                    attemptsLeft--;
                    System.out.println("Attempts remaining: " + attemptsLeft);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number between 1 and 100.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nSorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
            }

            roundsPlayed++;
            System.out.println("\nYour current score: " + totalScore);

            System.out.print("\nWould you like to play another round? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\nThanks for playing! You played " + roundsPlayed + " round(s) with a total score of " + totalScore + ". Goodbye!");
        scanner.close();
    }
}