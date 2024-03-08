import java.util.*;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int Trounds = 0;
        int totalAttempts = 0;

        while (true) {
            Trounds++;
            System.out.println("WELCOME TO ROUND " + Trounds + ":");
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = guessTheNumber(minRange, maxRange, maxAttempts, targetNumber, scanner);
            totalAttempts += attempts;
            if (attempts != 0) {
                System.out.print("Do you want to play again? (Y/N): ");
                String playAgain = scanner.next().toLowerCase();
                if (!playAgain.equals("y")) {
                    System.out.println("Thank you for playing! Your total score based on " + Trounds + " rounds and "
                            + totalAttempts + " attempts is ." + (((maxAttempts - totalAttempts) * 5) + 75));
                    break;
                } else {
                    System.out.println("Thank you for playing! Your total score based on " + Trounds + " rounds and "
                            + totalAttempts + " attempts is " + (((maxAttempts - totalAttempts) * 5) + 75) + " .");
                    totalAttempts = 0;
                }
            } else {
                System.out.println("You did'nt pass the first round. Please try again to move to next rounds");
                break;
            }
        }

    }

    public static int guessTheNumber(int minNum, int maxNum, int maxAttempts, int targetNumber, Scanner scanner) {
        int attempts = 0;

        while (attempts <= maxAttempts) {
            System.out.println("Guess the number between " + minNum + " and " + maxNum + ": ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == targetNumber) {
                System.out.println("Congratulations! You've guessed the number " + targetNumber + " correctly in "
                        + attempts + " attempts.");
                return attempts;
            } else if (guess < targetNumber) {
                if (guess < targetNumber - 25)
                    System.out.println("Too low! Try again.");
                else if (guess > targetNumber - 5) {
                    System.out.println("You are Close!! Try again.");
                } else
                    System.out.println("Lower!! Please try again");

            } else if (guess > targetNumber) {
                if (guess > targetNumber + 25)
                    System.out.println("Too high! Try again.");
                else if (guess < targetNumber + 5)
                    System.out.println("You are Close!! Try again.");
                else
                    System.out.println("Higher!! Please try again");
            }
        }

        System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
        return 0;
    }
}
