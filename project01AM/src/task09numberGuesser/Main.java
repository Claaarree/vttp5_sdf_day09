package task09numberGuesser;

import java.io.Console;
import java.util.Random;

public class Main {
    public static String[] range = {"111111", "699999"};
    public static void main(String[] args) {

        System.out.println("Hello! Let's play guess the number!");
        
        while (true) {
            //Generating number 
            Random rand = new Random();
            int generatedNumber = rand.nextInt(111111, 700000);
            System.out.println(generatedNumber);
    
            Console cons = System.console();
            String guess = "";
            while (guess != Integer.toString(generatedNumber)){
                //Getting guess input from player
                guess = cons.readLine("Guess the number between 111111 and 699999\nTo see the possible range, type 'range'\n");
                //checking for invalid input
                if (guess.length() != 6 && !guess.equalsIgnoreCase("range")){
                    System.out.println("Invalid input! Please try again!");
                }
        
                //checking guess
                if (guess.equals("range")) {
                    System.out.printf("Between %s and %s\n", range[0], range[1]);
                } else if (Integer.parseInt(guess) < generatedNumber) {
                    System.out.printf("%s is lower than the generated number.\n", guess);
                    range[0] = guess;
                } else if (Integer.parseInt(guess) > generatedNumber) {
                    System.out.printf("%s is higher than the generated number.\n", guess);
                    range[1] = guess;
                } else if (Integer.parseInt(guess) == generatedNumber) {
                    System.out.println("Congratulations! You have guessed correctly");
                    break;
                }
            }

            //checking if player wants to continue playing
            String option = "";
            while (!option.equals("2")) {
                option = cons.readLine("Select 1 to Play Again or 2 to Quit.\n");
                if (option.equals("2")) {
                    System.out.println("Bye bye!");
                    System.exit(0);
                } else if (option.equals("1")) {
                    break;
                } else {
                    System.out.println("Invalid option! Please try again!");
                }

            }
        }
    }
    

        
}