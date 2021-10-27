import java.io.*;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("************ Tic Tac Toe ************");
        System.out.println("Enter your choice \n1) X \n2) O");
        String choice = sc.next();
        choice = choice.toUpperCase();
        Board tictactoe = new Board(choice);

        System.out.println("Welcome Player!");
        tictactoe.display();
        do {
            System.out.print("Enter your position: ");
            int index = sc.nextInt();
            tictactoe.add(index);
            tictactoe.display();
        } while(!tictactoe.getWinner());
        if(tictactoe.winnerFlag) 
            System.out.println("JVM is the winner!!!");
        else 
            System.out.println("Player is the winner!!!");       
    }
}
