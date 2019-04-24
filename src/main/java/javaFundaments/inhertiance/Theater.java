package javaFundaments.inhertiance;

import java.util.ArrayList;
import java.util.List;

public class Theater extends Business {
    private List<String> showing;

    public Theater(String name, String location, int averagePrice) {
        super(name, location, averagePrice);
        this.showing = new ArrayList<>();
    }

    public void addMovie(String name) {
        if (showing.indexOf(name) == -1) {
            showing.add(name);
        } else {
            System.out.println(name + " was not added. That movie is already listed as showing");
        }
    }

    public void removeMovie(String name) {
        showing.remove(name);
    }

    public List<String> getShowing() {
        return showing;
    }

    @Override
    public String toString() {
        String output = super.toString();
        output += "\n Now Showing: ";
        for (String movie : showing) {
            output += "\n " + movie;
        }
        return output;
    }


}
