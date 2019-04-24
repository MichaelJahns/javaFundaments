package javaFundaments.inhertiance;

public class Review {
    private User user;
    private Business subject;
    private String critique;
    private int rating;

    public Review() {
        this.critique = "corrupted";
        this.rating = 1;
    }

    public Review(User user, Business business, String critique, int rating) {
        this.user = user;
        this.subject = business;
        this.critique = critique;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public Business getSubject() {
        return subject;
    }
}
