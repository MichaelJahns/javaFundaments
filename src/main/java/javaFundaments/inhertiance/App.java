package javaFundaments.inhertiance;

public class App {
    public static void main(String args[]) {
        User Tom = new User("Tom From Myspace");

        Restaurant chipotles = new Restaurant("Chipotles", "Downtown", 3, "Mexican");
        Shop riteAid = new Shop("Rite Aid", "Bellringer Street", 2, "Convenience");
        Theater silverSkin = new Theater("Silver Skin", "Paramount st.", 5);
        silverSkin.addMovie("Captain Marvel");
        silverSkin.addMovie("End Game");
        silverSkin.addMovie("Captain Marvel");
        silverSkin.removeMovie("End Game");

        System.out.println(silverSkin.toString());
        riteAid.reviewBusiness(Tom, "So nearby and SO convenient.", 5);
        System.out.println(chipotles.getReviews());

        silverSkin.reviewProduct(Tom, "Captain Marvel", "Very cool, thank you Kayne", 5);
    }
}

