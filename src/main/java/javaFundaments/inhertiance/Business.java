package javaFundaments.inhertiance;

import java.util.ArrayList;
import java.util.List;

public abstract class Business {
    public String name;
    public String location;
    public int averagePrice;
    public double rating;
    public List<Review> reviews;

    public Business(String name, String location, int averagePrice) {
        this.name = name;
        this.location = location;
        this.averagePrice = averagePrice;
        this.reviews = new ArrayList();
    }

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

    private int getTotalStars() {
        int totalStars = 0;
        for (Review r : reviews) {
            totalStars += r.getRating();
        }
        return totalStars;
    }

    public void updateRating() {
        int totalStars = getTotalStars();
        this.rating = (float) totalStars / this.reviews.size();
    }


    public String toString() {
        String rating = (String) String.format("%.2f", this.rating);
        String output = "";
        output += this.name + ", " + this.location;
        output += ": " + rating + " stars " + this.getPrice();
        return output;
    }

    public Review reviewBusiness(User user, String critique, int rating) {
        boolean unique = user.ensureUniqueFeedBack(this);
        if (unique == false) {
            Review newReview = new Review(user, this, critique, rating);
            this.reviews.add(newReview);
            this.updateRating();
            user.history.add(newReview);

            return newReview;
        } else {
            System.out.println("Stopping.. user has already reviewed this business once");
            return null;
        }
    }

    //If I had a week with this project, product would be an abstract and i would make a movie class to pass in.
    public Review reviewProduct(User user, String product, String critique, int rating) {
        boolean unique = user.ensureUniqueFeedBack(this);
        if (unique == false) {
            Review newReview = new Review(user, this, product, critique, rating);
            this.reviews.add(newReview);
            this.updateRating();
            user.history.add(newReview);

            return newReview;
        } else {
            System.out.println("Stopping.. user has already reviewed this business once");
            return null;
        }
    }

    ;
}