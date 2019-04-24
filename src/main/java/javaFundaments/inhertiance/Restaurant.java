package javaFundaments.inhertiance;

public class Restaurant extends Business {
    public String type;

    public Restaurant(String name, String location, int averagePrice, String type) {
        super(name, location, averagePrice);
        this.type = type;
    }

    @Override
    public String toString() {
        String output = super.toString();
        output += " " + this.type;
        return output;
    }

    public Review addReview(User user, String critique, int rating) {
        boolean unique = user.ensureUniqueFeedBack(this);
        if (unique == false) {
            Review newReview = new Review(user, this, critique, rating);
            this.reviews.add(newReview);
            this.updateRating();
            user.history.add(newReview);

            return newReview;
        }
        return null;
    }
}
