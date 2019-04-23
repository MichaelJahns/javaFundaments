package javaFundaments.inhertiance;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    public String name;
    public String location;
    public int averagePrice;
    public List reviews;
    public int totalStars;
    public float rating;

    public Restaurant() {
        name = "Unnamed";
        location = "Undisclosed Location";
        averagePrice = 0;
    }

    public Restaurant(Restaurant restaurant) {
        name = restaurant.name;
        location = restaurant.location;
        averagePrice = restaurant.averagePrice;
    }

    private Restaurant(String name, String location, int averagePrice) {
        this.name = name;
        this.location = location;
        this.averagePrice = averagePrice;
        reviews = new ArrayList();
    }

    public static void main(String[] args) {
        Restaurant subway = new Restaurant("Subway", "3rd and Bell", 2);
        Restaurant chipotles = new Restaurant("Chipotles", "Downtown", 3);
        Restaurant outback = new Restaurant("Outback", "Tacoma", 4);

        subway.addReview("James Matterson", "Irregular shaped ham", 2);
        subway.addReview("Mable Pouer", "Very good ventiliation", 5);
        subway.addReview("Keel of a boat", "Barely Nautical at all", 4);

        outback.addReview("Tom from Myspace", "How come no one asks how I'm doing?", 4);
        outback.addReview("A funny turtle", "Paid extra for this speaker", 5);
        outback.addReview("Brary Fortsworth", "Reminds me of home", 1);

        chipotles.addReview("Neil Patrick", "I dont eat", 5);
        chipotles.addReview("Hercules", "Eating here was not one of my trials", 5);
        chipotles.addReview("Tilly the Indomitable", "Okay eats. I'd like fresher meat", 4);

        System.out.println("test");
    }

    public Review addReview(String author, String critique, int rating) {
        Review newReview = new Review(this, author, critique, rating);
        this.reviews.add(newReview);
        this.updateRating(newReview);
        return newReview;
    }

    //Overrides
    @Override
    public String toString() {
        String output = "";
        output += this.name + " at " + this.location;
        output += " " + this.getPrice() + "\n";
        output += " ";
        return output;
    }

    //Helper Functions
    public List getReviews() {
        return this.reviews;
    }

    public String getPrice() {
        String dollarSigns = "";
        for (int i = 0; i < averagePrice; i++) {
            dollarSigns += "$";
        }
        return dollarSigns;
    }

    public void updateRating(Review review) {
        this.totalStars += review.getRating();
        this.rating = (float) totalStars / this.reviews.size();
    }
}
