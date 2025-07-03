
import java.util.Scanner;
import java.util.Random;
public class GuessTheNumber{
  public static void main(String[] args){
    Random RandomNumber=new Random();
    Scanner scanner=new Scanner(System.in);
    int lives=10;
    int Randomnom= RandomNumber.nextInt(100);
    System.out.println("|||||||||||||||||||||||||||||||||||||||||");
    System.out.println("||||||||||GUESS THE NUMBER GAME||||||||||");
    System.out.println("|||||||||||||||||||||||||||||||||||||||||");
    System.out.println("REMEMBER:\nYou have only 10 try to guess the right number, Good luck!");
    System.out.println("|||||||||||||||||||||||||||||||||||||||||");
    boolean islooping=true;
    
    while (islooping){
      System.out.println("Life: "+lives);
      System.out.print("Your Guess: ");
      int guess=scanner.nextInt();
      scanner.nextLine();
      if (guess< Randomnom){
        System.out.println("Higher!");
        lives=lives-1;
      }
      else if (guess >Randomnom){
          System.out.println("Lower!");
          lives=lives-1;
        }
      else{
        System.out.println("Correct!, Well guess!");
        islooping=false;
      }
    }
  }
}
