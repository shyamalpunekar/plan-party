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
                } else if (userAnswer.equalsIgnoreCase("YES")) {
                    boolean programRunning = true;

                    System.out.println("How many guests are you expecting at your party? Enter a number");
                    guests = Integer.parseInt(bufferedReader.readLine());
                    boolean isFoodChoiceSelected = true;

                    while (isFoodChoiceSelected) {
                        System.out.println("Please choose one of the following for your food service: Full Course, Light Meal or Snacks");
                        food = bufferedReader.readLine().toLowerCase();

                        if (!(food.equalsIgnoreCase("Full course") || food.equalsIgnoreCase("Light meal") || food.equalsIgnoreCase("Snacks"))) {
                            System.out.println("Sorry, we don't recognize your input. Please enter one of the following: " +
                                    "full course, light meal, snacks.");
                        } else {
                            isFoodChoiceSelected = false;
                        }
                    }


                    boolean isBeveragesOptionSelected = true;
                    while (isBeveragesOptionSelected) {
                        System.out.println("Please choose one of the options for beverages: Full bar, Light Refreshments, Water");
                        beverages = bufferedReader.readLine().toLowerCase();
                        if (!(beverages.equalsIgnoreCase("full bar") || beverages.equalsIgnoreCase("light refreshments")
                                || beverages.equalsIgnoreCase("water"))) {
                            System.out.println("Sorry, we don't recognize your input. Please enter one of the following: " +
                                    "full bar, light refreshments, water.");
                        } else {
                            isBeveragesOptionSelected = false;
                        }
                    }


                    boolean isEntertainmentOptionSelected = true;
                    while (isEntertainmentOptionSelected) {
                        System.out.println("Please choose one of the options for Entertainment: Live Band, DJ, None");
                        entertainment = bufferedReader.readLine().toLowerCase();
                        if (!(entertainment.equalsIgnoreCase("Live Band") || entertainment.equalsIgnoreCase("DJ")
                                || entertainment.equalsIgnoreCase("None"))) {
                            System.out.println("Sorry, we don't recognize your input. Please enter one of the following: " +
                                    "Live Band, DJ, None.");
                        } else {
                            isEntertainmentOptionSelected = false;
                        }
                    }

                    while (programRunning) {
                        Party party = new Party(guests, food, beverages, entertainment, false);
                        int cost = party.calculateCost(false, false);
                        boolean isDiscount = true;

                        while (isDiscount) {


                            if (guests >= 150 && food.equalsIgnoreCase("Full course")) {
                                System.out.println(String.format("Total cost for your party would be $%d.", cost));

                                System.out.println("Please enter your coupon code to see the discounted amount.");
                                String couponCode = bufferedReader.readLine().toLowerCase();
                                party = new Party(guests, food, beverages, entertainment, true);
                                cost = party.calculateCost(true, false);
                                System.out.println(String.format("Here are the details for your party: Number of guests: %d, " + "Food Service: %s, Beverage Service: %s, Entertainment: %s. Would you like to create a " + "new party or see the                                     cost estimate for this party? Enter one of the following options: " + "New Party or See Cost", guests, food, beverages, entertainment));
                                System.out.println(String.format("Total cost for your party would be $%d.", cost));
                                if (beverages.equalsIgnoreCase("full bar")) {
                                    System.out.println("Please enter your coupon code to see the discounted amount.");
                                     couponCode = bufferedReader.readLine().toLowerCase();

                                    party = new Party(guests, food, beverages, entertainment, true);
                                    cost = party.calculateCost(true, true);
                                    System.out.println(String.format("Here are the details for your party: Number of guests: %d, " + "Food Service: %s, Beverage Service: %s, Entertainment: %s. Would you like to create a " + "new party or see the                                     cost estimate for this party? Enter one of the following options: " + "New Party or See Cost", guests, food, beverages, entertainment));
                                    System.out.println(String.format("Total cost for your party would be $%d.", cost));
                                }

                                isDiscount = false;
                            } else {
                                Random randomGenerator = new Random();
                                String[] foodArray = {"Full Course", "Light Meal", "Snacks"};
                                String[] beverageArray = {"Full bar", "Light Refreshments", "Water"};
                                String[] entertainmentArray = {"Live Band", "DJ", "none"};
                                System.out.println(String.format("Total cost for your party would be $%d.", cost));
                                System.out.println(String.format("Here are the details for your party: Number of guests: %d, " +
                                        "Food Service: %s, Beverage Service: %s, Entertainment: %s." +
                                        "", guests, food, beverages, entertainment));

                                guests = 150;
                                food = foodArray[randomGenerator.nextInt(1)];
                                beverages = beverageArray[randomGenerator.nextInt(1)];
                                entertainment = entertainmentArray[randomGenerator.nextInt(2)];

                                party = new Party(guests, food, beverages, entertainment, true);
                                cost = party.calculateCost(true, true);

                                //System.out.println(String.format("Here are the details if you change your preferences Number of guests: %d, " +
                                        //"Food Service: %s, Beverage Service: %s, Entertainment: %s." +
                                       // "New Party or See Cost", guests, food, beverages, entertainment));
                                //System.out.println(String.format("Total cost for your party would be $%d.", cost));
                                isDiscount = false;

                            }
                        }
                        programRunning = false;

                    }
                    mainAppRunning = false;
                } else {
                    System.out.println("Sorry, We don't recognize your input. Please enter YES or NO.");
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
