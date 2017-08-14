package models;

/**
 * Created by spunek on 8/4/17.
 */
public class Party {

    private int numberOfGuests;
    private String yumFood;
    private String yumBeverages;
    private String yoEntertainment;
    private int yumFoodCost;
    private int yumBeverageCost;
    private int yoEntertainmentCost;
    private int totalCostOfTheEvent;
    private boolean isDiscounted;

    public Party(int guests, String food, String beverages, String entertainment, boolean isDiscounted) {
        this.numberOfGuests = guests;
        this.yumFood = food.toLowerCase();
        this.yumBeverages = beverages.toLowerCase();
        this.yoEntertainment = entertainment.toLowerCase();
        this.isDiscounted = isDiscounted;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getYumFood() {
        return yumFood;
    }

    public String getYumBeverages() {
        return yumBeverages;
    }

    public String getYoEntertainment() {
        return yoEntertainment;
    }

    public int getYumFoodCost() {
        return yumFoodCost;
    }

    public int getYumBeverageCost() {
        return yumBeverageCost;
    }

    public int getYumEntertainmentCost() {
        return yoEntertainmentCost;
    }

    public int getYumTotalCost() {
        return totalCostOfTheEvent;
    }


    public int calculateCost(boolean isFirstDiscount, boolean isSecondDiscount) {
        if (yumFood.equalsIgnoreCase("full course")){
            yumFoodCost = 80;
        } else if (yumFood.equals("light meal")){
            yumFoodCost = 20;
        } else {
            yumFoodCost = 10;
        }

        if (yumBeverages.equalsIgnoreCase("full bar")){
            yumBeverageCost = 50;
        } else if (yumBeverages.equals("light refreshments")){
            yumBeverageCost = 10;
        } else {
            yumBeverageCost = 5;
        }

        if (yoEntertainment.equalsIgnoreCase("live band")){
            yoEntertainmentCost = 2200;
        } else if (yoEntertainment.equals("dj")){
            yoEntertainmentCost = 1500;
        } else {
            yoEntertainmentCost = 500;
        }

        totalCostOfTheEvent = ((yumFoodCost + yumBeverageCost) * numberOfGuests + yoEntertainmentCost);

        if(isFirstDiscount) {
            totalCostOfTheEvent = totalCostOfTheEvent - 50;
        }
        if(isSecondDiscount) {
            totalCostOfTheEvent = totalCostOfTheEvent - 50;
        }
        return totalCostOfTheEvent;
    }
}
