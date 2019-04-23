package javaFundaments.inhertiance;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    public String name;
    public String location;
    public List reviews;


    public Restaurant() {
        this.name = "Food dispensary";
        this.location = "Near you";
        this.reviews = new ArrayList();
    }

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
        this.reviews = new ArrayList();
    }

    public static void main(String[] args) {
        Restaurant subway = new Restaurant("Subway", "3rd and Bell");
        Restaurant chipotles = new Restaurant("Chipotles", "Downtown");
        Restaurant outback = new Restaurant("Outback", "Tacoma");

        subway.addReview(subway, "James Matterson", "Irregular shaped ham", 2);
        subway.addReview(subway, "Mable Pouer", "Very good ventiliation", 5);
        subway.getReviews();

        System.out.println(outback.addReview(outback, "Brary Fortsworth", "Reminds me of Home. I hate home", 2).toString());
    }

    public static Review addReview(Restaurant restaurant, String author, String critique, int rating) {
        Review newReview = new Review(restaurant, author, critique, rating);
        restaurant.reviews.add(newReview);
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
