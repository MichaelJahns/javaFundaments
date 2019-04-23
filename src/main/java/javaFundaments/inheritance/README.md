# Inheritance
A simple local restaurant model
Reviews extend Restaurant and area subclass of them

### Guidelines
Restaurants are intalized with

    Restaurant <name> = new Restaurant(String name, String location, int averagePrice)
  
Reviews can be added a restaurants List of reviews using the .addReview() method, where

    <restaurantInstance>.addReview(String author, String critique, int Rating)
  
When a new review is added that restaurant instance automatically updates two of its paramaters, totalStars and rating to reflect the new review

To print a list of Reviews utilize the restaurant class method .getReviews();

    System.out.println(<resturantInstance>.getReviews();)
    
Both the Restaurant class and the Review class have had toString() overwritten with more informative Strings

    <restaurantInstance>.toString();
    <reviewInstance>.toString();
    
Inside the toString method for restaurants, getPrice() is automatically called to turn a restaurants instance of averagePrice from an int to a String with a number of dollar signs equal to the relative cost of the restaurant.
