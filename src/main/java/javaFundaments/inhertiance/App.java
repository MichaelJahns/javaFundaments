package javaFundaments.inhertiance;

public class App {
    public static void main(String args[]) {
        User Tom = new User("Tom From Myspace");
        Restaurant chipotles = new Restaurant("Chipotles", "Downtown", 3, "Mexican");
        chipotles.addReview(Tom, "How come no one asks how I'm doing?", 4);
        chipotles.addReview(Tom, "No Seriously", 1);
//        outback.addReview("A funny turtle", "Paid extra for this speaker", 5);
//        outback.addReview("Brary Fortsworth", "Reminds me of home", 1);
//
//        chipotles.addReview("Neil Patrick", "I dont eat", 5);
//        chipotles.addReview("Hercules", "Eating here was not one of my trials", 5);
//        chipotles.addReview("Tilly the Indomitable", "Okay eats. I'd like fresher meat", 4);
//        System.out.println(chipotles.toString());
    }
}

