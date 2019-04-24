package javaFundaments.inhertiance;

public class Restaurant extends Business {
    private String serves;

    public Restaurant(String name, String location, int averagePrice, String serves) {
        super(name, location, averagePrice);
        this.serves = serves;
    }

    @Override
    public String toString() {
        String output = super.toString();
        output += " Serves " + this.serves;
        return output;
    }


}
