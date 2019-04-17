import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main{
    public static void main(String[] args){
      System.out.println(pluralize("Lizard", 0));
      System.out.println(pluralize("Pig", 1));
      System.out.println(pluralize("Pigmy Elephant", 17));

      flipNHeads(1);
      flipNHeads(4);
      flipNHeads(10);

      clock();
    }

    public static String pluralize(String animal, int herdSize){
      String output = " ";
      if(herdSize == 0 || herdSize > 1){
        output = animal + "s";
      } else{
        output = animal;
      }
      return output;
    }

    public static void flipNHeads(int n){
      int heads = 0;
      int attempts = 0;
 
      while(heads < n){
        attempts ++;
        int flip = (int) Math.round(Math.random());
        if(flip == 0){
          heads = 0;
          System.out.println("tails");
        }if(flip == 1){
          System.out.println("heads");
          heads++;
        }
      }
        System.out.println("It took " + attempts + " coin flips to get " + n + " heads");
    }

    public static void clock(){
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
      //Constants for unit conversion
      float GHz = 1_000_000_000f;
      float MHz = 1_000_000f;
      float KHz = 1_000f;
      int Hz = 1;

      String previousTime = " ";
      int cycles = 0;

      while(true){
        String formattedTime = LocalDateTime.now().format(formatter);
        cycles ++;

        if(!formattedTime.equals(previousTime)){

          String units = 
            cycles > GHz ? "GHz" 
            : cycles > MHz ? "MHz" 
            : cycles > KHz ? "KHz" 
            : "Hz";
          float condensedCycles = 
            cycles > GHz ? cycles/GHz
            : cycles > MHz ? cycles/MHz 
            : cycles > KHz ? cycles /KHz
            : cycles;

          System.out.println(formattedTime + "  " + condensedCycles + " " + units);

          previousTime = formattedTime;
          cycles = 0;
        }    
      }
    }
}
