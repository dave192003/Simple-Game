import java.util.Scanner;
public class AsteriskShape{
  public static void main(String[] args){
      Print Print=new Print();
      PrintPyramid PrintPyramid = new PrintPyramid();
      PrintRRT PrintRRT=new PrintRRT();
      PrintDiamond PDiamond=new PrintDiamond();
      Scanner scanner =new Scanner(System.in);
      System.out.print("Print Shapes using asterisk\n");
      System.out.println("_________________________________________");
      boolean islooping=true;
      
      while (islooping){
        System.out.print("Choose shape you to print using asterisk;\n1).Right Triangle\n2).Reversed Right Triangle\n3).Diamond\n4).Pyramid\n5).Square\n6).Rectangle\nYour choice: ");
        int UserChoice=scanner.nextInt();
      
        switch(UserChoice){
          case 1-> Print.triangle();
          case 2-> PrintRRT.RRT();
          case 3-> PDiamond.diamond();
          case 4-> PrintPyramid.pyramid();
          default -> System.out.print("Invalid input");
        }
        System.out.print("Another one?(y/n): ");
        char again=scanner.next().charAt(0);
        if (again=='n'){
          islooping=false;
        }
        
        
      }
      scanner.close();
  }
}
    
    

class Print{
    
    void triangle(){
        int rows=8;
        System.out.println("Output: ");
        
        for (int i=0;i<=rows;i++){
            for (int j=0;j<= i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

            
class PrintPyramid{
    void pyramid(){
        int rows=8;
        System.out.println("Output");
        for (int i=0;i<=rows;i++){
            for (int j=0;j<=(rows-i);j++){
                System.out.print(" ");
            }
            for (int k=0; k<=(2*i)+1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}            
class PrintRRT{
  void RRT(){
    int rows=8;
    for (int i=0;i<=rows;i++){
      for (int j=0;j<=rows-1;j++){
        System.out.print(" ");
      }
      for (int k=0;k<=(rows-rows)+i;k++){
        System.out.print("*");
      }
      System.out.println();
    }
  }
}

class PrintDiamond{
  void diamond(){
    int rows=8;
    for (int i=0;i<=rows;i++){
      for(int j=0;j<=rows-i;j++){
        System.out.print(" ");
      }
      for (int k=0;k<=(2*i)+1;k++){
        System.out.print("*");
      }
      System.out.println();
    }
    for (int a=0;a<=rows;a++){
        for (int b=0;b<=(rows-rows)+a;b++){
            System.out.print(" ");
        }
        for (int c=0;c<=(rows-a)*2;c++){
            System.out.print("*");
        }
        System.out.println();
    }
  }
}
