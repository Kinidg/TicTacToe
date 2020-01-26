import java.util.Scanner;
class check{
  public static void main(String[] args) {
    String[][] Board = { {"X", "O", "X"}, {"O", "O", "O"}, {"X", "X", "X"} };
    for(String[] Row: Board){
      for(String element : Row){
        String.toLowerCase(element);
      }
    }
    }
  }
}
