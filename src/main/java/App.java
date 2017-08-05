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
                if (userAnswer.equals("NO")) {
                    System.out.println("How many guests are you expecting at your party? Enter number");
                    guests = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Please choose one of the following for your food service: full course, light meal or snacks");
                    boolean checkFood = true;
                    while (checkFood) {
                        food = bufferedReader.readLine().toLowerCase();
                        if (food.equals("full course") || food.equals("light meal") || food.equals("snacks")) {
                            checkFood = false;
                        } else {
                            System.out.println("Sorry, we don't recognize your input. Please enter one of the following: " +
                                    "full course, light meal, snacks.");
                        }
                    }
                    System.out.println("Please choose one of the options for beverages: full bar, light refreshments, water");
                    boolean checkBeverage = true;
                    while (checkBeverage) {
                        beverages = bufferedReader.readLine().toLowerCase();
                        if (beverages.equals("full bar") || beverages.equals("light refreshments") || beverages.equals("water")) {
                            checkBeverage = false;
                        } else {
                            System.out.println("Sorry, we don't recognize your input. Please enter one of the following: " +
                                    "full bar, light refreshments, water.");
                        }
                    }
                    System.out.println("Please choose one of the following for your entertainment service: live band, DJ, none");
                    boolean checkEntertainment = true;
                    while (checkEntertainment) {
                        entertainment = bufferedReader.readLine().toLowerCase();
                        if (entertainment.equals("dj") || entertainment.equals("live band") || entertainment.equals("none")) {
                            checkEntertainment = false;
                        } else {
                            System.out.println("Sorry, we don't recognize your input. Please enter one of the " +
                                    "following: live band, DJ, none.");
                        }

                    } mainAppRunning = false;
                } else if (userAnswer.equals("YES")) {
                    boolean programRunning = true;
                    while (programRunning) {
                        Random randomGenerator = new Random();
                        String[] foodArray = {"full course", "light meal", "snack"};
                        String[] beverageArray = {"full bar", "light refreshments", "water"};
                        String[] entertainmentArray = {"live band", "DJ", "none"};
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
            Party party = new Party(guests, food, beverages, entertainment);
            int cost = party.calculateCost();
            System.out.println(String.format("Total cost for your party would be $%d.", cost));

        }


        catch (IOException e){
            e.printStackTrace();
        }


    }

}
