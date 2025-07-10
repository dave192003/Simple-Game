import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
public class GuessTheNumber{
  //declaring/initializing of varibles/etc.
  Random RandomNumber=new Random();
  Scanner scanner=new Scanner(System.in);
  int lives=10;
  int RandomNum= RandomNumber.nextInt(101);
  int CorrectGuess=0;
  boolean islooping=true;
  String Difficulty= "Easy";
  String Range= " 1 to 100";
  String name;
  boolean GotBonus=true;

  public static void main(String[] args){
    GuessTheNumber Game=new GuessTheNumber();
    Game.GameStart();
    Game.GameLoop();
    
  }
  public void GameStart(){
    System.out.print("Enter your name: ");
    name= scanner.nextLine();
    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    System.out.println("||||||||||||||| GUESS THE NUMBER GAME ||||||||||||||||");
    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    System.out.println("                     REMEMBER:\nYou have only 10 try to guess the right number, Good luck!");
    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||");
  }
  
  
  public void GameLoop(){
    System.out.println("|||||||Guess the hidden number from " +Range+ "."+ "|||||\n                    GOOD LUCK!\n");
    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    System.out.print("|||||||||||||||||| Difficulty= "+ Difficulty+ " ||||||||||||||||||\n");
    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    //loop
    while (islooping){
      System.out.println("Remaining Life: "+lives);
      System.out.print("Your Guess: ");
      int guess=scanner.nextInt();
      scanner.nextLine();
      
      //Nested loop 
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
        RandomNum=RandomNumber.nextInt(1001);
        lives=10;
        Range="1 to 1000";
      }
      //if statement that checks if user guessed
      //correctly and below code will print.
      if (CorrectGuess==1&&lives==10){
        System.out.println("\n------------------- LEVEL UP -------------------");
        System.out.println("Guess the hidden number between " +Range+ ". "+ "GOOD LUCK!\n");
        System.out.print("||||||||||||||| Difficulty= "+ Difficulty+ " |||||||||||||||\n");
        System.out.println("______________________________________________");
        System.out.println("NOTE: If you guessed the hidden number at this level and your remaining life is equal or greater than 5, you will received another 10 life.");
        
      }
      //cobdition that will check if user guessed
      //the hard level
      if (CorrectGuess==2&&lives==10){
        System.out.println("\n----------------------LEVEL UP----------------------");
        
        RandomNum=RandomNumber.nextInt(100000);
        Range="(unknown)";
        Difficulty= "IMPOSSIBLE";
        System.out.println("You are entering the hardest level, in this level, I will not to tell you the range of numbers. \nIf you guess the right hidden number, the developer will give you a money as a price. GOOD LUCK!.");
        System.out.println("Guess the hidden number between " +Range+ ". "+ "GOOD LUCK!\n");
        System.out.print("||||||||||||||| Difficulty= "+ Difficulty+ " |||||||||||||||\n");
      }
      //this condition checks if user passed the
      //IMPOSSIBLE level and will print out the
      //below code and loop will stop
      if (CorrectGuess==3 ){
        islooping=false;
        GameRecords("Player " + name + "\n");
      }
      //condition that checks if user used his/her all remaining life
      if (lives<=0){
        islooping=false;
        System.out.println("You ran out of life(.");
        System.out.print("The correct number is "+ RandomNum);
      }
      //condition that checks if user guessed the
      //hard level and users life is greater than 
      //five and users will get 10 free lifes
      if (CorrectGuess==2 && lives>=5 && GotBonus==true){
        lives+=10;
        System.out.println("Bonus! You got 10 free life!");
        GotBonus=false;
      }
    }
  }
  
  //This function is used for writing down all users who passed the IMPOSSIBLE level, damn.
  //datas will store on Legend.txt file
  private void GameRecords(String name){
    try (BufferedWriter writer= new BufferedWriter(new FileWriter("Legend.txt",true))){
      writer.write( name);
    } catch (IOException e){
      e.printStackTrace();
    }
  }
  //This function is used for printing all data
  //(Players who passed the IMPOSSIBLE level )
  void RecordReader(){
    try (BufferedReader Reader= new BufferedReader(new FileReader("Legend.txt"))){ 
      String line;
      System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||");
      System.out.println("\n-------------Legendary Players-------------\nListed below are players who passed the hardest level.");
    
      while ((line=Reader.readLine()) != null){
        System.out.println(line);
        }
    }catch (IOException e){
      e.printStackTrace();
    }
  }
}

  
