import models.Party;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by spunek on 8/4/17.
 */
public class App {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int guests = 0;
        String food = "";
        String beverages = "";
        String entertainment = "";
        boolean mainAppRunning = true;

        System.out.println("Hello EveryOne! Welcome to PDX Party! Want to have free Quote for Party? We can arrange party as per " +
                "your choice. Answer these Questions. Would you like us to have party for you? YES or NO");

        try {
            while (mainAppRunning) {
                String userAnswer = bufferedReader.readLine().toUpperCase();
                if (userAnswer.equalsIgnoreCase("NO")) {
                    System.out.println("Thanks for checking with us, have a great day!");
                }
                else if (userAnswer.equalsIgnoreCase("YES")) {
                    boolean programRunning = true;
                    System.out.println("How many guests are you expecting at your party? Enter a number");
                    guests = Integer.parseInt(bufferedReader.readLine());

                    System.out.println("Please choose one of the following for your food service: Full Course, Light Meal or Snacks");

                    food = bufferedReader.readLine().toLowerCase();
                    if (!(food.equalsIgnoreCase("Full course") || food.equalsIgnoreCase("Light meal") || food.equalsIgnoreCase("Snacks"))) {
                        System.out.println("Sorry, we don't recognize your input. Please enter one of the following: " +
                                "full course, light meal, snacks.");
                    }

                    System.out.println("Please choose one of the options for beverages: Full bar, Light Refreshments, Water");
                    beverages = bufferedReader.readLine().toLowerCase();
                    if (beverages.equalsIgnoreCase("full bar") || beverages.equalsIgnoreCase("light refreshments")
                            || beverages.equalsIgnoreCase("water")) {
                        System.out.println("Sorry, we don't recognize your input. Please enter one of the following: " +
                                "full bar, light refreshments, water.");
                    }

                    while (programRunning) {
                        Party party = new Party(guests, food, beverages, entertainment);
                        int cost = party.calculateCost();
                        System.out.println(String.format("Total cost for your party would be $%d.", cost));
                        Random randomGenerator = new Random();
                        String[] foodArray = {"Full Course", "Light Meal", "Snacks"};
                        String[] beverageArray = {"Full bar", "Light Refreshments", "Water"};
                        String[] entertainmentArray = {"Live Band", "DJ", "none"};
                        guests = randomGenerator.nextInt(100) + 1;
                        food = foodArray[randomGenerator.nextInt(3)];
                        beverages = beverageArray[randomGenerator.nextInt(3)];
                        entertainment = entertainmentArray[randomGenerator.nextInt(3)];
                        System.out.println(String.format("Here are the details for your party: Number of guests: %d, " +
                                "Food Service: %s, Beverage Service: %s, Entertainment: %s. Would you like to create a " +
                                "new party or see the cost estimate for this party? Enter one of the following options: " +
                                "New Party or See Cost", guests, food, beverages, entertainment));
                        boolean checkOption = true;
                        while (checkOption) {
                            String optionForUser = bufferedReader.readLine().toLowerCase();
                            if (optionForUser.equals("new party")) {
                                checkOption = false;
                            } else if (optionForUser.equals("see cost")) {
                                programRunning = false;
                                checkOption = false;
                            } else {
                                System.out.println("Sorry, We don't recognize your input. Please enter New Party or See Cost.");
                            }
                        }
                    }
                    mainAppRunning = false;
                } else {
                    System.out.println("Sorry, We don't recognize your input. Please enter YES or NO.");
                }
            }



        }


        catch (IOException e){
            e.printStackTrace();
        }


    }

}
