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

    public Party(int guests, String food, String beverages, String entertainment) {
        this.numberOfGuests = guests;
        this.yumFood = food.toLowerCase();
        this.yumBeverages = beverages.toLowerCase();
        this.yoEntertainment = entertainment.toLowerCase();
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


    public int calculateCost() {
        if (yumFood.equals("full course")){
            yumFoodCost = 80;
        } else if (yumFood.equals("light meal")){
            yumFoodCost = 20;
        } else {
            yumFoodCost = 10;
        }

        if (yumBeverages.equals("full bar")){
            yumBeverageCost = 50;
        } else if (yumBeverages.equals("light refreshments")){
            yumBeverageCost = 10;
        } else {
            yumBeverageCost = 5;
        }

        if (yoEntertainment.equals("live band")){
            yoEntertainmentCost = 2200;
        } else if (yoEntertainment.equals("dj")){
            yoEntertainmentCost = 1500;
        } else {
            yoEntertainmentCost = 500;
        }

        totalCostOfTheEvent = ((yumFoodCost + yumBeverageCost) * numberOfGuests + yoEntertainmentCost);

        return totalCostOfTheEvent;
    }
}
