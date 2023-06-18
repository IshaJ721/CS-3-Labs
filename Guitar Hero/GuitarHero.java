 public class GuitarHero {
      public static void main(String[] args) {

          GuitarString[] array = new GuitarString[37];
          for(int i = 0; i<array.length; i++)
          {
         array[i] = new GuitarString(440*Math.pow(1.05956, (i-24)));
          }
          String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
          while (true) {
              // check if the user has typed a key; if so, process it  
         if (StdDraw.hasNextKeyTyped()) {
                  char key = StdDraw.nextKeyTyped();
                  int x = keyboard.indexOf(key);
                  if(x==-1)
                	  continue;
                  else
                	  array[x].pluck();
              }

              // compute the superposition of samples
              double sample=0;
              for(GuitarString x : array)
              {
             sample+=x.sample();
              }
 
              // play the sample on standard audio
              StdAudio.play(sample);
 
              // advance the simulation of each guitar string by one step  
              for(GuitarString x : array)
              {
             x.tic();
              }
          }
       }
  }
