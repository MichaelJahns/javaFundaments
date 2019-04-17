import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main{
    public static void main(String[] args){
      pluraize("Lizard", 0);
      pluraize("Pig", 1);
      pluraize("Pigmy Elephant", 17);

      flipNHeads(1);
      flipNHeads(4);
      flipNHeads(10);

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
          String units = cycles > 1000000000 ? "GHz" : cycles > 1000000 ? "MHz" : cycles > 1000 ? "KHz" : "Hz";
          float condensedCycles = cycles > 1000000000 ? cycles/1000000000f : cycles > 1000000 ? cycles/1000000f : cycles > 1000 ? cycles /1000f: cycles;

          System.out.println(formattedTime + "  " + condensedCycles + " " + units);

          previousTime = formattedTime;
          cycles = 0;
        }    
      }
    }
}
