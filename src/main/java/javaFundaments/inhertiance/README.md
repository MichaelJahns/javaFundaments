# Zelp for You!

### Updates 4-24-19
Zelp now can support business classes of types Restaurant, Shop, and Theater. Each has its own considerations and overwrites to reflect how our users want to have this information returned to them.
Zelp now requires that a review take in a user parameter, this is to insure that every review on a business or product are unique and to prevent deflamatory negative review spamming

### Future Features
Product classes for business owners to easily add and remove products to their stores master product list
The ability for Users to review either a business or a business's specific products
The getReviews() method for users to see all of their reviews

### Guidelines
Businesses of the various types can be initialized like so

    Restaurant <name> = new Restaurant(String name, String location, int averagePrice, String serves)
    Shop <name> = new Shop(String name, String Location int averageprice, String sells)
    Theater <name> = new Theater(String name, String location, int averagePrice)
    
Reviews can be added a restaurants List of reviews using the .addReview() method, where

    <restaurantInstance>.addReview(User user, String author, String critique, int Rating)
  
When a new review is added that restaurant instance automatically updates two of its paramaters, totalStars and rating to reflect the new review

To print a list of Reviews utilize the restaurant class method .getReviews();

    System.out.println(<resturantInstance>.getReviews();)
    
All classes except User have the toString() method overwritten to output more informative Strings

    <businessInstance>.toString();
    <reviewInstance>.toString();
    
Inside the toString method for restaurants, getPrice() is automatically called to turn a restaurants instance of averagePrice from an int to a String with a number of dollar signs equal to the relative cost of the restaurant.
Whenever a new review is made the business rating is recalculated to reflect how the new review has impacted the previous rating. 
