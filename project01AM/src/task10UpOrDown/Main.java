package task10UpOrDown;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Generating numbers 
        List<Integer> numbersList = new ArrayList<>();
        Random rand = new Random();
        while (numbersList.size() != 10) {
            int generatedNumber = rand.nextInt(100) + 1;
            //making sure none of the numbers are repeated
            if (numbersList.contains(generatedNumber)) {
                continue;
            } else numbersList.add(generatedNumber);
        }
        //No need to shuffle since the numbers are randomly generated?
        //Collections.shuffle(numbersList);
        int score = 0;

        while (numbersList.size() != 1){
            //Showing first number
            System.out.println(numbersList.get(0));
            int upCount = 0;
            int downCount = 0;
            for (int i = 1; i < numbersList.size(); i++){
                if (numbersList.get(0) > numbersList.get(i)) {
                    downCount++;
                } else if (numbersList.get(0) < numbersList.get(i)) {
                    upCount++;
                }
            }
            System.out.printf("UpCount: %d\nDownCount: %d\n", upCount, downCount);
            
            Console cons = System.console();
            while (true) {
                String guess = cons.readLine("Is the next number Up or Down?\n");
                if (!guess.equalsIgnoreCase("up") && !guess.equalsIgnoreCase("down")){
                    System.out.println("Inavalid guess! Please try again!\n");
                } else {
                    if (guess.equalsIgnoreCase("up")) {
                        if (numbersList.get(0) < numbersList.get(1)){
                            System.out.println("Yay! You guessed right!\n");
                            score++;
                        } else System.out.println("Sorry! Wrong answer!\n");
                    } else {                        
                        if (numbersList.get(0) > numbersList.get(1)){
                            System.out.println("Yay! You guessed right!\n");
                            score++;
                        } else System.out.println("Sorry! Wrong answer!\n");
                        
                    }
                    break;
                }

            }
            
            //removing the number revealed to get a 'new' first number
            numbersList.remove(0);
        }
        System.out.println("Game over! Your score is " + score);
    }
    
}
