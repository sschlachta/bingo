package com.company;
import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Bingo!!!" +
                "\n\nHere are the rules for the game: " +
                "\n\n-Each round, a number will be randomly chosen 1-100" +
                "\n-The game will search through your board to find the number" +
                "\n-If it finds the number, it will remove it an replace it with the number 0" +
                "\n-The game will also continuously check if you have bingo" +
                "\n-It's up to you to decide what kind of Bingo game you'd like to play" +
                "\n-There are four versions we offer: " +
                "\n     ~Original: Across, Up+Down, and Diagonal Bingo(O)" +
                "\n     ~Four Corners(FC)" +
                "\n     ~T-Shaped(T)" +
                "\n     ~Four Sides(FS)" +
                "\n\nSo, what game would you like to play today? ");

        Scanner gameType = new Scanner(System.in);
        String gt = gameType.next();

        if(gt.equalsIgnoreCase("O")) {

            boolean noEndGame = true;

            bingoo bb = new bingoo(5, 5);

            int bingoBoard[][] = bb.createBoard();


            bb.playTutorial(bb, bingoBoard);

            while (bb.getYON()) {

                bb.playBingoRound(bb, bingoBoard);

            }

        } else if(gt.equalsIgnoreCase("fc")){

            boolean noEndGame = true;

            bingoo bb = new bingoo(5, 5);

            int bingoBoard[][] = bb.createBoard();


            bb.playTutorial(bb, bingoBoard);

            while (bb.getYON()) {

                bb.playFourCorners(bb, bingoBoard);

            }

        } else if(gt.equalsIgnoreCase("T")){

            boolean noEndGame = true;

            bingoo bb = new bingoo(5, 5);

            int bingoBoard[][] = bb.createBoard();


            bb.playTutorial(bb, bingoBoard);

            while (bb.getYON()) {

                bb.playTShaped(bb, bingoBoard);

            }

        } else if(gt.equalsIgnoreCase("FS")){

            boolean noEndGame = true;

            bingoo bb = new bingoo(5, 5);

            int bingoBoard[][] = bb.createBoard();


            bb.playTutorial(bb, bingoBoard);

            while (bb.getYON()) {

                bb.playFourSides(bb, bingoBoard);

            }

        }
    }
}
