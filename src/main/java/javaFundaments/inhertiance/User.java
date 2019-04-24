package javaFundaments.inhertiance;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    public List<Review> history;

    public User() {

    }

    public User(String userName) {
        this.userName = userName;
        this.history = new ArrayList<>();
    }

    public boolean ensureUniqueFeedBack(Business business) {
        boolean hasReviewed = false;
        //Break immediately if its a users first review
        if (this.getHistory() == null) {
            return hasReviewed;
        }
        for (Review r : this.history) {
            if (r.getSubject() == business) {
                hasReviewed = true;
            }
        }
        return hasReviewed;
    }

    protected String getUserName() {
        return userName;
    }

    protected List getHistory() {
        return history;
    }
}
