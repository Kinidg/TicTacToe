import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
class TicTacToe{
    public static void main(String[] args) {
      String[][] Board = { {" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "} };
      Scanner scan = new Scanner(System.in);
      Boolean checkermain;
      int mainrow;
      String anmarker = "";
      int maincol;
      System.out.println("Rules:\n1. When Entering row and column numbers use number 1-3\n2. Do not enter strange inputs\n3. Have Fun!\nType anything when you have finished reading the rules");
      String init = scan.nextLine();
      DrawBoard(Board);
      String marker = Assign();
      if(marker.equals("X")){
        anmarker = "O";
      }
      else if(marker.equals("O")){
        anmarker = "X";
      }
      for(int x = 0; x < 4; x++){
      mainrow = Row();
      maincol = Col();
      Change(mainrow, maincol, marker, Board);
      CompChange(Board, marker);
      DrawBoard(Board);
      if(GameCheckWinner(marker, Board)){
        System.out.println("You win!");
        break;
      }
      if(GameCheckWinner(anmarker, Board)){
        System.out.println("Computer win!");
        break;
      }
    }
    if(!GameCheckWinner(marker, Board)){
      if(!GameCheckWinner(anmarker, Board)){
    mainrow = Row();
    maincol = Col();
    Change(mainrow, maincol, marker, Board);
    DrawBoard(Board);
    if(GameCheckWinner(marker, Board)){
      System.out.println("You win!");
    }
    if(GameCheckWinner(anmarker, Board)){
      System.out.println("Computer win!");
    }
  }
  }
    }
    public static void DrawBoard(String[][] Board){
          System.out.println(Board[0][0] + " | " + Board[0][1] + " | " + Board[0][2]);
          System.out.println("-------------");
          System.out.println(Board[1][0] + " | " + Board[1][1] + " | " + Board[1][2]);
          System.out.println("-------------");
          System.out.println(Board[2][0] + " | " + Board[2][1] + " | " + Board[2][2]);
    }
    public static void EndPiece(String[][] Board, String marker){
      int y = 0;
      for(int x = 0; x<3; x++){
        if(Board[y][x].equals("X") || Board[y][x].equals("O")){
        }
        else{
          Board[y][x] = "X";
        }
      }
      y++;
      for(int x = 0; x<3; x++){
        if(Board[y][x].equals("X") || Board[y][x].equals("O")){
        }
        else{
          Board[y][x] = "X";
        }
      }
      y++;
      for(int x = 0; x<3; x++){
        if(Board[y][x].equals("X") || Board[y][x].equals("O")){
        }
        else{
          Board[y][x] = "X";
        }
      }
    }
    public static int Row(){
      Boolean checker2 = false;
      int row;
      Scanner scan = new Scanner(System.in);
      do{
        try{
          System.out.println("which row?");
          row = scan.nextInt();
        }
        catch(InputMismatchException e){
          System.out.println("Invalid input");
          scan.next();
          continue;
        }
        if(row == 1 || row == 2 || row == 3){
          return row - 1;
        }
      else{
        scan.reset();
        System.out.println("invalid input");
        continue;
      }
    }while(checker2 == false);
    return 0;
    }
    public static Boolean GameFinishWinner(String[][] Board){
    Boolean checker = false;
      for(String[] Row: Board){
        for(String element : Row){
          if(element.length() == 0){
            checker = false;
            }
          else{
              checker = true;
            }
          }
        }return checker;
    }
    public static int Col(){
      Boolean checker3 = false;
      int col;
      Scanner scan = new Scanner(System.in);
      do{
        try{
          System.out.println("which column?");
          col = scan.nextInt();
        }
        catch(InputMismatchException e){
          System.out.println("Invalid input");
          scan.next();
          continue;
        }
        if(col == 1 || col == 2 || col == 3){
          return col - 1;
        }
      else{
        scan.reset();
        System.out.println("invalid input");
        continue;
      }
    }while(checker3 == false);
    return 0;
    }
    public static void CompChange(String[][] example, String marker){
      int row;
      int col;
      String compmark = "";
      boolean checker3;
      if(marker.equals("X")){
        compmark = "O";
      }
      if(marker.equals("O")){
        compmark = "X";
      }
      do{
        row = (int) (3 * Math.random());
        col = (int) (3 * Math.random());
        if(example[row][col].equals(" ")){
          example[row][col] = compmark;
          checker3 = true;
        }
        else{
          checker3 = false;
        }
      }while(checker3 == false);
    }
    public static String Assign(){
      String marker;
      Boolean checker;
      Scanner scan = new Scanner(System.in);
      do{
      System.out.println("Do you want to be X or O");
      String XO = scan.nextLine();
      if(XO.equals("X")){
        marker = XO;
        return marker;
      }
      else if(XO.equals("O")){
        marker = XO;
        return marker;
      }
      else{
        System.out.println("Sorry, thats not a valid input");
        checker = false;
          }
        }while(checker == false);
        return null;
        }
        public static void Change(int row, int col, String marker, String[][] example){
        int newrow = 0;
        int newcol = 0;
        Boolean changecheck = true;
        Boolean spotcheck = example[row][col].equals("O");
        Boolean spotcheck2 = example[row][col].equals("X");
        if(spotcheck == true || spotcheck2 == true){
        do{
          System.out.println("This spot has been taken. re-enter your position");
          newrow = Row();
          newcol = Col();
          if(example[newrow][newcol].equals("O") || example[newrow][newcol].equals("X")){
            continue;
          }
          else{
            example[newrow][newcol] = marker;
            changecheck = false;
          }
        }while(changecheck == true);
        }
        else{
          example[row][col] = marker;
        }
      }
      public static Boolean GameCheckWinner(String marker, String[][] board){
        Boolean gamecheck;
        if(board[0][0].equals(marker) && board[0][1].equals(marker) && board[0][2].equals(marker)){
           return true;
        }
        if(board[1][0].equals(marker) && board[1][1].equals(marker) && board[1][2].equals(marker)){
           return true;
        }
        if(board[2][0].equals(marker) && board[2][1].equals(marker) && board[2][2].equals(marker)){
           return true;
        }
        if(board[0][0].equals(marker) && board[1][0].equals(marker) && board[2][0].equals(marker)){
           return true;
        }
        if(board[0][1].equals(marker) && board[1][1].equals(marker) && board[2][2].equals(marker)){
           return true;
        }
        if(board[0][2].equals(marker) && board[1][2].equals(marker) && board[2][2].equals(marker)){
           return true;
        }
        if(board[0][0].equals(marker) && board[1][1].equals(marker) && board[2][2].equals(marker)){
           return true;
        }
        if(board[0][2].equals(marker) && board[1][1].equals(marker) && board[2][0].equals(marker)){
           return true;
        }
        return false;
      }
}
