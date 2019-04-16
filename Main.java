public class Main{
    public static void main(String[] args){
      pluraize("Lizard", 0);
      pluraize("Pig", 1);
      pluraize("Pigmy Elephant", 17);

      flipNHeads(4);
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
    public static void flipNHeads(int n){
      int heads = 0;
      int attempts = 0;
 
      while(heads < n){
        attempts ++;
        int flip = (int) Math.round(Math.random());
        if(flip == 0){
          System.out.println("tails");
        }if(flip == 1){
          System.out.println("heads");
          heads++;
        }
      }
      if(heads == n){
        System.out.println("It took " + attempts + " coin flips to get " + n + " heads");
      }
    }
}