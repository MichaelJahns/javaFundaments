package javaFundaments.inhertiance;

public class Restaurant extends Business {
    public Restaurant(String name, String location, int averagePrice) {
        super(name, location, averagePrice);

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
}
