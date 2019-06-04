package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Bingo!!!" +
                "\n\nHere are the rules for the game: " +
                "\n\n-Each round, a number will be randomly chosen 1-100" +
                "\n-The game will search through your board to find the number" +
                "\n-If it finds the number, it will remove it an replace it with the number 0" +
                "\n-The game will also continuously check if you have bingo" +
                "\n-There are also a variety of mini games to play that you can choose to play after each bingo round!" +
                "\n-It's up to you to decide what kind of Bingo game you'd like to play" +
                "\n-There are four versions of Bingo we offer: " +
                "\n     ~Original: Across, Up+Down, and Diagonal Bingo(O)" +
                "\n     ~Four Corners(FC)" +
                "\n     ~T-Shaped(T)" +
                "\n     ~Four Sides(FS)" +
                "\n\nSo, what game would you like to play today? ");

        Scanner gameType = new Scanner(System.in);
        String gt = gameType.next();

        boolean noEndGame = true;

        bingoo bb = new bingoo(5, 5, gt);

        int bingoBoard[][] = bb.createBoard();


        bb.playTutorial(bb, bingoBoard);

        while (bb.yon) {

            bb.playBingoRound(bb, bingoBoard);

        }

    }

    //HERE IS LINK TO FRAMES AND SUCH: https://www.quora.com/Can-I-create-a-game-with-Java

}
