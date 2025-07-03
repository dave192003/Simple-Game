
import java.util.Scanner;
import java.util.Random;
public class GuessTheNumber{
  Random RandomNumber=new Random();
  Scanner scanner=new Scanner(System.in);
  int lives=10;
  int RandomNum= RandomNumber.nextInt(100);
  boolean islooping=true;
  String Difficulty= "Easy";
  String Range= " 1 to 100";
  
  public static void main(String[] args){
    GuessTheNumber Game=new GuessTheNumber();
    Game.GameStart();
    Game.GameLoop();
  }
  public void GameStart(){
    System.out.println("|||||||||||||||||||||||||||||||||||||||||");
    System.out.println("||||||||||GUESS THE NUMBER GAME||||||||||");
    System.out.println("|||||||||||||||||||||||||||||||||||||||||");
    System.out.println("REMEMBER:\nYou have only 10 try to guess the right number, Good luck!");
    System.out.println("|||||||||||||||||||||||||||||||||||||||||");
  }
  
  
  public void GameLoop(){
    
    System.out.println("Guess the hidden number between" +Range+ "."+ "GOOD LUCK!\n");
    System.out.println("Difficulty= "+ Difficulty);
    while (islooping){
      
      System.out.println("Remaining Life: "+lives);
      System.out.print("Your Guess: ");
      int guess=scanner.nextInt();
      scanner.nextLine();
      if (guess< RandomNum){
        System.out.println("Higher!");
        lives=lives-1;
        
      }
      else if (guess >RandomNum){
        System.out.println("Lower!");
        lives=lives-1;
      }
      
      else{
        System.out.println("Correct!, Well guess!");
        Difficulty="Hard";
        RandomNum=RandomNumber.nextInt(500);
        lives=10;
        Range="1 to 500";
        System.out.println("----------------LEVEL UP----------------");
        System.out.println("Difficulty= "+ Difficulty);
        System.out.println("Guess the hidden number between " +Range+ ". "+ "GOOD LUCK!\n");
      }
      if (lives<=0){
        islooping=false;
        System.out.println("You ran out of life.");
        System.out.print("The correct number is "+ RandomNum);
      }
    }
  }
}
