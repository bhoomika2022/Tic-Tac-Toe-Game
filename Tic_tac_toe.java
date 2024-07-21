import java.util.Scanner;
public class Tic_tac_toe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                board[r][c] = ' ';
            }
        }
        char player = 'X';
        boolean gameover = false;
        Scanner sc = new Scanner(System.in);
        while (!gameover && !NobodyWon(board) ){
            //printing board
            Printboard(board);
            //placing the X and O
            System.out.println("Player "+ player+ " enter the row and column of the box ");
            int row = sc.nextInt();
            int column = sc.nextInt();
            if(board[row][column]==' '){
                board[row][column]= player;
                //checkin if the game is over or not
                gameover=haveWon(board, player);
                if(gameover){
                    System.out.println("Player "+ player+ " has won!");
                }
                //switching player
                else{
//                    if(player=='X'){
//                        player='O';
//                    }
//                    else{
//                        player='X';
//                    }
                    player = (player=='X')? 'O': 'X';
                }
            }else{
                System.out.println("invalid move! Try again in another box.");
            }
        }
        Printboard(board);
        if(
                haveWon(board, player)==false
        ){
            System.out.println("game is over and nobody won");
        }
    }
    public static boolean haveWon(char[][] board, char player){

        //check for diagonals
        if(board[0][0]==player&&board[1][1]==player&&board[2][2]==player){
            return true;
        } else if (board[0][2]==player&&board[1][1]==player&&board[2][0]==player) {
            return true;
        }
        //check for rows
        for (int r=0; r<board.length; r++){
            if(board[r][0]==player&&board[r][1]==player&&board[r][2]==player){
                return true;
            }
        }
        // check for columns
        for (int c=0; c<board.length; c++){
            if(board[0][c]==player&&board[1][c]==player&&board[2][c]==player){
                return true;
            }
        }

        return false;

    }

    public static void Printboard(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                System.out.print(board[r][c] + "| ");
            }
            System.out.println();
        }

    }
    public static boolean NobodyWon(char[][] board){
        int count =0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if(board[r][c]=='X'||board[r][c]=='O'){
                    count++;
                }
            }
        }
        if(count==9){
            return true;
        }
        return false;
    }
}