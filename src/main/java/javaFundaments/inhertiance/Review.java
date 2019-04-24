package javaFundaments.inhertiance;

public class Review {
    private User user;
    private Business business;
    private String product;
    private String critique;
    private int rating;

    public Review() {
        this.critique = "corrupted";
        this.rating = 1;
    }

    public Review(User user, Business business, String critique, int rating) {
        this.user = user;
        this.business = business;
        this.critique = critique;
        this.rating = rating;
    }

    public Review(User user, Business business, String product, String critique, int rating) {
        this.user = user;
        this.business = business;
        this.product = product;
        this.critique = critique;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public Business getBusiness() {
        return business;
    }

    @Override
    public String toString() {
        String output = "";
        output += user.getUserName() + " ";
        output += business.name;
        output += " review: " + critique;
        output += " " + rating + "stars";
        return output;
    }
}
