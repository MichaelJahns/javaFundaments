package javaFundaments.inhertiance;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    public String name;
    public String location;
    public int averagePrice;
    public List reviews;


    public Restaurant() {
        this.name = "Food dispensary";
        this.location = "Near you";
        this.averagePrice = 1;
        this.reviews = new ArrayList();
    }

    public Restaurant(Restaurant restaurant) {
        this.name = restaurant.name;
        this.location = restaurant.location;
        this.averagePrice = restaurant.averagePrice;
    }

    public Restaurant(String name, String location, int averagePrice) {
        this.name = name;
        this.location = location;
        this.averagePrice = averagePrice;
        this.reviews = new ArrayList();
    }

    public static void main(String[] args) {
        Restaurant subway = new Restaurant("Subway", "3rd and Bell", 2);
        Restaurant chipotles = new Restaurant("Chipotles", "Downtown", 3);
        Restaurant outback = new Restaurant("Outback", "Tacoma", 4);

        subway.addReview(subway, "James Matterson", "Irregular shaped ham", 2);
        subway.addReview(subway, "Mable Pouer", "Very good ventiliation", 5);
        subway.getReviews();

        outback.addReview(outback, "Brary Fortsworth", "Reminds me of home", 1);
    }

    public static Review addReview(Restaurant restaurant, String author, String critique, int rating) {
        Review newReview = new Review(restaurant, author, critique, rating);
        restaurant.reviews.add(newReview);
        System.out.println(newReview.toString());
        return newReview;
    }

//    public void updateStars() {
//        double averageRating = 0;
//        for (int i = 0; i < this.reviews.size(); i++) {
//            averageRating += [i];
//        }
//    }

    public List getReviews() {
        return this.reviews;
    }
}
