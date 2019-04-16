import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main{
    public static void main(String[] args){
      pluraize("Lizard", 0);
      pluraize("Pig", 1);
      pluraize("Pigmy Elephant", 17);

      flipNHeads(4);

      clock();
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

    public static void clock(){
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
      String previousTime = " ";
      int cycles = 0;

      for(;;){
        String formattedTime = LocalDateTime.now().format(formatter);

        cycles ++ ;

        if(!formattedTime.equals(previousTime)){
          System.out.println(formattedTime + "  " +(float) cycles/1000000 + "MHz");

          previousTime = formattedTime;
          cycles = 0;
        }    
      }
    }
}