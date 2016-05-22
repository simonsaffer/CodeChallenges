import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args){

    try {
      Scanner sc = new Scanner(new File(args[0]));

      while(sc.hasNextInt()){

        int nbrOfDoors = sc.nextInt();
        int nbrOfIterations = sc.nextInt();

        int nbrOfOpenDoors = 0;
        for(int i = 0; i < nbrOfDoors; i++){
          if (i % 6 == 0){

              ++nbrOfOpenDoors;

          } else if(i % 3 == 0 ) {

            if(nbrOfIterations % 2 != 0){
              ++nbrOfOpenDoors;
            }

          } else if(i % 2 != 0){
            ++nbrOfOpenDoors;
          }
        }

        System.out.println(nbrOfOpenDoors);
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

}
