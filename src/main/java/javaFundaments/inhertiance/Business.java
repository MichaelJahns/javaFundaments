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
        reviews = new ArrayList();
    }
}
