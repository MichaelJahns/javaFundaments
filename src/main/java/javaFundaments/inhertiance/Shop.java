package javaFundaments.inhertiance;

public class Shop extends Business {
    private String sells;

    public Shop(String name, String location, int averagePrice, String sells) {
        super(name, location, averagePrice);
        this.sells = sells;
    }

    @Override
    public String toString() {
        String output = super.toString();
        output += " Sells " + this.sells;
        return output;

    }
}
