package javaFundaments.inhertiance;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends Business {

    public String name;
    public String location;
    public int averagePrice;
    public List<Review> reviews;
    public float rating;

    public Restaurant(String name, String location, int averagePrice) {
        super(name, location, averagePrice);
        this.name = name;
        this.location = location;
        this.averagePrice = averagePrice;
        reviews = new ArrayList();
    }

    public static void main(String[] args) {
        Restaurant chipotles = new Restaurant("Chipotles", "Downtown", 3);
        Restaurant outback = new Restaurant("Outback", "Tacoma", 4);


        outback.addReview("Tom from Myspace", "How come no one asks how I'm doing?", 4);
        outback.addReview("A funny turtle", "Paid extra for this speaker", 5);
        outback.addReview("Brary Fortsworth", "Reminds me of home", 1);

        chipotles.addReview("Neil Patrick", "I dont eat", 5);
        chipotles.addReview("Hercules", "Eating here was not one of my trials", 5);
        chipotles.addReview("Tilly the Indomitable", "Okay eats. I'd like fresher meat", 4);
        System.out.println(chipotles.getReviews());
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
        int totalStars = getTotalStars();
        this.rating = (float) totalStars / this.reviews.size();
    }

    private int getTotalStars() {
        int totalStars = 0;
        for (Review r : reviews) {
            totalStars += r.getRating();
        }
        return totalStars;
    }

    public Review addReview(String author, String critique, int rating) {
        Review newReview = new Review(this, author, critique, rating);
        this.reviews.add(newReview);
        this.updateRating(newReview);
        return newReview;
    }
}
