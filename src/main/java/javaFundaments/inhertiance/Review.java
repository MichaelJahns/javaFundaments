package javaFundaments.inhertiance;

public class Review extends Restaurant {
    private String author;
    private String critique;
    private int rating;

    public Review() {
        author = "Annonymous";
        critique = "Food Bad";
        rating = 0;
    }

    public Review(Restaurant restaurant, String author, String critique, int rating) {
        super(restaurant);
        this.author = author;
        this.critique = critique;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        String restaurant = super.toString();
        String output = "";
        output += restaurant;
        output += " Rating: " + this.rating + " stars";
        output += " By: " + this.author;
        output += " Review: " + this.critique;
        return output;
    }
}
