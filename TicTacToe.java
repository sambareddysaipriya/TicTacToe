import java.util.*;
public class TicTacToe{
    public static boolean helper(char a[][],char player){
        for(int i=0;i<3;i++){
            if(a[i][0]==player&&a[i][1]==player&&a[i][2]==player){
                return true;
            }
        }
        for(int i=0;i<3;i++){
            if(a[0][i]==player&&a[1][i]==player&&a[2][i]==player){
                return true;
            }
        }
        if(a[0][0]==player&&a[1][1]==player&&a[2][2]==player)
        return true;
        if(a[0][2]==player&&a[1][1]==player&&a[2][0]==player)
        return true;
        return false;
    }
    public static void printBoard(char[][] a){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(j==2){
                    System.out.print(a[i][j]);
                }
                else
                System.out.print(a[i][j]+" | ");
            }
            System.out.println();
            if(i!=2)
            System.out.println("-   -   -");
        }
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        char board[][]=new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=' ';
            }
        }
        char player='X';
        boolean b=false;
        int count=0;
        while(!b){
            printBoard(board);
            System.out.println("Player "+player+" enter: ");
            int r=s.nextInt();
            int c=s.nextInt();
            if(board[r][c]==' '){
                board[r][c]=player;
                b=helper(board,player);
                if(b){
                    System.out.println("Player "+player+" has won!");
                    printBoard(board);
                    return;
                }
                else{
                    if(player=='X')
                    player='O';
                    else
                    player='X';
                }
                count++;
            }
            else{
                System.out.println("Invalid move. Try again!");
            }
            if(count==9)
            break;
        }
        if(count==9)
        System.out.println("Draw");
        printBoard(board);
    }
}