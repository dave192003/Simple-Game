
import java.util.Scanner;
import java.util.Random;
public class GuessTheNumber{
  Random RandomNumber=new Random();
  Scanner scanner=new Scanner(System.in);
  int lives=10;
  int RandomNum= RandomNumber.nextInt(100);
  int CorrectGuess=0;
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
    System.out.print("||||||||||| Difficulty= "+ Difficulty+ " ||||||||||||\n");
    while (islooping){
      
      System.out.println("Remaining Life: "+lives);
      System.out.print("Your Guess: ");
      int guess=scanner.nextInt();
      scanner.nextLine();
      if (guess< RandomNum){
        System.out.println("Higher!");
        lives--;
        
      }
    
      else if (guess >RandomNum){
        System.out.println("Lower!");
        lives--;
      }
      
      
      else{
        System.out.println("Correct!, Well guess!");
        
        CorrectGuess++;
        Difficulty="Hard";
        RandomNum=RandomNumber.nextInt(1000);
        lives=10;
        Range="1 to 1000";
        System.out.println("\n----------------LEVEL UP----------------");
        
      }
      if (CorrectGuess==1&&lives==10){
        System.out.print("||||||||||| Difficulty= "+ Difficulty+ " ||||||||||||\n");
        System.out.println("Guess the hidden number between " +Range+ ". "+ "GOOD LUCK!\n");
        
      }
      
      if (CorrectGuess==2&&lives==10){
        
        RandomNum=RandomNumber.nextInt(100000);
        Range="(unknown)";
        Difficulty= "IMPOSSIBLE";
        
        System.out.print("|||||||| Difficulty= "+ Difficulty+ " ||||||||\n");
        System.out.println("Guess the hidden number between " +Range+ ". "+ "GOOD LUCK!\n");
        System.out.println("You are entering the hardest level, in this level, I will not to tell you the range of numbers. So the number that will generate is so random that possible it reach to a 100,000.\nIf you correct the right number, the developer will give you a money as a price. GOOD LUCK!.");
      }
      
      if (lives<=0){
        islooping=false;
        System.out.println("You ran out of life.");
        System.out.print("The correct number is "+ RandomNum);
      }
    }
  }
}
