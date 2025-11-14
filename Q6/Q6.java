import java.util.Scanner;
import java.util.Random;
public class Q6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        // Welcome message
        System.out.println("Welcome to the Dragon Egg Quest!");
        System.out.println("There are 10 chests, 3 dragon eggs, and 2 cursed chests.");
        System.out.println("You have 10 attempts to find all dragon eggs.");
        System.out.println();

        // Declare array
        int[] eggs = new int[3];
        int[] curse = new int[2];

        // Generate random eggs
        for (int i = 0; i < eggs.length; i++) {
            int uniEgg;
            boolean unique;
            do {
                unique = true;
                uniEgg = r.nextInt(10) + 1;
                // Check whether the egg chest is unique or not
                for (int j = 0; j < i; j++) {
                    if (eggs[j] == uniEgg) {
                        unique = false;
                        break;
                    }
                }
            } while (!unique);
            eggs[i] = uniEgg;
        }

        // Generate random chest
        for (int i = 0; i < curse.length; i++) {
            int uniCurse;
            boolean unique;
            do {
                unique = true;
                uniCurse = r.nextInt(10) + 1;
                // Check whether the curse is unique or not
                for (int j = 0; j < i; j++) {
                    if (curse[j] == uniCurse) {
                        unique = false;
                        break;
                    }
                }
            } while (!unique);
            curse[i] = uniCurse;
        }

        // Read guess from user
        int attempt = 10;
        int found = 0;
        while (attempt > 0 && found < 3) {
            System.out.print("Guess a chest (1-10): ");
            int guess = s.nextInt();

            // Print error message if guess is out of range
            if (guess < 1 || guess > 10) {
                System.out.println("Out of range! Try again!");
                System.out.println();
                continue;
            }

            // Declare found egg and cursed chest
            boolean foundEgg = false;
            boolean cursed = false;

            // If the chest is cursed
            for (int i = 0; i < curse.length; i++) {
                int c = curse[i];
                if (guess == c) {
                    cursed = true;
                }
            }
            if (cursed) {
                System.out.println("This chest is cursed! Beware!");
                attempt--;
            }

            // If the egg is found
            for (int i = 0; i < eggs.length; i++) {
                int e = eggs[i];
                if (guess == e) {
                    foundEgg = true;
                    eggs[i] = -1; // Mark the egg as found
                    found++;
                }
            }

            // Action if the egg is found (print message or break)
            if (foundEgg) {
                System.out.println("You found a dragon egg!");
                if (found == 3) {
                    System.out.println();
                    System.out.println("Congratulations! ALl dragon eggs are safe!");
                    break;
                }

            } else {
                // Find the min distance and the nearest egg
                int minDistance = 11;
                int nearestEgg = -1;
                for (int i = 0; i < eggs.length; i++) {
                    int e = eggs[i];
                    if (e == -1) {
                        continue;
                    }
                    // Calculate distance between all eggs and the chest
                    int distance = Math.abs(guess - e);
                    // Found the min distance and the nearest egg
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestEgg = e;
                    }
                }

                // Action if the egg is near (hint on chest number)
                if (minDistance <= 3) {
                    System.out.println("Warm! You're very close to a dragon egg!");
                    if (guess > nearestEgg) {
                        System.out.println("Hint: Try a lower chest number.");
                        System.out.println("No egg here, keep searching!");
                    }else{
                        System.out.println("Hint: Try a higher chest number.");
                        System.out.println("No egg here, keep searching!");
                    }
                }else{
                    // Action if the egg is far
                    System.out.println("Cold! You're far from any dragon egg!");
                    System.out.println("No egg here, keep searching!");
                }
            }

            // Print attempts left
            attempt--;
            System.out.println("Attempts left: " + attempt);
            System.out.println();
        }

        // If lose the game
        if (found < 3) {
            System.out.println("Game Over! Some dragon eggs remain hidden!");
        }
    }
}