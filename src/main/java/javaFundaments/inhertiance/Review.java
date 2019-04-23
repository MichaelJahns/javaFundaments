package javaFundaments.inhertiance;

public class Review extends Restaurant {
    public String author;
    public String critique;
    public int rating;

    public Review() {
        this.author = "Annonymous";
        this.critique = "Food Bad";
        this.rating = 5;
    }

    public Review(Restaurant restaurant, String author, String critique, int rating) {
        super(restaurant.name, restaurant.location);
        this.author = author;
        this.critique = critique;
        this.rating = rating;
    }

    @Override
    public String toString() {
        String output = "";
        output = this.name + " at " + this.location + ", Rating: " + this.rating + " stars, By: " + this.author + ", Review: " + this.critique;
        return output;
    }
}
