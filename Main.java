public class Main{
    public static void main(String[] args){
      pluraize("Lizard", 0);
      pluraize("Pig", 1);
      pluraize("Pigmy Elephant", 17);
    }
    public static void pluraize(String animal, int herdSize){
      if(herdSize == 0){
        System.out.println("Do you have any " + animal + "'s?");
      }
      else if(herdSize == 1){
        System.out.println("You have a " + animal + "?");
      } else{
        System.out.println("You have " + herdSize + " " +animal + "'s?");
      }
    }
}