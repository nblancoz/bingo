import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Greet the user - Explain the program
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.printf("Hello %s! Welcome to Bingo. The first Trimestral Activity of 'Programación' of 'Grado Superior DAW, Universidad Europea'.\n", name);

        // Play the game until the user decides to stop
        do {
            playGame();
        } while (playAgain());

        System.out.printf("Thank you for playing Bingo! Goodbye, %s!", name);
    }

    private static void playGame() {
        System.out.println("Enter your bet amount: "); // Ask the user for a bet amount

        // Check if the input is an integer
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Discard the invalid input
        }
        int bet = scanner.nextInt();

        // Check if the bet is a positive number
        while (bet <= 0) {
            System.out.println("Invalid input. Please enter a positive number.");
            bet = scanner.nextInt();
        }

        // Get prediction for number of attempts
        System.out.println("How many numbers do you think will be needed to win the Bingo?");
        int predictedAttempts = scanner.nextInt();

        scanner.nextLine(); // Clear the scanner buffer after reading integers

        // Generate bingo card
        int[] bingoCard = generateBingoCard();
        System.out.println("Your Bingo card is: ");

        // for each - iterates every element in the array (in this case, every number in the bingo card)
        for (int num : bingoCard) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Start the game
        int attempts = 0;
        int lineHits = 0;

        // Set - collection that contains no duplicate elements
        // HashSet - constructs a new, empty set
        Set<Integer> numbersCalled = new HashSet<>();
        Set<Integer> matchedNumbers = new HashSet<>();

        // Generate random numbers until all numbers on the card are matched
        while (matchedNumbers.size() < 10) {
            int randomNumber = generateUniqueNumber(numbersCalled); // Generate a unique random number
            attempts++; // Increment the number of attempts
            System.out.printf("Number called: %d\n", randomNumber); // Print the number called

            // for each - iterates every element in the array (in this case, every number in the bingo card)
            for (int num : bingoCard) {
                // If the number called matches a number on the card, add it to the matched numbers set
                if (num == randomNumber) {
                    matchedNumbers.add(num);
                    System.out.printf("Matched number: %d\n", num);
                    break;
                }
            }

            // Check for line achievement
            if (matchedNumbers.size() == 5 && lineHits == 0) {
                lineHits = attempts;
                System.out.println("Line achieved!");
            }
        }

        // Bingo achieved
        System.out.println("Bingo! All numbers matched!");

        // Show results
        System.out.printf("It took %d numbers to achieve Bingo.\n", attempts);
        System.out.printf("It took %d numbers to achieve Line.\n", lineHits);

        // Check for exact prediction to win the prize
        if (attempts == predictedAttempts) {
            System.out.printf("Congratulations! You guessed the attempts! You won the prize: %d\n", bet * 10);
        } else {
            System.out.printf("Bingo achieved in %d attempts, but your prediction was %d. Better luck next time!\n", attempts, predictedAttempts);
        }
    }

    private static boolean playAgain() {
        System.out.println("Do you want to play again? (yes/no)");
        String response = scanner.nextLine().trim().toLowerCase();
        while (!response.equals("yes") && !response.equals("no")) {
            System.out.println("Invalid input. Please type 'yes' or 'no'.");
            response = scanner.nextLine().trim().toLowerCase();
        }
        return response.equals("yes");
    }

    // Generate a Bingo card with unique numbers
    private static int[] generateBingoCard() {
        Set<Integer> cardNumbers = new HashSet<>();

        // Generate unique random numbers until the card has 10 numbers
        while (cardNumbers.size() < 10) {
            cardNumbers.add((int) (Math.random() * 99) + 1);
        }
        int[] card = new int[10]; // Create an array to store the card numbers
        int i = 0;

        // for each - iterates every element in the set (in this case, every number in the card)
        for (int num : cardNumbers) {
            // Add the number to the card array
            card[i++] = num;
        }
        return card;
    }

    // Generate unique random numbers
    private static int generateUniqueNumber(Set<Integer> numbersCalled) {
        int num;

        // Generate random numbers until a unique number is found
        do {
            num = (int) (Math.random() * 99) + 1;
            // Check if the number is already in the set
        } while (numbersCalled.contains(num));

        // Add the number to the set
        numbersCalled.add(num);
        return num;
    }
}